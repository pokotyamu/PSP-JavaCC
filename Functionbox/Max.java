/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import pspdata.DataSet;
import pspdata.Pair;
import pspdata.UserData;
import java.io.IOException;

/**
 *
 * @author pokotyamu
 */
public class Max extends AbstractOneArgBox{
    int PROID = 399;
    
    
    @Override
    protected DataSet initDataSet(DataSet ds){
        return new DataSet(ds.getKeyString(), ds.getValueString()+"_max");
    }
    
    
    @Override
    protected DataSet function(DataSet ds){
        UserData addedUserData = new UserData(ds.getKeyString(), ds.getValueString()+"_MAX",-1,ds.getUserData(0).getClass_ID());
        DataSet dataset = new DataSet(addedUserData.getKeyString(), addedUserData.getValueString());
        // DataSet 内の UserData から最大演習課題番号を求める
        int max_pro_id = getMaxProjectID(ds);
        Pair maxPair;
        Pair tempPair;
        for(int index = 0; index < max_pro_id-PROID; index++)
        {
            maxPair = new Pair("","");
            for(int i = 0; i < ds.getUserDataSize(); i++)
            {
                // 演習課題ごとのユーザの値をみていく
                try{
                    if(maxPair.getX() == ""){
                        maxPair = ds.getUserData(i).getPair(index);
                    }else{
                        tempPair = ds.getUserData(i).getPair(index);
                        if(maxPair.matchX(tempPair)){  
                            if(Double.parseDouble(maxPair.getY().toString()) < Double.parseDouble(tempPair.getY().toString())){
                                maxPair = tempPair;
                            }
                        }
                    }
                    }catch(java.lang.IndexOutOfBoundsException e){
                            System.out.println("ST_ID = " + (i+1) + " don't have " + (index+400) + " data");
                }
            }
            addedUserData.addData(maxPair);
        }
        dataset.addUserData(addedUserData);
        return dataset;
    }
    
    // DataSet 内の UserData から最大演習課題番号を求める
    int getMaxProjectID(DataSet ds)
    {
        int max_size = ds.getUserData(0).getSize();
        int max_pro_id = Integer.parseInt(ds.getUserData(0).getPair(max_size - 1).getX().toString());
        for(int i = 1; i < ds.getUserDataSize(); i++)
        {
            // 各 UserData の最後の演習課題の番号を取得
            max_size = ds.getUserData(i).getSize();
            int temp = Integer.parseInt(ds.getUserData(i).getPair(max_size - 1).getX().toString());
            if(max_pro_id < temp)
            {
                max_pro_id = temp;
            }
        }
        return max_pro_id;
    }
}
