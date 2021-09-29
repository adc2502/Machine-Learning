package Humans;

import java.security.SecureRandom;

public class Emotions {

    public Emotions(double joy, double love, double compassion, double confidence, double pride, double empathy, double interest,
                    double motivation, double gratitude, double serenity, double comfort, double amusement, double hope,
                    double inspiration, double awe, double admiration, double appreciation, double calmness, double entrancement,
                    double excitement, double nostalgia, double satisfaction, double trust, double honesty, double courage,
                    double pity, double productive, double surprise, double anger, double anxiety, double fear, double distrust,
                    double horror, double awkwardness, double uncomfortable, double boredom, double annoyed, double sadness,
                    double suffering, double envy, double greed, double shame, double frustration) {

        this.joy = joy;
        this.love = love;
        this.compassion = compassion;
        this.confidence = confidence;
        this.pride = pride;
        this.empathy = empathy;
        this.interest = interest;
        this.motivation = motivation;
        this.gratitude = gratitude;
        this.serenity = serenity;
        this.comfort = comfort;
        this.amusement = amusement;
        this.hope = hope;
        this.inspiration = inspiration;
        this.awe = awe;
        this.admiration = admiration;
        this.appreciation = appreciation;
        this.calmness = calmness;
        this.entrancement = entrancement;
        this.excitement = excitement;
        this.nostalgia = nostalgia;
        this.satisfaction = satisfaction;
        this.trust = trust;
        this.honesty = honesty;
        this.courage = courage;
        this.pity = pity;
        this.productive = productive;
        this.surprise = surprise;
        this.anger = anger;
        this.anxiety = anxiety;
        this.fear = fear;
        this.distrust = distrust;
        this.horror = horror;
        this.awkwardness = awkwardness;
        this.uncomfortable = uncomfortable;
        this.boredom = boredom;
        this.annoyed = annoyed;
        this.sadness = sadness;
        this.suffering = suffering;
        this.envy = envy;
        this.greed = greed;
        this.shame = shame;
        this.frustration = frustration;
    }

    // 43 emotions

    // positive
    public double joy;
    public double love;
    public double compassion;
    public double confidence;
    public double pride;
    public double empathy;
    public double interest;
    public double motivation;
    public double gratitude;
    public double serenity;
    public double comfort;
    public double amusement;
    public double hope;
    public double inspiration;
    public double awe;
    public double admiration;
    public double appreciation;
    public double calmness;
    public double entrancement;
    public double excitement;
    public double nostalgia;
    public double satisfaction;
    public double trust;
    public double honesty;
    public double courage;
    public double pity;
    public double productive;

    // neutral
    public double surprise;

    // negative
    public double anger;
    public double anxiety;
    public double fear;
    public double distrust;
    public double horror;
    public double awkwardness;
    public double uncomfortable;
    public double boredom;
    public double annoyed;
    public double sadness;
    public double suffering;
    public double envy;
    public double greed;
    public double shame;
    public double frustration;

    public static double distribution(double sd, double mean) {
        SecureRandom secureRandom = new SecureRandom();
        return Humans.round((secureRandom.nextGaussian()*sd) + mean, 2);
    }

