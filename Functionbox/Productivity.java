/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import pspdata.DataSet;
import box.AbstractBox;
import sqlbox.ProductivitySize;
import sqlbox.ProductivityTime;

/**
 *
 * @author pokotyamu
 */
public class Productivity extends AbstractTwoArgBox{

    @Override
    public DataSet function(String whereString){
        AbstractBox sql1 = new ProductivitySize("PROJECTID","ACTUALA");
        AbstractBox sql2 = new ProductivityTime("PROJECTID", "MYAT");
        AbstractBox mtoh = new MtoH();
        AbstractBox div = new Division();
        return div.actionBox(sql1.actionBox(whereString), mtoh.actionBox(sql2.actionBox(whereString)));
    }
}
