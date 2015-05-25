/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

/**
 *
 * @author pokotyamu
 */
public class CountDBBox extends AbstractSQLBox{
    private String y_asix;

    public CountDBBox(String x_asix, String y_asix) {
        super(x_asix, y_asix);
    }

    @Override
    public String createSQL(String whereString) {
        return "select  count(*) from ROOT.LOGDDETAIL WHERE "+whereString+" Group by "+this.y_asix;
    }
    
}
