import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

abstract class Menu {
    private static String root = System.getProperty("user.dir") + "/src/";

    static void showMainMenu() throws IOException, ParserConfigurationException {
        String choice;
        Scanner read = new Scanner(System.in);

        System.out.println("Welcome to the School Library!");
        while (true) {
            System.out.println("Enter 1 if you're a pupil and 2 if you're a librarian.");
            System.out.println("If you want to exit - enter 'quit'.");
            System.out.print("Enter your choice: ");
            choice = read.next();
            switch (choice) {
                case "1":
                    showMenuPupil(read);
                    break;
                case "2":
                    showMenuLibrarian(read);
                    break;
                case "quit":
                    System.out.println("Exit committed.");
                    return;
                default:
                    System.out.println("Error!");
                    break;
            }
        }
    }

    private static void showMenuPupil(Scanner read) throws ParserConfigurationException, IOException {
        Library instance = new Library(root);
        instance.buildPupils(root);
        System.out.print("\nEnter your pupil id (back - return to main menu): ");
        while (true){
            String ID = read.next();
            if (instance.acceptID(ID)){
                showPupilWork(read, instance, ID);
                return;
            } else if (ID.equals("back")) {
                return;
            } else System.out.print("Pupil with such ID is not registrated. Try again: ");
        }
    }

    private static void showPupilWork(Scanner read, Library instance, String ID) throws IOException {
        String choice;
        System.out.println(instance.greeting(ID));
        instance.showAvailable();
        while (true) {
            System.out.print("\tYour choice: ");
            choice = read.next();
            switch (choice){
                case "back":
                    return;
                default:
                    instance.readSmth(ID, choice, root);
                    break;
            }
        }
    }

    private static void showMenuLibrarian(Scanner read) throws IOException, ParserConfigurationException {
        Scanner fileReader = new Scanner(new File(root + "sources/superpass.txt"));
        String superPassword = fileReader.next();

        System.out.print("\nEnter administration password (back - return to main menu): ");
        while (true){
            String password;
            password = read.next();
            if (password.equals(superPassword)) {
                showLibrarianWork(read, root);
                return;
            } else if (password.equals("back")){
                return;
            } else System.out.print("Invalid password. Try again: ");
        }
    }

    private static void showLibrarianWork(Scanner read, String root) throws IOException, ParserConfigurationException {
        String choice;
        Library instance = new Library(root);
        instance.buildPupils(root);
        System.out.println("\nWelcome, librarian. Choose the command: ");
        System.out.println("\t1 - View the list of available for reading books, articles, journal and newspapers;");
        System.out.println("\t2 - View report on the pupils who have read more than 1 book;");
        System.out.println("\t3 - View report on the pupils who have read less than or equal to 2 books;");
        System.out.println("back - return to main menu.");
        while (true) {
            System.out.print("Waiting for input: ");
            choice = read.next();
            switch (choice){
                case "1":
                    instance.showAvailable();
                    break;
                case "2":
                    instance.showMoreThan1Book();
                    break;
                case "3":
                    instance.showLessThan3Book();
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Unknown command. ");
                    break;
            }
        }
    }
}
