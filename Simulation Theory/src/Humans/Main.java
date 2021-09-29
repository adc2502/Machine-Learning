package Humans;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Human[] people = Humans.generateHumans(4);
        /*
         This is correct

        for(int i=0; i < 100; i++){
            int rand = Humans.Random(1,10);
            System.out.println(Humans.LineToValue(rand, "Adjectives/adj_example.txt"));
        }
         */


        Arrays.stream(people).forEach(Human::printStats);
        int gay = 0;
        int bisexual = 0;
        int straight = 0;
        /*
        for (Human person : people) {
            if(person.sexualOrientation.equals("gay")){
                gay++;
            } else if(person.sexualOrientation.equals("bisexual")){
                bisexual++;
            } else if(person.sexualOrientation.equals("straight")){
                straight++;
            }
        }

        System.out.println("Straight: " + (straight / people.length)*100 + "%");
        System.out.println("Gay: " + (gay / people.length)*100 + "%");
        System.out.println("Bisexual: " + (bisexual / people.length)*100 + "%");

         */

    }


}
