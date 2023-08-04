import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    Transaction transaction;
    MonthlyReport(HashMap<String, ArrayList<String>> monthlyReport){

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

    void printMonthlyReport() {
        /* По сохранённым данным вывести в консоль имеющуюся информацию
                1 - название месяца;
                2 - самый прибыльный товар, название товара и сумму;
                3 - самую большую трату, название товара и сумму.
                Перед выполнением подсчётов необходимо проверить, что месячные отчёты были считаны из файла.
                В случае если этого сделано не было, нужно предложить сначала считать данные.
                */
    }

    int getMinSumIncome(){


        return ;
    }

    int getMaxSumIncome(){


        return ;
    }



}
