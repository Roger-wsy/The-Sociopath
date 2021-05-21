package sp;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class Event1 {
    public static void main(String[] args) {
        Relationship r = new Relationship();
        r.addPerson("v1");
        r.addPerson("v2");
        r.addPerson("v3");
        Person v1 = r.getPerson("v1");
        Person v2 = r.getPerson("v2");
        Person v3 = r.getPerson("v3");
        v1.addF(v2, 1);
        r.addFriend(v2, v1, 3);
        r.addFriend(v1, v3, 3);
        r.addFriend(v2, v3, 3);
        r.addFriend(v3, v1, 3);
        r.getPerson("v3").addF(v2, 5);
        System.out.println(r.toString());

        labQuestions(r);
        System.out.println(r.toString());

    }

    public static void labQuestions(Relationship r){
        Scanner sc = new Scanner(System.in);
        String[] array1 = new String[3];
        double newWeight=0;
        System.out.println("Enter the conclusion of solving lab questions: (A did good/bad to B): ");
        String str = sc.nextLine();
        String[] array = str.split(" ");
        array1[0] = array[0]; //Person A
        array1[2] = array[2]; //good/bad
        array1[1] = array[4]; //Person B
        //


        try {
            Person personA = r.getPerson(array1[0]);
            Person personB = r.getPerson(array1[1]);
            if(array1[2].equals("good")){
                int AtoB=0;
                for (int i = 0; i < personA.friend.size(); i++) {
                    if (personA.friend.get(i).friendDetail().equals(personB)) {
                        AtoB=i;
                    }
                }
                newWeight =  personA.friend.get(AtoB).getLove()+10;
                personA.setF(personB, newWeight);
            }else if(array1[2].equals("bad")){
                int AtoB=0;
                for (int i = 0; i < personB.friend.size(); i++) {
                    if (personB.friend.get(i).friendDetail().equals(personA)) {
                        AtoB=i;
                    }
                }
                newWeight =  personA.friend.get(AtoB).getLove()-2;
                personA.setF(personB, newWeight);
            }

        } catch (NoSuchElementException e) {
            System.out.println("There is not connection");
        }
    }
}
