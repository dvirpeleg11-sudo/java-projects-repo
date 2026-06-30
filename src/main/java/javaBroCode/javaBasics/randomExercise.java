package javaBroCode.javaBasics;

import java.util.Random;

public class randomExercise {

    public static void main(String[] arg){

        Random randomObj = new Random();

        int integerVar;

        integerVar = randomObj.nextInt(1, 7);

        double doubleVar;

        doubleVar = randomObj.nextDouble(1, 7);

        boolean booleanVar;

        booleanVar = randomObj.nextBoolean();

    }

}
