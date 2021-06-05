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
public class Friend {
    private Person f ;
    private int type;

    public Friend(Person f, int type) {
        this.f = f;
        this.type = type;
    }
    public String toString(){
        return f.getName() +" type : "+type;
    }
    public Person personDetail(){
        return f;
    }

    public double getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
