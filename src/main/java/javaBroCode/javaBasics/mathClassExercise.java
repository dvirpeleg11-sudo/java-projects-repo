package javaBroCode.javaBasics;

public class mathClassExercise {

    public static void main(String[] args){

        System.out.printf("pi is equal to this with only two numbers after the '.': %.2f\n", Math.PI);

        double result;

        result = Math.pow(5, 2);

        System.out.println(result);

        int rounded = (int) Math.floor(Math.PI);

        System.out.print(Math.min(rounded, result));

    }

}
