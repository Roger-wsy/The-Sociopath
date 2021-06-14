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
    //method to let someone to have lunch with his/her interested people to increase reputation point
    public static void haveMoreLunch(Person p, Relationship r){
        HashMap<Person,Integer> map = new HashMap<>();
        System.out.println("Extra feature 4 running:");
        System.out.println(p.getName()+" wants to have lunch with people with high reputation.");
        //get the targeted person start eating time, eating period and end eating time
        int start = p.getAveLunT();
        int eat_period = p.getAveLunP();
        int end = start+eat_period;
        //round the time to the correct format
        if(end%100>=60){
            end+=40;
        }
        ArrayList<Person> arr = getlistPerson(p,r);
        for (int i = 0; i < arr.size(); i++) {
            int endeat = arr.get(i).getAveLunP()+arr.get(i).getAveLunT();
            if(endeat%100>=60){
                endeat+=40;
            }
            //find all the person ending time
            map.put(arr.get(i),endeat);
            System.out.println(arr.get(i).getName()+" Start : "+arr.get(i).getAveLunT()+" End : "+endeat+"  Rep point : "+r.getAveRep(arr.get(i)));
        }
        System.out.println("");
        System.out.println(p.getName()+" wants to have lunch together with whose lunch time intersects with him.");
        System.out.println(p.getName()+" lunch session has started:");
        System.out.println(p.getName()+" || Lunch start : "+start+" || Lunch end : "+end);
        System.out.println("");
        int count = 0;
        //compare the time to get which person eat faster.
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
        //add the first person to the list
        //if detect the person inside the waiting list add to the table to eat together
        if(change){
            eating.add(eat);
            System.out.println(p.getName()+" invite "+eat.getName()+" to eat together");
            System.out.println("");
        }       
        //if there is still having some people on the table, search for the next person to eat
        while(eating.size()!=0){
            eat = arr.get(0);
            if(start<end){
                //if the table not full yet find another person 
                while(eating.size()<3){
                    eat = arr.get(0);
                    time = 2400;
                    change = false;
                    //compare the time to get which person eat faster           
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
                    //add the person to the list
                    //if detect the person inside the waiting list, add to the table to eat together
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
            //update the person reputation
            eating.get(0).setRep(p, eating.get(0).getRep(p)+1);
            System.out.println("Result : Rep point of "+eating.get(0).getName()+ " to "+p.getName()+" change from "+a+" to "+eating.get(0).getRep(p));
            System.out.println("");
            //remove the person in the table and minus the size by 1
            eating.remove(0);
            
        }
        System.out.println("Max reputation gained by "+p.getName()+" is "+count);
    }
    
    //find the personlist that are with higer reliability (higher reputation)
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
