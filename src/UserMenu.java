import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------" +
                    "\nМеню сотрудников: " +
                    "\n-------------------------" +
                    "\n1) Зарегистрироваться" +
                    "\n2) Войти" +
                    "\n3) Восстановление пароля" +
                    "\n4) Просмотр инструкции" +
                    "\n0) Вернуться в главное меню");

            System.out.print("\nВведите номер меню: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    boolean result = user.signup();
                    if (result) SantaMenu.start();
                    else UserMenu.start();
                    break;
                case 2:
                    boolean res = user.signin();
                    if (res)
                        SantaMenu.start();
                    else System.out.println("\nНеверный логин или пароль, повторите попытку или создайте аккаунт!");
                    break;
                case 3:
                    Admin.recoveryPassword();
                    break;
                case 4:
                    admin.setInstruction();
                    break;
                case 0:
                    MainMenu.start();
                    return;
                default:
                    System.out.println("Выберите номер с меню!");
                    UserMenu.start();
                    break;
            }
        }
    }
}
