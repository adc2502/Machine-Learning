/*
This container is for a 14-16 year old.
Patrick Miller


They will have exams and probably start liking girls or guys etc based on their sexual orientation.

Probably start going to parties, maybe first kiss and with who?

Emotions will be affected by puberty etc but I will be doing that.

 */

package Humans;

import java.io.IOException;

public class MidTeen {
    // constructor
    // make sure the attribute is in the top line within the brackets
    // follow the same format as closeFriend attribute
    public MidTeen(String closeFriend) {
        this.closeFriend = closeFriend;
    }


    // any attributes you want to be stored, they need to be here: make sure to update MidTeen constructor after
    public String closeFriend;



    /*
    Methods you will need are in the Humans file.

    To generate a random number -> Humans.mix(0, 101)
    This is between 0 and 100 inclusive

    To generate a distribution -> Humans.distribution(sd, mean)

    To get a value from a file use -> Humans.LineToValue(lineNumber, filename)
                                        filename must be in the Data directory
     */

    public static String[] DRINK = {"tea", "coffee", "water"};



    // This is used to give the attribute a value
    // Humans.LineTOValue(mix(0, 721), "721_Names.txt"));
    // This line uses mix(0, 721), to get a random value between 0 and 721. The LineTOValue then gets the value at that
    // line number in the file
    // it says Humans at the beginning because the LineTOValue function is in the Humans.java file

    public static MidTeen getMidTeen() throws IOException {
        return new MidTeen(
                Humans.LineToValue(Humans.Random(1, 721), "721_Names.txt") // getting name




        );
    }


    // Use this to display the data
    public void PrintMidTeen() {
        System.out.println("Close friend: " + this.closeFriend);

    }












}
