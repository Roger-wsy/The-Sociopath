import java.util.LinkedList;
import java.util.Scanner;

public class Event4 {
    public static void main(String[] args) {
        //Scanner read the input
        Scanner sc=new Scanner(System.in);
        //linkedlist to store the value
        LinkedList<Integer>list=new LinkedList<>();
        LinkedList<Integer>temp=new LinkedList<>();

        int no_of_books=sc.nextInt();
        int count=0;

        //loop to add the height of book one by one
        for(int i=0;i<no_of_books;i++){
            list.add(i, sc.nextInt());
        }

        //to check the height
        boolean check=checker(list.size(), list);
        int x=0;
        while(check){
            for(int i=1;i<list.size();i++){
                if(list.get(i)>list.get(i-1)){
                    temp.add(i);
                }
            }
            for(int i=0;i<temp.size();i++){
                x=temp.get(i);
                list.remove(x);
                for(int j=i+1;j<temp.size();j++){
                    temp.set(j, temp.get(j)-1);
                }

            }
            count++;
            temp.clear();
            check=checker(list.size(), list);
        }
        System.out.println(count);
    }

    public static boolean checker(int no_of_books,LinkedList<Integer> list){
        boolean check=false;
        int first_height=list.get(0);
        for(int i=1;i<no_of_books;i++){
            if(list.get(i)>first_height){
                check=true;
                break;
            }else{
                check=false;
            }
        }
        return check;
    }
}
