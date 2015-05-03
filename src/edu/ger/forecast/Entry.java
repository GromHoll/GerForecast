package edu.ger.forecast;

import edu.ger.forecast.data.InputValues;
import edu.ger.forecast.data.OutputValues;
import edu.ger.forecast.scenario.MainScenario;

public class Entry {

    public static void main(String[] args) {

        InputValues input = new InputValues(5);
        input.setRepaymentOfCredit(1000, 1);
        input.setRepaymentOfCredit(3000, 2);
        input.setRepaymentOfCredit(4000, 3);
        input.setRepaymentOfCredit(2000, 4);

        MainScenario scenario = new MainScenario();

        OutputValues output = scenario.calculate(input);

        System.out.println(output);

    }
}
