import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AdminMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = new User();
        boolean res = admin.signin();
        if (res) {
            System.out.println("\n�������� ���� � �������!");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("-------------------------" +
                        "\n���� ��� �������: " +
                        "\n-------------------------" +
                        "\n1) ������� ����������� ��������� ������" +
                        "\n2) ������ � ������������" +
                        "\n3) ������ � �����������" +
                        "\n4) ������ � �����" +
                        "\n5) �������� ����������" +
                        "\n6) ���������� �� ����������" +
                        "\n0) ��������� � ������� ����");

                System.out.print("\n������� ����� ����: ");

                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        admin.setPrice();
                        break;
                    case 2:
                        System.out.println("\n1) ����� ������ ����������" +
                                "\n2) ���������� ����������\n\n" +
                                "������� ����� ����: ");
                        int num = scanner.nextInt();
                        if (num == 1) admin.setInstruction();
                        else if (num == 2) admin.addInstruction();
                        break;
                    case 3:
                        System.out.println("\n1) ����� ������ ���������" +
                                "\n2) ���������� ���������\n\n" +
                                "������� ����� ����: ");
                        int numb = scanner.nextInt();
                        if (numb == 1) admin.setCategories();
                        else if (numb == 2) admin.addCategories();
                        break;
                    case 4:
                        System.out.println("\n1) ���������� ����" +
                                "\n2) �������� ������������� ����" +
                                "\n3) �������� � ���� ��������� ���������� ����" +
                                "\n4) ������ �� ���� ��������� ���������� ����\n" +
                                "������� ����� ����: ");
                        int numberr = scanner.nextInt();
                        if (numberr == 1) {
                            admin.setExpirationDate();
                        } else if (numberr == 2) {
                            if (admin.getLocalDate() == null) {
                                System.out.println("���� ��� �� �����������!");
                            } else {
                                System.out.println(admin.getLocalDate());
                            }
                        } else if (numberr == 3) {
                            System.out.print("������� ���-�� ���� ��� ����������: ");
                            int day = scanner.nextInt();
                            admin.setLocalDate(admin.getLocalDate().plusDays(day));
                            System.out.println("����� ����: " + admin.getLocalDate());
                        } else if (numberr == 4) {
                            System.out.print("������� ���-�� ���� ��� �������: ");
                            int day = scanner.nextInt();
                            admin.setLocalDate(admin.getLocalDate().minusDays(day));
                            System.out.println("����� ����: " + admin.getLocalDate());
                        } else System.out.println("������� ����� � ����!");
                        break;
                    case 5:
                        Admin.randomGiver();
                        break;
                    case 6:
                        Storage.infoEmployee();
                        break;
                    case 0:
                        MainMenu.start();
                        return;
                }
            }
        } else {
            System.out.println("\n����� ��� ������ ������ �����������, ��������� �������!");
            MainMenu.start();
        }


    }
}
