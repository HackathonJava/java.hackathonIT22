import java.util.Scanner;

public class Santa extends User {
    public static void myProfile() {
        User user = User.getCurrentUser();
        System.out.println("\n�����: " + user.getLogin() +
                "\n���: " + user.getName() +
                "\n�������: " + user.getAge() +
                "\n���������: " + user.getJobs()
        );
    }

    // ����� ���������
    public static void choiceCategories() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        boolean res = false;
        for (String categories : User.getCategories()) {
            System.out.println(count + ": " + categories);
            res = true;
            count++;
        }
        if (!res) {
            System.out.println("����� ��� �� ������� ���������!");
            return;
        }
        System.out.print("������� �������� ���������: ");
        String nameCategories = scanner.nextLine();
        for (String categories : User.getCategories()) {
            if (nameCategories.equals(categories)) {
                User.getCurrentUser().setCategory(nameCategories);
                System.out.println("���� ��������� �����������! : " + User.getCurrentUser().getCategory());
            }
        }
    }

    // ���� ����������
    public static boolean resultJereb() {
        String set = Admin.getHashMap().get(User.getCurrentUser().getName());
        if (set != null) {
            System.out.print("�� ������ ������ �������: " + set +
                    "\n��� ���������: ");
            for (User user : Storage.getEmpList()) {
                if (user.getName().equals(Admin.getHashMap().get(User.getCurrentUser().getName()))) {
                    System.out.println(user.getCategory());
                    return true;
                }
            }
        } else {
            System.out.println("����� ��� �� ������ ����������!");
            return false;
        }
        return false;
    }

    // ���������� �������
    public static void selectGift() {
        Scanner scanner = new Scanner(System.in);
        if(!resultJereb()) return;
        else if(Personal.getMinPrice() == 0) {
            System.out.println("����� ��� �� ��������� ��� ���������, ���������� �����!");
            return;
        }

        double price = 0;
        while (true) {
            System.out.print("������� �������� �������: ");
            String nameGift = scanner.next();
            System.out.print("���� �������: ");
            double priceGift = scanner.nextDouble();
            price += priceGift;
            System.out.println("������� ��������! ������� ���������: " + price);
            System.out.println("\n1) �������� ��� �������" + "\n2) ��������� �������");
            int number = scanner.nextInt();
            if (number == 2) {
                if (price < Personal.getMinPrice()) {
                    System.out.println("\n��������� ������� ������ ������������!" +
                            "\n1) �������� ��� �������" + "\n2) �������� �������");
                    int num = scanner.nextInt();
                    if (num == 2) break;
                } else {
                    System.out.println("������� ������� �����������! ���� �������: " + price);
                    break;
                }
            } else if (number != 1 || number != 2) {
                System.out.println("��� ������ ����! ���������� ��� ���!");
                break;
            }
        }
    }
}
