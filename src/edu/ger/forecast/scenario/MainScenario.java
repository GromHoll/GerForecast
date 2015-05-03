package edu.ger.forecast.scenario;

import edu.ger.forecast.data.InputValues;
import edu.ger.forecast.data.OutputValues;

public class MainScenario {

    public OutputValues calculate(InputValues input) {
        OutputValues output = new OutputValues(input);

        calculateRealizationForecast(input, output);

        return output;
    }

    private void calculateRealizationForecast(InputValues input, OutputValues output) {
        output.productCostForecast[1] = input.getProductCost();
        for (int i = 2; i <= input.getYearsNumber(); i++) {
            output.productCostForecast[i] = output.productCostForecast[i-1] * (1 + input.getExpectedRateOfInflation_1());
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.productRevenueForecast[i] = output.productCostForecast[i] * input.getProductsSoldPerYears();
        }
    }

}
