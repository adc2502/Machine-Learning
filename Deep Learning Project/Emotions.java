import java.lang.reflect.Field;

public class Emotions {

    // add in all your variables here ***
    public int joy;
    public int love;
    public int compassion;
    public int confidence;
    public int pride;

    // this takes any number of arguments and makes sure to still work if there are too many arguments
    // parameters -- joy, love, compassion, confidence, pride etc
    public Emotions(int... parameters) {
        // the fields are the instance variables eg love
        Field[] declaredFields = getClass().getDeclaredFields();

        for (int i = 0; (i < declaredFields.length) && (i < parameters.length); i++) {
            Field f = declaredFields[i];
            try {

                // this sets the value using the argument
                f.setInt(this, parameters[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // just prints the values
    public void printVariables() {
        Field[] declaredFields = getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field f = declaredFields[i];
            try {
                System.out.println(f.getName() + ": " + f.getInt(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
