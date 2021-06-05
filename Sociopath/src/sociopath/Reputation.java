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
public class Reputation {
    private Person f ;
    private int reputation;

    public Reputation(Person f, int reputation) {
        this.f = f;
        this.reputation = reputation;
    }
    public String toString(){
        return f.getName() +" rep point : "+reputation;
    }
    public Person personDetail(){
        return f;
    }

    public int getRep() {
        return reputation;
    }

    public void setRep(int reputation) {
        this.reputation = reputation;
    }
}
