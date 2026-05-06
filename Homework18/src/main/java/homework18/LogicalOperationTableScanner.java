package main.java.homework18;
import java.util.Scanner; // используем класс Scanner для ввода значений P и Q через консоль

public class LogicalOperationTableScanner {
    public static void main(String[] args) {
        //boolean oP = false, sP = true, tP = false, fP = true;
        //boolean oQ = false, sQ = false, tQ = true, fQ = true;
        Scanner sc = new Scanner(System.in);

        boolean oP = sc.nextBoolean(); // для более красивого кода нужно использовать массивы,
        boolean sP = sc.nextBoolean(); // поэтому пока что делаем количество вводимых переменных "в лоб";
        boolean tP = sc.nextBoolean(); // в консоли (в блоке Run) после прогона кода нужно ввести через Enter
        boolean fP = sc.nextBoolean(); // 4 значения переменной P,
                                        // затем поставить пустой Enter,
        boolean oQ = sc.nextBoolean(); // и ввести 4 значения переменной Q, так же через Enter,
        boolean sQ = sc.nextBoolean(); // после нажать еще раз Enter для вывода результирующей таблицы
        boolean tQ = sc.nextBoolean();
        boolean fQ = sc.nextBoolean();

        System.out.println("P\t\tQ\t\tP AND Q\t\tP OR Q\t P XOR Q\tNOT P"); // остальной блок как в первом решении
        System.out.println(oP +"\t" + oQ + "\t" + (oP & oQ) + "\t\t" + (oP | oQ) + "\t" + (oP ^ oQ) + "\t\t" + (!oP));
        System.out.println(sP +"\t" + sQ + "\t" + (sP & sQ) + "\t\t" + (sP | sQ) + "\t" + (sP ^ sQ) + "\t\t" + (!sP));
        System.out.println(tP +"\t" + tQ + "\t" + (tP & tQ) + "\t\t" + (tP | tQ) + "\t" + (tP ^ tQ) + "\t\t" + (!tP));
        System.out.println(fP +"\t" + fQ + "\t" + (fP & fQ) + "\t\t" + (fP | fQ) + "\t" + (fP ^ fQ) + "\t\t" + (!fP));
    }
}
