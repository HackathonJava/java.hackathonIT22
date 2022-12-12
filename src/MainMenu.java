import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainMenu {
    public static void start() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n    Welcome to Secrets Santa!" +
                "\nКем вы являетесь?" +
                "\n1) Админ" +
                "\n2) Сотрудник" +
                "\nДля выхода из программы введите 0");

        System.out.print("\nВведите номер меню: ");
        int number = scanner.nextInt();
        if (number == 1)
            AdminMenu.start();
        else if (number == 2)
            EmployeeMenu.start();
        else if(number == 0) {
            while (true) {
                System.out.println("Вы точно хотите выйти?" +
                        "\n1) Выход" +
                        "\n2) Отмена\n" +
                        "\nВведите номер с меню: ");
                int num = scanner.nextInt();
                if (num == 1) return;
                else if (num == 2) MainMenu.start();
                    else System.out.println("Выберите номер с меню!");
            }
        }
        else System.out.println("Выберите номер с меню!");
    }
}