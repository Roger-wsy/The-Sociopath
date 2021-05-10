/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialpath;

/**
 *
 * @author chunfang
 */
public class Person {
    private int div_rate;
    private int lun_time;
    private int lun_period;
    
    public Person(int div_rate,int lun_time, int lun_period){
        this.div_rate = div_rate;
        this.lun_period = lun_period;
        this.lun_time = lun_time;
    }

    public int getDiv_rate() {
        return div_rate;
    }

    public void setDiv_rate(int div_rate) {
        this.div_rate = div_rate;
    }

    public int getLun_time() {
        return lun_time;
    }

    public void setLun_time(int lun_time) {
        this.lun_time = lun_time;
    }

    public int getLun_period() {
        return lun_period;
    }

    public void setLun_period(int lun_period) {
        this.lun_period = lun_period;
    }
    
}
