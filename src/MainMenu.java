import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainMenu {
    public static void start() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n  Welcome to Secrets Santa!" +
                "\n���������� ���� \"������ �����\"" +
                "\n������� ���� � ������!\n" +
                "\n��� �� ���������?" +
                "\n1) �����" +
                "\n2) ���������" +
                "\n��� ������ �� ��������� ������� 0");

        System.out.print("\n������� ����� ����: ");
        int number = scanner.nextInt();
        if (number == 1)
            AdminMenu.start();
        else if (number == 2)
            UserMenu.start();
        else if (number == 0) {
            while (true) {
                System.out.print("�� ����� ������ �����?" +
                        "\n y/n: ");
                String num = scanner.next();
                if (num.equals("y")) {
                    System.out.println("�� ����� � ���������!");
                    break;
                }
                MainMenu.start();
            }
        } else {
            System.out.println("�������� ����� � ����!");
            MainMenu.start();
        }
    }
}