    public static int mix(int min, int max) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min) + min;
    }

    public static double getAverage(double[] values){
        double total = 0;

        for(double v: values){
            total += v;
        }

        return total/values.length;
    }

    public static double gratitude(double compassion, double empathy){
        return getAverage(new double[]{compassion, empathy});
    }

    // fear, anger, sadness, joy, shame (maybe), [ base emotions ]

    public static Emotions getEmotions(int age){
        // positive
        double joy = 0;
        double love = 0;
        double compassion = 0;
        double confidence = 0;
        double pride = 0;
        double empathy = 0;
        double interest = 0;
        double motivation = 0;
        double gratitude = 0;
        double serenity = 0;
        double comfort = 0;
        double amusement = 0;
        double hope = 0;
        double inspiration = 0;
        double awe = 0;
        double admiration = 0;
        double appreciation = 0;
        double calmness = 0;
        double entrancement = 0;
        double excitement = 0;
        double nostalgia = 0;
        double satisfaction = 0;
        double trust = 0;
        double honesty = 0;
        double courage = 0;
        double pity = 0;
        double productive = 0;

        // neutral
        double surprise = 0;

        // negative
        double anger = 0;
        double anxiety = 0;
        double fear = 0;
        double distrust = 0;
        double horror = 0;
        double awkwardness = 0;
        double uncomfortable = 0;
        double boredom = 0;
        double annoyed = 0;
        double sadness = 0;
        double suffering = 0;
        double envy = 0;
        double greed = 0;
        double shame = 0;
        double frustration = 0;




        if(age <= 14){
            // Early Teen

            // positive
            joy = distribution(.1, .65);
            love = 0;
            compassion = distribution(.1, .65);
            confidence = distribution(.1, .65);
            pride = 0;
            empathy = distribution(.1, .65);
            interest = 0;
            motivation = 0;
            gratitude = gratitude(compassion, empathy);
            serenity = 0;
            comfort = 0;
            amusement = 0;
            hope = 0;
            inspiration = 0;
            awe = 0;
            admiration = 0;
            appreciation = 0;
            calmness = 0;
            entrancement = 0;
            excitement = 0;
            nostalgia = 0;
            satisfaction = 0;
            trust = 0;
            honesty = 0;
            courage = 0;
            pity = 0;
            productive = 0;

            // neutral
            surprise = 0;

            // negative
            anger = distribution(.1, .3);
            anxiety = 0;
            fear = distribution(.1, .3);
            distrust = 0;
            horror = 0;
            awkwardness = 0;
            uncomfortable = 0;
            boredom = 0;
            annoyed = 0;
            sadness = distribution(.1, .3);
            suffering = 0;
            envy = 0;
            greed = 0;
            shame = distribution(.1, .3);
            frustration = 0;

        } else {
            // positive
            joy = 0;
            love = 0;
            compassion = distribution(.1, .65);
            confidence = distribution(.1, .65);
            pride = 0;
            empathy = distribution(.1, .65);
            interest = 0;
            motivation = 0;
            gratitude = gratitude(compassion, empathy);
            serenity = 0;
            comfort = 0;
            amusement = 0;
            hope = 0;
            inspiration = 0;
            awe = 0;
            admiration = 0;
            appreciation = 0;
            calmness = 0;
            entrancement = 0;
            excitement = 0;
            nostalgia = 0;
            satisfaction = 0;
            trust = 0;
            honesty = 0;
            courage = 0;
            pity = 0;
            productive = 0;

            // neutral
            surprise = 0;

            // negative
            anger = 0;
            anxiety = 0;
            fear = 0;
            distrust = 0;
            horror = 0;
            awkwardness = 0;
            uncomfortable = 0;
            boredom = 0;
            annoyed = 0;
            sadness = 0;
            suffering = 0;
            envy = 0;
            greed = 0;
            shame = 0;
            frustration = 0;
        }





        return new Emotions(
                // positive
                joy,
                love,
                compassion,
                confidence,
                pride,
                empathy,
                interest,
                motivation,
                gratitude,
                serenity,
                comfort,
                amusement,
                hope,
                inspiration,
                awe,
                admiration,
                appreciation,
                calmness,
                entrancement,
                excitement,
                nostalgia,
                satisfaction,
                trust,
                honesty,
                courage,
                pity,
                productive,

                // neutral
                surprise,

                // negative
                anger,
                anxiety,
                fear,
                distrust,
                horror,
                awkwardness,
                uncomfortable,
                boredom,
                annoyed,
                sadness,
                suffering,
                envy,
                greed,
                shame,
                frustration);
    }

    public void PrintEmotions(){

        System.out.println("Confidence: " + this.confidence);
        System.out.println("Compassion: " + this.compassion);
        System.out.println("Empathy: " + this.empathy);
        System.out.println("Gratitude: " + this.gratitude);


    }

























}
