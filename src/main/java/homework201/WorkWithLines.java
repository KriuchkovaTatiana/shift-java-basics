package main.java.homework201;
import java.util.Scanner;

public class WorkWithLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalString; // цикл для проверки введенной исходной строки
        while (true) {
            System.out.print("Введите строку: ");
            originalString = scanner.nextLine();

            if (originalString.length() <= 1) {
                System.out.println("Строка должна содержать более одного символа!");
                continue; // если введена пустая строка - предупреждение, выход на повторный ввод строки
            }
            if (!originalString.matches("[a-zA-Zа-яА-ЯёЁ .?!,:;]+")) {
                System.out.println("Строка содержит недопустимые символы!");
                continue; // если введена строка с недопустимыми символами - предупреждение, выход на повторный ввод строки
            }
            break; // все проверки пройдены — выход из цикла
        }

        char searchChar; // цикл для проверки введенного символа для замены
        while (true) {
            System.out.print("Введите символ для замены: ");
            String charInput = scanner.nextLine();

            if (charInput.length() != 1 || charInput.charAt(0) == ' ') {
                System.out.println("Необходимо ввести ровно один символ, не являющийся пробелом!");
                continue; // если введен пустой символ или несколько символов - предупреждение, выход на повторный ввод символа
            }
            searchChar = charInput.charAt(0);
            break;
        }

        // убираем лишние пробелы в исходной строке
        String formattedString = originalString.replaceAll(" {2,}", " ");

        // заменяем исходный символ на пробел, убираем лишние пробелы
        String result = formattedString.replace(searchChar, ' ').replaceAll(" {2,}", " ");

        if (originalString.equals(result)) {
            System.out.println("Строка не изменилась после преобразований");
        } else {
            System.out.println("Исходная строка: \"" + originalString + "\"\nПолучившаяся строка: \"" + result + "\"");
        }
    }
}
