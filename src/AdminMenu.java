import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AdminMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        Employee employee = new Employee();
        boolean res = admin.signin();
        if (res) {
            System.out.println("\n�������� ���� � �������!");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n���� ��� �������: " +
                        "\n1) ������� ������������ ��������� ������" +
                        "\n2) ������ � ������������" +
                        "\n3) ���������� ���� ��������� ����" +
                        "\n4) ���������� ����� ������ ���������" +
                        "\n5) �������� ����������" +
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
                        if(num == 1) admin.setInstruction();
                            else if(num == 2) admin.addInstruction();
                        break;
                    case 3:
                        admin.setExpirationDate();
                        break;
                    case 4:
                        admin.setDateChange();
                        break;
                    case 5:
                        employee.randomGiver();
                        System.out.println(Employee.getHashMap());
                        break;
                    case 0:
                        MainMenu.start();
                }
            }
        } else {
            System.out.println("����� ��� ������ ������ �����������, ��������� �������!");
            AdminMenu.start();
        }


    }
}
