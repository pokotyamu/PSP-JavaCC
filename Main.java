import java.io.*;
import java.util.*;
import parse.*;
import pspdata.*;
import Functionbox.*;
import box.*;
import sqlbox.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Contents c = ProcessParser.parse("PSP1.txt");
        c.printPro();

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");        
        String whereString = " WHERE CLASS_ID=201301 AND SUBMITION_ID=1 ORDER BY ST_ID ASC,PROJECTID ASC, SUBMITION_ID ASC";
        AbstractBox actmin = new ACTMIN("PROJECTID", "ACTMIN");
        AbstractBox max = new Max();

        max.actionBox(actmin.actionBox(whereString)).debugPrint();
        
    }
}
