/*
Human Basic Template.
Andreas Campbell
 */

package Humans;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class Humans {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static double NormalDistribution(double sd, double mean) {
        SecureRandom secureRandom = new SecureRandom();
        return (secureRandom.nextGaussian()*sd) + mean;
    }

    public static int Random(int min, int max){
        // remember to use the max+1 if your random number doesn't correspond to a file or array
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min) + min;
    }


    public static String LineToValue(int lineNumber, String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("Data/"+ filename))) {
            return lines.skip(lineNumber).findFirst().get();
        }
    }

    public static ArrayList<String> MultipleFriends(int numberOfFriends, String filename) throws IOException {
        ArrayList<String> friends = new ArrayList<String>(numberOfFriends-1);
        int number = Random(0, 721);;
        int prev = 0;

       for(int i=0; i < numberOfFriends; i++){
           while(i > 0 && number == prev){
               number = Random(0, 721);
            }
           friends.add(LineToValue(number, filename));
           prev = number;
        }

        return friends;
    }

    public static String GenderToName(String gender) throws IOException {
        if(gender.equals("MALE")){
            return LineToValue(Random(0, 313), "313_Male_Names.txt");
        } else {
           return LineToValue(Random(0, 313), "408_Female_Names.txt");
        }
    }

    public static int AgeAndGenderToHeight(int age, String gender) {
        double[][] MenHeight = {{10, 138.4}, {11, 143.5}, {12, 149.1}, {13, 156.2}, {14, 163.8}, {15, 170.1},
                {16, 173.4}, {17, 175.2}, {18, 175.7}, {19, 176.5}, {20, 177}, {21, 177.4}};

        double[][] WomenHeight = {{10, 138.4}, {11, 144}, {12, 149.8}, {13, 156.7}, {14, 158.7}, {15, 159.7},
                {16, 162.5}, {17, 162.5}, {18, 163}, {19, 163}, {20, 163.3}, {21, 163.4}};

        double sd = 0;
        double mean = 0;
        if(gender.equals("MALE")){
            sd = 10.16;
            for (double[] doubles : MenHeight) {
                if (age == doubles[0]) {
                    mean = doubles[1];
                    break;
                } else {
                    mean = 177.4;
                }
            }
        } else {
            sd = 8.89;
            for (double[] doubles : WomenHeight) {
                if (age == doubles[0]) {
                    mean = doubles[1];
                    break;
                } else {
                    mean = 163.4;
                }
            }
        }
        return (int) NormalDistribution(sd, mean);
    }

    public static LocalDate GenerateBirthday(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = Random(1916, (Calendar.getInstance().get(Calendar.YEAR)-10));

        gc.set(Calendar.YEAR, year);

        int dayOfYear = Random(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return LocalDate.of(gc.get(Calendar.YEAR), (gc.get(Calendar.MONTH) + 1), (gc.get(Calendar.DAY_OF_MONTH)));

    }

    public static int calculateAge(LocalDate birthDate) {
      //  DateTimeFormatter formatter = new DateTimeFormatter("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }


        public static String PetCheck(String hasPet) throws IOException {
        if(hasPet.equals("null")){
            return "null";
        } else {
            return Humans.LineToValue(Random(0, 721), "721_Names.txt");
        }
    }



    public static double AgeAndGenderAndHeightToWeight(int age, String gender, int height) {
        double[][] Under20_Male = {{10, 37.9}, {11, 43.4}, {12, 47.4}, {13, 51.1}, {14, 58.0}, {15, 67.1},
                {16, 67.5}, {17, 70.1}, {18, 70.5}, {19, 74.3}};

        double[][] Under20_Female = {{10, 37.0}, {11, 43.9}, {12, 48.1}, {13, 53.2}, {14, 55.0}, {15, 57.2},
                {16, 56.8}, {17, 56.5}, {18, 57.6}, {19, 57.4}};

        double[][] Twenty_PlusNineMale = {{150, 51.3}, {152, 53.1}, {154, 55.3}, {156, 58.5}, {158, 61.2}, {160, 62.9},
                {162, 64.6}, {164, 67.3}, {166, 68.8}, {168, 70.8}, {170, 72.7}, {172, 74.4}, {174, 77.7}, {176, 80.8},
                {178, 83.0}, {180, 85.1}, {182, 87.2}, {184, 89.1}, {186, 93.1}, {188, 95.8}, {190, 97.1}};

        double[][] Twenty_PlusNineFemale = {{150, 48.9}, {152, 51.0}, {154, 53.0}, {156, 55.8}, {158, 58.1}, {160, 59.8},
                {162, 61.6}, {164, 63.6}, {166, 65.2}, {168, 68.5}, {170, 69.2}, {172, 72.8}, {174, 74.3}, {176, 76.8},
                {178, 78.2}, {180, 80.9}, {182, 83.3}, {184, 85.5}, {186, 89.2}, {188, 91.8}, {190, 92.3}};

        double[][] Thirty_PlusNineMale = {{150, 56.7}, {152, 58.7}, {154, 61.6}, {156, 65.5}, {158, 67.3}, {160, 69.4},
                {162, 71.0}, {164, 73.9}, {166, 74.5}, {168, 76.2}, {170, 77.7}, {172, 79.3}, {174, 80.8}, {176, 83.3},
                {178, 85.6}, {180, 88.0}, {182, 90.6}, {184, 92.0}, {186, 95.0}, {188, 97.0}, {190, 99.5}};

        double[][] Thirty_PlusNineFemale = {{150, 53.9}, {152, 55.0}, {154, 59.1}, {156, 61.5}, {158, 64.1}, {160, 65.8},
                {162, 68.5}, {164, 70.8}, {166, 71.8}, {168, 73.7}, {170, 75.8}, {172, 77.0}, {174, 79.0}, {176, 79.9},
                {178, 82.4}, {180, 83.9}, {182, 87.7}, {184, 89.4}, {186, 91.0}, {188, 94.4}, {190, 95.8}};

        double[][] Forty_PlusNineMale = {{150, 58.1}, {152, 61.5}, {154, 64.5}, {156, 67.3}, {158, 70.4}, {160, 72.3},
                {162, 74.4}, {164, 77.2}, {166, 78.0}, {168, 79.6}, {170, 81.0}, {172, 82.8}, {174, 84.4}, {176, 86.0},
                {178, 88.0}, {180, 89.9}, {182, 91.4}, {184, 92.9}, {186, 96.6}, {188, 98.0}, {190, 100.7}};

        double[][] Forty_PlusNineFemale = {{150, 58.5}, {152, 59.5}, {154, 62.4}, {156, 66.0}, {158, 67.9}, {160, 69.9},
                {162, 72.2}, {164, 74.0}, {166, 76.6}, {168, 78.2}, {170, 79.8}, {172, 81.7}, {174, 83.7}, {176, 84.6},
                {178, 86.1}, {180, 88.1}, {182, 89.3}, {184, 90.9}, {186, 92.9}, {188, 95.8}, {190, 97.4}};

        double[][] Fifty_PlusNineMale = {{150, 58.0}, {152, 61.0}, {154, 63.8}, {156, 65.8}, {158, 68.0}, {160, 69.7},
                {162, 72.7}, {164, 75.6}, {166, 76.3}, {168, 79.5}, {170, 79.9}, {172, 81.1}, {174, 82.5}, {176, 84.1},
                {178, 86.5}, {180, 87.5}, {182, 89.5}, {184, 91.6}, {186, 92.8}, {188, 95.0}, {190, 99.4}};

        double[][] Fifty_PlusNineFemale = {{150, 55.7}, {152, 57.6}, {154, 60.2}, {156, 62.4}, {158, 64.5}, {160, 65.8},
                {162, 68.7}, {164, 72.0}, {166, 73.8}, {168, 74.8}, {170, 76.8}, {172, 77.7}, {174, 79.4}, {176, 80.5},
                {178, 82.4}, {180, 84.1}, {182, 86.5}, {184, 87.4}, {186, 89.6}, {188, 91.5}, {190, 95.6}};

        double[][] Sixty_PlusNineMale = {{150, 57.3}, {152, 60.3}, {154, 61.9}, {156, 63.7}, {158, 67.0}, {160, 68.2},
                {162, 69.1}, {164, 72.2}, {166, 74.3}, {168, 76.0}, {170, 79.9}, {172, 79.3}, {174, 79.3}, {176, 81.9},
                {178, 82.8}, {180, 84.4}, {182, 85.4}, {184, 88.0}, {186, 89.0}, {188, 91.5}, {190, 94.8}};

        double[][] Sixty_PlusNineFemale = {{150, 54.8}, {152, 55.9}, {154, 59.0}, {156, 60.9}, {158, 62.4}, {160, 64.6},
                {162, 66.5}, {164, 70.7}, {166, 71.4}, {168, 73.3}, {170, 75.0}, {172, 76.3}, {174, 78.0}, {176, 79.1},
                {178, 80.9}, {180, 81.6}, {182, 82.9}, {184, 85.8}, {186, 87.3}, {188, 88.8}, {190, 92.9}};


        // need to account for cases where their height isn't between 150cm and 190 cm


        if(height%2 != 0){
            height = height+1;
        }

        double sd = 0;
        double mean = 0;
        if(gender.equals("MALE")){
            sd = 4;
            if(age < 20){
                for (double[] under : Under20_Male) {
                    if (age == under[0]) {
                        mean = under[1];
                        NormalDistribution(sd, mean);
                        break;
                    }
                }
            }else if (age <= 29){
                for (double[] twenty : Twenty_PlusNineMale) {
                    if (height == twenty[0]) {
                        mean = twenty[1];
                        NormalDistribution(sd, mean);
                        break;
                    } else if(height < 150){
                        mean = 51.3;
                    } else {
                        mean = 97.1;
                    }
                }
            } else if(age <= 39){
                for (double[] thirty : Thirty_PlusNineMale) {
                    if (height == thirty[0]) {
                        mean = thirty[1];
                        break;
                    } else if(height < 150){
                        mean = 56.7;
                    } else {
                        mean = 99.5;
                    }
                }
            } else if(age <= 49){
                for (double[] forty : Forty_PlusNineMale) {
                    if (height == forty[0]) {
                        mean = forty[1];
                        break;
                    } else if(height < 150){
                        mean = 58.1;
                    } else {
                        mean = 100.7;
                    }
                }
            } else if(age <= 59){
                for (double[] fifty : Fifty_PlusNineMale) {
                    if (height == fifty[0]) {
                        mean = fifty[1];
                        break;
                    } else if(height < 150){
                        mean = 58.0;
                    } else {
                        mean = 99.4;
                    }
                }
            } else {
                for (double[] sixty : Sixty_PlusNineMale) {
                    if (height == sixty[0]) {
                        mean = sixty[1];
                        break;
                    } else if(height < 150){
                        mean = 57.3;
                    } else {
                        mean = 94.8;
                    }
                }
            }
        } else {
            sd = 3;
            if(age < 20) {
                for (double[] under : Under20_Female) {
                    if (age == under[0]) {
                        mean = under[1];
                        break;
                    }
                }
            } else if(age <= 29){
                for (double[] twenty : Twenty_PlusNineFemale) {
                    if (height == twenty[0]) {
                        mean = twenty[1];
                        break;
                    } else if(height < 150){
                        mean = 48.9;
                    } else {
                        mean = 92.3;
                    }
                }
            } else if(age <= 39){
                for (double[] thirty : Thirty_PlusNineFemale) {
                    if (height == thirty[0]) {
                        mean = thirty[1];
                        break;
                    } else if(height < 150){
                        mean = 53.9;
                    } else {
                        mean = 95.8;
                    }
                }
            } else if(age <= 49){
                for (double[] forty : Forty_PlusNineFemale) {
                    if (height == forty[0]) {
                        mean = forty[1];
                        break;
                    } else if(height < 150){
                        mean = 58.5;
                    } else {
                        mean = 97.4;
                    }
                }
            } else if(age <= 59){
                for (double[] fifty : Fifty_PlusNineFemale) {
                    if (height == fifty[0]) {
                        mean = fifty[1];
                        break;
                    } else if(height < 150){
                        mean = 55.7;
                    } else {
                        mean = 95.6;
                    }
                }
            } else {
                for (double[] sixty : Sixty_PlusNineFemale) {
                    if (height == sixty[0]) {
                        mean = sixty[1];
                        break;
                    } else if(height < 150){
                        mean = 54.8;
                    } else {
                        mean = 92.9;
                    }
                }
            }
        }
        return round(NormalDistribution(sd, mean), 1);
    }

    public static String GenerateSexualOrientation(String gender) {
        int odds = Random(1, 1001);
        String sexualOrientation = "";
        if (gender.equals("MALE")) {
            if (odds <= 6) {
                sexualOrientation = "bisexual";
            } else if (odds <= 25) {
                sexualOrientation = "gay";
            } else {
                sexualOrientation = "straight";
            }
        } else {
            if(odds <= 9) {
                sexualOrientation = "gay";
            } else if (odds <= 20) {
                sexualOrientation = "bisexual";
            } else {
                sexualOrientation = "straight";
            }
        }
        return sexualOrientation;
    }

    public static String Diet() {
        int odds = Random(1, 100);
        String diet = "";

        if (odds <= 3) {
            diet = "vegan";
        } else if (odds <= 8) {
            diet = "pescatarian";
        } else if (odds <= 14) {
            diet = "vegetarian";
        } else {
            diet = "omnivore";
        }

        return diet;
    }

    public static String CheckAllowedFavouriteFood(String diet){
        String favouriteFood = "";
        switch (diet) {
            case "vegan":
                favouriteFood = Humans.FAVOURITE_FOOD[Random(0, 5)];
                break;
            case "vegetarian":
                favouriteFood = Humans.FAVOURITE_FOOD[Random(3, 10)];
                break;
            case "pescatarian":
                favouriteFood = Humans.FAVOURITE_FOOD[Random(10, 14)];
                break;
            default:
                favouriteFood = Humans.FAVOURITE_FOOD[Random(10, 27)];
                break;
        }
        return favouriteFood;
    }

    public static String CheckAllowedMorningDrink(String diet){
        String morningDrink = "";
        if(diet.equals("vegan")){
            morningDrink = Humans.MORNING_DRINK[Random(0, 3)];
        } else {
            morningDrink = Humans.MORNING_DRINK[Random(0, 6)];
        }
        return morningDrink;
    }

    public static String CheckAllowedMorningBreakfast(String diet){
        String morningBreakfast = "";
        if(diet.equals("vegan")){
            morningBreakfast = Humans.USUAL_BREAKFAST[Random(0, 4)];
        } else {
            morningBreakfast = Humans.USUAL_BREAKFAST[Random(4, 9)];
        }
        return morningBreakfast;
    }

    public static String PickSportToPlay(String sportWatched){
        String play = "";
        if(sportWatched.equals("none")){
            play = "none";
        } else {
            if(Random(0, 101) <= 70){
                play = sportWatched;
            } else {
                play = Humans.SPORTS_TO_WATCH[Random(0, Humans.SPORTS_TO_WATCH.length)];
            }
        }
        return play;
    }

    public static String AgeToTvShow(int age){
        String tvShow = "";

        if(age <= 14){
            tvShow = Humans.EarlyTeenTvShow[Random(0, Humans.EarlyTeenTvShow.length)];
        }
        return tvShow;
    }


    public static String[] GENDER = {"MALE", "FEMALE"};

    public static String[] HAIR_COLOUR = {"brown", "black", "blonde", "ginger", "grey"};

    public static String[] EYE_COLOUR = {"brown", "blue", "green"};

    // check diet requirements
    public static String[] FAVOURITE_FOOD = {
            /* Vegan Meals -5- */ "black pepper tofu with bok choy", "portobello mushroom burger", "quinoa cakes", "bombay burrito", "vegetable biryani",
            /* Vegetarian Meals -5- */ "carrot toad in the hole", "spaghetti with mushroom bolognese", "vegetable lasagne", "crispy tacos with charred veg and refried beans", "sweet potato burgers with halloumi",
            /* Pescatarian -4- */ "fish and chips", "fish pie", "sushi", "tuna steaks with noodles",
            /* Omnivore -14- */ "pizza", "chinese takeaway", "spaghetti bolognese", "indian takeaway", "burger", "lasagne",
            "steak & ale pie", "haggis", "toad in the hole", "shepard's pie", "bangers and mash",
            "roast dinner", "chicken korma"};

    public static String[] PET = {"null", "dog", "cat", "fish", "hamster", "rabbit", "snake", "lizard", "guinea pig", "chicken"};

    public static String[] FAVOURITE_SONG = {"Lemon Tree"};

    public static String[] PERSONALITY_TYPE = {"introverted", "extroverted"};

    public static String[] COLOUR = { "yellow", "blue", "red", "green", "brown", "purple", "navy blue", "orange", "sky blue"};

    // needs much more detail
    public static String[] RELATIONSHIP_WITH_PARENTS = {"good", "bad", "non-existent"};

    public static String[] MUSICAL_INSTRUMENT = {"piano", "guitar", "violin", "drums", "saxophone", "flute", "cello", "clarinet", "trumpet"};

    // check diet requirements
    public static String[] MORNING_DRINK = {"glass of water", "carrot juice", "glass of orange juice", "glass of milk", "cup of tea", "cup of coffee"};

    // check diet requirements
    public static String[] USUAL_BREAKFAST = {"breakfast smoothie", "vegan yoghurt with fruit", "bowl of weetabix with almond milk",
            "bowl of porridge", "bowl of cheerios", "bowl of rice crispies", "bowl of coco pops",
            "bowl of weetabix", "yoghurt with fruit", "breakfast smoothie", "fry up", "omelette"};

    public static String[] SPORTS_TO_WATCH = {"football", "tennis", "cricket", "rugby", "basketball", "golf", "none"};

    public static String[] EarlyTeenTvShow = {"Almost Never", "Art Ninja", "Blue Peter", "Boy girl dog cat moouse cheese",
            "Creeped out", "Danger Mouse", "Deadly 60", "Deadly Dinosaurs", "The deep", "Dennis and Gnasher", "Odd squad",
            "Our School", "Katie Morag", "The zoo"};




    // generates n human objects
    public static Human[] generateHumans(int number_of_humans) throws IOException {

        Human[] people = new Human[number_of_humans];

        // From here on, the actual Human instances are created
        for (int i = 0; i < people.length; i++) {

            String gender = Humans.GENDER[Random(0, Humans.GENDER.length)];
            String name = Humans.GenderToName(gender);
            LocalDate birthday = GenerateBirthday();
            /////////////
            birthday = LocalDate.parse("2007-02-22");
            ////////////
            int age = calculateAge(birthday);
            String lastName = Humans.LineToValue(Random(0, 409), "409_Last_Names.txt");
            int height = AgeAndGenderToHeight(age, gender);
            String diet = Diet();
            double weight = AgeAndGenderAndHeightToWeight(age, gender, height);
            String nationality = "British";
            String hairColour = Humans.HAIR_COLOUR[Random(0, Humans.HAIR_COLOUR.length)];
            String eyeColour = Humans.EYE_COLOUR[Random(0, Humans.EYE_COLOUR.length)];
            String hobbies = Humans.LineToValue(Random(0, 124), "124_Hobbies_Interests.txt");
            String favouriteFilm = Humans.LineToValue(Random(0, 250), "250_Films.txt");
            String pet = Humans.PET[Random(0, Humans.PET.length)];
            String petName = PetCheck(pet);
            String favouriteSong = Humans.FAVOURITE_SONG[Random(0, Humans.FAVOURITE_SONG.length)];
            String personalityType = Humans.PERSONALITY_TYPE[(Random(0, PERSONALITY_TYPE.length))];
            String favouriteFood = CheckAllowedFavouriteFood(diet);
            String physicalHealth = null;
            String allergies = null;
            String favouriteColour = Humans.COLOUR[Random(0, COLOUR.length)];
            String relationshipWithParents = Humans.RELATIONSHIP_WITH_PARENTS[Random(0, RELATIONSHIP_WITH_PARENTS.length)];
            String musicalInstrument = Humans.MUSICAL_INSTRUMENT[Random(0, MUSICAL_INSTRUMENT.length)];
            int instrumentGrade = Random(0, 5);
            String morningDrink = CheckAllowedMorningDrink(diet);
            String usualBreakfast = CheckAllowedMorningBreakfast(diet);
            String sportsToWatch = Humans.SPORTS_TO_WATCH[Random(0, Humans.SPORTS_TO_WATCH.length)];
            String sportsPlayed = PickSportToPlay(sportsToWatch);
            String competitiveInterests = null;
            String favouriteTVShow = AgeToTvShow(age);
            String favouriteBookGenre = null;
            String favouriteBook = null;
            String guiltyPleasure = null;
            String politicalViews = null;
            String sexualOrientation = Humans.GenerateSexualOrientation(gender);




            if(age >= 18){
                people[i] = new Human(
                        name,
                        lastName,
                        age, // age
                        gender, // gender
                        height, // height in cm
                        weight, // weight in kg
                        nationality, // nationality
                        hairColour, // hair colour
                        eyeColour, // eye colour
                        hobbies, // hobbies and interests
                        favouriteFood, // favourite food
                        favouriteFilm, // favourite film
                        pet, // pet type
                        petName, // pet name
                        favouriteSong, // favourite song
                        personalityType, // personality type
                        diet, // diet
                        physicalHealth, // physical health
                        birthday, // birthday
                        allergies, // allergies
                        favouriteColour, // favourite Colour
                        relationshipWithParents, // relationship with parents
                        musicalInstrument, // musical instrument
                        instrumentGrade, // musical instrument grade
                        morningDrink, // morning drink
                        usualBreakfast, // usual breakfast
                        sportsToWatch, // sports watched
                        sportsPlayed, // sports played
                        competitiveInterests, // competitive hobbies
                        favouriteTVShow, // favourite tv show
                        favouriteBookGenre, // favourite book genre
                        favouriteBook, // favourite book
                        guiltyPleasure, // guilty pleasure
                        politicalViews, // political views
                        sexualOrientation, // sexual orientation
                        null, // 10-14yr
                        AdultInfo.getAdultInfo(), // adult
                        null, // 14-16yr
                        Emotions.getEmotions(age) // // emotions
                );

            } else if(age <= 14) {

                people[i] = new Human(
                        name,
                        lastName,
                        age, // age
                        gender, // gender
                        height, // height in cm
                        weight, // weight in kg
                        nationality, // nationality
                        hairColour, // hair colour
                        eyeColour, // eye colour
                        hobbies, // hobbies and interests
                        favouriteFood, // favourite food
                        favouriteFilm, // favourite film
                        pet, // pet type
                        petName, // pet name
                        favouriteSong, // favourite song
                        personalityType, // personality type
                        diet, // diet
                        physicalHealth, // physical health
                        birthday, // birthday
                        allergies, // allergies
                        favouriteColour, // favourite Colour
                        relationshipWithParents, // relationship with parents
                        musicalInstrument, // musical instrument
                        instrumentGrade, // musical instrument grade
                        morningDrink, // morning drink
                        usualBreakfast, // usual breakfast
                        sportsToWatch, // sports watched
                        sportsPlayed, // sports played
                        competitiveInterests, // competitive hobbies
                        favouriteTVShow, // favourite tv show
                        favouriteBookGenre, // favourite book genre
                        favouriteBook, // favourite book
                        guiltyPleasure, // guilty pleasure
                        politicalViews, // political views
                        sexualOrientation, // sexual orientation
                        EarlyTeen.getEarlyTeen(), // 10-14yr
                        null, // adult
                        null, // 14-16yr
                        Emotions.getEmotions(age) // // emotions
                );


            } else if(age <= 16) {

                people[i] = new Human(
                        name,
                        lastName,
                        age, // age
                        gender, // gender
                        height, // height in cm
                        weight, // weight in kg
                        nationality, // nationality
                        hairColour, // hair colour
                        eyeColour, // eye colour
                        hobbies, // hobbies and interests
                        favouriteFood, // favourite food
                        favouriteFilm, // favourite film
                        pet, // pet type
                        petName, // pet name
                        favouriteSong, // favourite song
                        personalityType, // personality type
                        diet, // diet
                        physicalHealth, // physical health
                        birthday, // birthday
                        allergies, // allergies
                        favouriteColour, // favourite Colour
                        relationshipWithParents, // relationship with parents
                        musicalInstrument, // musical instrument
                        instrumentGrade, // musical instrument grade
                        morningDrink, // morning drink
                        usualBreakfast, // usual breakfast
                        sportsToWatch, // sports watched
                        sportsPlayed, // sports played
                        competitiveInterests, // competitive hobbies
                        favouriteTVShow, // favourite tv show
                        favouriteBookGenre, // favourite book genre
                        favouriteBook, // favourite book
                        guiltyPleasure, // guilty pleasure
                        politicalViews, // political views
                        sexualOrientation, // sexual orientation
                        EarlyTeen.getEarlyTeen(), // 10-14yr
                        null, // adult
                        MidTeen.getMidTeen(), // 14-16yr
                        Emotions.getEmotions(age) // // emotions
                );

            } else {
                people[i] = new Human(
                        name,
                        lastName,
                        age, // age
                        gender, // gender
                        height, // height in cm
                        weight, // weight in kg
                        nationality, // nationality
                        hairColour, // hair colour
                        eyeColour, // eye colour
                        hobbies, // hobbies and interests
                        favouriteFood, // favourite food
                        favouriteFilm, // favourite film
                        pet, // pet type
                        petName, // pet name
                        favouriteSong, // favourite song
                        personalityType, // personality type
                        diet, // diet
                        physicalHealth, // physical health
                        birthday, // birthday
                        allergies, // allergies
                        favouriteColour, // favourite Colour
                        relationshipWithParents, // relationship with parents
                        musicalInstrument, // musical instrument
                        instrumentGrade, // musical instrument grade
                        morningDrink, // morning drink
                        usualBreakfast, // usual breakfast
                        sportsToWatch, // sports watched
                        sportsPlayed, // sports played
                        competitiveInterests, // competitive hobbies
                        favouriteTVShow, // favourite tv show
                        favouriteBookGenre, // favourite book genre
                        favouriteBook, // favourite book
                        guiltyPleasure, // guilty pleasure
                        politicalViews, // political views
                        sexualOrientation, // sexual orientation
                        null, // 10-14yr
                        null, // adult
                        null, // 14-16yr
                        Emotions.getEmotions(age) // // emotions
                );
            }





                  //  AdultInfo.adultInfos[generator.nextInt(AdultInfo.adultInfos.length)]);

            /*
            try {
                String filename = "MyFile.txt";
                FileWriter fw = new FileWriter(filename, true); //the true will append the new data
                fw.write(("Human: " + i + "\n"));
                fw.write(("Name: " + people[i].firstName + " " + people[i].lastName) + "\n");//appends the string to the file
                fw.write(("Age: " + people[i].age) + "\n");
                fw.write(("Gender: " + people[i].gender) + "\n");
                fw.write(("Height in cm: " + people[i].heightInCM) + "\n");
                fw.write(("Nationality: " + people[i].nationality) + "\n");
                fw.write(("Hair Colour: " + people[i].hairColour) + "\n");
                fw.write(("Eye Colour: " + people[i].eyeColour) + "\n");
                fw.write(("Interests: " + people[i].interests) + "\n");
                fw.write(("Favourite Food: " + people[i].favouriteFood) + "\n");
                fw.write(("Favourite Film: " + people[i].favouriteFilm) + "\n");
                fw.write(("Pet: " + people[i].pet) + "\n");
                fw.write(("Pet Name: " + people[i].petName) + "\n");
                fw.write(("Favourite Song: " + people[i].favouriteSong) + "\n");
                fw.write(("Personality Type: " + people[i].personalityType) + "\n");

                // checks if employed
                if (people[i].adult_info != null) fw.write(("Job: " + people[i].adult_info.job) + "\n");

                fw.write("\n");
                fw.close();

            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }


             */
        }

        return people;
    }


}



