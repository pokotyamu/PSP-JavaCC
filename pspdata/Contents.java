package pspdata;
import java.util.*;
import box.*;
import sqlbox.*;

public class Contents{
    private String condition;
    private ArrayList<AbstractBox> process_list;
    private int index;
    public Contents(){
        this.condition = "";
        this.process_list = new ArrayList();
        this.index = 0;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public String getCondition(){
        return this.condition;
    }

    public void addProcess(AbstractBox box){
        process_list.add(box);
    }

    public void printPro(){
        for(AbstractBox name: process_list){
            System.out.println(name);
            System.out.println(name.getArgSize());
        }
    }

    public ArrayList<AbstractBox> getProcessList(){
        return this.process_list;
    }
    
    public AbstractBox getProcess(int index){
        return this.process_list.get(index);
    }

    public void nextPoint() {
        this.index++;
    }

    public int getIndex() {
        return index;
    }
    
    
    
}
