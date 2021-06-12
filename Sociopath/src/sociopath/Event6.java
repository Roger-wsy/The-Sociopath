/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author chunfang
 */
public class Event6 {
    private static int relation_number = 0 ;
    public static void friendShip() {
        relation_number = 0;
        Scanner sc = new Scanner(System.in);
        Relationship r = new Relationship();
        System.out.println("Event6 running: ");
        System.out.print("How many friendship exists : ");
        int n = sc.nextInt();
        System.out.println("Output format : example1 --> example2");
        for (int i = 0; i < n; i++) {
            String src = sc.next();
            String des = sc.next();
            if(!r.contains(src)){
                r.addPerson(src);
            }
            if(!r.contains(des)){
                r.addPerson(des);
            }
            r.addFriend(r.getPerson(src), r.getPerson(des));
        }
        Person [] allperson = r.toArray();
        for (int i = 0; i < allperson.length; i++) {
            for (int j = i+1; j < allperson.length; j++) {
                findNewFriend(allperson[i],allperson[j],new ArrayList<>());
            }
        }
        System.out.println("Total relationship : "+relation_number);
    }
    
    public static void findNewFriend(Person src, Person des,ArrayList<Person>arr){
        LinkedList<Friend> f = src.friend;
        arr.add(src);
        for (int i = 0; i < f.size(); i++) {
            if(f.get(i).personDetail().equals(des)){
                ArrayList<Person>newArr = new ArrayList<>();
                for (int j = 0; j < arr.size(); j++) {
                    newArr.add(arr.get(j));
                }
                newArr.add(des);
                relation_number++;
                display(newArr);
            }else{
                if(!arr.contains(f.get(i).personDetail())){
                    ArrayList<Person>newArr = new ArrayList<>();
                    for (int j = 0; j < arr.size(); j++) {
                        newArr.add(arr.get(j));
                    }
                    findNewFriend(f.get(i).personDetail(), des, newArr);
                }
            }
        }
    }
    public static void display(ArrayList<Person>arr){
        System.out.print("[ ");
        for (int i = 0; i < arr.size(); i++) {
            if(i==arr.size()-1){
                System.out.print(arr.get(i));
            }else
                System.out.print(arr.get(i)+", ");
        }
        System.out.println(" ]");
    }
}
