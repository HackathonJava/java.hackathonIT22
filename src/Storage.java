import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<User> empList = new ArrayList<>();

    public static ArrayList<User> getEmpList() {
        return empList;
    }

    public static void setEmpList(ArrayList<User> empList) {
        Storage.empList = empList;
    }

    // ���� ����������
    public static void infoEmployee() {
        System.out.println("���������� ����������: " + Storage.getEmpList().size() + "\n");
        for(User user : Storage.getEmpList()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = user.getLocalDateTime().format(formatter);
            System.out.println("���� �����������: " + formatDateTime +
                    "\n�����: " + user.getLogin() +
                    "\n���: " + user.getName() +
                    "\n�������: " + user.getAge() +
                    "\n���������: " + user.getJobs() + "\n");
        }
    }
}
