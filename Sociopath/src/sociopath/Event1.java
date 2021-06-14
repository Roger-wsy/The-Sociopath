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
public class Event1 {
    // p2 is teacher, p1 is student, rate is good or not
    public static void askQuestion(Person p1, Person p2, boolean rate){
        System.out.println("Event 1 running:");
        // if they are not strangers, event 1 will not run because the question mentions that the person seeking help is a stranger.
        if (p2.containF(p1)||p1.containF(p2)){ //check whether they are friends
            System.out.println(p2.getName()+" and "+p1.getName()+" are not strangers"+"."); //if there are friends, print message
        }
        else { //they are strangers
            System.out.println(p1.getName()+" asks "+p2.getName()+" about lab questions"+".");
             //print the reputation berfore teaching
            System.out.println("Before teaching, "+p1.getName()+" has "+p1.getRep(p2)+" reputation point towards "+p2.getName()+".");
            p1.addF(p2, 1); //make them friends
            p2.addF(p1, 1); //make them friends
            //true=teaches well, false=teaches badly
            if (rate){ //teaches well
                p1.setRep(p2, 10); //reputation point +10
                System.out.println(p2.getName()+" teaches "+p1.getName()+" very well.");
                System.out.println("After teaching, "+p1.getName()+" has "+p1.getRep(p2)+" reputation points towards "+p2.getName()+".");
            }
            else { //teaches badly
                p1.setRep(p2, 2); //reputation point +2
                System.out.println(p2.getName()+" teaches "+p1.getName()+" badly.");
                System.out.println("After teaching, "+p1.getName()+" has "+p1.getRep(p2)+" reputation points towards "+p2.getName()+".");
            }
        }
        System.out.println();
    }
}

