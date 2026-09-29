import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    String task = scanner.nextLine();

                    if (!tasks.contains(task)) {
                        tasks.add(task);
                        System.out.println("Добавлено!");
                    } else {
                        System.out.println("Такое дело уже есть!");
                    }

                    showTasks(tasks);
                    break;

                case 2:
                    showTasks(tasks);
                    break;

                case 3:
                    System.out.print("Введите номер для удаления: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();

                    if (number >= 1 && number <= tasks.size()) {
                        tasks.remove(number - 1);
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Дела с таким номером нет!");
                    }

                    showTasks(tasks);
                    break;

                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    String taskToDelete = scanner.nextLine();

                    if (tasks.remove(taskToDelete)) {
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Дела с таким названием нет!");
                    }

                    showTasks(tasks);
                    break;

                default:
                    System.out.println("Неизвестная операция!");
                    showTasks(tasks);
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void showTasks(ArrayList<String> tasks) {
        System.out.println("Ваш список дел:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}