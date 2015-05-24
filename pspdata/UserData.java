
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokotyamu
 */
public class UserData {
    
    List<Pair> pairs;

    private String keyString;
    private String valueString;
    private int st_id;
    private int class_id;
    //複数人のデータを対象にすることはまだ実装できていない
    //さらに上のくくりでまとめる必要がある
    public UserData(String keyString, String valueString, ResultSet result) {
        this.keyString = keyString;
        this.valueString = valueString;
        this.pairs = new ArrayList();
        int project_ID = 0;
        int count = 0;
        try {
            while (result.next()) {
                if(count < 0)
                {
                    project_ID = result.getInt("PROJECTID");
                    pairs.add(new Pair(result.getObject(keyString),result.getObject(valueString)));
                    count = 1;
                }
                if(project_ID != result.getInt("PROJECTID"))
                {
                    pairs.add(new Pair(result.getObject(keyString),result.getObject(valueString)));
                    project_ID = result.getInt("PROJECTID");
                }
            }       
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // SUBMITION_ID が指定された時
    public UserData(String keyString, String valueString, ResultSet result, String submitionID) {
        this.keyString = keyString;
        this.valueString = valueString;
        this.pairs = new ArrayList();
        try {
            while (result.next()) 
            {
                //System.out.println(result.getObject(valueString));
                pairs.add(new Pair(result.getObject(keyString),result.getObject(valueString)));
            }       
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserData(String keyString,String valueString){
        this.keyString = keyString;
        this.valueString = valueString;
        this.st_id = -1;
        this.class_id = -1;
        this.pairs = new ArrayList();
    }
    
    public UserData(String keyString, String valueString, int st_id, int class_id){
        this.keyString = keyString;
        this.valueString = valueString;
        this.st_id = st_id;
        this.class_id = class_id;
        this.pairs = new ArrayList();
    }
    
    public List<Pair> getPairs(){
        return this.pairs;
    }
    
    public Pair getPair(int index){
        return this.pairs.get(index);
    }

    public int getSize(){
        return this.pairs.size();
    }
    
    public String dataLabel(){
        return "["+this.keyString+","+this.valueString+"]";
    }
    
    public String getKeyString(){
        return this.keyString;
    }
    
    public String getValueString(){
        return this.valueString;
    }

    public void addData(Pair addedPair) {
        this.pairs.add(addedPair);
    }
    
    public int getST_ID(){
        return this.st_id;
    }
    
    public void setST_ID(int st_id){
        this.st_id = st_id;
    }
    public int getClass_ID(){
        return this.class_id;
    }
    
    public void setClass_ID(int class_id){
        this.class_id = class_id;
    }
    
    public void debugPrint(){
        System.out.println(dataInfo());
        System.out.println(dataLabel());
        System.out.println(getPairs());
    }
    
    @Override
    public UserData clone(){
        UserData userdata = new UserData(keyString, valueString,st_id,class_id);
        for(Pair p : this.pairs){
            userdata.addData(p);
        }
        return userdata;
    }

    private String dataInfo() {
        return "[ST_ID="+this.st_id+",Class_ID="+this.class_id+"]";
    }
}
