import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<String>> reportForAllMonths;
    boolean isLines = false;
    FileReader fileReader = new FileReader();
    String[] monthsName = {"Январь", "Февраль", "Март", "Апрель", "Май",
                       "Июнь", "Июль", "Август", "Сентябрь",
                       "Октябрь", "Ноябрь", "Декабрь"};
    Transaction transaction;
    MonthlyReport(){
        reportForAllMonths = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            ArrayList<String> lines;
            if (i < 10) {
                lines = fileReader.readFileContents("m.20210" + i + ".csv");
            } else {
                lines = fileReader.readFileContents("m.2021" + i + ".csv");
            }
            if (lines.size() != 0) {
                reportForAllMonths.put(i, lines);
                isLines = true;
            }
        }
    }

    void getMonthlyReport() { // Вывод в консоль имеющейся информации
        System.out.println("Информация обо всех месячных отчётах.");
        for (int i = 1; i <= 12; i++) {
            if (reportForAllMonths.get(i) != null) {
                System.out.println(monthsName[i - 1]);
                mostProfitableProduct(reportForAllMonths.get(i));
                biggestExpense(reportForAllMonths.get(i));
                System.out.println();
            }
        }
    }

    void mostProfitableProduct(ArrayList<String> lines){ // Самый прибыльный товар
        String nameOfProfitableProduct = null;
        int sumProfit = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            transaction = new Transaction(line);
            if (!transaction.isExpense){
                int profit = transaction.unitPrice * transaction.quantity;
                if (profit > sumProfit){
                    nameOfProfitableProduct = transaction.name;
                    sumProfit = profit;
                }
            }
        }
        System.out.println("Самый прибыльный товар: " + nameOfProfitableProduct + " " + sumProfit);
    }

    void biggestExpense(ArrayList<String> lines){ // Самая большая трата
        String nameOfBiggestExpense = null;
        int sumExpense = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            transaction = new Transaction(line);
            if (transaction.isExpense){
                int expense = transaction.unitPrice * transaction.quantity;
                if (expense > sumExpense){
                    nameOfBiggestExpense = transaction.name;
                    sumExpense = expense;
                }
            }
        }
        System.out.println("Самая большая трата: " + nameOfBiggestExpense + " " + sumExpense);
    }

    int getSumIncome(ArrayList<String> lines){
        int sumIncome = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            transaction = new Transaction(line);
            if (!transaction.isExpense) {
                sumIncome += transaction.quantity * transaction.unitPrice;
            }
        }
        return sumIncome;
    }

    int getSumExpense(ArrayList<String> lines) {
        int sumExpense = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            transaction = new Transaction(line);
            if (transaction.isExpense) {
                sumExpense += transaction.quantity * transaction.unitPrice;
            }
        }
        return sumExpense;
    }
}
