/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import Functionbox.Division;
import Functionbox.Max;
import Functionbox.MtoH;
import box.AbstractBox;

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
    public static AbstractBox createDBBox(String x_asix, String y_asix) {
        return new ACTMIN(x_asix, y_asix);
    }
}
