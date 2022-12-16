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

    // ��������� ��� ���������
    public void setPrice() {
        System.out.print("������� ����������� ��������� ������ ��� ����: ");
        double price = scanner.nextDouble();
        Personal.setMinPrice(price);
        System.out.println("����������� ��������� �����������! : " + price);
    }

    // �������� ����������
    public void setInstruction() {
        int count = 1;
        boolean res = false;
        System.out.println("������ ����������:");
        for (String s : Personal.getInstruction()) {
            System.out.println(count + ": " + s);
            count++;
            res = true;
        }
        if (!res) System.out.println("���������� ��� �� �����������, ���� �������� ��!");
    }

    // ���������� ����������
    public void addInstruction() {
        System.out.println("�������� ����� ����������: ");
        String inst = scanner.nextLine();
        Personal.getInstruction().add(inst);
    }

    // �������� ���������
    public void setCategories() {
        int count = 1;
        boolean res = false;
        System.out.println("������ ���������:");
        for (String s : Personal.getCategories()) {
            System.out.println(count + ": " + s);
            count++;
            res = true;
        }
        if (!res) System.out.println("��������� ��� �� �����������, ���� �������� ��!");
    }

    // ���������� ���������
    public void addCategories() {
        System.out.println("�������� ����� ����������: ");
        String inst = scanner.nextLine();
        Personal.getCategories().add(inst);
    }

    // ��������� ����
    public void setExpirationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ���: ");
        int year = scanner.nextInt();
        System.out.print("������� �����: ");
        int month = scanner.nextInt();
        System.out.print("������� ����: ");
        int day = scanner.nextInt();
        localDate = LocalDate.of(year, month, day);
        System.out.println("���� ��������� ���� �����������! - " + localDate);
    }

    // ���� � �������
    @Override
    public boolean signin() throws NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("MD5");
        System.out.print("������� �����: ");
        String logIn = scanner.nextLine();
        System.out.print("������� ������: ");
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

    // �����������
    public static void randomGiver() {
        if (Storage.getEmpList().size() < 3) {
            System.out.println("��� ������ ���������� ��������� ������� 3 ��������!");
            return;
        }
        hashMap.clear();
        Collections.shuffle(Storage.getEmpList());
        for (int i = 0; i < Storage.getEmpList().size() - 1; i++) {
            hashMap.put(Storage.getEmpList().get(i).getName(), Storage.getEmpList().get(i + 1).getName());
        }
        hashMap.put(Storage.getEmpList().get(Storage.getEmpList().size() - 1).getName(),
                Storage.getEmpList().get(0).getName());

        System.out.println("���������� ������� ���������!" +
                "\n���������� ����������: \n");
        for (Map.Entry<String, String> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " ����� ������� -> " + map.getValue());
        }
    }


    // �������������� ������
    public static void recoveryPassword() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        System.out.print("������� ��� �����: ");
        String login = scanner.next();
        for(User u : Storage.getEmpList()) {
            if(u.getLogin().equals(login)) {
                user = u;
            }
        }
        if(user == null) {
            System.out.println("��� ������ ������ � ����!");
            return;
        }
        System.out.print("��� ������������� ��������" +
                "\n������� ���� ���: ");
        String name = scanner.next();
        System.out.print("������� ��� �������: ");
        int age = scanner.nextInt();
        if(!user.getName().equals(name) || user.getAge() != age) {
            System.out.println("������ ������������� ��������");
            return;
        }
        for(User u : Storage.getEmpList()) {
            if(u.getName().equals(name) && u.getAge() == age) {
                while (true) {
                    System.out.print("������� ����� ������: ");
                    String password = scanner.next();
                    System.out.print("����������� ������: ");
                    String passwordCheck = scanner.next();
                    if(!password.equals(passwordCheck)) {
                        System.out.println("������ �� ���������, ��������� ��� ���!");
                    }
                    else {
                        System.out.println("����� ������ ������� ����������!");
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
