/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author chunfang
 */
public class Extra7 {

    static ArrayList<ArrayList<Person>> path = new ArrayList<>();

    public static void sixDegree(Relationship r, Person src) {
        path.clear();
        System.out.println("Extra feature 7 running: ");
        addKen(r);
        System.out.println("The targeted person is "+src.getName());
        methodTransfer(src, r.getPerson("Ken Thompson"), new ArrayList<Person>());
        if (path.size() == 0) {
            System.out.println("no connection");
        }else{
            int length = path.get(0).size();
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i).toString());
                if(path.get(i).size()<length){    
                    length = path.get(i).size();
                }
            }
            System.out.println("hop: "+(length-2));
            if (length-2>6) {
                System.out.println("The six degrees of ken Thompson theory is not proven");
            }else{
                System.out.println("The six degrees of ken Thompson theory is proven");
            }
            
        }
    }

    public static void addKen(Relationship r) {
        Random rand = new Random();
        int n = rand.nextInt(r.getSize());
        System.out.println("Random person is " + r.getPerson(n).getName() + ".");
        r.addPerson("Ken Thompson");
        Person ken = r.getPerson("Ken Thompson");
        r.addFriend(ken, r.getPerson(n));
    }

    public static void methodTransfer(Person src, Person des, ArrayList<Person> arr) {
        LinkedList<Friend> f = src.friend;
        arr.add(src);
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).personDetail().equals(des)) {
                ArrayList<Person> newArr = new ArrayList<>();
                for (int j = 0; j < arr.size(); j++) {
                    newArr.add(arr.get(j));
                }
                newArr.add(des);
                path.add(newArr);
            } else {
                if (!arr.contains(f.get(i).personDetail())) {
                    ArrayList<Person> newArr = new ArrayList<>();
                    for (int j = 0; j < arr.size(); j++) {
                        newArr.add(arr.get(j));
                    }
                    methodTransfer(f.get(i).personDetail(), des, newArr);
                }
            }
        }
    }
}

