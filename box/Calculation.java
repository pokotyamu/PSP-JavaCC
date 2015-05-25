package box;

import java.util.*;
import parse.*;
import pspdata.*;
import Functionbox.*;
import sqlbox.*;

public class Calculation{

    public static DataSet cal(int now_index,Contents c){

        AbstractBox target = c.getProcess(now_index);
        if(target.getArgSize() == 0)
            return target.getDataSet(c.getCondition());
        else if(target.getArgSize() == 1){
            c.nextPoint();
            DataSet arg1 = cal(c.getIndex(),c);
            return target.function(arg1);
        }else if(target.getArgSize() == 2){
            c.nextPoint();
            DataSet arg1 = cal(c.getIndex(),c);
            c.nextPoint();
            DataSet arg2 = cal(c.getIndex(),c);
            arg1.debugPrint();
            arg2.debugPrint();
            return target.function(arg1,arg2);
        }
        return null;
    }
}
