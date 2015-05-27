/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pspdata.DataSet;
import pspdata.Pair;
import pspdata.UserData;

/**
 *
 * @author pokotyamu
 */
public class AllDefectCountDBBox extends AbstractSQLBox{

    public AllDefectCountDBBox(String keyString, String valueString) {
        super(keyString, valueString);
    }

    @Override
    public String createSQL(String whereString) {
        return "select count("+keyString+"),ST_ID,CLASS_ID,"+keyString+
                " from ROOT.LOGDDETAIL WHERE "+whereString+
                " Group by "+keyString+",ST_ID,CLASS_ID ORDER BY "+keyString+" ASC";
    }

    @Override
    public DataSet getDataSet(String wheresString){
        DataSet ds = new DataSet(this.keyString, this.valueString);
        connection();
        //ResultSetをとってくる。
        ResultSet rs = getResultSet(createSQL(wheresString));
        try {
            rs.next();
            UserData ud = new UserData(keyString, valueString,rs.getInt("ST_ID"),rs.getInt("CLASS_ID"));
            for (int defect_type = 1; defect_type < 9; defect_type++) {
                try{
                    if (rs.getInt(keyString) == defect_type) {
                        ud.addData(new Pair(defect_type, rs.getInt(1), 1));
                        rs.next();
                    }else{
                        ud.addData(new Pair(defect_type, 0, 1));
                    }
                }catch(SQLException se){
                    ud.addData(new Pair(defect_type, 0, 1));
                }
            }
            ds.addUserData(ud);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractSQLBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ds;
    }
}
