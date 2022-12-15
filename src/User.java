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

    // вход
    @Override
    public boolean signin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите ваш пароль: ");
        String password = scanner.nextLine();

        for (User user : Storage.getEmpList()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("\nУспешный вход в систему!");
                return true;
            }
        }
        return false;
    }

    // регистрация
    public boolean signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Подтвердите пароль: ");
        String passwordCheck = scanner.nextLine();
        if (password.equals(passwordCheck)) {
            System.out.print("Пожалуйста заполните анкету!" +
                    "\nВаше имя:  ");
            String name = scanner.nextLine();
            System.out.print("Ваш возраст: ");
            int age = scanner.nextInt();
            System.out.print("Должность: ");
            String job = scanner.next();

            while (true) {
                boolean checkLogin = false;
                boolean checkName = false;
                for (User employees : Storage.getEmpList()) {
                    if (employees.getLogin().equals(login)) {
                        checkLogin = true;
                        System.out.print("\nПользователь с таким логином уже существует!" +
                                "\nВведите новый логин: ");
                        login = scanner.next();
                    } else if (employees.getName().equals(name)) {
                        checkName = true;
                        System.out.print("\nПользователь с таким именем уже существует!" +
                                "\nВведите новое имя: ");
                        name = scanner.next();
                    }
                }
                if (!checkLogin && !checkName) {
                    break;
                }
            }

            User user = new User(login, password, name, age, job, localDateTime);
            currentUser = user;
            System.out.println("Регистрация успешно завершена!");
            return true;
        } else {
            System.out.println("Пароли не совпадают, повторите попытку");
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
