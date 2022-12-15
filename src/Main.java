import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        LocalDateTime localDateTime = LocalDateTime.now();
        User user1 = new User("ruslan","java","������",19,"Student", localDateTime);
        User user2 = new User("arsen","java","�����",17,"Student", localDateTime);
        User user3 = new User("nurmuhammed","java","�����������",18,"Student", localDateTime);
        User user4 = new User("maks","java","������",25,"Student", localDateTime);
        User user5 = new User("atai","java","����",17,"Student", localDateTime);
        User user6 = new User("askat","java","�����",17,"Student", localDateTime);
        User user7 = new User("aidai","java","�����",18,"Student", localDateTime);
        User user8 = new User("erlan","java","�����",20,"Student", localDateTime);
        User user9 = new User("adelina","java","�������",17,"Student", localDateTime);
        User user10 = new User("argen","java","�����",25,"Reviewer", localDateTime);

        Personal.getInstruction().add("������ ����� - ��� ������ ���������� ���� ��� ������� ��������, " +
                "� ������� ����� ����������� �� ����� 3 �������");
        Personal.getInstruction().add("���� ���� ������� � ������ ��������� ����� ����� �����������");
        Personal.getInstruction().add("��� ��������, �������� �� ������ �������, ���������� ��������� ������� � ���������� ������ ���");
        Personal.getInstruction().add("�� ������� ������ ��������� ����� �� �����, ��� ���� ����� �������");
        Personal.getInstruction().add("� �� ���� ��������, �� �����, ���� ������ ��� ���");
        Personal.getInstruction().add("����� ��������� ���������� � ����������� ����");
        Personal.getInstruction().add("�� ����� ������� ������ �������� ������ ����������� ������� ��� ������ ��������");

        Personal.getCategories().add("����������");
        Personal.getCategories().add("������");
        Personal.getCategories().add("�����");
        Personal.getCategories().add("���������� ����");
        Personal.getCategories().add("����");
        Personal.getCategories().add("������ �����");
        Personal.getCategories().add("����������-�������");

        MainMenu.start();

    }
}