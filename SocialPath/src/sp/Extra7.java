package sp;

import java.util.Random;

public class Extra7 {
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
        r.addFriend(r.getPerson("5"), r.getPerson("7"));
        r.addFriend(r.getPerson("6"), r.getPerson("2"));
        r.addFriend(r.getPerson("7"), r.getPerson("1"));
        r.addFriend(r.getPerson("7"), r.getPerson("5"));
        r.addFriend(r.getPerson("8"), r.getPerson("4"));
        r.addFriend(r.getPerson("9"), r.getPerson("10"));
        r.addFriend(r.getPerson("10"), r.getPerson("4"));
        r.addFriend(r.getPerson("10"), r.getPerson("9"));
        System.out.println(r.getPerson("1").friend.toString());
    }

    public static boolean sixdegree(Relationship r){
        Random rand=new Random();
        int n=rand.nextInt(r.size());
        System.out.println("Random person is "+r.getPerson(n).getName()+".");
        r.addPerson("Ken Thompson");
        Person ken=r.getPerson("Ken Thompson");
        r.addFriend(ken, r.getPerson(n));
        r.addFriend(r.getPerson(n), ken);





        return false;
    }

}
