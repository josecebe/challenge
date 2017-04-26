package net.tuenti.contest.challenge1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * TuentiChallenge7 - Challenge 1
 * @author Jose Cebellán
 */
public class Challenge1 {
    private static File file = new File(System.getProperty("user.dir") + "/../submitInput");

    private static final int ONE_PIZZA_SLICES = 8;

    private static final int MIN_CASES = 1;
    private static final int MAX_CASES = 100;
    private static final int MIN_PEOPLE_PARTY = 1;
    private static final int MAX_PEOPLE_PARTY = 10000;
    private static final int MIN_PIZZA_SLICES = 1;
    private static final int MAX_PIZZA_SLICES = 100;

    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            int cases = Integer.parseInt(buffer.readLine());
            int actualCase = 1;

            if (cases >= MIN_CASES && cases <= MAX_CASES) {
                String line = "";

                while ((line = buffer.readLine()) != null) {
                    int peopleParty = Integer.parseInt(line);
                    double totalSlices = 0;

                    if (peopleParty >= MIN_PEOPLE_PARTY && peopleParty <= MAX_PEOPLE_PARTY) {
                        String[] pizzaSlices = buffer.readLine().split(" ");
                        for (String pizzaSlice : pizzaSlices) {
                            int personPizzaSlice = Integer.parseInt(pizzaSlice);

                            if (personPizzaSlice >= MIN_PIZZA_SLICES && personPizzaSlice <= MAX_PIZZA_SLICES) {
                                totalSlices += personPizzaSlice;
                            }
                        }
                    }

                    int pizzas = (int) Math.ceil(totalSlices / ONE_PIZZA_SLICES);
                    System.out.println(String.format("Case #%s: %s", actualCase, pizzas));
                    actualCase++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
