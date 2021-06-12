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
public class Extra6 {
    static LinkedList<Person> vaccinated = new LinkedList<>();
    static ArrayList<ArrayList<Person>> cluster = new ArrayList<>();
    static ArrayList<Person> visited = new ArrayList<>();
    public static void herdImmunity(int vaccine, Relationship r){
        vaccinated.clear();
        cluster.clear();
        visited.clear();
        System.out.println("Extra feature 6 running:");
        System.out.println("Total vaccine number : "+vaccine);
        if (vaccine >= r.getSize()){
            System.out.println("Since the number of vaccine >= number of people, everyone is vaccinated.");
        }else{
            while(vaccine != 0 ){
                cluster.clear();
                visited.clear();
                LinkedList<Person> personlist = r.toLinkedList();
                for (int j = 0; j < vaccinated.size(); j++) {
                    visited.add(vaccinated.get(j));
                }
                for (int i = 0; i < personlist.size(); i++) {
                    if(!visited.contains(personlist.get(i))){
                        ArrayList<Person> a = new ArrayList<>();
                        BFS(personlist.get(i),a);
                        cluster.add(a);
                    } 
                }
                for (int i = 0; i < cluster.size(); i++) {
                    System.out.print("Cluster "+(i+1)+" : ");
                    for (int j = 0; j < cluster.get(i).size(); j++) {
                        System.out.print(cluster.get(i).get(j).toString()+" ");
                    }
                    System.out.println("");
                }
                int max = 0;
                Person p = null;
                for (int i = 0; i < personlist.size(); i++) {
                    cluster.clear();
                    visited.clear();
                    
                    for (int j = 0; j < vaccinated.size(); j++) {
                        visited.add(vaccinated.get(j));
                    }
                    if(visited.contains(personlist.get(i))){
                        continue;
                    }
                    visited.add(personlist.get(i));
                    for (int j = 0; j < personlist.size(); j++) {
                        if(!visited.contains(personlist.get(j))){
                            ArrayList<Person> a = new ArrayList<>();
                            BFS(personlist.get(j),a);
                            cluster.add(a);
                        } 
                    }
                    if(cluster.size()>max){
                        max = cluster.size();
                        p = personlist.get(i);
                    }
                }
                vaccinated.add(p);
                System.out.println("People vaccinated : "+p.getName());
                vaccine--;
            } 
        }
    }
    public static void BFS(Person src,ArrayList<Person> a){
        visited.add(src);
        a.add(src);
        LinkedList<Friend> f = src.friend;
        for (int i = 0; i < f.size(); i++) {
            if(!visited.contains(f.get(i).personDetail())){       
               BFS(f.get(i).personDetail(),a);
            }
        }
    }
}
