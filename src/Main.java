import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        // приветствие
        System.out.println();
        System.out.println("\uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6" +
                " \uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6" +
                " \uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6");
        System.out.println("Добро пожаловать в счётчик калорий!");
        System.out.println("\uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6" +
                " \uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6" +
                " \uD83E\uDDE6\uD83E\uDDE6 \uD83E\uDDE6\uD83E\uDDE6");
        System.out.println();

        while (true) {
            printMenu();
            // ввод и обработка команды от пользователя
            int command = scanner.nextInt();
            System.out.println();

            if (command == 1) {
                System.out.println("\uD83E\uDDE6\uD83E\uDDE6 Ввод данных " +
                        "\uD83E\uDDE6\uD83E\uDDE6");
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                System.out.println("\uD83E\uDDE6\uD83E\uDDE6 Цель " +
                        "\uD83E\uDDE6\uD83E\uDDE6");
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                System.out.println("\uD83E\uDDE6\uD83E\uDDE6 Статистика " +
                        "\uD83E\uDDE6\uD83E\uDDE6");
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("\uD83E\uDDE6\uD83E\uDDE6 До новых встреч!");
                scanner.close();
                return;
            } else {
                System.out.println("Такого пункта меню нет, попробуй ещё раз!");
                System.out.println();
            }
        }
    }


    static void printMenu() {
        System.out.println("\uD83E\uDDE6 Выбери пункт меню:");
        System.out.println("\uD83E\uDDE6 1 - ввести количество шагов за день");
        System.out.println("\uD83E\uDDE6 2 - изменить цель по количеству шагов");
        System.out.println("\uD83E\uDDE6 3 - показать статистику за месяц");
        System.out.println("\uD83E\uDDE6 0 - выход");
    }
}
