/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import pspdata.DataSet;
import sqlbox.AbstractSQLBox;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractBox {
    
    public DataSet actionBox(String whereString){
        if(this instanceof AbstractSQLBox){
            return getDataSet(whereString);
        }else{
            return function(whereString);
        }
    }

    public abstract int getArgSize();
    
    public DataSet actionBox(DataSet... dataSets){
        return function(dataSets);
    }

    public DataSet function(DataSet... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataSet getDataSet(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DataSet function(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
