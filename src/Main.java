import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = null;
        YearlyReport yearlyReport = null;

        while (true) {
            printMenu(); // Вывод доступных пунктов меню в консоль
            int userInput = scanner.nextInt();
            if (userInput == 1) { // Считывание месячных отчётов.
                monthlyReport = new MonthlyReport();
                if (!monthlyReport.isLines) {
                    System.out.println("Невозможно прочитать файлы с отчётом. " +
                            "Возможно, они отсутствуют в нужной директории.");
                } else {
                    System.out.println("Все месячные отчёты загружены.");
                }
                System.out.println();
            } else if (userInput == 2) { // Считывание годового отчёта.
                yearlyReport = new YearlyReport();
                System.out.println();
            } else if (userInput == 3) { // Сверка отчётов.
                // По сохранённым данным проверка, сходятся ли отчёты за месяцы и за год
                 if ((monthlyReport != null) && (yearlyReport != null)) {
                     yearlyReport.comparisonOfReports();
                 } else {
                     System.out.println("Извините, отчёты отсутствуют. Сначала их необходимо загрузить.");
                }
            } else if (userInput == 4) { // Вывод информацию обо всех месячных отчётах.
                if (monthlyReport != null) {
                    monthlyReport.getMonthlyReport();
                } else {
                    System.out.println("Извините, отчёты отсутствуют. Сначала их необходимо загрузить.");
                }
            } else if (userInput == 5) { // Вывод информацию о годовом отчёте.
                if (yearlyReport != null) {
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
}

