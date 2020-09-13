package pl.mimuw.jnp2.camelproject.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.UUID;

@UtilityClass
public class RandomUtil {

    private static final Random rand = new Random();

    public static String getRandomTextOfLines(int numOfLines) {
        StringBuilder stringBuilder = new StringBuilder();

        while (numOfLines > 0) {
            int lineLength = rand.nextInt(10) + 1;
            String line = getRandomStringOfLength(lineLength);
            stringBuilder.append(line).append('\n');
            numOfLines--;
        }

        return stringBuilder.toString();
    }

    public static String getRandomStringOfLength(int length) {
        StringBuilder stringBuilder = new StringBuilder();

        while (length > 0) {
            char randomCharacter = (char) (rand.nextInt(26) + 97);
            stringBuilder.append(randomCharacter);
            length--;
        }

        return stringBuilder.toString();
    }

    public static String getRandomId() {
        return UUID.randomUUID().toString();
    }
}