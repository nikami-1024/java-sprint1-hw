import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    // конструктор
    StepTracker (Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        // ввод и проверка месяца
        System.out.println("Введи порядковый номер месяца:");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть в диапазоне 1-12");
            printError();
            return;
        }

        // ввод и проверка дня
        System.out.println("Введи день:");
        int day = scanner.nextInt();

        if (day < 1 || day > 30) {
            System.out.println("День должен быть в диапазоне 1-30");
            printError();
            return;
        }

        // ввод и проверка количества шагов
        System.out.println("Введи количество пройденных шагов:");
        int steps = scanner.nextInt();

        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным");
            printError();
            return;
        }

        // сохранение данных в массив
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Новое значение сохранено!");
        System.out.println("Месяц " + month + ": день " + day + ": " + steps);
        separator();
    }


    // ввод, проверка и сохранение новой цели по шагам
    void changeStepGoal() {
        System.out.println("Текущая цель: " +
                goalByStepsPerDay + " шагов в день");
        System.out.println("Введи новое значение цели:");
        int newGoal = scanner.nextInt();

        if (newGoal <= 0) {
            System.out.println("Количество шагов должно быть положительным");
            printError();
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Новое значение сохранено!");
            System.out.println("Текущая цель: " +
                    goalByStepsPerDay + " шагов в день");
            separator();
        }
    }


    // вывод статистики за месяц
    void printStatistic() {
        System.out.println("Введи номер месяца для просмотра статистики:");
        int month = scanner.nextInt();

        // проверка и обработка номера месяца
        if (month > 0 && month < 13) {
            int sumSteps = monthToData[month - 1].sumStepsFromMonth();
            int bestStreak = monthToData[month - 1].bestSeries(goalByStepsPerDay);
            String daysWord = "";

            // подбор правильного падежа для слова "день"
            if (bestStreak == 1 || bestStreak == 21) {
                daysWord = " день";
            } else if ((bestStreak >= 2 && bestStreak <= 4) ||
                      (bestStreak >= 22 && bestStreak <= 24)) {
                daysWord = " дня";
            } else if ((bestStreak >= 5 && bestStreak <= 20) ||
                      (bestStreak >= 25 && bestStreak <= 30) ||
                      bestStreak == 0) {
                daysWord = " дней";
            }

            // вывод статистики
            monthToData[month - 1].printDaysAndStepsFromMonth();
            System.out.println("Общее количество шагов за месяц: " + sumSteps);
            System.out.println("Максимальное количество шагов за день: " +
                    monthToData[month - 1].maxSteps());
            System.out.println("Среднее количество шагов за месяц: " +
                    sumSteps / 30);
            System.out.println("Пройденная дистанция: " +
                    converter.convertToKm(sumSteps) + " км");
            System.out.println("Сожжено: " +
                    converter.convertStepsToKilocalories(sumSteps) + " Ккал");
            System.out.println("Лучшая серия: " + bestStreak + daysWord);
            separator();
        } else {
            System.out.println("Месяц должен быть в диапазоне 1-12");
            printError();
        }
    }


    // уведомление об ошибочных данных
    void printError() {
        System.out.println("Перепроверь данные и попробуй ещё раз");
        separator();
    }


    // разделитель
    void separator() {
        System.out.println("========================================");
        System.out.println();
    }
}
