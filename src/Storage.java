import java.util.ArrayList;

public class Storage {
    private static ArrayList<User> empList = new ArrayList<>();

    public static ArrayList<User> getEmpList() {
        return empList;
    }

    public static void setEmpList(ArrayList<User> empList) {
        Storage.empList = empList;
    }
}
