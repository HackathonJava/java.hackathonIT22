import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        LocalDateTime localDateTime = LocalDateTime.now();
        User user1 = new User("ruslan","java","Руслан",19,"Student", localDateTime);
        User user2 = new User("arsen","java","Арсен",17,"Student", localDateTime);
        User user3 = new User("nurmuhammed","java","Нурмухаммед",18,"Student", localDateTime);
        User user4 = new User("maks","java","Максим",25,"Student", localDateTime);
        User user5 = new User("atai","java","Атай",17,"Student", localDateTime);
        User user6 = new User("askat","java","Аскат",17,"Student", localDateTime);
        User user7 = new User("aidai","java","Айдай",18,"Student", localDateTime);
        User user8 = new User("erlan","java","Эрлан",20,"Student", localDateTime);
        User user9 = new User("adelina","java","Аделина",17,"Student", localDateTime);
        User user10 = new User("argen","java","Арген",25,"Reviewer", localDateTime);

        Personal.getInstruction().add("Тайный Санта - это весёлая новогодняя игра для дружной компании, " +
                "в которой может участвовать не менее 3 человек");
        Personal.getInstruction().add("Суть игры состоит в обмене подарками между всеми участниками");
        Personal.getInstruction().add("Имя человека, которому вы дарите подарок, выбирается случайным образом и сообщается только вам");
        Personal.getInstruction().add("До момента обмена подарками никто не знает, кто кому дарит подарок");
        Personal.getInstruction().add("И ни один участник, не знает, кому выпало его имя");
        Personal.getInstruction().add("Обмен подарками происходит в назначенную дату");
        Personal.getInstruction().add("До этого момента каждый участник должен подготовить подарок для своего адресата");

        Personal.getCategories().add("Аксессуары");
        Personal.getCategories().add("Посуда");
        Personal.getCategories().add("Книга");
        Personal.getCategories().add("Настольная игра");
        Personal.getCategories().add("Шарф");
        Personal.getCategories().add("Онлайн уроки");
        Personal.getCategories().add("Антистресс-игрушка");

        MainMenu.start();

    }
}