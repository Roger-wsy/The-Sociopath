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
public class Event2 {
    //p1 is talker
    //p2 is listener
    //p3 is targetperson
    public static void chitchat(Person p1, Person p2, Person p3, boolean rate){
        System.out.println("Event 2 running:");
        System.out.println(p1.getName()+" chitchat with "+p2.getName()+" about "+p3.getName()+".");
        if (rate){
            System.out.println("Before chitchatting, "+p2.getName()+" has "+p2.getRep(p3)+" reputation point towards "+p3.getName()+".");
            p2.setRep(p3, (int)(p2.getRep(p3)+p1.getRep(p3)*0.5));
            System.out.println(p1.getName()+" talks about good side of "+p3.getName()+".");
            System.out.println("After chitchatting, "+p2.getName()+" has "+p2.getRep(p3)+" reputation point towards "+p3.getName()+".");
        }
        else {
            System.out.println("Before chitchatting, "+p2.getName()+" has "+p2.getRep(p3)+" reputation point towards "+p3.getName()+".");
            p2.setRep(p3, (int)(p2.getRep(p3)-p1.getRep(p3)));
            System.out.println(p1.getName()+" talks about bad side of "+p3.getName()+".");
            System.out.println("After chitchatting, "+p2.getName()+" has "+p2.getRep(p3)+" reputation point towards "+p3.getName()+".");
        }
        System.out.println();
    }
}
