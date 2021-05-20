/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialpath;

import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Person {
    private String name;
    private int div_rate;
    private int lun_time;
    private int lun_period;
    LinkedList<Friend> friend = new LinkedList<>();

    public Person(String name) {
        this.name = name;
    }

    public void addF(Person p2, int w){
        Friend f = new Friend(p2,w);
        friend.add(f);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString(){
        return name;
    }
    
}
