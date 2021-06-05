/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Event3 {
    public static void haveLunch(Person p, Relationship r){
        HashMap<Person,Integer> map = new HashMap<>();
        System.out.println("Event 3 running:");
        System.out.println(p.getName()+" wants to have lunch with people with high reputation.");
        int start = p.getAveLunT();
        int eat_period = p.getAveLunP();
        int end = start+eat_period;
        if(end%100>=60){
            end+=40;
        }
        ArrayList<Person> arr = getlistPerson(p,r);
        System.out.println("Target people : ");
        for (int i = 0; i < arr.size(); i++) {
            int endeat = arr.get(i).getAveLunP()+arr.get(i).getAveLunT();
            if(endeat%100>=60){
                endeat+=40;
            }
            map.put(arr.get(i),endeat);
            System.out.println(arr.get(i).getName()+" Start : "+arr.get(i).getAveLunT()+" End : "+endeat+"  Rep point : "+r.getAveRep(arr.get(i)));
        }
        System.out.println("");
        System.out.println(p.getName()+" wants to have lunch together with whose lunch time intersects with him.");
        System.out.println(p.getName()+" lunch session has started:");
        System.out.println(p.getName()+" || Lunch start : "+start+" || Lunch end : "+end);
        System.out.println("");
        int count = 0;
        while(start<end){
            Person eat = arr.get(0);
            int time = 2400;
            boolean change = false;
            for (int i = 0; i < arr.size(); i++) {
                if(map.get(arr.get(i))>start){          
                    if(map.get(arr.get(i))<time){
                        eat = arr.get(i);
                        time = map.get(arr.get(i));
                        change = true;
                    }
                }  
            }
            if(change == false){
                break;
            }
            count++;
            
            if(eat.getAveLunT()>start && map.get(eat)>end){
                System.out.println(p.getName()+" eat with "+eat.getName()+" Time : "+eat.getAveLunT()+" to "+end);
            }else if(eat.getAveLunT()>start && map.get(eat)<end){
                System.out.println(p.getName()+" eat with "+eat.getName()+" Time : "+eat.getAveLunT()+" to "+map.get(eat));
            }else if(eat.getAveLunT()<start && map.get(eat)>end){
                System.out.println(p.getName()+" eat with "+eat.getName()+" Time : "+start+" to "+end);
            }else{
                System.out.println(p.getName()+" eat with "+eat.getName()+" Time : "+start+" to "+map.get(eat));
            }
            int a = eat.getRep(p);
            eat.setRep(p, eat.getRep(p)+1);
            System.out.println("Result : Rep point of "+eat.getName()+ " to "+p.getName()+" change from "+a+" to "+eat.getRep(p));
            start = time;
            System.out.println("");
            
        }
        System.out.println("Max reputation gained by "+p.getName()+" is "+count);
    }
    
    public static ArrayList<Person> getlistPerson(Person p,Relationship r){
        ArrayList<Person> arr = new ArrayList<>();
        LinkedList<Person> personlist = r.toLinkedList();
        for (int i = 0; i < personlist.size(); i++) {
            if(personlist.get(i).equals(p)){
                continue;
            }else{
                int a = r.getAveRep(personlist.get(i));
                if(a>=6){
                    arr.add(personlist.get(i));
                }
            }
        }
        return arr;
    }
}
