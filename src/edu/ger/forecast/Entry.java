package edu.ger.forecast;

import edu.ger.forecast.data.InputLoader;
import edu.ger.forecast.data.InputValues;
import edu.ger.forecast.data.OutputValues;
import edu.ger.forecast.scenario.MainScenario;

public class Entry {

    public static void main(String[] args) {
        InputLoader loader = new InputLoader();
        InputValues input = loader.load("input.properties");


        // Scenario
        MainScenario scenario = new MainScenario();
        OutputValues output = scenario.calculate(input);

        System.out.println(output);

    }
}
