import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the shop!");

        System.out.println("Let's add some items!");

        String command = scanner.nextLine();

        while (!command.equals("Cash Out")) {

            String[] commandArr = command.split("-");
            String commandType = commandArr[0];
            switch (commandType) {
                case "add":
                    String productName = commandArr[1];
                    String quantity = commandArr[2];
                    String price = commandArr[3];

            }
        }

    }

}