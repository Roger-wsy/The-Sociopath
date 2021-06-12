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
                for (int i = 0; i < vaccinated.size(); i++) {
                    visited.add(vaccinated.get(i));
                }
                vaccine--;
                LinkedList<Person> personlist = r.toLinkedList();
                for (int i = 0; i < personlist.size(); i++) {
                    if(!visited.contains(personlist.get(i))){
                        ArrayList<Person> a = new ArrayList<>();
                        BFS(personlist.get(i),a);
                        cluster.add(a);
                    }
                }
                int max_clu_size = 0;
                int max_clu = -1;
                for (int i = 0; i < cluster.size(); i++) {
                    if(cluster.get(i).size()>max_clu_size){
                        max_clu_size = cluster.get(i).size();
                        max_clu = i ;
                    }
                }
                for (int i = 0; i < cluster.size(); i++) {
                    System.out.print("Cluster "+(i+1)+" : ");
                    for (int j = 0; j < cluster.get(i).size(); j++) {
                        System.out.print(cluster.get(i).get(j).toString()+" ");
                    }
                    System.out.println("");
                }
                int maxoutdeg = 0;
                int maxoutdegindex = -1;
                for (int i = 0; i < cluster.get(max_clu).size(); i++) {
                    LinkedList<Friend> f = cluster.get(max_clu).get(i).friend;
                    int count = 0;
                    for (int j = 0; j < f.size(); j++) {
                        if(vaccinated.contains(f.get(j).personDetail())){
                            count++;
                        }
                    }
                    int outdeg = f.size() - count;
                    if(outdeg>maxoutdeg){
                        maxoutdeg = outdeg;
                        maxoutdegindex = i;
                    }
                }
                System.out.println("People vaccinated : "+cluster.get(max_clu).get(maxoutdegindex).getName());
                vaccinated.add(cluster.get(max_clu).get(maxoutdegindex));
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
