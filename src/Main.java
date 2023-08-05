import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        boolean isMonthlyReport = false;
        boolean isYearlyReport = false;


        HashMap<String, ArrayList<String>> report = new HashMap<>();


        MonthlyReport monthlyReport = null;
        YearlyReport yearlyReport = null;


        while (true) {
            printMenu(); // Вывод доступных пунктов меню в консоль
            int userInput = scanner.nextInt();

            if (userInput == 1) { // Считывание месячных отчётов.
                for (int i = 1; i < 4; i++) {
                    ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
                    report.put("m.20210" + i + ".csv", lines);
                }
                monthlyReport = new MonthlyReport(report);
                isMonthlyReport = true;
            } else if (userInput == 2) { // Считывание годового отчёта.
                ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
                yearlyReport = new YearlyReport(lines);
                isYearlyReport = true;
            } else if (userInput == 3) { // Сверка отчётов.
                if (isMonthlyReport&&isYearlyReport){





                /* По сохранённым данным проверить, сходятся ли отчёты за месяцы и за год
                Вам нужно проверить, что информация в годовом отчёте не противоречит информации в месячных отчётах
                1 - Проверить, что месячные и годовой отчёты были считаны из файлов. В случае если этого не было сделано, нужно предложить сначала считать данные.
                2 - Подсчитать суммы доходов и расходов по каждому из месяцев.
                3 - Сверить полученные суммы с суммой доходов и расходов в отчёте по году.
                4 - При обнаружении несоответствия программа должна вывести месяц, где оно обнаружено.
                5 - Если несоответствий не обнаружено, приложение должно вывести только информацию об успешном завершении операции.
                */
                } else {
                    System.out.println("Извините, отчёты отсутствуют. Сначала их необходимо загрузить.");
                }
            } else if (userInput == 4) { // Вывод информацию обо всех месячных отчётах.
                if (isMonthlyReport){
                    monthlyReport.printMonthlyReport();
                } else {
                    System.out.println("Извините, отчёты отсутствуют. Сначала их необходимо загрузить.");
                }
            } else if (userInput == 5) { // Вывод информацию о годовом отчёте.
                if (isYearlyReport){
                    yearlyReport.getYearlyReport();
                } else {
                    System.out.println("Извините, отчёт отсутствует. Сначала его необходимо загрузить.");
                }
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

