import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        String task = "размер списка";
        logger.log("Просим пользователя ввести входные данные: " + task);
        int arraySize = getValue(task);

        task = "максимальное значение элементов списка";
        logger.log("Просим пользователя ввести входные данные: " + task);
        int maxValue = getValue(task);

        logger.log("Создаём и наполняем список");
        List<Integer> list = createRandomList(arraySize, maxValue);
        System.out.println("Получился случайный список: " + list);

        task = "максимальное значение для фильтрации";
        logger.log("Просим пользователя ввести входные данные: " + task);
        int threshold = getValue(task);
        Filter filter = new Filter(threshold);
        List<Integer> filteredList = filter.filterOut(list);
        System.out.println("Отфильтрованный список: " + filteredList);

        logger.log("Завершаем программу");
        scanner.close();
    }

    private static int getValue(String task) {
        Logger logger = Logger.getInstance();
        int value = 0;
        while (true) {
            System.out.println("Введите целое число: " + task);
            String input = scanner.nextLine();
            if (isInputCorrect(input)) {
                value = Integer.parseInt(input);
                logger.log("Пользователь ввел " + task + ": " + value);
                break;
            }
        }
        return value;
    }

    private static boolean isInputCorrect(String input) {
        Logger logger = Logger.getInstance();
        try {
            int number = Integer.parseInt(input);
            if (number >= 1) {
                return true;
            }
        } catch (NumberFormatException e) {
            logger.log("Некорректный ввод входных данных");
            return false;
        }
        logger.log("Некорректный ввод входных данных");
        return false;
    }

    public static List<Integer> createRandomList(int arraySize, int maxValue) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            randomList.add(i, new Random().nextInt(maxValue + 1));
        }
        return randomList;
    }
}
