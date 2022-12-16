import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AdminMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = new User();
        boolean res = admin.signin();
        if (res) {
            System.out.println("\nУспешный вход в систему!");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("-------------------------" +
                        "\nМеню для админов: " +
                        "\n-------------------------" +
                        "\n1) Указать минимальную стоимость товара" +
                        "\n2) Работа с инструкциями" +
                        "\n3) Работа с категориями" +
                        "\n4) Работа с датой" +
                        "\n5) Провести жеребьевку" +
                        "\n6) Информация об участниках" +
                        "\n0) Вернуться в главное меню");

                System.out.print("\nВведите номер меню: ");

                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        admin.setPrice();
                        break;
                    case 2:
                        System.out.println("\n1) Вывод списка инструкций" +
                                "\n2) Добавление инструкции\n\n" +
                                "Введите номер меню: ");
                        int num = scanner.nextInt();
                        if (num == 1) admin.setInstruction();
                        else if (num == 2) admin.addInstruction();
                        break;
                    case 3:
                        System.out.println("\n1) Вывод списка категорий" +
                                "\n2) Добавление категорий\n\n" +
                                "Введите номер меню: ");
                        int numb = scanner.nextInt();
                        if (numb == 1) admin.setCategories();
                        else if (numb == 2) admin.addCategories();
                        break;
                    case 4:
                        System.out.println("\n1) Установить дату" +
                                "\n2) Просмотр установленной даты" +
                                "\n3) Добавить к дате некоторое количество дней" +
                                "\n4) Отнять от даты некоторое количество дней\n" +
                                "Введите номер меню: ");
                        int numberr = scanner.nextInt();
                        if (numberr == 1) {
                            admin.setExpirationDate();
                        } else if (numberr == 2) {
                            if (admin.getLocalDate() == null) {
                                System.out.println("Дата еще не установлена!");
                            } else {
                                System.out.println(admin.getLocalDate());
                            }
                        } else if (numberr == 3) {
                            System.out.print("Введите кол-во дней для добавления: ");
                            int day = scanner.nextInt();
                            admin.setLocalDate(admin.getLocalDate().plusDays(day));
                            System.out.println("Новая дата: " + admin.getLocalDate());
                        } else if (numberr == 4) {
                            System.out.print("Введите кол-во дней для отнятия: ");
                            int day = scanner.nextInt();
                            admin.setLocalDate(admin.getLocalDate().minusDays(day));
                            System.out.println("Новая дата: " + admin.getLocalDate());
                        } else System.out.println("Введите номер в меню!");
                        break;
                    case 5:
                        Admin.randomGiver();
                        break;
                    case 6:
                        Storage.infoEmployee();
                        break;
                    case 0:
                        MainMenu.start();
                        return;
                }
            }
        } else {
            System.out.println("\nЛогин или пароль указан неправильно, повторите попытку!");
            MainMenu.start();
        }


    }
}
