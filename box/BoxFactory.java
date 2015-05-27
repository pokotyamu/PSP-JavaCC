/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import Functionbox.Division;
import Functionbox.Max;
import Functionbox.MtoH;
import Graphbox.AbstractDataSetParser;
import Graphbox.ParetoParser;
import Graphbox.SeriesParser;
import sqlbox.*;
/**
 *
 * @author pokotyamu
 */
public class BoxFactory {

    public static AbstractBox createBox(String processName) {
        switch(processName){
            case "MAX":
                return new Max();
            case "MtoH":
                return new MtoH();
            case "DIV":
                return new Division();
        }
        return null;
    }

    public static AbstractBox createDBBox(String x_asix, String y_asix, String db_type) {
        switch(db_type){
            case "DB":
                return new DBBox(x_asix, y_asix);
            case "CountDB":
                return new DefectCountDBBox(x_asix, y_asix);
                
            case "AllDefectCount":
                return new AllDefectCountDBBox(x_asix,y_asix);
        }
        return null;
    }
    
    public static AbstractDataSetParser createGraphParser(String graph_type){
        switch(graph_type){
            case "Line":
                return new SeriesParser();
            case "Pareto":
                return new ParetoParser();
        }
        return null;
    }
}
