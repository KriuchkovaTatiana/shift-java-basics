package main.java.homework19;
import java.util.List; // интерфейс List для удобства работы с классом ArrayList
import java.util.ArrayList; // класс ArrayList для работы с массивами
import java.util.Scanner; // класс Scanner для ввода входных значений из консоли

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ввод входных значений (первое число, второе число, шаг)
        int first = readInt(scanner, "Введите первое число: ");
        int second = readInt(scanner, "Введите второе число: ");
        int step = readPositiveInt(scanner, "Введите шаг: ");

        /* подготовка данных для работы с массивом - обращение к методу buildRange
        * через List для большей "гибкости" в плане работы с массивом в ArrayList*/

        List<Integer> numbers = buildRange(first, second, step);
        printTable(numbers);
    }

    /* методы для проверки корректности введенных данных (чисел и шага):
    * сделаны через private-доступ, т.к. данные методы вспомогательные, являются деталями
    * реализации main, и снаружи класса MultiplicationTable не нужны*/

    // проверка введенных чисел (числа должны быть целыми, могут быть отрицательными)
    private static int readInt(Scanner scanner, String error) {
        while (true) {
            System.out.print(error);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("" + "Введите целое число!");
            scanner.next();
        }
    }

    // проверка введенного шага (шаг должн быть целым, не может быть отрицательным)
    private static int readPositiveInt(Scanner scanner, String error) {
        while (true) {
            System.out.print(error);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                }
                System.out.println("Шаг должен быть положительным числом!");
            } else {
                System.out.println("Введите целое число!");
                scanner.next();
            }
        }
    }

    // метод buildRange для построения списка чисел от first до second с шагом step (так же не нужен в отрыве от класса MultiplicationTable)
    private static List<Integer> buildRange(int first, int second, int step) {
        List<Integer> numbers = new ArrayList<>(); // создание нового пустого массива для добавления чисел
        if (first <= second) { // для возрастающего диапазона чисел (например, от -2 до 5) - проходя вперед, прибавляется шаг
            for (int i = first; i < second; i += step) {
                numbers.add(i);
            }
        } else { // для убывающего диапазона чисел (например, от 5 до -2) - проходя назад, вычитывается шаг
            for (int i = first; i > second; i -= step) {
                numbers.add(i);
            }
        }
        numbers.add(second); // добавление second-числа
        return numbers;
    }

    // вычисление поля результата умножения
    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
    }

    // вывод таблицы умножения
    public static void printTable(List<Integer> numbers) {
        int cellWidth = 0; // вычисление ширины ячейки - перебор чисел и их произведений
        for (int row : numbers) {
            cellWidth = Math.max(cellWidth, getCellWidth(row)); // поиск максимальной длины среди чисел
            for (int col : numbers) {
                cellWidth = Math.max(cellWidth, getCellWidth(row * col)); // и произведений
            }
        }

        String fmt = "%" + cellWidth + "d"; // подготовка данных для вывода:
        // например, если cellWidth = 3, получится "%3d" — число будет выровнено по правому краю в поле шириной 3 символа

        String corner = " ".repeat(cellWidth); // пустое место в левом верхнем углу таблицы — под заголовки строк (для сдвига вправо)

        System.out.print(corner); // печать заголовка
        for (int col : numbers) {
            System.out.printf(" " + fmt, col); // cначала пустой угол, затем каждое число диапазона через пробел
        }
        System.out.println(); // переход на новую строку

        for (int row : numbers) { // печать строк таблиц
            System.out.printf(fmt, row); // вывод заголовок строк
            for (int col : numbers) {
                System.out.printf(" " + fmt, row * col); // вывод произведений через пробел
            }
            System.out.println(); // переход на новую строку
        }
    }
}
