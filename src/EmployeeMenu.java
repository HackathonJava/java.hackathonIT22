import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class EmployeeMenu {
    public static void start() throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню сотрудников: " +
                    "\n1) Зарегистрироваться" +
                    "\n2) Войти" +
                    "\n3) Поддержка" +
                    "\n0) Вернуться в главное меню");

            System.out.print("\nВведите номер меню: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    employee.signup();
                    SantaMenu.start();
                    break;
                case 2:
                    boolean res = employee.signin();
                    if(res)
                        SantaMenu.start();
                    else System.out.println("\nНеверный логин или пароль, повторите попытку или создайте аккаунт!");
                    break;
                case 3:
                    System.out.println("Введите текст для отправки в поддержку:");
                    String text = scanner.nextLine();
                    break;
                case 0: MainMenu.start();
                default:
                    System.out.println("Выберите номер с меню!");
                    break;
            }
//                "\n4) Добавление сотрудника в компанию" +
//                "\n5) Удаление сотрудника из компании" +
//                "\n6) Поменять руководителя компании" +
//                "\n7) Меню для работы с сотрудниками" +
//                "\n0) Вернуться в меню для работы с холдингом");
        }
    }
}
