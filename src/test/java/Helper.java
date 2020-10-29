
import java.util.Random;
import java.util.stream.Collectors;

public class Helper {

    public String randomNumberGenerator() {

        Random rand = new Random();
        int x = rand.nextInt(1000000000);
        return String.valueOf(x);
    }

    public String randomStringGenerator() {

        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        return new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }

    public String randomSpecialCharsGenerator() {

        int length = 8;
        String CHARS = "!@#$='?&%$)(€*<>";

        return new Random().ints(length, 0, CHARS.length())
                .mapToObj(i -> "" + CHARS.charAt(i))
                .collect(Collectors.joining());
    }
}