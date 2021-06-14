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
    LinkedList<Friend> friend = new LinkedList<>();         //to store a list of friends
    LinkedList<Reputation> reputation = new LinkedList<>(); //to store other people's reputation points for that person
    //constructor
    public Person(String name) {    
        this.name = name;
    }
    //constructor
    public Person(String name, int div_rate, int [] lun_time,int [] lun_period){    
        this.name = name;
        this.div_rate = div_rate;
        this.lun_time = lun_time;
        this.lun_period = lun_period;
    }
    //add a new friend
    public void addF(Person p2, int type){  
        Friend f = new Friend(p2,type);
        friend.add(f);
    }
    
    //add reputation point
    public void addRep(Person p, int rep){
        Reputation re = new Reputation(p,rep);
        reputation.add(re);
    }
    //return the name of person
    public String getName() {
        return name;
    }
    //set the name of the person
    public void setName(String name) {
        this.name = name;
    }

    //return diving rate
    public int getDiv_rate() {
        return div_rate;
    }

    //set diving rate
    public void setDiv_rate(int div_rate) {
        this.div_rate = div_rate;
    }

    //return name
    public String toString(){
        return name;
    }
    
    //check the person has that friends or not
    public boolean containF(Person p){      
        for (int i = 0; i < friend.size(); i++) {
            if(friend.get(i).personDetail().equals(p)){
                return true;
            }
        }
        return false;
    }
    
    //set the type of the friend(personB)
    public void setF(Person personB, int type) {    
        int a=0;
        for(int i=0;i<friend.size();i++) {
            if (friend.get(i).personDetail().equals(personB)) {
                a=i;
            }
        }
        friend.get(a).setType(type);
    }
    
    //get average lunch time
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
    
    //get average lunch time
    public int getAveLunP(){
        int sum = 0;
        for (int i = 0; i < lun_period.length; i++) {
            sum+= lun_period[i];
        }
        int ave = sum/lun_period.length;
        return ave;
    }
    
    //get reputation point of person p
    public int getRep(Person p){
        for (int i = 0; i < reputation.size(); i++) {
            if(reputation.get(i).personDetail().equals(p)){
                return reputation.get(i).getRep();
            }
        }
        return 0;
    }
    
    //set reputation point of Person p
    public void setRep(Person p, int rep){
        for (int i = 0; i < reputation.size(); i++) {
            if(reputation.get(i).personDetail().equals(p)){
                reputation.get(i).setRep(rep);
            }
        }
    }
}
