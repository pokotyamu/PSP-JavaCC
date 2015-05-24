package parse;
import java.util.*;

public class Contents{
    private String condition;
    private ArrayList<String> pro_list;
    public Contents(){
        this.condition = "";
        this.pro_list = new ArrayList();
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

    public void printPro(){
        for(String name: pro_list){
            System.out.println(name);
        }
    }

    
}
