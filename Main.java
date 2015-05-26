import Graphbox.GraphCreater;
import java.io.*;
import parse.ProcessParser;
import pspdata.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Contents c = ProcessParser.parse("/Users/pokotyamu/NetBeansProjects/PSP/src/PSP.txt");
        GraphCreater.make(c).debugPrint();
        

        
/*
        AllDefectCountDBBox ad = new AllDefectCountDBBox("DEFECTTYPEID", "COUNT");
        DataSet dataSet = ad.getDataSet("CLASS_ID=201301");
        dataSet.sortY();
        dataSet.debugPrint();
        ParetoParser pp = new ParetoParser();
        pp.parse(dataSet).debugPrint();
        */
    }
    
}

