/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

/**
 *
 * @author chunfang
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Extra4 {
    public static void haveMoreLunch(Person p, Relationship r){
        HashMap<Person,Integer> map = new HashMap<>();
        System.out.println("Extra 6 running:");
        System.out.println(p.getName()+" wants to have lunch with people with high reputation.");
        int start = p.getAveLunT();
        int eat_period = p.getAveLunP();
        int end = start+eat_period;
        if(end%100>=60){
            end+=40;
        }
        ArrayList<Person> arr = getlistPerson(p,r);
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
        ArrayList<Person> eating = new ArrayList<>();
        Person eat = arr.get(0);
        int time = 2400;
        boolean change = false;
        for (int i = 0; i < arr.size(); i++) {
            if(map.get(arr.get(i))>start){          
                if(map.get(arr.get(i))<time){
                    eat = arr.get(i);
                    change = true;
                    time = map.get(arr.get(i));
                }
            }  
        }
        if(change){
            eating.add(eat);
            System.out.println(p.getName()+" invite "+eat.getName()+" to eat together");
            System.out.println("");
        }       
        while(eating.size()!=0){
            eat = arr.get(0);
            if(start<end){
                while(eating.size()<3){
                    eat = arr.get(0);
                    time = 2400;
                    change = false;
                    for (int i = 0; i < arr.size(); i++) {
                        if(map.get(arr.get(i))>start){          
                            if(map.get(arr.get(i))<time){
                                if(!eating.contains(arr.get(i))){
                                    eat = arr.get(i);
                                    time = map.get(arr.get(i));
                                    change = true;
                                }     
                            }
                        }  
                    }
                    if(change==false){
                        break;
                    }else{
                        eating.add(eat);
                        System.out.println(p.getName()+" invite "+eat.getName()+" to eat together");
                        System.out.println("");
                    }
                }
            }
           
            count++;
            
            start = map.get(eating.get(0));
            System.out.println(eating.get(0)+" finish his/her lunch at "+map.get(eating.get(0)));
            int a = eating.get(0).getRep(p);
            eating.get(0).setRep(p, eating.get(0).getRep(p)+1);
            System.out.println("Result : Rep point of "+eating.get(0).getName()+ " to "+p.getName()+" change from "+a+" to "+eating.get(0).getRep(p));
            System.out.println("");
            eating.remove(0);
            
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
