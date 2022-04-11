import database.Database;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        show_info();
        String tablename = "credentials";
        Database db = new Database();
        Scanner s = new Scanner(System.in);
        while (true) {
            int option = choose_option();
            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.print("""
                            Введите количетсво записей и их данные. Формат входных данных:
                            N
                            username_1 password_1
                            ...
                            username_N password_N
                                                        
                            """);
                    int n = s.nextInt();
                    String ids = "";
                    for (int i = 0; i < n; i++) {
                        try {
                            ids += db.insert(tablename, new Credential(s.next(), s.next())).get(0).toString() + " ";
                        } catch (ConcurrentModificationException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("ID введённых записей: " + ids);
                    break;
                case 2:
                    System.out.print("Введите id удаляемой записи: ");
                    int id = s.nextInt();
                    Record rec = db.deleteRec(tablename, id);
                    if (rec == null) {
                        System.out.println("Записи не существует.");
                        break;
                    }
                    System.out.println("Удалённая запись: " + rec);
                    break;
                case 3:
                    System.out.println("Таблица credentials:\n");
                    for (Map.Entry<Integer, Record> row : db.getTableContent("credentials"))
                        System.out.println("id=" + row.getKey() + ", data=" + row.getValue().toString());
                    break;
                case 4:
                    System.out.print("Введите id искомой записи: ");
                    id = s.nextInt();
                    rec = db.getRow(tablename, id);
                    if (rec == null) {
                        System.out.println("Записи не существует.");
                        break;
                    }
                    System.out.println("Найденная запись: " + rec);
                    break;
                default:
                    System.out.println("Неизвестная опция.");
            }
        }
    }

    public static void show_info() {
        System.out.print("""
                Данная база данных содержит одну таблицу таблицы:
                \tтаблица реквизитов для входа (credentials) - две колонки: username, password
                Добавление прочих таблиц невозможно из данного меню, однако возможно в коде.
                                
                """);
    }

    public static int choose_option() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите номер опции (0 - выход из программы, 1 - вставка, 2 - удаление, 3 - получение всех записей, 4 - поиск по id): ");
        return s.nextInt();
    }
}
