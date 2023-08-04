import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        HashMap<String, ArrayList<String>> report = new HashMap<>();
        MonthlyReport monthlyReport;

        while (true) {
            printMenu(); // Вывод доступных пунктов меню в консоль
            int userInput = scanner.nextInt();
            // Вызов соответствующего метода в зависимости от userInput
            if (userInput == 1) {

                // должно происходить считывание трёх файлов


                for (int i = 1; i < 4; i++) {
                    ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
                    report.put("m.20210" + i + ".csv", lines);

                }
                monthlyReport = new MonthlyReport(report);
            } else if (userInput == 2) {

                // должно происходить считывание из одного файла



            } else if (userInput == 3) {


                /* По сохранённым данным проверить, сходятся ли отчёты за месяцы и за год
                Вам нужно проверить, что информация в годовом отчёте не противоречит информации в месячных отчётах
                1 - Проверить, что месячные и годовой отчёты были считаны из файлов. В случае если этого не было сделано, нужно предложить сначала считать данные.
                2 - Подсчитать суммы доходов и расходов по каждому из месяцев.
                3 - Сверить полученные суммы с суммой доходов и расходов в отчёте по году.
                4 - При обнаружении несоответствия программа должна вывести месяц, где оно обнаружено.
                5 - Если несоответствий не обнаружено, приложение должно вывести только информацию об успешном завершении операции.
                */

            } else if (userInput == 4) {

                /* По сохранённым данным вывести в консоль имеющуюся информацию
                1 - название месяца;
                2 - самый прибыльный товар, название товара и сумму;
                3 - самую большую трату, название товара и сумму.
                Перед выполнением подсчётов необходимо проверить, что месячные отчёты были считаны из файла.
                В случае если этого сделано не было, нужно предложить сначала считать данные.
                */

            } else if (userInput == 5) {

                /* По сохранённым данным вывести в консоль имеющуюся информацию
                1 - рассматриваемый год
                2 - прибыль по каждому месяцу
                3 - средний расход за все имеющиеся операции в году;
                4 - средний доход за все имеющиеся операции в году.
                Перед выполнением подсчётов необходимо проверить, что месячные отчёты были считаны из файла.
                В случае если этого сделано не было, нужно предложить сначала считать данные.
                */

            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }
    }

    static void printMenu(){
        System.out.println("Введите команду:");
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("0 - Выйти из программы.");
    }
}

