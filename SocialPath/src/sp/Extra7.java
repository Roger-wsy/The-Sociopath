package sp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Extra7 {

    static ArrayList<ArrayList<Person>> path = new ArrayList<>();

    public static void main(String[] args) {
        Relationship r = new Relationship();
        r.addPerson("1");
        r.addPerson("2");
        r.addPerson("3");
        r.addPerson("4");
        r.addPerson("5");
        r.addPerson("6");
        r.addPerson("7");
        r.addPerson("8");
        r.addPerson("9");
        r.addPerson("10");

        r.addFriend(r.getPerson("1"), r.getPerson("2"));
        r.addFriend(r.getPerson("1"), r.getPerson("7"));
        r.addFriend(r.getPerson("2"), r.getPerson("1"));
        r.addFriend(r.getPerson("2"), r.getPerson("3"));
        r.addFriend(r.getPerson("2"), r.getPerson("5"));
        r.addFriend(r.getPerson("2"), r.getPerson("6"));
        r.addFriend(r.getPerson("3"), r.getPerson("2"));
        r.addFriend(r.getPerson("4"), r.getPerson("8"));
        r.addFriend(r.getPerson("4"), r.getPerson("10"));
        r.addFriend(r.getPerson("5"), r.getPerson("2"));
        r.addFriend(r.getPerson("6"), r.getPerson("2"));
        r.addFriend(r.getPerson("7"), r.getPerson("1"));
        r.addFriend(r.getPerson("8"), r.getPerson("4"));
        r.addFriend(r.getPerson("9"), r.getPerson("10"));
        r.addFriend(r.getPerson("10"), r.getPerson("4"));
        r.addFriend(r.getPerson("10"), r.getPerson("9"));
        sixdegree(r);
        methodTransfer(r.getPerson("1"), r.getPerson("Ken Thompson"), new ArrayList<Person>());
        if (path.size() == 0) {
            System.out.println("no connecttion");
        }else{
            int length = path.get(0).size();
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i).toString());
                if(path.get(i).size()<length){    
                    length = path.get(i).size();
                }
            }
            System.out.println("hope: "+(length-1));
            if (length-1>6) {
                System.out.println("The six degrees of ken Thompson theory is not proven");
            }else{
                System.out.println("The six degrees of ken Thompson theory is proven");
            }
            
        }
    }

    public static boolean sixdegree(Relationship r) {
        Random rand = new Random();
        int n = rand.nextInt(r.size());
        System.out.println("Random person is " + r.getPerson(n).getName() + ".");
        r.addPerson("Ken Thompson");
        Person ken = r.getPerson("Ken Thompson");
        r.addFriend(ken, r.getPerson(n));
        r.addFriend(r.getPerson(n), ken);
        return false;
    }

    public static void methodTransfer(Person src, Person des, ArrayList<Person> arr) {
        LinkedList<Friend> f = src.friend;
        arr.add(src);
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).friendDetail().equals(des)) {
                ArrayList<Person> newArr = new ArrayList<>();
                for (int j = 0; j < arr.size(); j++) {
                    newArr.add(arr.get(j));
                }
                newArr.add(des);
                path.add(newArr);
            } else {
                if (!arr.contains(f.get(i).friendDetail())) {
                    ArrayList<Person> newArr = new ArrayList<>();
                    for (int j = 0; j < arr.size(); j++) {
                        newArr.add(arr.get(j));
                    }
                    methodTransfer(f.get(i).friendDetail(), des, newArr);
                }
            }
        }
    }
}
