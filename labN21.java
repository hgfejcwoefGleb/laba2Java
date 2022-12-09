import java.util.Scanner;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате дд/мм/гг");
        String data;
        data = sc.nextLine();//ошибки ввода
        char[] myArrayOfYear = new char[4];
        char[] myArrayOfDay = new char[2];
        char[] myArrayOfMonth = new char[2];
        String wrongPattern = "(\\d{2})\\.(\\d{2})\\.\\d{4}";
        String rightPattern = "(\\d{2})\\/(\\d{2})\\/(\\d{4})";
        Pattern DifBeetDataAndRight = Pattern.compile(rightPattern);
        Pattern DifBeetDataAndwrong = Pattern.compile(wrongPattern);
        Matcher m = DifBeetDataAndRight.matcher(data);
        Matcher d = DifBeetDataAndwrong.matcher(data);
            if (d.matches() == true)
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
            else {if (m.matches() == true)
                System.out.println(" ");
                if (m.matches() == false && d.matches() == false){
                System.out.println("Обшибка");
                System.exit(1);}
            }
        data.getChars(6, 10, myArrayOfYear, 0);
        int year = Integer.parseInt(String.valueOf(myArrayOfYear));
        boolean BoolYear = year < 1900;
        if (BoolYear == true)
            System.out.println("Введите год от 1900 до 9999");
        data.getChars(3, 5, myArrayOfMonth, 0);
        int month = Integer.parseInt(String.valueOf(myArrayOfMonth));
        boolean BoolMonth = month < 1 || month > 12;
        if (BoolMonth == true)
            System.out.println("Неверный формат месяца");
        int c;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                c = 31;
                break;
            case 4, 6, 9, 11:
                c = 30;
                break;
            case 2:
                c = 28;
                break;
            default:
                c = 0;
                break;
        }
        data.getChars(0, 2, myArrayOfDay, 0);
        int day = Integer.parseInt(String.valueOf(myArrayOfDay));
        boolean BoolDay = day < 1 || day > 28;
        if (BoolDay == true && c == 28)
            System.out.println("Неверный формат дня");
        boolean BoolDay1 = day < 1 || day > 30;
        if (BoolDay1 == true && c == 30)
            System.out.println("Неверный формат дня");
        boolean BoolDay2 = day < 1 || day > 31;
        if (BoolDay2 == true && c == 31)
            System.out.println("Неверный формат дня");
        if (c == 28 && BoolDay == false && BoolMonth == false && BoolYear == false && d.matches() == false)
            System.out.println("Введенное выражение является датой");
        if (c == 30 && BoolDay1 == false && BoolMonth == false && BoolYear == false && d.matches() == false)
            System.out.println("Введенное выражение является датой");
        if (c == 31 && BoolDay2 == false && BoolMonth == false && BoolYear == false && d.matches() == false)
            System.out.println("Введенное выражение является датой");
        sc.close();
    }
}