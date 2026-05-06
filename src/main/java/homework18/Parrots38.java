package main.java.homework18;

public class Parrots38 {
    public static void main(String[] args){
        double lSnake = 380 / 100.0; // конвертация длины (роста) удава в м

        int hSnakeInParrots = 38; // рост удава в попугаях
        int hSnakeInMonkeys = 5; // рост удава в мартышках
        int hSnakeInElephants = 2; // рост удава в слонёнках

        double hParrot = lSnake / hSnakeInParrots; // рост попугая в м
        double hMonkey = lSnake / hSnakeInMonkeys; // рост мартышки в м
        double hElephant = lSnake / hSnakeInElephants; // рост слоненка в м

        // вывод информации о росте каждого персонажа
        System.out.printf("Рост удава: %.2f м%n", lSnake);
        System.out.printf("Рост попугая: %.2f м%n", hParrot);
        System.out.printf("Рост мартышки: %.2f м%n", hMonkey);
        System.out.printf("Рост слонёнка: %.2f м%n", hElephant);

        // вывод информации о суммарном росте персонажей
        double hSum = lSnake + hParrot + hMonkey + hElephant;
        System.out.printf("Суммарный рост персонашей: %.2f м%n", hSum);
    }
}
