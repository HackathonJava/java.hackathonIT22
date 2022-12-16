import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------" +
                    "\n���� �����������: " +
                    "\n-------------------------" +
                    "\n1) ������������������" +
                    "\n2) �����" +
                    "\n3) �������������� ������" +
                    "\n4) �������� ����������" +
                    "\n0) ��������� � ������� ����");

            System.out.print("\n������� ����� ����: ");
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
                    else System.out.println("\n�������� ����� ��� ������, ��������� ������� ��� �������� �������!");
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
                    System.out.println("�������� ����� � ����!");
                    UserMenu.start();
                    break;
            }
        }
    }
}
