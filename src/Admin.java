import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Admin extends Personal implements Avtorization {
    LocalDate localDate;

    private String login = "[-29, -81, -19, 0, 71, -80, -128, 89, -48, -6, -38, 16, -12, 0, -63, -27]";
    private String password = "[-43, 35, -121, -120, 14, 30, -94, 40, 23, -89, 45, 55, 89, 33, 56, 25]";

    private static HashMap<String, String> hashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public Admin() {}

    public Admin(String login, String password) {
        super(login, password);
    }

    // Установка мин стоимости
    public void setPrice() {
        System.out.print("Введите минимальную стоимость товара для игры: ");
        double price = scanner.nextDouble();
        Personal.setMinPrice(price);
        System.out.println("Минимальная стоимость установлена! : " + price);
    }

    // просмотр инструкций
    public void setInstruction() {
        int count = 1;
        boolean res = false;
        System.out.println("Список инструкция:");
        for (String s : Personal.getInstruction()) {
            System.out.println(count + ": " + s);
            count++;
            res = true;
        }
        if (!res) System.out.println("Инструкции еще не установлены, плиз добавьте их!");
    }

    // добавление инструкций
    public void addInstruction() {
        System.out.println("Напишите новую инструкцию: ");
        String inst = scanner.nextLine();
        Personal.getInstruction().add(inst);
    }

    // просмотр категорий
    public void setCategories() {
        int count = 1;
        boolean res = false;
        System.out.println("Список категорий:");
        for (String s : Personal.getCategories()) {
            System.out.println(count + ": " + s);
            count++;
            res = true;
        }
        if (!res) System.out.println("Категории еще не установлены, плиз добавьте их!");
    }

    // добавление категорий
    public void addCategories() {
        System.out.println("Напишите новую инструкцию: ");
        String inst = scanner.nextLine();
        Personal.getCategories().add(inst);
    }

    // установка даты
    public void setExpirationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();
        System.out.print("Введите день: ");
        int day = scanner.nextInt();
        localDate = LocalDate.of(year, month, day);
        System.out.println("Дата окончания игры установлена! - " + localDate);
    }

    // вход в админку
    @Override
    public boolean signin() throws NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("MD5");
        System.out.print("Введите логин: ");
        String logIn = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String passWord = scanner.nextLine();
        byte[] input = logIn.getBytes();
        byte[] digest = digester.digest(input);
        String log = Arrays.toString(digest);

        byte[] input2 = passWord.getBytes();
        byte[] digest2 = digester.digest(input2);
        String pass = Arrays.toString(digest2);

        if (!log.equals(login) || !pass.equals(password)) return false;
        else return true;
    }

    // рандомайзер
    public static void randomGiver() {
        if (Storage.getEmpList().size() < 3) {
            System.out.println("Для старта жеребьевки требуется минимум 3 человека!");
            return;
        }
        hashMap.clear();
        Collections.shuffle(Storage.getEmpList());
        for (int i = 0; i < Storage.getEmpList().size() - 1; i++) {
            hashMap.put(Storage.getEmpList().get(i).getName(), Storage.getEmpList().get(i + 1).getName());
        }
        hashMap.put(Storage.getEmpList().get(Storage.getEmpList().size() - 1).getName(),
                Storage.getEmpList().get(0).getName());

        System.out.println("Жеребьевка успешно завершена!" +
                "\nРезультаты жеребьевки: \n");
        for (Map.Entry<String, String> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " дарит подарок -> " + map.getValue());
        }
    }


    // восстановление пароля
    public static void recoveryPassword() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        System.out.print("Введите ваш логин: ");
        String login = scanner.next();
        for(User u : Storage.getEmpList()) {
            if(u.getLogin().equals(login)) {
                user = u;
            }
        }
        if(user == null) {
            System.out.println("Нет такого логина в базе!");
            return;
        }
        System.out.print("Для подтверждения личности" +
                "\nВведите ваше имя: ");
        String name = scanner.next();
        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        if(!user.getName().equals(name) || user.getAge() != age) {
            System.out.println("Ошибка подтверждения личности");
            return;
        }
        for(User u : Storage.getEmpList()) {
            if(u.getName().equals(name) && u.getAge() == age) {
                while (true) {
                    System.out.print("Введите новый пароль: ");
                    String password = scanner.next();
                    System.out.print("Подтвердите пароль: ");
                    String passwordCheck = scanner.next();
                    if(!password.equals(passwordCheck)) {
                        System.out.println("Пароли не совпадают, повторите еще раз!");
                    }
                    else {
                        System.out.println("Новый пароль успешно установлен!");
                        u.setPassword(password);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(HashMap<String, String> hashMap) {
        Admin.hashMap = hashMap;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

}
