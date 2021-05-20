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
public class Friend {
    private Person f ;
    private double love;

    public Friend(Person f, double love) {
        this.f = f;
        this.love = love;
    }
    public String toString(){
        return f.getName() +" weight : "+love;
    }
    public Person friendDetail(){
        return f;
    }

    public double getLove() {
        return love;
    }

    public void setLove(double love) {
        this.love = love;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
