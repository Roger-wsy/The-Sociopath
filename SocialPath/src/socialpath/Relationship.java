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
public class Relationship {
    private int size = 0;
    private LinkedList<Person> v;
    
    public Relationship(){
        v = new LinkedList<>();
    }
    
    public void addPerson(String name){
        Person p = new Person(name);
        v.add(p);
        size++;
    }
    public void addFriend(Person p1 ,Person p2, int w){
        p1.addF(p2, w);
    }
    public void addFriend(Person p1 ,Person p2){
        p1.addF(p2, 1);
    }
    public Person getPerson(String name){
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).getName().equals(name)){
                return v.get(i);
            }
        }
        return null;
    }
    public String toString(){
        String z ="All vertex : ";
        for (int i = 0; i < v.size(); i++) {
            z+= v.get(i).toString()+" ";
        }
        z+="\n";
        for (int i = 0; i < v.size(); i++) {
            Person p = v.get(i);
            for (int j = 0; j < p.friend.size(); j++) {
                z+=p.getName()+" --> "+p.friend.get(j).toString()+"\n";
            }
        }
        return z;
    }
    public boolean contains(String name){
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    public Person[] toArray(){
        Person[] p = new Person[v.size()];
        for (int i = 0; i < v.size(); i++) {
            p[i]=v.get(i);
        }
        return p;
    }
}
