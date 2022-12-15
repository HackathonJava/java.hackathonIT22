import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainMenu {
    public static void start() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n  Welcome to Secrets Santa!" +
                "\nНовогодняя игра \"Тайный Санта\"" +
                "\nПорадуй себя и друзей!\n" +
                "\nКем вы являетесь?" +
                "\n1) Админ" +
                "\n2) Сотрудник" +
                "\nДля выхода из программы введите 0");

        System.out.print("\nВведите номер меню: ");
        int number = scanner.nextInt();
        if (number == 1)
            AdminMenu.start();
        else if (number == 2)
            UserMenu.start();
        else if (number == 0) {
            while (true) {
                System.out.print("Вы точно хотите выйти?" +
                        "\n y/n: ");
                String num = scanner.next();
                if (num.equals("y")) {
                    System.out.println("Вы вышли с программы!");
                    break;
                }
                MainMenu.start();
            }
        } else {
            System.out.println("Выберите номер с меню!");
            MainMenu.start();
        }
    }
}