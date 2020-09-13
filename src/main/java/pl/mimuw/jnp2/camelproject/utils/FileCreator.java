package pl.mimuw.jnp2.camelproject.utils;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@UtilityClass
public class FileCreator {

    private static final int MAX_NUM_OF_FILES = 10;
    private static int fileCreatedCounter = 0;

    public static void createNextFileWithRandomBody() {
        if (fileCreatedCounter == MAX_NUM_OF_FILES) {
            fileCreatedCounter = 0;
        }

        try (PrintWriter out = new PrintWriter(new File(String.format("filesForKafka/randomFile%d.txt", ++fileCreatedCounter)))) {
            String fileBody = RandomUtil.getRandomTextOfLines(3);
            out.print(fileBody);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
