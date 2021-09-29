/*
This container is for a 10-14 year old.
Andreas Campbell
 */

package Humans;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;

public class EarlyTeen {

    // 1-7 importance: 1 being most important from Lucas

    // 9 emotions

    public String afterSchoolActivities;
    public ArrayList<String> friends; // 1
    public String schoolTopics; // 4
    public String lookingForwardTo; // 5
    public String kidGames; // 2
    public String schoolTrip; // 6
    public String teacherName; // 3
    public String teacherTitle;
    public String teacherGender;
    public String favouriteSubject;

    public EarlyTeen(ArrayList<String> friends, String schoolTopics, String lookingForwardTo, String kidGames, String schoolTrip,
                     String teacherName, String teacherTitle, String favouriteSubject) {

        this.friends = friends;
        this.schoolTopics = schoolTopics;
        this.lookingForwardTo = lookingForwardTo;
        this.kidGames = kidGames;
        this.schoolTrip = schoolTrip;
        this.teacherName = teacherName;
        this.teacherTitle = teacherTitle;
        this.favouriteSubject = favouriteSubject;
    }


    public static double distribution(int sd, double mean) {
        SecureRandom secureRandom = new SecureRandom();
        return (secureRandom.nextGaussian()*sd) + mean;
    }

    public static String ReturnExcept(String dontReturn){
        String check = EarlyTeen.KIDS_GAMES[Humans.Random(0, KIDS_GAMES.length)];
        if(check.equals(dontReturn)){
            ReturnExcept(dontReturn);
        }
        return check;
    }

    public static String[] SCHOOL_TOPICS = {"the ice age", "space", "ancient egypt", "jungle animals",
            "science", "planet earth", "the Victorians", "natural disasters", "the Romans", "he human body", "the vikings"};
    // could have a pair with the topic and quick description

    public static String[] LookingForwardTo;

