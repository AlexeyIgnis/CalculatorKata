import MyException.MyException;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws MyException, NumberFormatException, ArrayIndexOutOfBoundsException {
        System.out.println("Введите выражение:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Ваш ответ: " + Main.calc(input));
    }

    public static String calc (String input) throws MyException, NumberFormatException, ArrayIndexOutOfBoundsException {

        String opera;
        String[] massiv = input.split(" ");
        String a = massiv[0];
        try {
            opera = massiv[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyException("Нет пробелов");
        }
        String b = massiv[2];
        String[] rimskie = {"_", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        boolean aB, bB;
        int itogA = 0;
        int itogB = 0;

        if (a.indexOf(73) == 0 || a.indexOf(86) == 0 || a.indexOf(88) == 0) {
            aB = (true);
        } else {
            aB = (false);
        }

        if (b.charAt(0) == 'I' || b.charAt(0) == 'V' || b.charAt(0) == 'X'){
            bB = (true);
        } else {
            bB = (false);
        }

        if (aB != bB){
            throw new MyException("Разные системы счисления");
        } else if (aB == true){

//Перевод рима в арабов
            for (int i = 0; i <= 10; i++){
                if (rimskie[i].equals(a)){  //сравнение строк массива и написанного
                    itogA = i;
                }
            }

            for (int i = 0; i <= 10; i++){
                if (rimskie[i].equals(b)){  //сравнение строк массива и написанного
                    itogB = i;
                }
            }
        } else {
            try {
                itogA = Integer.parseInt(a);
                itogB = Integer.parseInt(b);
            } catch (NumberFormatException e){
                throw new MyException("Очень странные числа");
            }
        }

//Вывод ошибки если введенные значения меньше 1 и больше 10
        if (itogA < 1 || itogA > 10 || itogB < 1 || itogB > 10){
            throw new MyException("Введите значения от 1 до 10");
        }

//Применяем оператор и считаем результат
        int result = switch (opera) {
            case "+" -> itogA + itogB;
            case "-" -> itogA - itogB;
            case "/" -> itogA / itogB;
            case "*" -> itogA * itogB;
            default -> throw new MyException("Неверный оператор");
        };

//Итоговое значение в арабских или римских
        String abricos;
        if (aB){
            if(result <= 0){
                throw new MyException("В риме нет нуля и отрицательных значений");
            }
            abricos = rimskie[result];
        } else {
            abricos = String.valueOf(result);
        }

//Возврат
        return abricos;
    }
}