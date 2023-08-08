import java.util.ArrayList;
import java.util.HashMap;
public class YearlyReport {
    ArrayList<String> reportForYear;
    FileReader fileReader = new FileReader();
    MonthlyReport monthlyReport;
    ArrayList<HashMap<String, Integer>> months = new ArrayList<>();
    String[] monthsName = {"Январь", "Февраль", "Март", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь",
            "Октябрь", "Ноябрь", "Декабрь"};

    YearlyReport(){
        ArrayList<String> yearlyReport = fileReader.readFileContents("y.2021.csv");
        if (yearlyReport.size() != 0) {
            this.reportForYear = yearlyReport;
            for (int i = 0; i < 12; i++){
                months.add(i, new HashMap<>());
            }
            for (int i = 1; i < yearlyReport.size(); i++) {
                String[] lineContents = yearlyReport.get(i).split(",");
                for (int k = 1; k <= 12; k++){
                    if (lineContents[2].equals("true")) {
                        months.get(Integer.parseInt(lineContents[0])-1).put("Расход", Integer.parseInt(lineContents[1]));
                    } else {
                        months.get(Integer.parseInt(lineContents[0])-1).put("Доход", Integer.parseInt(lineContents[1]));
                    }
                }
            }
            System.out.println("Годовой отчёт загружен.");
        } else {
            System.out.println("Невозможно прочитать файлы с отчётом. Возможно, они отсутствуют в нужной директории.");
        }
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
        for (int i = 0; i < 12; i++) {
            if (!months.get(i).isEmpty()) {
                System.out.println(monthsName[i] + ": " + (months.get(i).get("Доход")
                        - months.get(i).get("Расход")) + " рублей.");
            }
        }
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
        monthlyReport = new MonthlyReport();
        boolean isReportsAreEqual = true;
        for (int i = 0; i < 12; i++) {
            if (!months.get(i).isEmpty()) {
                ArrayList<String> lines = monthlyReport.reportForAllMonths.get(i+1);
                int sumExpenseFromMonthlyReport = monthlyReport.getSumExpense(lines);
                int sumIncomeFromMonthlyReport = monthlyReport.getSumIncome(lines);
                int sumExpenseFromYearlyReport = months.get(i).get("Расход");
                int sumIncomeFromYearlyReport = months.get(i).get("Доход");
                if ((sumExpenseFromMonthlyReport != sumExpenseFromYearlyReport) ||
                        (sumIncomeFromMonthlyReport != sumIncomeFromYearlyReport)) {
                    System.out.println("Обнаружены различия в отчётах за " + monthsName[i] + ".");
                    isReportsAreEqual = false;
                }
            }
        }
        if (isReportsAreEqual) {
            System.out.println("Сверка завершена. Отчёты идентичны.");
        }
    }
}
