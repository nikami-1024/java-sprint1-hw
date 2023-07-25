public class MonthData {
    // в прототипе любой месяц из 30 дней
    int[] days = new int[30];


    // вывод статистики за месяц
    void printDaysAndStepsFromMonth() {
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
        System.out.println();
    }


    // подсчёт суммы шагов за месяц
    int sumStepsFromMonth() {
        int stepsSum = 0;

        for (int i = 0; i < days.length; i++) {
            stepsSum = stepsSum + days[i];
        }
        return stepsSum;
    }


    // вычисление максимального количества шагов
    int maxSteps() {
        int stepsMaxValue = days[0];
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= stepsMaxValue) {
                stepsMaxValue = days[i];
            }
        }
        return stepsMaxValue;
    }


    // подсчёт лучшей серии
    int bestSeries(int goal) {
        int bestStreak = 0;
        int lastBestStreak = 0;
        for (int i = 0; i < days.length; i++) {
            bestStreak = (days[i] >= goal) ? (bestStreak + 1) : 0;
            lastBestStreak = Math.max(bestStreak, lastBestStreak);
        }
        return lastBestStreak;
    }
}
