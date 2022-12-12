import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainMenu {
    public static void start() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n    Welcome to Secrets Santa!" +
                "\n��� �� ���������?" +
                "\n1) �����" +
                "\n2) ���������" +
                "\n��� ������ �� ��������� ������� 0");

        System.out.print("\n������� ����� ����: ");
        int number = scanner.nextInt();
        if (number == 1)
            AdminMenu.start();
        else if (number == 2)
            EmployeeMenu.start();
        else if(number == 0) {
            while (true) {
                System.out.println("�� ����� ������ �����?" +
                        "\n1) �����" +
                        "\n2) ������\n" +
                        "\n������� ����� � ����: ");
                int num = scanner.nextInt();
                if (num == 1) return;
                else if (num == 2) MainMenu.start();
                    else System.out.println("�������� ����� � ����!");
            }
        }
        else System.out.println("�������� ����� � ����!");
    }
}