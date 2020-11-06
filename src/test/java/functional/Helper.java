package functional;

import java.util.Random;

public class Helper {

    public String randomNumberGenerator() {

        Random rand = new Random();
        int x = rand.nextInt(1000000000);
        return String.valueOf(x);
    }


    public String randomStringGenerator() {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length = 7;
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();

    }
}