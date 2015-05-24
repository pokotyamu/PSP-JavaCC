package pspdata;
import java.util.*;
import box.*;
import sqlbox.*;

public class Contents{
    private String condition;
    private ArrayList<String> pro_list;
    private ArrayList<AbstractBox> pros;
    public Contents(){
        this.condition = "";
        this.pro_list = new ArrayList();
        this.pros = new ArrayList();
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public String getCondition(){
        return this.condition;
    }

    public void addPro(String pro){
        pro_list.add(pro);
    }

    public void addProcess(AbstractBox box){
        pros.add(box);
    }

    public void printPro(){
        for(AbstractBox name: pros){
            System.out.println(name);
            System.out.println(name.getArgSize());
        }
    }

    public ArrayList<String> getProcessList(){
        return this.pro_list;
    }

    
}