    static {
        try {
            LookingForwardTo = new String[]{(Humans.LineToValue(Humans.Random(0, 721), "721_Names.txt") + "'s " + "birthday"),
                        "wedding", "holiday", "christmas", "halloween", "the easter bunny coming", "my birthday"};
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String PetActivity(String pet){
        String[][] petActivity = {{"chicken", "I go outside and feed and water them every day and in return we get beautiful fresh eggs!"},
                {"dog", "I love when I get my face licked and when we play with the tennis ball."},
                {"cat", "We sometimes play with one of my socks, but they always get holes in them."},
                {"hamster", "The annoying thing with hamsters is they always sleep. But sometimes we make an obstacle course for fun."},
                {"rabbit", "It's great because rabbits eat all the vegetables I don't want to eat."},
                {"snake", "My mum hates snakes so she won't even go in my room anymore!"},
                {"guinea pig", "Guinea pigs are the best! They are so cute and fun to play with everyone should get one."},
                {"lizard", "Lizards are so cool because they can hold on to walls and they are great at hiding."},
                {"fish", "Fish are very boring, I wish we could get a dog instead."},
                {"none", "All my friends have dogs so I hope my mum will let us get one soon. My dad wants a dog too."}};

        String activity = "";

        for(String[] petType: petActivity){
            if(petType[0].equals(pet)){
                activity = petType[1];
                break;
            }
        }
        return activity;
    }

    public String HasPet(String pet, String petName){
        if(pet.equals("none")){
            return "I'm trying to get my mum to buy a dog because I really want one.";
        } else {
            return ("At home I have a " + pet + " called " + petName + ". " + PetActivity(pet) + " ");
        }
    }

    public static String[] KIDS_GAMES = {"tig", "hide and seek", "bulldogs", "minecraft", "football", "on the trampoline", "among us", "whitehorse"};

    public static String[] SCHOOL_TRIP = {"Zoo", "beach", "castle", "national science museum", "christmas panto",
            "ice cream farm", "Victorian village", "aquarium"};

    public static String[] TEACHER_TITLE = {"Mr", "Mrs", "Miss", "Ms"};

    public static String[] GREETING = {"Hi", "Hello"};

    public static String[] FUTURE_TIME = {"next week", "tomorrow", "after the holidays", "in a month"};

    public static String[] FAVOURITE_SUBJECT = {"English", "maths", "science", "design and technology", "history",
            "geography", "art and design", "music", "P.E.", "computing", "modern foreign languages"};

    public static EarlyTeen getEarlyTeen() throws IOException {
        return new EarlyTeen(

                Humans.MultipleFriends(3, "721_Names.txt"),
                EarlyTeen.SCHOOL_TOPICS[Humans.Random(0, SCHOOL_TOPICS.length)],
                EarlyTeen.LookingForwardTo[Humans.Random(0, LookingForwardTo.length)],
                EarlyTeen.KIDS_GAMES[Humans.Random(0, KIDS_GAMES.length)],
                EarlyTeen.SCHOOL_TRIP[Humans.Random(0, SCHOOL_TRIP.length)],
                Humans.LineToValue(Humans.Random(0, 250), "409_Last_Names.txt"),
                EarlyTeen.TEACHER_TITLE[Humans.Random(0, TEACHER_TITLE.length)],
                EarlyTeen.FAVOURITE_SUBJECT[Humans.Random(0, EarlyTeen.FAVOURITE_SUBJECT.length)]

        );
    }

    public void PrintEarlyTeen(){
        friends.forEach(friend -> System.out.println("Friend: " + friend));
        System.out.println("School Topics: " + this.schoolTopics);
        System.out.println("Looking forward to: " + this.lookingForwardTo);
        System.out.println("Kids Game: " + this.kidGames);
        System.out.println("School Trip: " + this.schoolTrip);
        System.out.println("Teacher Name: " + this.teacherTitle + " " + this.teacherName);
        System.out.println("Favourite Subject: " + this.favouriteSubject);

    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //----------------------------------------------------Templates-----------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    public String Introduction(String name, int age) throws IOException {
        String introduction = (EarlyTeen.GREETING[Humans.Random(0, GREETING.length)] + ", i'm " + name + "." + '\n'
                + "I am " + age + ". ");

        return introduction;
    }

    public String SchoolExperience(ArrayList<String> friends) throws IOException {
        int teacherOpinion = Humans.Random(1, 7);
        String teacherPronoun = "";
        if(this.teacherTitle.equals("Mr")){
            teacherPronoun = "he";
        } else {
            teacherPronoun = "she";
        }

        String schoolExperience = ("At school we are learning all about " + this.schoolTopics + ", which is " + Humans.LineToValue(Humans.Random(1, 7), "/Adjectives/8_adj_school_topic_opinion.txt") +
                ". I " + Humans.LineToValue(teacherOpinion, "/Adjectives/7_adj_teacher_opinion.txt") + " my teacher " + this.teacherTitle + " " + this.teacherName + ", because " + teacherPronoun + " " +
                Humans.LineToValue(teacherOpinion, "/Adjectives/7_adj_teacher_opinion_reason.txt") + '\n' + "At school, my best friend is probably " + friends.get(0) + ", and we sit across from each other in class. ");
        return schoolExperience;
    }

    public String AfterSchool() throws IOException {
        String afterSchool = ("");

        return afterSchool;
    }


    public void BasicLetter(String name, int age) throws IOException {
        String letter = (Introduction(name, age) + SchoolExperience(this.friends)/* + " My best friend at school is " + this.friends.get(0)
                + " and we love to play " + this.kidGames + " together." + '\n' +
                "We are going to the " + this.schoolTrip + " " + EarlyTeen.FUTURE_TIME[Humans.Random(0, FUTURE_TIME.length)] +
                " which I can't wait for."*/);
        System.out.println();
        System.out.println(letter);

        // remove mix from theses
    }

    public void LucasTemplate(String name, String sportPlayed, String instrument, String pet, String favTvShow, String petName) throws IOException {
        System.out.println("Hi, I\u2019m " + name + ". At school my best friend " +
                "is " + this.friends.get(0) + ". We love playing\n" + this.kidGames + " together and I also " + Humans.LineToValue(Humans.Random(1, 6), "/Adjectives/6_adj_sports_opinion.txt") + " playing " + sportPlayed +
                " with my friends " + Humans.GenderToName("MALE") + " & " + Humans.GenderToName("") + ".\n" + HasPet(pet, petName) + "I also play " + instrument + " and I \nhave " + instrument + " lessons every Tuesday. " +
                "I really like watching a programme \ncalled " + favTvShow + " and its always on after school. " +
                "My other hobbies are playing " + EarlyTeen.ReturnExcept(this.kidGames) + " with " +
                "my brother " + Humans.GenderToName("MALE") + ".\n ");
    }

    // As my mum is Austrian, I speak german and sometimes even watch German shows on TV!

    //I\u2019m also in the Eggy Team, Eggy is basically\na comic " +
    //                "character who is an egg (You might have guessed that!) and\nevery time he dies a chicken comes over and " +
    //                "lays him again! Eggy\u2019s\nmain rivalry was Appley but we have now formed an Eggy-Appley\nteam together.


}
