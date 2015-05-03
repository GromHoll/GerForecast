package edu.ger.forecast.data;

import java.util.Arrays;

public class OutputValues {

    /** iMax - ?????????? ????????????? ??? */
    public final int yearsNumber;

    /** K(i) - ??????? ??? ?? ???????? */
    public double[] productCostForecast;

    /** N(i) - ??????? ??????? */
    public double[] productRevenueForecast;

    public OutputValues(InputValues input) {
        yearsNumber = input.getYearsNumber() + 1;

        productRevenueForecast = new double[yearsNumber];
        productCostForecast = new double[yearsNumber];

        Arrays.fill(productRevenueForecast, 0);
        Arrays.fill(productCostForecast, 0);
    }

}
