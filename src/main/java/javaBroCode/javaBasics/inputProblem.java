package javaBroCode.javaBasics;

import java.util.Scanner;

public class inputProblem {

    public static void main(String[] arg){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        /*
        without it your favorite color would be "/n" because there is a problem in java
        that after a int input you cannot input a string. so this just empty the
        input buffer.
        */
        input.nextLine();

        System.out.print("Enter your favorite color : ");
        String color = input.nextLine();

        System.out.println("your age is " + age + ".");
        System.out.println("you like the " + color + "color.");

        input.close();

    }

}
