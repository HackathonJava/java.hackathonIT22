import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
public class Admin extends Personal implements Avtorization{

    private String login = "[-29, -81, -19, 0, 71, -80, -128, 89, -48, -6, -38, 16, -12, 0, -63, -27]";
    private String password = "[-43, 35, -121, -120, 14, 30, -94, 40, 23, -89, 45, 55, 89, 33, 56, 25]";
    Scanner scanner = new Scanner(System.in);

    public Admin() {
    }

    public Admin(String login, String password) {
        super(login, password);
    }

    public void setPrice() {
        System.out.println("������� ������������ ��������� ������ ��� ����: ");
        double price = scanner.nextDouble();
        Personal.setMaxPrice(price);
        System.out.println("������������ ��������� �����������! - " + price);
    }

    public void setInstruction() {
        int count = 1;
        boolean res = false;
                System.out.println("������ ����������:");
        for(String s : Personal.getInstruction()) {
            System.out.println(count + ": " + s);
            count++;
            res = true;
        }
        if(!res) System.out.println("���������� ��� �� �����������, ���� �������� ��!");
    }

    public void addInstruction() {
        System.out.println("�������� ����� ����������: ");
        String inst = scanner.nextLine();
        Personal.getInstruction().add(inst);
    }
    public void setExpirationDate() {
        System.out.print("������� ���� ��������� ����: ");
        String date = scanner.nextLine();
        Admin.setExpirationDate(date);
        System.out.println("���� ��������� ���� �����������! - " + date);
    }

    public void setDateChange() {
        System.out.print("������� ���� ������ ���������: ");
        String date = scanner.nextLine();
        Personal.setDateChange(date);
        System.out.println("���� ������ ��������� �����������! - " + date);
    }

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

        if(!log.equals(login) || !pass.equals(password))  return false;
        else return true;
    }


}
