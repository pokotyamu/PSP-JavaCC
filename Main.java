import Graphbox.SeriesParser;
import java.io.*;
import parse.*;
import pspdata.*;
import box.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Contents c = ProcessParser.parse("/Users/pokotyamu/NetBeansProjects/PSP/src/PSP.txt");
        Calculation.cal(0, c).debugPrint();
        
        SeriesParser sp = new SeriesParser();
        sp.parse(Calculation.cal(0,c)).debugPrint();
    }
    
}

