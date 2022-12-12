import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AdminMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        Employee employee = new Employee();
        boolean res = admin.signin();
        if (res) {
            System.out.println("\nУспешный вход в систему!");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nМеню для админов: " +
                        "\n1) Указать максимальную стоимость товара" +
                        "\n2) Работа с инструкциями" +
                        "\n3) Установить дату окончания игры" +
                        "\n4) Установить время обмена подарками" +
                        "\n5) Провести жеребьевку" +
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
                        if(num == 1) admin.setInstruction();
                            else if(num == 2) admin.addInstruction();
                        break;
                    case 3:
                        admin.setExpirationDate();
                        break;
                    case 4:
                        admin.setDateChange();
                        break;
                    case 5:
                        employee.randomGiver();
                        System.out.println(Employee.getHashMap());
                        break;
                    case 0:
                        MainMenu.start();
                }
            }
        } else {
            System.out.println("Логин или пароль указан неправильно, повторите попытку!");
            AdminMenu.start();
        }


    }
}
