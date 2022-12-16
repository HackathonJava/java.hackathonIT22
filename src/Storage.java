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

    // инфо участников
    public static void infoEmployee() {
        System.out.println("Количество участников: " + Storage.getEmpList().size() + "\n");
        for(User user : Storage.getEmpList()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = user.getLocalDateTime().format(formatter);
            System.out.println("Дата регистрации: " + formatDateTime +
                    "\nЛогин: " + user.getLogin() +
                    "\nИмя: " + user.getName() +
                    "\nВозраст: " + user.getAge() +
                    "\nДолжность: " + user.getJobs() + "\n");
        }
    }
}
