import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SantaMenu {
    public static void start() throws NoSuchAlgorithmException {
        Admin admin = new Admin();
        User user = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------" +
                    "\nМеню для санты: " +
                    "\n-------------------------" +
                    "\n1) Выбор категории" +
                    "\n2) Узнать результаты жеребьевки" +
                    "\n3) Мои данные" +
                    "\n4) Подготовить подарок" +
                    "\n5) Просмотр инструкции" +
                    "\n0) Вернуться в меню сотрудников");

            System.out.print("\nВведите номер меню: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Santa.choiceCategories();
                    break;
                case 2:
                    Santa.resultJereb();
                    break;
                case 3:
                    Santa.myProfile();
                    break;
                case 4:
                    Santa.selectGift();
                    break;
                case 5:
                    admin.setInstruction();
                    break;
                case 0:
                    UserMenu.start();
                    return;
                default:
                    System.out.println("Выберите номер с меню!");
                    SantaMenu.start();
                    break;
            }
        }
    }
}

