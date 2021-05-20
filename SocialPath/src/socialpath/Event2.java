package socialpath;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Event2 {
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

        chitchat(r);
        System.out.println(r.toString());

    }

    public static Relationship chitchat(Relationship r) {
        Scanner sc = new Scanner(System.in);
        double newWeight = 0;
        String[] arr = new String[4];
        System.out.println("Enter the conclusion of chitchat: (A says good/bad about B to C)");
        String s = sc.nextLine();
        String[] arr1 = s.split(" ");
        System.out.println(arr1.toString());
        arr[0] = arr1[0]; //Person A
        arr[1] = arr1[4]; //Person B
        arr[2] = arr1[6]; //Person C
        arr[3] = arr1[2]; //good or bad
        try {
            Person personA=r.getPerson(arr[0]);
            Person personB=r.getPerson(arr[1]);
            Person personC=r.getPerson(arr[2]);

            if (arr[3].equals("good")) {
                int AtoB=0;
                int CtoB=0;
                for(int i=0;i<personA.friend.size();i++){
                    if(personA.friend.get(i).friendDetail().equals(personB)) {
                        AtoB= i;
                    }
                }
                for(int i=0;i<personC.friend.size();i++){
                    if(personC.friend.get(i).friendDetail().equals(personB)) {
                        CtoB = i;
                    }
                }
                double A_B=personA.friend.get(AtoB).getLove();
                newWeight=(A_B*0.5)+personC.friend.get(CtoB).getLove();
                personC.setF(personB, newWeight);

           } else if (arr[3].equals("bad")) {
                int AtoB=0;
                int CtoB=0;
                for(int i=0;i<personA.friend.size();i++){
                    if(personA.friend.get(i).friendDetail().equals(personB)) {
                        AtoB= i;
                    }
                }
                for(int i=0;i<personC.friend.size();i++){
                    if(personC.friend.get(i).friendDetail().equals(personB)) {
                        CtoB = i;
                    }
                }
                double A_B=personA.friend.get(AtoB).getLove();
                newWeight=personC.friend.get(CtoB).getLove()-A_B;
                personC.setF(personB, newWeight);

           } else {
                System.out.println("Your input format is wrong.");
           }

        } catch (NoSuchElementException e) {
            System.out.println("There is no connection between the input vertices.");
            return r;
        }
            return r;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
