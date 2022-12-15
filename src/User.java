import java.time.LocalDateTime;
import java.util.Scanner;

public class User extends Personal implements Avtorization {

    private LocalDateTime localDateTime = LocalDateTime.now();
    private static User currentUser;


    public User(String name) {
        super(name);
        Storage.getEmpList().add(this);
    }

    public User(String login, String password, String name, int age, String jobs, LocalDateTime localDateTime) {
        super(login, password, name, age, jobs);
        this.localDateTime = localDateTime;
        Storage.getEmpList().add(this);
    }

    public User() {
    }

    // ����
    @Override
    public boolean signin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ��� �����: ");
        String login = scanner.nextLine();
        System.out.print("������� ��� ������: ");
        String password = scanner.nextLine();

        for (User user : Storage.getEmpList()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("\n�������� ���� � �������!");
                return true;
            }
        }
        return false;
    }

    // �����������
    public boolean signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� �����: ");
        String login = scanner.nextLine();
        System.out.print("������� ������: ");
        String password = scanner.nextLine();
        System.out.print("����������� ������: ");
        String passwordCheck = scanner.nextLine();
        if (password.equals(passwordCheck)) {
            System.out.print("���������� ��������� ������!" +
                    "\n���� ���:  ");
            String name = scanner.nextLine();
            System.out.print("��� �������: ");
            int age = scanner.nextInt();
            System.out.print("���������: ");
            String job = scanner.next();

            while (true) {
                boolean checkLogin = false;
                boolean checkName = false;
                for (User employees : Storage.getEmpList()) {
                    if (employees.getLogin().equals(login)) {
                        checkLogin = true;
                        System.out.print("\n������������ � ����� ������� ��� ����������!" +
                                "\n������� ����� �����: ");
                        login = scanner.next();
                    } else if (employees.getName().equals(name)) {
                        checkName = true;
                        System.out.print("\n������������ � ����� ������ ��� ����������!" +
                                "\n������� ����� ���: ");
                        name = scanner.next();
                    }
                }
                if (!checkLogin && !checkName) {
                    break;
                }
            }

            User user = new User(login, password, name, age, job, localDateTime);
            currentUser = user;
            System.out.println("����������� ������� ���������!");
            return true;
        } else {
            System.out.println("������ �� ���������, ��������� �������");
            return false;
        }
    }


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
