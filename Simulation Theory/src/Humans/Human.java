package Humans;

import org.w3c.dom.ls.LSOutput;

import java.io.DataOutput;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Human {

    // 16-18yr will also need grades

    // for adults working, will need attribute for level of influence/position in hierarchy

    // 39 emotions

    // if you need glasses
    // piercings

    public String firstName;
    public String lastName;
    public int age;
    public String gender;
    public int heightInCM;
    public double weightInKg;
    public String nationality;
    public String hairColour;
    public String eyeColour;
    public String religion;
    public String sexualOrientation;

    public String pet;
    public String petName;
    public String personalityType;
    public String diet;
    public String physicalHealth;
    public LocalDate birthday;
    public String allergies;
    public String favouriteColour;

    public String relationshipWithParents;
    public String morningDrink;
    public String usualBreakfast;

    // interests
    public String interests; // interests should be an array eventually
    public String politicalViews;
    public String favouriteSong;
    public String favouriteFood;
    public String favouriteFilm;
    public String sportsToWatch;
    public String sportsToPlay;
    public String musicalInstrument;
    public int instrumentGrade;
    public String favouriteSubject; // e.g. Human Biology, which will eventually link to a job
    public String competitiveHobbies;
    public String favouriteTvShow;
    public String bookGenre;
    public String favouriteBook;
    public String guiltyPleasure;

    public EarlyTeen EarlyTeen;
    public AdultInfo AdultInfo;
    public MidTeen MidTeen;
    public Emotions Emotions;


    public Human(String firstName, String lastName, int age, String gender, int heightInCM, double weightInKg, String nationality,
                 String hairColour, String eyeColour, String interests, String favouriteFood, String favouriteFilm,
                 String pet, String petName, String favouriteSong, String personalityType, String diet, String physicalHealth,
                 LocalDate birthday, String allergies, String favouriteColour, String relationshipWithParents,
                 String musicalInstrument, int instrumentGrade, String morningDrink, String usualBreakfast,
                 String sportsToWatch, String sportsToPlay, String competitiveHobbies, String favouriteTvShow,
                 String bookGenre, String favouriteBook, String guiltyPleasure, String politicalViews,
                 String sexualOrientation, EarlyTeen earlyTeen, AdultInfo AdultInfo, MidTeen MidTeen, Emotions Emotions) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.heightInCM = heightInCM;
        this.weightInKg = weightInKg;
        this.nationality = nationality;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.interests = interests;
        this.favouriteFood = favouriteFood;
        this.favouriteFilm = favouriteFilm;
        this.pet = pet;
        this.petName = petName;
        this.favouriteSong = favouriteSong;
        this.personalityType = personalityType;
        this.politicalViews = politicalViews;
        this.sexualOrientation = sexualOrientation;

        this.diet = diet;
        this.physicalHealth = physicalHealth;
        this.birthday = birthday;
        this.allergies = allergies;
        this.favouriteColour = favouriteColour;
        this.relationshipWithParents = relationshipWithParents;
        this.morningDrink = morningDrink;
        this.usualBreakfast = usualBreakfast;

        this.musicalInstrument = musicalInstrument;
        this.instrumentGrade = instrumentGrade;
        this.sportsToWatch = sportsToWatch;
        this.sportsToPlay = sportsToPlay;
        this.competitiveHobbies = competitiveHobbies;
        this.favouriteTvShow = favouriteTvShow;
        this.bookGenre = bookGenre;
        this.favouriteBook = favouriteBook;
        this.guiltyPleasure = guiltyPleasure;


        // checks if person over 16, if true then adult_info assigned with parameter value else its assigned null
        this.EarlyTeen = earlyTeen;
        this.AdultInfo = AdultInfo;
        this.MidTeen = MidTeen;
        this.Emotions = Emotions;

    }


 // prints instances details
    public void printStats() {
/*
        System.out.println("Human: " );
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Age: " + this.age);
        System.out.println("DoB yyyy-MM-dd: " + this.birthday);
        System.out.println("Gender: " + this.gender);
        System.out.println("Height in cm: " + this.heightInCM);
        System.out.println("Weight in Kg: " + this.weightInKg);
        System.out.println("Nationality: " + this.nationality);
        System.out.println("Hair Colour: " + this.hairColour);
        System.out.println("Eye Colour: " + this.eyeColour);
        System.out.println("Diet: " + this.diet);
        System.out.println("Interests: " + this.interests);
        System.out.println("Favourite Food: " + this.favouriteFood);
        System.out.println("Favourite Film: " + this.favouriteFilm);
        System.out.println("Pet: " + this.pet);
        System.out.println("Pet Name: " + this.petName);
        System.out.println("Favourite Song: " + this.favouriteSong);
        System.out.println("Personality Type: " + this.personalityType);
        System.out.println("Favourite Colour: " + this.favouriteColour);
        System.out.println("Relationship with parents: " + this.relationshipWithParents);
        System.out.println("Musical Instrument: " + this.musicalInstrument);
        System.out.println("Musical Grade: " + this.instrumentGrade);
        System.out.println("Morning Drink: " + this.morningDrink);
        System.out.println("Usual Breakfast: " + this.usualBreakfast);
        System.out.println("Sexual Orientation: " + this.sexualOrientation);
        System.out.println("Favourite Sport to watch: " + this.sportsToWatch);
        System.out.println("Favourite Sport to play: " + this.sportsToPlay);
*/

      //  Emotions.PrintEmotions();
       // if (this.EarlyTeen != null) EarlyTeen.PrintEarlyTeen();
        if (this.EarlyTeen != null) {
            try {
                // if you are changing this, make sure the Main.java -> Arrays.stream(people).forEach(Human::printStats); -> still works
                EarlyTeen.BasicLetter(this.firstName, this.age);
                System.out.println("");
              //  EarlyTeen.LucasTemplate(firstName, sportsToPlay, musicalInstrument, pet, favouriteTvShow, petName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.MidTeen != null) MidTeen.PrintMidTeen();
        System.out.println();


   //     if (this.AdultInfo != null) AdultInfo.PrintAdultStats();
     //   System.out.println();

        // eventually have if age between certain range, activate template
    }

}
