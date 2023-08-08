import java.util.ArrayList;
import java.util.HashMap;
public class YearlyReport {
    ArrayList<String> reportForYear;
    FileReader fileReader = new FileReader();
    MonthlyReport monthlyReport = new MonthlyReport();
    ArrayList<HashMap<String, Integer>> months = new ArrayList<>();
    HashMap<String, Integer> january = new HashMap<>();
    HashMap<String, Integer> february = new HashMap<>();
    HashMap<String, Integer> march = new HashMap<>();
    YearlyReport(){
        ArrayList<String> yearlyReport = fileReader.readFileContents("y.2021.csv");
        this.reportForYear = yearlyReport;
        for (int i = 1; i < yearlyReport.size(); i++) {
            String[] lineContents = yearlyReport.get(i).split(",");
            if (lineContents[0].equals("01")){
                if (lineContents[2].equals("true")) {
                    january.put("Расход", Integer.parseInt(lineContents[1]));
                } else {
                    january.put("Доход", Integer.parseInt(lineContents[1]));
                }
            } else if (lineContents[0].equals("02")){
                if (lineContents[2].equals("true")) {
                    february.put("Расход", Integer.parseInt(lineContents[1]));
                } else {
                    february.put("Доход", Integer.parseInt(lineContents[1]));
                }
            } else {
                if (lineContents[2].equals("true")) {
                    march.put("Расход", Integer.parseInt(lineContents[1]));
                } else {
                    march.put("Доход", Integer.parseInt(lineContents[1]));
                }
            }
        }
        months.add(0, january);
        months.add(1, february);
        months.add(2, march);
    }

    void getYearlyReport() {                 // Вывести в консоль имеющуюся информацию
        System.out.println("2021й год.");    //1 - рассматриваемый год
        profitForEachMonth();                //2 - прибыль по каждому месяцу
        averageExpensesForEachMonth();       //3 - средний расход за все имеющиеся операции в году;
        averageIncomeForEachMonth();         //4 - средний доход за все имеющиеся операции в году.
        System.out.println();
    }

    void profitForEachMonth(){ // прибыль по каждому месяцу
        System.out.println("Прибыль по каждому месяцу:");
        System.out.println("Январь: " + (january.get("Доход") - january.get("Расход")) + " рублей.");
        System.out.println("Февраль: " + (february.get("Доход") - february.get("Расход")) + " рублей.");
        System.out.println("Март: " + (march.get("Доход") - march.get("Расход")) + " рублей.");
    }

    void averageExpensesForEachMonth(){ // средний расход за все имеющиеся операции в году
        int averageExpenses;
        int sumExpenses = 0;
        int numberOfExpenses = 0;
        for (int i = 1; i < reportForYear.size(); i++) {
            String[] lineContents = reportForYear.get(i).split(",");
            if (lineContents[2].equals("true")) {
                sumExpenses += Integer.parseInt(lineContents[1]);
                numberOfExpenses++;
            }
        }
        averageExpenses = sumExpenses/numberOfExpenses;
        System.out.println("Средний расход за все имеющиеся операции в году: " + averageExpenses + " рублей.");
    }

    void averageIncomeForEachMonth(){ // средний доход за все имеющиеся операции в году.
        int averageIncome;
        int sumIncome = 0;
        int numberOfIncome = 0;
        for (int i = 1; i < reportForYear.size(); i++) {
            String[] lineContents = reportForYear.get(i).split(",");
            if (lineContents[2].equals("false")) {
                sumIncome += Integer.parseInt(lineContents[1]);
                numberOfIncome++;
            }
        }
        averageIncome = sumIncome/numberOfIncome;
        System.out.println("Средний доход за все имеющиеся операции в году: " + averageIncome + " рублей.");
    }

    void comparisonOfReports(){        //Проверка отчётов
        boolean isReportsAreEqual = true;
        for (int i = 1; i < 4; i++) {
            ArrayList<String> lines = monthlyReport.reportForAllMonths.get(i);
            int sumExpenseFromMonthlyReport = monthlyReport.getSumExpense(lines);
            int sumIncomeFromMonthlyReport = monthlyReport.getSumIncome(lines);
            int sumExpenseFromYearlyReport = months.get(i - 1).get("Расход");
            int sumIncomeFromYearlyReport = months.get(i - 1).get("Доход");
            if ((sumExpenseFromMonthlyReport != sumExpenseFromYearlyReport) ||
                    (sumIncomeFromMonthlyReport != sumIncomeFromYearlyReport)) {
                System.out.println("Обнаружены различия в отчётах за " + monthlyReport.months[i - 1] + ".");
                isReportsAreEqual = false;
            }
        }
        if (isReportsAreEqual) {
            System.out.println("Сверка завершена. Отчёты идентичны.");
        }
    }
}
