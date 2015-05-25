/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import pspdata.DataSet;
import pspdata.Pair;

/**
 *
 * @author pokotyamu
 */
public class MtoH extends AbstractOneArgBox{
    
    @Override
    protected DataSet initDataSet(DataSet dataSet){
        return new DataSet(dataSet.getKeyString(), dataSet.getValueString()+"(h)");
    }
    
    @Override
    public Pair function(Pair p){
        double parseDouble = Double.parseDouble(p.getY().toString());
        return new Pair(p.getX(), parseDouble / 60.0);
    }
    
}
