/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphbox;

import java.math.BigDecimal;
import pspdata.DataSet;
import pspdata.Pair;
import pspdata.UserData;

/**
 *
 * @author pokotyamu
 */
public class ParetoParser extends AbstractDataSetParser{

    @Override
    public GraphDataSet parse(DataSet ds) {
        GraphDataSet parsedDataSet = new GraphDataSet();
        ds.sortY();
        UserData u = ds.getUserData(0);
        SeriesData xasix = new SeriesData(u.getKeyString(), u.getST_ID(), u.getClass_ID());
        for (Pair p : u.getPairs()) {
            xasix.addData(p.getX());
        }
        parsedDataSet.addXasix(xasix);
        for (UserData ud : ds.getUserDatas()) {
            SeriesData yasix = new SeriesData(ud.getKeyString(), ud.getST_ID(),ud.getClass_ID());
            BigDecimal total = new BigDecimal(0.0);
            for (Pair p : ud.getPairs()) {
                yasix.addData(p.getY());
                total = total.add(new BigDecimal((int) p.getY()));
            }
            parsedDataSet.addYasix(yasix);
            SeriesData pardata = new SeriesData(ud.getKeyString(), ud.getST_ID(),ud.getClass_ID());
            BigDecimal all = new BigDecimal(0);
            for (Pair p : ud.getPairs()) {
                BigDecimal bd = new BigDecimal((int)p.getY());
                all = all.add(bd.divide(total,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
                pardata.addData(all);
            }
            parsedDataSet.addYasix(pardata);
        }
        return parsedDataSet;
    }
    
}
