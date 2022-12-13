import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SantaMenu {
    public static void start() throws NoSuchAlgorithmException {
        Employee employee = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню для санты: " +
                    "\n1) Выбор категории" +
                    "\n2) Узнать результаты жеребьевки" +
                    "\n3) Мои данные" +
                    "\n4) Подготовить подарок" +
                    "\n0) Вернуться в меню сотрудников");

            System.out.print("\nВведите номер меню: ");
            int number = scanner.nextInt();
            if(number == 0) EmployeeMenu.start();
        }
    }
}

