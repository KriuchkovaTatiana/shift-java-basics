package main.java.homework202;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileNotFoundException; // добавленные классы для работы с файлами
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiplicationTableInFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = readInt(scanner, "Введите первое число: ");
        int second = readInt(scanner, "Введите второе число: ");
        int step = readPositiveInt(scanner, "Введите шаг: ");

        List<Integer> numbers = buildRange(first, second, step);
        String table = buildTable(numbers);

        FileOutputStream FileOutputStream = null; // настройки для работы с файлом
        try {
            FileOutputStream = new FileOutputStream("multiplication_table.txt");
            FileOutputStream.write(table.getBytes());
            System.out.println("Таблица сохранена в файл multiplication_table.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        } finally {
            try {
                if (FileOutputStream != null) {
                    FileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла");
            }
        }
    }

    private static int readInt(Scanner scanner, String error) {
        while (true) {
            System.out.print(error);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Введите целое число!");
            scanner.next();
        }
    }

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

    private static List<Integer> buildRange(int first, int second, int step) {
        List<Integer> numbers = new ArrayList<>();
        if (first <= second) {
            for (int i = first; i < second; i += step) {
                numbers.add(i);
            }
        } else {
            for (int i = first; i > second; i -= step) {
                numbers.add(i);
            }
        }
        numbers.add(second);
        return numbers;
    }

    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
    }

    public static String buildTable(List<Integer> numbers) {
        int cellWidth = 0;
        for (int row : numbers) {
            cellWidth = Math.max(cellWidth, getCellWidth(row));
            for (int col : numbers) {
                cellWidth = Math.max(cellWidth, getCellWidth(row * col));
            }
        }

        String fmt = "%" + cellWidth + "d";
        String corner = " ".repeat(cellWidth);
        StringBuilder sb = new StringBuilder();

        sb.append(corner);
        for (int col : numbers) {
            sb.append(String.format(" " + fmt, col));
        }
        sb.append(System.lineSeparator());

        for (int row : numbers) {
            sb.append(String.format(fmt, row));
            for (int col : numbers) {
                sb.append(String.format(" " + fmt, row * col));
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}