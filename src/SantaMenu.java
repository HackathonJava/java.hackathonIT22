import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SantaMenu {
    public static void start() throws NoSuchAlgorithmException {
        Employee employee = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n���� ��� �����: " +
                    "\n1) ����� ���������" +
                    "\n2) ������ ���������� ����������" +
                    "\n3) ��� ������" +
                    "\n4) ����������� �������" +
                    "\n0) ��������� � ���� �����������");

            System.out.print("\n������� ����� ����: ");
            int number = scanner.nextInt();
            if(number == 0) EmployeeMenu.start();
        }
    }
}

