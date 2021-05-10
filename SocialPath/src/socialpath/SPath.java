/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialpath;

/**
 *
 * @author chunfang
 */
public class SPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Relationship r = new Relationship();
        r.addPerson("v1");
        r.addPerson("v2");
        r.addPerson("v3");
        Person v1 = r.getPerson("v1");
        Person v2 = r.getPerson("v2");
        v1.addF(v2, 1);
        r.addFriend(v2, v1, 3);
        r.addFriend(v2, v1, 3);
        r.getPerson("v3").addF(v2, 5);
        System.out.println(r.toString());

    }
    
}
