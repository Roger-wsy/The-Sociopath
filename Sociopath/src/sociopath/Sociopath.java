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
public class Sociopath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Relationship r = new Relationship();
        init(r);
        
//        Event1.askQuestion(r.getPerson("v1"), r.getPerson("v3"), true);
//        Event2.chitchat(r.getPerson("v1"), r.getPerson("v2"), r.getPerson("v3"), false);
//        Event3.haveLunch(r.getPerson("v3"),r);
//        Event4.arrangebook();
//        Event5.meetCrush(r.getPerson("v3"), r.getPerson("v7"));
//        Event6.friendShip();
//        Extra4.haveMoreLunch(r.getPerson("v5"), r);
//        Extra6.herdImmunity(4, r);
//        Extra7.sixDegree(r,r.getPerson("v3"));
//        System.out.println(r.toString());
        
    }
 
    
    
    
    
    public static void init(Relationship r){
        // initialize person info (name, div_rate, lun_time, lun_period) addPerson in Relationship class)
        // 0 < Diving rate (%) < 100        
        // 1100 <= lunch time <= 1400
        // 5 < lunch period(minutes) < 60
        r.addPerson("v1",10, new int[] {1145, 1145, 1145, 1245, 1245, 1300, 1300}, new int[] {15, 20, 25, 15, 20, 30, 30});
        r.addPerson("v2",15, new int[] {1315, 1315, 1215, 1215, 1315, 1330, 1330}, new int[] {30, 25, 30, 25, 30, 35, 35});
        r.addPerson("v3",20, new int[] {1200, 1230, 1300, 1100, 1400, 1130, 1330}, new int[] {30, 30, 30, 30, 30, 55, 55});
        r.addPerson("v4",25, new int[] {1215, 1115, 1215, 1215, 1215, 1315, 1315}, new int[] {15, 20, 25, 15, 20, 25, 20});
        r.addPerson("v5",30, new int[] {1215, 1230, 1245, 1145, 1315, 1200, 1300}, new int[] {25, 25, 25, 25, 25, 45, 45});
        r.addPerson("v6",35, new int[] {1100, 1100, 1100, 1100, 1100, 1200, 1200}, new int[] {15, 15, 15, 10, 10, 55, 55});
        r.addPerson("v7",40, new int[] {1200, 1200, 1200, 1200, 1200, 1300, 1300}, new int[] {30, 30, 30, 30, 30, 35, 35});
        r.addPerson("v8",45, new int[] {1230, 1230, 1230, 1230, 1230, 1200, 1200}, new int[] {20, 20, 20, 20, 20, 30, 30});
        r.addPerson("v9",50, new int[] {1215, 1230, 1245, 1145, 1315, 1200, 1300}, new int[] {25, 25, 25, 25, 25, 45, 45});
        r.addPerson("v10",5, new int[] {1215, 1230, 1245, 1215, 1245, 1230, 1230}, new int[] {30, 30, 30, 30, 30, 40, 40});
        
        //set reputation
        //1 <= rep <= 10        
        r.getPerson("v1").setRep(r.getPerson("v2"), 5);
        r.getPerson("v1").setRep(r.getPerson("v7"), 4);
        r.getPerson("v2").setRep(r.getPerson("v1"), 8);
        r.getPerson("v2").setRep(r.getPerson("v3"), 5);
        r.getPerson("v2").setRep(r.getPerson("v5"), 6);
        r.getPerson("v2").setRep(r.getPerson("v6"), 9);
        r.getPerson("v3").setRep(r.getPerson("v2"), 4);
        r.getPerson("v4").setRep(r.getPerson("v8"), 7);
        r.getPerson("v4").setRep(r.getPerson("v10"), 7);
        r.getPerson("v5").setRep(r.getPerson("v2"), 2);
        r.getPerson("v6").setRep(r.getPerson("v2"), 7);
        r.getPerson("v7").setRep(r.getPerson("v1"), 3);
        r.getPerson("v8").setRep(r.getPerson("v4"), 10);
        r.getPerson("v9").setRep(r.getPerson("v10"), 5);
        r.getPerson("v10").setRep(r.getPerson("v4"), 7);
        r.getPerson("v10").setRep(r.getPerson("v9"), 6);

        //make them become friends
        r.addFriend(r.getPerson("v1"), r.getPerson("v2"));
        r.addFriend(r.getPerson("v1"), r.getPerson("v7"));
        r.addFriend(r.getPerson("v2"), r.getPerson("v3"));
        r.addFriend(r.getPerson("v2"), r.getPerson("v5"));
        r.addFriend(r.getPerson("v2"), r.getPerson("v6"));
        r.addFriend(r.getPerson("v4"), r.getPerson("v8"));
        r.addFriend(r.getPerson("v4"), r.getPerson("v10"));
        r.addFriend(r.getPerson("v9"), r.getPerson("v10"));
        
        
    }
    
}
