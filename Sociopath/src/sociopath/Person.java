/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Person {
    private String name;
    private int div_rate;
    private int [] lun_time;
    private int [] lun_period;
    LinkedList<Friend> friend = new LinkedList<>();
    LinkedList<Reputation> reputation = new LinkedList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int div_rate, int [] lun_time,int [] lun_period){
        this.name = name;
        this.div_rate = div_rate;
        this.lun_time = lun_time;
        this.lun_period = lun_period;
    }
    public void addF(Person p2, int type){
        Friend f = new Friend(p2,type);
        friend.add(f);
    }
    
    public void addRep(Person p, int rep){
        Reputation re = new Reputation(p,rep);
        reputation.add(re);
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



    public String toString(){
        return name;
    }

    public boolean containF(Person p){
        for (int i = 0; i < friend.size(); i++) {
            if(friend.get(i).personDetail().equals(p)){
                return true;
            }
        }
        return false;
    }
    public void setF(Person personB, int type) {
        int a=0;
        for(int i=0;i<friend.size();i++) {
            if (friend.get(i).personDetail().equals(personB)) {
                a=i;
            }
        }
        friend.get(a).setType(type);
    }
    public int getAveLunT(){
        int sum = 0;
        for (int i = 0; i < lun_time.length; i++) {
            sum+= lun_time[i];
        }
        int ave = sum/lun_time.length;
        if(ave%100>=60){
            ave+=40;
        }
        return ave;
    }
    public int getAveLunP(){
        int sum = 0;
        for (int i = 0; i < lun_period.length; i++) {
            sum+= lun_period[i];
        }
        int ave = sum/lun_period.length;
        return ave;
    }
    
    public int getRep(Person p){
        for (int i = 0; i < reputation.size(); i++) {
            if(reputation.get(i).personDetail().equals(p)){
                return reputation.get(i).getRep();
            }
        }
        return 0;
    }
    public void setRep(Person p, int rep){
        for (int i = 0; i < reputation.size(); i++) {
            if(reputation.get(i).personDetail().equals(p)){
                reputation.get(i).setRep(rep);
            }
        }
    }
}
