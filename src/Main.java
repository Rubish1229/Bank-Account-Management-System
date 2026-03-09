import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int choice;
        int accNumber;
        double amt;
        Bank bank=new Bank();
        Scanner sc=new Scanner(System.in);

        do {
            System.out.println("---------MENU----------");
            System.out.println("Select option\n 1) CREATE ACCOUNT\n 2) DEPOSIT\n 3) WITHDRAW\n 4) CHECK BALANCE\n 5) DISPLAY DETAILS\n 6) EXIT  ");

            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter account holder name : ");
                    String name = sc.nextLine();

                    System.out.println("Enter account number : ");
                    accNumber = sc.nextInt();

                    System.out.println("Enter initial amount : ");
                    amt = sc.nextDouble();
                    sc.nextLine();


                    System.out.println("Enter account type : (Saving, Fixed)");
                    String accType = sc.nextLine();

                    Account account = new Account(name, accNumber, amt, accType);
                    bank.createAccount(account);
                    break;

                case 2:
                    System.out.println("Enter account number : ");
                     accNumber=sc.nextInt();
                    System.out.println("Enter amount to deposit : ");
                     amt=sc.nextDouble();
                     bank.deposit(accNumber,amt);
                    break;

                case 3:
                    System.out.println("Enter account number : ");
                    accNumber=sc.nextInt();
                    System.out.println("Enter amount to withdraw : ");
                    amt=sc.nextDouble();
                    bank.withdraw(accNumber,amt);
                    break;



                case 4:
                    System.out.println("Enter account number : ");
                    accNumber= sc.nextInt();
                    bank.displayDetails(accNumber);
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid input!");
            }
        }while(choice!=6);

    }
}