import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Employee extends Personal implements Avtorization{

    private static Employee currentUser;

    private static HashMap<String, String> hashMap = new HashMap<>();
    private static ArrayList<Employee> empList = new ArrayList<>();

    public Employee(String login, String password) {
        super(login, password);
    }

    public Employee(String login, String password, String name, int age, String jobs) {
        super(login, password, name, age, jobs);
    }

    public Employee() {
    }

    @Override
    public boolean signin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите ваш пароль: ");
        String password = scanner.nextLine();
        for(Employee employee : empList) {
            if(employee.getLogin().equals(login) && employee.getPassword().equals(password)) {
                currentUser = employee;
                System.out.println("\nУспешный вход в систему!");
                return true;
            }
        }
        return false;
    }

    public void signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Подтвердите пароль: ");
        String passwordCheck = scanner.nextLine();
        if(passwordCheck.equals(passwordCheck)) {
            System.out.print("Пожалуйста заполните анкету!" +
                    "\nВаше имя:  ");
            String name = scanner.nextLine();
            System.out.print("Ваш возраст: ");
            int age = scanner.nextInt();
            System.out.println("Кем работаете: ");
            String job = scanner.nextLine();
            System.out.println();
            empList.add(new Employee(login, password, name, age, job));
            System.out.println("Регистрация успешно завершена!");
        }
        else System.out.println("Пароли не совпадают, повторите попытку");
    }

    public void randomGiver() {
//        Random random = new Random();
//        int size = empList.size();
//        int rand = random.nextInt(1, size + 1);
//        if(empList.get(rand).getName() != currentUser.getName() && empList.get(rand).isSanta()) {
//            hashMap.put(currentUser.getName(), empList.get(rand).getName());
//            System.out.println("Вы дарите подарок: " + hashMap.get(currentUser.getName()));

        Random random = new Random();
        for(Employee employee : empList) {
            int count = random.nextInt(1, empList.size());
            if(empList.get(count).isRecipient()) {
                while (true) {
                    count = random.nextInt(1, empList.size());
                    if(!empList.get(count).isRecipient()) {
                        hashMap.put(employee.getName(), empList.get(count).getName());
                        empList.get(count).setRecipient(true);
                        break;
                    }
                }
            }
            else if(!empList.get(count).isRecipient()) {
                hashMap.put(employee.getName(), empList.get(count).getName());
                empList.get(count).setRecipient(true);
            }
        }
    }

    public static Employee getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Employee currentUser) {
        Employee.currentUser = currentUser;
    }

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(HashMap<String, String> hashMap) {
        Employee.hashMap = hashMap;
    }

    public static ArrayList<Employee> getEmpList() {
        return empList;
    }

    public static void setEmpList(ArrayList<Employee> empList) {
        Employee.empList = empList;
    }
}
