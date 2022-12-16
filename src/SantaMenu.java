import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SantaMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------" +
                    "\n���� ��� �����: " +
                    "\n-------------------------" +
                    "\n1) ����� ���������" +
                    "\n2) ������ ���������� ����������" +
                    "\n3) ��� ������" +
                    "\n4) ����������� �������" +
                    "\n5) �������� ����������" +
                    "\n0) ��������� � ���� �����������");

            System.out.print("\n������� ����� ����: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Santa.choiceCategories();
                    break;
                case 2:
                    Santa.resultJereb();
                    break;
                case 3:
                    Santa.myProfile();
                    break;
                case 4:
                    Santa.selectGift();
                    break;
                case 5:
                    admin.setInstruction();
                    break;
                case 0:
                    UserMenu.start();
                    return;
                default:
                    System.out.println("�������� ����� � ����!");
                    SantaMenu.start();
                    break;
            }
        }
    }
}

