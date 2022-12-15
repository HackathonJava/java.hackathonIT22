import java.util.Scanner;

public class Santa extends User {
    public static void myProfile() {
        User user = User.getCurrentUser();
        System.out.println("\nЛогин: " + user.getLogin() +
                "\nИмя: " + user.getName() +
                "\nВозраст: " + user.getAge() +
                "\nДолжность: " + user.getJobs()
        );
    }

    // выбор категории
    public static void choiceCategories() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        boolean res = false;
        for (String categories : User.getCategories()) {
            System.out.println(count + ": " + categories);
            res = true;
            count++;
        }
        if (!res) {
            System.out.println("Админ еще не добавил категории!");
            return;
        }
        System.out.print("Введите название категории: ");
        String nameCategories = scanner.nextLine();
        for (String categories : User.getCategories()) {
            if (nameCategories.equals(categories)) {
                User.getCurrentUser().setCategory(nameCategories);
                System.out.println("Ваша категория установлена! : " + User.getCurrentUser().getCategory());
            }
        }
    }

    // резы жеребьевки
    public static boolean resultJereb() {
        String set = Admin.getHashMap().get(User.getCurrentUser().getName());
        if (set != null) {
            System.out.print("Вы будете дарить подарок: " + set +
                    "\nЕго категория: ");
            for (User user : Storage.getEmpList()) {
                if (user.getName().equals(Admin.getHashMap().get(User.getCurrentUser().getName()))) {
                    System.out.println(user.getCategory());
                    return true;
                }
            }
        } else {
            System.out.println("Админ еще не провел жеребьевку!");
            return false;
        }
        return false;
    }

    // Подготовка подарка
    public static void selectGift() {
        Scanner scanner = new Scanner(System.in);
        if(!resultJereb()) return;
        else if(Personal.getMinPrice() == 0) {
            System.out.println("Админ еще не установил мин стоимость, попробуйте позже!");
            return;
        }

        double price = 0;
        while (true) {
            System.out.print("Введите название подарка: ");
            String nameGift = scanner.next();
            System.out.print("Цена подарка: ");
            double priceGift = scanner.nextDouble();
            price += priceGift;
            System.out.println("Подарок добавлен! Текущая стоимость: " + price);
            System.out.println("\n1) Добавить еще подарок" + "\n2) Завершить подарок");
            int number = scanner.nextInt();
            if (number == 2) {
                if (price < Personal.getMinPrice()) {
                    System.out.println("\nСтоимость подарка меньше минимального!" +
                            "\n1) Добавить еще подарок" + "\n2) Отменить подарок");
                    int num = scanner.nextInt();
                    if (num == 2) break;
                } else {
                    System.out.println("Подарок успешно подготовлен! Цена подарка: " + price);
                    break;
                }
            } else if (number != 1 || number != 2) {
                System.out.println("Нет такого меню! Попробуйте еще раз!");
                break;
            }
        }
    }
}
