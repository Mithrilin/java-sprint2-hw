import java.util.ArrayList;

public class YearlyReport {
    ArrayList<String> yearlyReport;


    YearlyReport(ArrayList<String> yearlyReport){
        this.yearlyReport = yearlyReport;
    }

    void printYearlyReport() {
                // По сохранённым данным вывести в консоль имеющуюся информацию
                //1 - рассматриваемый год
        profitForEachMonth();        //2 - прибыль по каждому месяцу
        averageExpensesForEachMonth();        //3 - средний расход за все имеющиеся операции в году;
        averageIncomeForEachMonth();        //4 - средний доход за все имеющиеся операции в году.

    }

    void profitForEachMonth(){

        // прибыль по каждому месяцу

    }

    void averageExpensesForEachMonth(){

        // средний расход за все имеющиеся операции в году;

    }

    void averageIncomeForEachMonth(){

        // средний доход за все имеющиеся операции в году.

    }

}
