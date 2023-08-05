import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        boolean isMonthlyReport = false;
        boolean isYearlyReport = false;
        HashMap<Integer, ArrayList<String>> report = new HashMap<>();
        MonthlyReport monthlyReport = null;
        YearlyReport yearlyReport = null;

        while (true) {
            printMenu(); // Вывод доступных пунктов меню в консоль
            int userInput = scanner.nextInt();
            if (userInput == 1) { // Считывание месячных отчётов.
                for (int i = 1; i < 4; i++) {
                    ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
                    report.put(i, lines);
                }
                monthlyReport = new MonthlyReport(report);
                isMonthlyReport = true;
                System.out.println("Все месячные отчёты загружены.");
                System.out.println();
            } else if (userInput == 2) { // Считывание годового отчёта.
                ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
                yearlyReport = new YearlyReport(lines);
                isYearlyReport = true;
                System.out.println("Годовой отчёт загружен.");
                System.out.println();
            } else if (userInput == 3) { // Сверка отчётов.
                if (isMonthlyReport&&isYearlyReport){ // По сохранённым данным проверить, сходятся ли отчёты за месяцы и за год
                    comparisonOfReports(monthlyReport, yearlyReport, report);
                } else {
                    System.out.println("Извините, отчёты отсутствуют. Сначала их необходимо загрузить.");
                }
            } else if (userInput == 4) { // Вывод информацию обо всех месячных отчётах.
                if (isMonthlyReport){
                    monthlyReport.getMonthlyReport();
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
                System.out.println("Завершение программы.");
                scanner.close();
                return;
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

    static void comparisonOfReports (MonthlyReport monthlyReport, YearlyReport yearlyReport, HashMap<Integer, ArrayList<String>> report){ //Проверка отчётов

        //2 - Подсчитать суммы доходов и расходов по каждому из месяцев.
        //3 - Сверить полученные суммы с суммой доходов и расходов в отчёте по году.
        //4 - При обнаружении несоответствия программа должна вывести месяц, где оно обнаружено.
        for (int i = 1; i < 3; i++){
            ArrayList<String> line = report.get(i);
            int sumExpense = monthlyReport.getSumExpense(line);
            int sumIncome = monthlyReport.getSumIncome(line);
            if (sumExpense == yearlyReport.)


        }

        System.out.println("Сверка завершена. Отчёты идентичны."); //5 - Если несоответствий не обнаружено, приложение должно вывести только информацию об успешном завершении операции.
    }

}

