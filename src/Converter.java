public class Converter {
    int stepLength = 75; // сантиметры
    int stepInCal = 50; // калории


    // перевод шагов в километры
    int convertToKm(int steps) {
        return steps * stepLength / 100000;
    }


    // перевод шагов в килокалории
    int convertStepsToKilocalories(int steps) {
        return steps * stepInCal / 1000;
    }
}
