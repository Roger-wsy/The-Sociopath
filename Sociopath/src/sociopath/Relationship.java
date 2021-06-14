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
public class Relationship {
    private LinkedList<Person> v;
    
    public Relationship(){
        v = new LinkedList<>();
    }
    public int getSize(){
        return v.size();
    }
    public void addPerson(String name){
        Person p = new Person(name);
        for (int i = 0; i < v.size(); i++) {
            v.get(i).addRep(p, 0);
        }
        for (int i = 0; i < v.size(); i++) {
            p.addRep(v.get(i), 0);
        }
        v.add(p);
    }
    
    //add one person into the LinkedList
    public void addPerson(String name, int div_rate, int [] lun_time,int [] lun_period){
        Person p = new Person(name,div_rate,lun_time,lun_period);
        for (int i = 0; i < v.size(); i++) {
            v.get(i).addRep(p, 0);
        }
        for (int i = 0; i < v.size(); i++) {
            p.addRep(v.get(i), 0);
        }
        v.add(p);
    }
    
    //add one person into the LinkedList
    public void addFriend(Person p1 ,Person p2, int type){
        p1.addF(p2, type);// add person2 into person1's friends list
        p2.addF(p1, type);// add person1 into person2's friends list
    }
    
    public void addFriend(Person p1 ,Person p2){
        p1.addF(p2, 1);// add person2 into person1's friends list
        p2.addF(p1, 1);// add person1 into person2's friends list
    }
    
    //search and return the person info with name
    public Person getPerson(String name){
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).getName().equals(name)){
                return v.get(i);
            }
        }
        return null;
    }

    //get the average reputation point
    public int getAveRep(Person p){
        int sum = 0; 
        int count = 0;
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).equals(p)){
                continue;
            }else{
                if(v.get(i).getRep(p)!=0){
                    sum+= v.get(i).getRep(p);
                    count++;
                }
            }
        }
        return sum/count;
    }
    
    //search and return the person by using index
    public Person getPerson(int a){
        return v.get(a);
    }
    
    //print the vertex and its edge in the graph
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
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < v.get(i).reputation.size(); j++) {
                System.out.println(v.get(i).getName()+" >>> "+v.get(i).reputation.get(j).toString());
            }
        }
        return z;
    }
    
    //check whether the list contains the person
    public boolean contains(String name){
        for (int i = 0; i < v.size(); i++) {
            if(v.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    //copy the contents into Person[] array
    public Person[] toArray(){
        Person[] p = new Person[v.size()];
        for (int i = 0; i < v.size(); i++) {
            p[i]=v.get(i);
        }
        return p;
    }
    public LinkedList<Person> toLinkedList(){
        return v;
    }
}
