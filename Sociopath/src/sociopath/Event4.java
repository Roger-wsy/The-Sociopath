/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sociopath;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author chunfang
 */
public class Event4 {
    public static void arrangebook(){
        //Scanner read the input
        Scanner sc=new Scanner(System.in);
        //linkedlist to store the value
        LinkedList<Integer>list=new LinkedList<>();
        LinkedList<Integer>temp=new LinkedList<>();

        System.out.print("Book Number : ");
        int no_of_books=sc.nextInt();
        System.out.println("");
        int count=0;
        System.out.print("Book arrangement : ");
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
        System.out.println("The number of round is "+count);
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
