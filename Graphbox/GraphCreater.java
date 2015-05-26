/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphbox;

import box.Calculation;
import pspdata.Contents;
import pspdata.DataSet;

/**
 *
 * @author pokotyamu
 */
public class GraphCreater {

    public static GraphDataSet make(Contents c) {
        DataSet dataSet = Calculation.cal(0, c);
        return c.getParser().parse(dataSet);
    }
    
}
