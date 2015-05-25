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
public class DefectCountDBBox extends AbstractSQLBox {

    public DefectCountDBBox(String keyString, String valueString) {
        super(keyString, valueString);
    }

    @Override
    public String createSQL(String whereString) {
        return "select count(DEFECTLOGENTRYID),ST_ID,CLASS_ID,PROJECTID,DEFECTTYPEID from ROOT.LOGDDETAIL WHERE "
                +whereString+" Group by DEFECTTYPEID,PROJECTID,ST_ID,CLASS_ID ORDER BY PROJECTID ASC,DEFECTTYPEID ASC";
    }

    
    @Override
    public DataSet getDataSet(String wheresString){
        DataSet ds = new DataSet(this.keyString, this.valueString);
        connection();
        //ResultSetをとってくる。
        ResultSet rs = getResultSet(createSQL(wheresString));
        try {            
            rs.next();
            for(int project_id = 400; project_id < 408; project_id++){
                UserData ud = new UserData(keyString, valueString,project_id,201301);
                for (int defect_type = 1; defect_type < 9; defect_type++) {
                    try{
                        if (rs.getInt("DEFECTTYPEID") == defect_type) {
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractSQLBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ds;
    }
}
