import Graphbox.SeriesParser;
import java.io.*;
import parse.*;
import pspdata.*;
import box.*;
import sqlbox.AllDefectCountDBBox;

public class Main{
    public static void main(String[] args) throws IOException{
        //Contents c = ProcessParser.parse("/Users/pokotyamu/NetBeansProjects/PSP/src/PSP.txt");
        //Calculation.cal(0, c).debugPrint();
        
        AllDefectCountDBBox ad = new AllDefectCountDBBox("DEFECTTYPEID", "COUNT");
        ad.getDataSet("CLASS_ID=201301").debugPrint();
    }
    
}

