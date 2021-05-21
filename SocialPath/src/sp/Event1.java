package sp;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class Event1 {
    public static void main(String[] args) {
        Relationship r = new Relationship();


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
        if(!r.contains(array1[0])){
            r.addPerson(array1[0]);
        }
        if(!r.contains(array1[1])){
            r.addPerson(array1[1]);
        }
        Person personA = r.getPerson(array1[0]);
        Person personB = r.getPerson(array1[1]);


        personA.addF(personB, 0);
        personB.addF(personA, 0);
        try {

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
                personA.setF(personB, 2);
            }

        } catch (NoSuchElementException e) {
            System.out.println("There is not connection");
        }
    }
}
