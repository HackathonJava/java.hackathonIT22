import java.util.ArrayList;

public abstract class Personal {
    public Personal() {
    }

    private static double maxPrice;
    private static ArrayList<String> instruction = new ArrayList<>();
    private static String expirationDate;
    private static String dateChange;
    private boolean isSanta = false;
    private boolean isRecipient = false;
    private String login;

    private String password;
    private String name;

    private int age;
    private String jobs;
    private String category;
    private String giftRecipients;
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

    public static double getMaxPrice() {
        return maxPrice;
    }

    public static void setMaxPrice(double maxPrice) {
        Personal.maxPrice = maxPrice;
    }

    public static ArrayList<String> getInstruction() {
        return instruction;
    }

    public static void setInstruction(ArrayList<String> instruction) {
        Personal.instruction = instruction;
    }

    public static String getExpirationDate() {
        return expirationDate;
    }

    public static void setExpirationDate(String expirationDate) {
        Personal.expirationDate = expirationDate;
    }

    public boolean isSanta() {
        return isSanta;
    }

    public void setSanta(boolean santa) {
        isSanta = santa;
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

    public String getGiftRecipients() {
        return giftRecipients;
    }

    public void setGiftRecipients(String giftRecipients) {
        this.giftRecipients = giftRecipients;
    }

    public static String getDateChange() {
        return dateChange;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void setDateChange(String dateChange) {
        Personal.dateChange = dateChange;
    }

    public boolean isRecipient() {
        return isRecipient;
    }

    public void setRecipient(boolean recipient) {
        isRecipient = recipient;
    }

    public int getAge() {
        return age;
    }
}
