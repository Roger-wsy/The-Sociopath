/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author chunfang
 */
public class Event5 {
    static ArrayList<ArrayList<Person>>rumorpath = new ArrayList<>();
    public static void main(String[] args) {
        Relationship r = new Relationship();
        ArrayList<Person>blocked = new ArrayList<>();
        r.addPerson("1");
        r.addPerson("2");
        r.addPerson("3");
        r.addPerson("4");
        r.addPerson("5");
        r.addPerson("6");
        r.addPerson("7");
        r.addPerson("8");
        r.addPerson("9");
        r.addPerson("10");
        
        r.addFriend(r.getPerson("1"), r.getPerson("2"));
        r.addFriend(r.getPerson("1"), r.getPerson("7"));
        r.addFriend(r.getPerson("2"), r.getPerson("1"));
        r.addFriend(r.getPerson("2"), r.getPerson("3"));
        r.addFriend(r.getPerson("2"), r.getPerson("5"));
        r.addFriend(r.getPerson("2"), r.getPerson("6"));
        r.addFriend(r.getPerson("3"), r.getPerson("2"));
        r.addFriend(r.getPerson("4"), r.getPerson("8"));
        r.addFriend(r.getPerson("4"), r.getPerson("10"));
        r.addFriend(r.getPerson("5"), r.getPerson("2"));
        r.addFriend(r.getPerson("5"), r.getPerson("7"));
        r.addFriend(r.getPerson("6"), r.getPerson("2"));
        r.addFriend(r.getPerson("7"), r.getPerson("1"));
        r.addFriend(r.getPerson("7"), r.getPerson("5"));
        r.addFriend(r.getPerson("8"), r.getPerson("4"));
        r.addFriend(r.getPerson("9"), r.getPerson("10"));
        r.addFriend(r.getPerson("10"), r.getPerson("4"));
        r.addFriend(r.getPerson("10"), r.getPerson("9"));
        
        methodTransfer(r.getPerson("2"),r.getPerson("7"),new ArrayList<Person>());
        System.out.println(rumorpath.size());
        if(rumorpath.size()==0){
            System.out.println("impossible to arrive at clush");
            return;
        }
        int spread = 1;
        int min_index = 0;
        int min = rumorpath.get(min_index).size();
        
        while(!rumorpath.isEmpty()){
            for (int i = 0; i < rumorpath.size(); i++) {
                if(rumorpath.get(i).size()<min){
                    min_index = i;
                    min = rumorpath.get(i).size();
                }
                if(rumorpath.get(i).get(spread).equals(r.getPerson("7"))){
                    System.out.println("impossible to block the rumor");
                    return;
                }
            }
            blocked.add(rumorpath.get(min_index).get(1));
            for (int i = 0; i < rumorpath.size(); i++) {
                if(blocked.contains(rumorpath.get(i).get(spread))){
                    rumorpath.remove(i);
                    i--;
                }
            }
            spread++;
        }
        System.out.println("blocked successful");
        
    }
    public static void methodTransfer(Person src, Person des,ArrayList<Person>arr){
        LinkedList<Friend> f = src.friend;
        arr.add(src);
        for (int i = 0; i < f.size(); i++) {
            if(f.get(i).friendDetail().equals(des)){
                ArrayList<Person>newArr = new ArrayList<>();
                for (int j = 0; j < arr.size(); j++) {
                    newArr.add(arr.get(j));
                }
                newArr.add(des);
                rumorpath.add(newArr);
            }else{
                if(!arr.contains(f.get(i).friendDetail())){
                    ArrayList<Person>newArr = new ArrayList<>();
                    for (int j = 0; j < arr.size(); j++) {
                        newArr.add(arr.get(j));
                    }
                    methodTransfer(f.get(i).friendDetail(), des, newArr);
                }
            }
        }
    }
}
