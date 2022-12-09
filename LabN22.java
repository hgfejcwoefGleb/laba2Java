import java.util.Scanner;
import java.util.regex.*;
public class lr1 {
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String password = sc.nextLine();
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*_).{8,}$";
        Pattern CheckThePassword = Pattern.compile(passwordPattern);
        Matcher m = CheckThePassword.matcher(password);
        boolean a = m.matches();
        if (a == true )
            System.out.println("Пароль надежен");
        else{
            do {
                System.out.println("Введите пароль надежнее(8 символов, 1 заглавная, 1 строчная буква английского алфавита и пробел)");
                password = sc.nextLine();
                passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*_).{8,}$";
                CheckThePassword = Pattern.compile(passwordPattern);
                m = CheckThePassword.matcher(password);
                a = m.matches();
            }while(a == false) ;
            System.out.println("Пароль надежен");
        }
    }}