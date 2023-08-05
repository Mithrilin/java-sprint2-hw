import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<String>> monthlyReport;
    String[] months = {"Январь", "Февраль", "Март"};
    Transaction transaction;
    MonthlyReport(HashMap<Integer, ArrayList<String>> monthlyReport){
        this.monthlyReport = monthlyReport;

    }


    void getMonthlyReport() { // По сохранённым данным вывод в консоль имеющейся информации
        System.out.println("Информация обо всех месячных отчётах.");
        for (int i = 1; i < 4; i++) {
            System.out.println(months[i]);
            mostProfitableProduct(monthlyReport.get(i));
            biggestExpense(monthlyReport.get(i));
            System.out.println();
        }
    }

    void mostProfitableProduct(ArrayList<String> lines){ // Самый прибыльный товар, название товара и сумму;
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

    void biggestExpense(ArrayList<String> lines){ // Самая большая трата, название товара и сумму.
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
        System.out.println("Самый прибыльный товар: " + nameOfBiggestExpense + " " + sumExpense);



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
