import java.util.ArrayList;

public abstract class Personal {
    public Personal() {}

    private static double minPrice;
    private static ArrayList<String> instruction = new ArrayList<>();
    private static ArrayList<String> categories = new ArrayList<>();
    private String login;
    private String password;
    private String name;

    private int age;
    private String jobs;
    private String category = "сюрприз";

    public Personal(String name) {
        this.name = name;
    }

    public Personal(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Personal(String login, String password, String name, int age, String jobs) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
        this.jobs = jobs;
    }

    public static double getMinPrice() {
        return minPrice;
    }

    public static void setMinPrice(double minPrice) {
        Personal.minPrice = minPrice;
    }

    public static ArrayList<String> getInstruction() {
        return instruction;
    }

    public static void setInstruction(ArrayList<String> instruction) {
        Personal.instruction = instruction;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public static ArrayList<String> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<String> categories) {
        Personal.categories = categories;
    }

}
