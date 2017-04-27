package net.tuenti.contest.challenge2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * TuentiChallenge7 - Challenge 2
 * @author Jose Cebellán
 */
public class Challenge2 {
    private static File file = new File(System.getProperty("user.dir") + "/../submitInput");

    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            int cases = Integer.parseInt(buffer.readLine());
            int actualCase = 1;
            String rollsStr = "";

            while ((rollsStr = buffer.readLine()) != null) {
                int numberOfRolls = Integer.parseInt(rollsStr);

                String[] gameRollsStr = buffer.readLine().split(" ");
                List<Integer> gameRolls = new ArrayList<Integer>();
                for (String gameRollStr : gameRollsStr) {
                    gameRolls.add(Integer.parseInt(gameRollStr));
                }
                BowlingGame bowlingGame = new BowlingGame(gameRolls);
                List<Integer> gameScores = bowlingGame.getScores();
                String scores = StringUtils.join(gameScores, " ");

                System.out.println(String.format("Case #%s: %s", actualCase, scores));                
                actualCase++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
