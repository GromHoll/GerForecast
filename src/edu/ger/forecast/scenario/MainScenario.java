package edu.ger.forecast.scenario;

import edu.ger.forecast.data.InputValues;
import edu.ger.forecast.data.OutputValues;

public class MainScenario {

    public OutputValues calculate(InputValues input) {
        OutputValues output = new OutputValues(input);

        calculateRealizationForecast(input, output);
        calculateExpenses(input, output);
        calculateBankForecast(input, output);
        calculateCapitalForecast(input, output);

        return output;
    }

    private void calculateRealizationForecast(InputValues input, OutputValues output) {
        output.productCostForecast[1] = input.getProductCost();
        for (int i = 2; i < output.yearsNumber; i++) {
            output.productCostForecast[i] = output.productCostForecast[i-1] * (1 + input.getExpectedRateOfInflation_1());
        }
        for (int i = 1; i < output.yearsNumber; i++) {
            output.productRevenueForecast[i] = output.productCostForecast[i] * input.getProductsSoldPerYears();
        }
    }

    private void calculateExpenses(InputValues input, OutputValues output) {
        double pmc = input.getProductMaterialCost();
        for (int i = 1; i < output.yearsNumber; i++) {
            output.productMaterialExpenses[i] = - pmc * input.getProductsSoldPerYears();
            pmc *= (1 + input.getExpectedRateOfInflation_2());
        }

        double lc = input.getLaborCosts();
        for (int i = 1; i < output.yearsNumber; i++) {
            output.laborExpenses[i] = - lc;
            lc *= (1 + input.getExpectedRateOfInflation_3());
        }

        double gpe = input.getGeneralProductionExpenses();
        for (int i = 1; i < output.yearsNumber; i++) {
            output.generalProductionExpenses[i] = - gpe;
            gpe *= (1 + input.getExpectedRateOfInflation_4());
        }

        double me = input.getManagementExpenses();
        for (int i = 1; i < output.yearsNumber; i++) {
            output.managementExpenses[i] = - me;
            me *= (1 + input.getExpectedRateOfInflation_5());
        }

        double ae = input.getAdsExpenses();
        for (int i = 1; i < output.yearsNumber; i++) {
            output.adsExpenses[i] = - ae;
            ae *= (1 + input.getExpectedRateOfInflation_6());
        }

        for (int i = 1; i < output.yearsNumber; i++) {
            output.depreciationOfEquipment[i] = - input.getInitialEquipmentCost()/input.getYearsNumber();
        }

        for (int i = 1; i < output.yearsNumber; i++) {
            output.totalExpenses[i] = output.productMaterialExpenses[i]
                                    + output.laborExpenses[i]
                                    + output.generalProductionExpenses[i]
                                    + output.managementExpenses[i]
                                    + output.adsExpenses[i]
                                    + output.depreciationOfEquipment[i];
        }

    }

    private void calculateBankForecast(InputValues input, OutputValues output) {
        output.outstandingBalance[0] = input.getInitialEquipmentCost();
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.outstandingBalance[i] = output.outstandingBalance[i - 1] - input.getRepaymentOfCredit(i);
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.amountOfPayments[i] = output.outstandingBalance[i - 1]*input.getInterestOnLoan();
        }
    }

    private void calculateCapitalForecast(InputValues input, OutputValues output) {
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.accountsReceivable[i] = - output.productRevenueForecast[i]/input.getSalesTurnoverRatio();
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.stocks[i] = output.productMaterialExpenses[i]/input.getStocksTurnoverRatio();
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.payablesToSuppliers[i] = - output.productMaterialExpenses[i]/input.getSuppliesTurnoverRatio();
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.arrearsOfWages[i] = - output.laborExpenses[i]/input.getSalariesTurnoverRatio();
        }
        for (int i = 1; i <= input.getYearsNumber(); i++) {
            output.workingCapitalRequirements[i] = output.accountsReceivable[i]
                                                 + output.stocks[i]
                                                 + output.payablesToSuppliers[i]
                                                 + output.arrearsOfWages[i];
        }
        for (int i = 1; i <= input.getYearsNumber() + 1; i++) {
            output.changesInWorkingCapital[i] = output.workingCapitalRequirements[i] - output.workingCapitalRequirements[i - 1];
        }

    }

}
