package edu.ger.forecast.data;

import java.util.Arrays;

public class OutputValues {

    /** iMax - ?????????? ????????????? ??? */
    public final int yearsNumber;

    /* ??????? ??????? */
    /** K(i) - ??????? ??? ?? ???????? */
    public double[] productCostForecast;
    /** N(i) - ??????? ??????? */
    public double[] productRevenueForecast;

    /* ??????? ???????? */
    /** OL(i) - ??????? ?? ????? ? ????????? */
    public double[] productMaterialExpenses;
    /** OT(i) - ?????? ????? (??????? ???) */
    public double[] laborExpenses;
    /** OO(i) - ???????????????????? ??????? */
    public double[] generalProductionExpenses;
    /** OY(i) - ?????????????? ??????? */
    public double[] managementExpenses;
    /** OP(i) - ??????? ?? ??????? ? ???? */
    public double[] adsExpenses;
    /** OA(i) - ??????????? ???????????? */
    public double[] depreciationOfEquipment;
    /** R(i) - ????? ???????? */
    public double[] totalExpenses;

    /* ??????? ?????? */
    /** U(i) - ??????? ???????????? */
    public double[] outstandingBalance;
    /** W(i) - ?????? ?????? ??  ?????? */
    public double[] amountOfPayments;

    /* ??????? ????????? ? ????????? ???????? */
    /** D(i) - ??????????? ????????????? */
    public double[] accountsReceivable;
    /** B(i) - ?????? */
    public double[] stocks;
    /** G(i) - ????????????? ????? ???????????? */
    public double[] payablesToSuppliers;
    /** T(i) - ????????????? ?? ?????? ????? */
    public double[] arrearsOfWages;
    /** C(i) - ??????????? ? ????????? ???????? */
    public double[] workingCapitalRequirements;
    /** H(i) - ????????? ?????????? ???????? */
    public double[] changesInWorkingCapital;

    /* ??????? ????????/??????? */
    /** DA(i) - ????? ?? ?????????? ??????? */
    public double[] revenueFromSaleOfAssets;
    /** BA(i) - ????? ??????? */
    public double[] totalIncome;
    /** P(i) - ??????? ?? ??????? ??????? */
    public double[] profitBeforeTaxes;
    /** TP(i) - ????? ?? ??????? */
    public double[] taxOnProfits;
    /** PR(i) - ?????? ??????? */
    public double[] netProfit;
    /** PN(i) - ???????????????? ??????? */
    public double[] retainedProfit;

    /* ??????? ???????? ???????? ??????? */
    /** CI(i) - ?????? ?? ?????????????? ???????????? */
    public double[] balanceFromInvestingActivities;
    /** CO(i) - ?????? ?? ???????????? ???????????? */
    public double[] balanceFromOperatingActivities;
    /** CF(i) - ?????? ?? ?????????? ???????????? */
    public double[] balanceFromFinanceActivities;
    /** CC(i) - ????????? ?????? */
    public double[] balanceFromAllActivities;
    /** O(i) - ??????? ???????? ??????? */
    public double[] cashBalance;



    public OutputValues(InputValues input) {
        yearsNumber = input.getYearsNumber() + 1;

        productRevenueForecast = new double[yearsNumber];
        productCostForecast = new double[yearsNumber];

        Arrays.fill(productRevenueForecast, 0);
        Arrays.fill(productCostForecast, 0);

        productMaterialExpenses = new double[yearsNumber];
        laborExpenses = new double[yearsNumber];
        generalProductionExpenses = new double[yearsNumber];
        managementExpenses = new double[yearsNumber];
        adsExpenses = new double[yearsNumber];
        depreciationOfEquipment = new double[yearsNumber];
        totalExpenses = new double[yearsNumber];

        Arrays.fill(productMaterialExpenses, 0);
        Arrays.fill(laborExpenses, 0);
        Arrays.fill(generalProductionExpenses, 0);
        Arrays.fill(managementExpenses, 0);
        Arrays.fill(adsExpenses, 0);
        Arrays.fill(depreciationOfEquipment, 0);
        Arrays.fill(totalExpenses, 0);

        outstandingBalance = new double[yearsNumber];
        amountOfPayments = new double[yearsNumber];

        Arrays.fill(outstandingBalance, 0);
        Arrays.fill(amountOfPayments, 0);

        accountsReceivable = new double[yearsNumber];
        stocks = new double[yearsNumber];
        payablesToSuppliers = new double[yearsNumber];
        arrearsOfWages = new double[yearsNumber];
        workingCapitalRequirements = new double[yearsNumber + 1];
        changesInWorkingCapital = new double[yearsNumber + 1];

        Arrays.fill(accountsReceivable, 0);
        Arrays.fill(stocks, 0);
        Arrays.fill(payablesToSuppliers, 0);
        Arrays.fill(arrearsOfWages, 0);
        Arrays.fill(workingCapitalRequirements, 0);
        Arrays.fill(changesInWorkingCapital, 0);

        revenueFromSaleOfAssets = new double[yearsNumber + 1];
        totalIncome = new double[yearsNumber + 1];
        profitBeforeTaxes = new double[yearsNumber + 1];
        taxOnProfits = new double[yearsNumber + 1];
        netProfit = new double[yearsNumber + 1];
        retainedProfit = new double[yearsNumber + 1];

        Arrays.fill(revenueFromSaleOfAssets, 0);
        Arrays.fill(totalIncome, 0);
        Arrays.fill(profitBeforeTaxes, 0);
        Arrays.fill(taxOnProfits, 0);
        Arrays.fill(netProfit, 0);
        Arrays.fill(retainedProfit, 0);

        balanceFromInvestingActivities = new double[yearsNumber + 1];
        balanceFromOperatingActivities = new double[yearsNumber + 1];
        balanceFromFinanceActivities = new double[yearsNumber + 1];
        balanceFromAllActivities = new double[yearsNumber + 1];
        cashBalance = new double[yearsNumber + 1];

        Arrays.fill(balanceFromInvestingActivities, 0);
        Arrays.fill(balanceFromOperatingActivities, 0);
        Arrays.fill(balanceFromFinanceActivities, 0);
        Arrays.fill(balanceFromAllActivities, 0);
        Arrays.fill(cashBalance, 0);
    }

}
