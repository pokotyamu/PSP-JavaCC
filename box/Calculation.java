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
            int index = now_index + 1;
            DataSet arg1 = cal(index,c);
            return target.function(arg1);
        }else if(target.getArgSize() == 2){
            int index = now_index + 1;
            DataSet arg1 = cal(index,c);
            DataSet arg2 = cal(index,c);
            return target.function(arg1,arg2);
        }
        return null;
    }
}
