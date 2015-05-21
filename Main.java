import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Contents c = ProcessParser.parse("PSP1.txt");
        System.out.println(c);
    }
}
