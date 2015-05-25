import java.io.*;
import java.util.*;
import parse.*;
import pspdata.*;
import Functionbox.*;
import box.*;
import sqlbox.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Contents c = ProcessParser.parse("/Users/pokotyamu/NetBeansProjects/PSP/src/PSP1.txt");
        Calculation.cal(0,c).debugPrint();
    }
}

