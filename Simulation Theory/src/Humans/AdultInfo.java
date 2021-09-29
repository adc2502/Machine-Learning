package Humans;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class AdultInfo {

    public static Random generator = new Random();

    public static int mix(int min, int max) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min) + min;
    }

    public static String[] KID_NAMES = {"Andreas", "Jay", "Sam", "Anna", "Holly", "Frank", "John", "Joe",
            "Isobel", "June", "Camilla"};

    public static String[] JOBS = {"chef", "Engineer", "Plumber"};


    public static AdultInfo getAdultInfo() throws IOException {
        return new AdultInfo(AdultInfo.JOBS[mix(0, JOBS.length)], Humans.LineToValue(Humans.Random(0, 721), "721_Names.txt"));
    }

    public String kids;
    public String job;

    public AdultInfo(String job, String kids) {
        this.job = job;
        this.kids = kids;
    }

    public void PrintAdultStats() {
        System.out.println("Job: " + this.job);
        System.out.println("Kid: " + this.kids);

    }


}
