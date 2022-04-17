import database.Table;

import java.util.Map;
import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        Table<Credential> db = new Table<>();
        Scanner s = new Scanner(System.in);
        while (true) {
            int option = chooseOption(s);
            switch (option) {
                case 0:
                    return;
                case 1:
                    insertion(db, s);
                    break;
                case 2:
                    deletion(db, s);
                    break;
                case 3:
                    gettingAll(db);
                    break;
                case 4:
                    gettingOne(db, s);
                    break;
                case 5:
                    updating(db, s);
                    break;
                default:
                    System.out.println("Unknown option.");
            }
        }
    }

    public static int chooseOption(Scanner s) {
        System.out.println("""
                Choose option:
                    0 - exit;
                    1 - insert;
                    2 - delete;
                    3 - get all;
                    4 - find by id;
                    5 - update.""");
        return s.nextInt();
    }

    public static void insertion(Table<Credential> db, Scanner s) {
        System.out.println("Enter data - username and password seperated by space:");
        Map.Entry<Integer, Credential> item = db.insert(new Credential(s.next(), s.next()));
        if (item == null){
            System.out.println("Username must be unique.");
            return;
        }
        System.out.println(item);
    }

    public static void deletion(Table<Credential> db, Scanner s) {
        System.out.print("Enter id: ");
        int id = s.nextInt();
        Credential data = db.delete(id);
        if (data == null) {
            System.out.println("There is no such id.");
            return;
        }
        System.out.println(data + " - was deleted.");
    }

    public static void gettingAll(Table<Credential> db) {
        if (db.size() == 0) {
            System.out.println("Table is empty.");
            return;
        }
        for (Map.Entry<Integer, Credential> elem : db.getAll())
            System.out.println(elem.toString());
    }

    public static void gettingOne(Table<Credential> db, Scanner s) {
        System.out.print("Enter id: ");
        int id = s.nextInt();
        Credential data = db.getOne(id);
        if (data == null) {
            System.out.println("There is no such id.");
            return;
        }
        System.out.println(data);
    }

    public static void updating(Table<Credential> db, Scanner s) {
        System.out.println("Enter data - id, new username and new password seperated by spaces:");
        int id = s.nextInt();
        Credential newItem = new Credential(s.next(), s.next());
        if (!db.update(id, newItem)) {
            System.out.println("There is no such id.");
            return;
        }
        System.out.println("Updated successfully");
    }
}
