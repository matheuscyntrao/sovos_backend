package dataprovider;

import java.util.Random;

public class EmailGenerator {

    public static String getEmail() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * letters.length());
            stringBuilder.append(letters.charAt(index));
        }
        String saltStr = stringBuilder.toString();
        return saltStr + "@gmail.com";
    }

}
