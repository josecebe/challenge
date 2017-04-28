package net.tuenti.contest.challenge3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * TuentiChallenge7 - Challenge 3
 * @author Jose Cebellán
 */
public class Challenge3 {
    private static File file = new File(System.getProperty("user.dir") + "/../submitInput");

    private static final int MIN_CASES = 1;
    private static final double MAX_CASES = Math.pow(10, 4);
    private static final int MIN_POINTS_CASE = 1;
    private static final double MAX_POINTS_CASE = Math.pow(10, 9);

    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            int cases = Integer.parseInt(buffer.readLine());

            if (cases >= MIN_CASES && cases <= MAX_CASES) {
                int actualCase = 1;

                String line = "";
                while ((line = buffer.readLine()) != null) {
                    int maxPoints = Integer.parseInt(line);

                    if (maxPoints >= MIN_POINTS_CASE && maxPoints <= MAX_POINTS_CASE) {
                        int cards = 1;
                        while (maxPoints >= 2) {
                            maxPoints = maxPoints/2;
                            cards++;
                        }

                        System.out.println(String.format("Case #%s: %s", actualCase, cards));
                    }

                    actualCase++;
                }
            }
            buffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
