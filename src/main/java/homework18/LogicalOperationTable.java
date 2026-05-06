package main.java.homework18;

public class LogicalOperationTable {
    public static void main(String[] args) {
        boolean oP = false, sP = true, tP = false, fP = true; // определяем переменную P и ее значения
        boolean oQ = false, sQ = false, tQ = true, fQ = true; // определяем переменную Q и ее значения
        // заголовок таблицы (взят из описания домашки + кое-где добавлена табуляция для более красивого вывода)
        System.out.println("P\t\tQ\t\tP AND Q\t\tP OR Q\t P XOR Q\tNOT P");
        // логические операции для заполнения строк таблицы и вывод результатов
        System.out.println(oP +"\t" + oQ + "\t" + (oP & oQ) + "\t\t" + (oP | oQ) + "\t" + (oP ^ oQ) + "\t\t" + (!oP));
        System.out.println(sP +"\t" + sQ + "\t" + (sP & sQ) + "\t\t" + (sP | sQ) + "\t" + (sP ^ sQ) + "\t\t" + (!sP));
        System.out.println(tP +"\t" + tQ + "\t" + (tP & tQ) + "\t\t" + (tP | tQ) + "\t" + (tP ^ tQ) + "\t\t" + (!tP));
        System.out.println(fP +"\t" + fQ + "\t" + (fP & fQ) + "\t\t" + (fP | fQ) + "\t" + (fP ^ fQ) + "\t\t" + (!fP));
    }

}
