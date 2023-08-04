import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<String, ArrayList<String>> monthlyReport;

    Transaction transaction;
    MonthlyReport(HashMap<String, ArrayList<String>> monthlyReport){
        this.monthlyReport = monthlyReport;
    }


    void printMonthlyReport() { // По сохранённым данным вывести в консоль имеющуюся информацию

                //1 - название месяца;
        mostProfitableProduct();       //2 - самый прибыльный товар, название товара и сумму;
        biggestExpense();        //3 - самую большую трату, название товара и сумму.



    }

    void mostProfitableProduct(){

        // самый прибыльный товар, название товара и сумму;

    }

    void biggestExpense(){

        // самую большую трату, название товара и сумму.

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

}
