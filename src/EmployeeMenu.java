import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class EmployeeMenu {
    public static void start() throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n���� �����������: " +
                    "\n1) ������������������" +
                    "\n2) �����" +
                    "\n3) ���������" +
                    "\n0) ��������� � ������� ����");

            System.out.print("\n������� ����� ����: ");
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
                    else System.out.println("\n�������� ����� ��� ������, ��������� ������� ��� �������� �������!");
                    break;
                case 3:
                    System.out.println("������� ����� ��� �������� � ���������:");
                    String text = scanner.nextLine();
                    break;
                case 0: MainMenu.start();
                default:
                    System.out.println("�������� ����� � ����!");
                    break;
            }
//                "\n4) ���������� ���������� � ��������" +
//                "\n5) �������� ���������� �� ��������" +
//                "\n6) �������� ������������ ��������" +
//                "\n7) ���� ��� ������ � ������������" +
//                "\n0) ��������� � ���� ��� ������ � ���������");
        }
    }
}
