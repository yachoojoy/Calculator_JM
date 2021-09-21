import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Calk {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);                  //получение вводимых данных
        String data = scan.nextLine();

        String[] words = data.split(" ");                   //делим на строки

        if (words.length != 3) {                                   //проверка колличества значений
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. не верный формат (число знак число)");
                System.exit(1);
            }
        }

        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};        //массив арабсиких
        String[] znak = new String[]{"+", "-", "*", "/"};                                       //массив знаков

        if (!Arrays.asList(znak).contains(words[1])) {                                           //проверка знака
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. [" + words[1] +                                                  "] не является математической операцией (+,-,*,/)");
                System.exit(1);
            }
        }
        int zna = Arrays.asList(znak).indexOf(words[1]);
        int ara1 = Arrays.asList(arab).indexOf(words[0]);
        int ara2 = Arrays.asList(arab).indexOf(words[2]);


        first:
        if (ara1 >= 0 & ara2 >= 0) {                        //вывод результата арабсиких

            Arabs ar = new Arabs();
            ar.add(ara1 + 1, ara2 + 1);
            if (zna == 0) {
                System.out.println(ar.sum_ar);
            }
            if (zna == 1) {
                System.out.println(ar.raz_ar);
            }
            if (zna == 2) {
                System.out.println(ar.umn_ar);
            }
            if (zna == 3) {
                System.out.println(ar.del_ar);
            }
            System.exit(1);
            if (ara1 < 0 & ara2 < 0) {
                break first;
            }
        }

        int rim1;                               //сравнение со списком из римских 1
        Rim n = Rim.get(words[0]);
        if (n != null) {
            rim1 = n.ordinal() + 1;
        } else {
            rim1 = 0;
        }

        int rim2;                            //сравнение со списком из римских 2
        Rim n1 = Rim.get(words[2]);
        if (n1 != null) {
            rim2 = n1.ordinal() + 1;
        } else {
            rim2 = 0;
        }

        if ((ara1 >= 0 & rim2 != 0) || (ara2 >= 0 & rim1 != 0)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(1);
            }
        }

        if (ara1 < 0 & rim1 == 0 || rim2 == 0) {                    //проверка значений не относящихся к СС
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println(
                        "throws Exception //т.к. не верный формат ввода (римские или арабские числа до десяти)");
                System.exit(1);
            }
        }

        Rims ri = new Rims();                                       //вывод римских рачётов
        ri.add(rim1, rim2);
        if (zna == 0) {
            if (ri.sum_ri <= 10) {
                System.out.println(Rim.values()[ri.sum_ri - 1]);
            }
            if (ri.sum_ri >= 11) {
                System.out.println("X" + Rim.values()[ri.sum_ri - 11]);
            }
        }

        if (zna == 1) {
            if (ri.raz_ri <= 0){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и нуля");
                    System.exit(1);
                }
            } else {
                System.out.println(Rim.values()[ri.raz_ri-1]);
            }
        }
        if (zna == 2) {
            if (ri.umn_ri <= 10) {
                System.out.println(Rim.values()[ri.umn_ri - 1]);
            }
            if (ri.umn_ri >= 11 & ri.umn_ri <= 19) {
                System.out.println("X"+ Rim.values()[ri.umn_ri - 11]);
            }
            if (ri.umn_ri == 20) {
                System.out.println("XX");
            }
            if (ri.umn_ri >= 21 & ri.umn_ri <= 29) {
                System.out.println("XX"+ Rim.values()[ri.umn_ri - 21]);
            }
            if (ri.umn_ri == 30) {
                System.out.println("XXX");
            }
            if (ri.umn_ri >= 31 & ri.umn_ri <= 39) {
                System.out.println("XXX"+ Rim.values()[ri.umn_ri - 31]);
            }
            if (ri.umn_ri == 40) {
                System.out.println("XL");
            }
            if (ri.umn_ri >= 41 & ri.umn_ri <= 49) {
                System.out.println("XL"+ Rim.values()[ri.umn_ri - 41]);
            }
            if (ri.umn_ri == 50) {
                System.out.println("L");
            }
            if (ri.umn_ri >= 51 & ri.umn_ri <= 59) {
                System.out.println("L"+ Rim.values()[ri.umn_ri - 51]);
            }
            if (ri.umn_ri == 60) {
                System.out.println("LX");
            }
            if (ri.umn_ri >= 61 & ri.umn_ri <= 69) {
                System.out.println("LX"+ Rim.values()[ri.umn_ri - 61]);
            }
            if (ri.umn_ri == 70) {
                System.out.println("LXX");
            }
            if (ri.umn_ri >= 71 & ri.umn_ri <= 79) {
                System.out.println("LXX"+ Rim.values()[ri.umn_ri - 71]);
            }
            if (ri.umn_ri == 80) {
                System.out.println("LXXX");
            }
            if (ri.umn_ri >= 81 & ri.umn_ri <= 89) {
                System.out.println("LXXX"+ Rim.values()[ri.umn_ri - 81]);
            }
            if (ri.umn_ri == 90) {
                System.out.println("XC");
            }
            if (ri.umn_ri == 100) {
                System.out.println("C");
            }
        }
        if (zna == 3) {
            try {
                System.out.println(Rim.values()[ri.del_ri-1]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("throws Exception //т.к. деление невозможно выполнить");
            }
        }
    }
}

class Arabs {                           //вычисления арабских чисел
    int sum_ar;
    int raz_ar;
    int umn_ar;
    int del_ar;

    void add(int a_ar, int b_ar) {
        sum_ar = a_ar + b_ar;
        raz_ar = a_ar - b_ar;
        umn_ar = a_ar * b_ar;
        del_ar = a_ar / b_ar;
    }
}

class Rims {                            //вычисления римских чисел
    int sum_ri;
    int raz_ri;
    int umn_ri;
    int del_ri;

    void add(int a_ri, int b_ri) {
        sum_ri = a_ri + b_ri;
        raz_ri = a_ri - b_ri;
        umn_ri = a_ri * b_ri;
        del_ri = (a_ri / b_ri);
    }
}