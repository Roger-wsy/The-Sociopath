/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Event5 {
    static ArrayList<ArrayList<Person>>rumorpath = new ArrayList<>();
    public static void meetCrush(Person src, Person des) {
        rumorpath.clear();
        Relationship r = new Relationship();
        ArrayList<Person>blocked = new ArrayList<>();
        
        System.out.println("The rumor start at "+src.getName());
        System.out.println("The crush is at "+des.getName());
        methodTransfer(src,des,new ArrayList<Person>());
        if(rumorpath.size()==0){
            System.out.println("impossible to arrive at clush");
            return;
        }
        int spread = 1;
        
        for (int i = 0; i < rumorpath.size(); i++) {
            for (int j = 0; j < rumorpath.get(i).size(); j++) {
                if(j==rumorpath.get(i).size()-1){
                    System.out.print(rumorpath.get(i).get(j).getName());
                }else{
                    System.out.print(rumorpath.get(i).get(j).getName()+" --> ");
                }
                
            }
            System.out.println("");
        }
        while(!rumorpath.isEmpty()){
            int min_index = 0;
            int min = rumorpath.get(min_index).size();
            for (int i = 0; i < rumorpath.size(); i++) {
                if(rumorpath.get(i).size()<min){
                    min_index = i;
                    min = rumorpath.get(i).size();
                }
                if(rumorpath.get(i).get(spread).equals(des)){
                    System.out.println("Impossible to block the rumor !");
                    return;
                }
            }
            if(!blocked.contains(rumorpath.get(min_index).get(spread))){
                blocked.add(rumorpath.get(min_index).get(spread));
            }            
            for (int i = 0; i < rumorpath.size(); i++) {
                if(blocked.contains(rumorpath.get(i).get(spread))){
                    rumorpath.remove(i);
                    i--;
                }
            }
            spread++;
        }
        System.out.println("The rumor is blocked successful");
        System.out.print("The person convinced are : ");
        for (int i = 0; i < blocked.size(); i++) {
            System.out.print(blocked.get(i).getName()+" ");
        }
        System.out.println("");
        
    }
    public static void methodTransfer(Person src, Person des,ArrayList<Person>arr){
        LinkedList<Friend> f = src.friend;
        arr.add(src);
        for (int i = 0; i < f.size(); i++) {
            if(f.get(i).personDetail().equals(des)){
                ArrayList<Person>newArr = new ArrayList<>();
                for (int j = 0; j < arr.size(); j++) {
                    newArr.add(arr.get(j));
                }
                newArr.add(des);
                rumorpath.add(newArr);
            }else{
                if(!arr.contains(f.get(i).personDetail())){
                    ArrayList<Person>newArr = new ArrayList<>();
                    for (int j = 0; j < arr.size(); j++) {
                        newArr.add(arr.get(j));
                    }
                    methodTransfer(f.get(i).personDetail(), des, newArr);
                }
            }
        }
    }
}
