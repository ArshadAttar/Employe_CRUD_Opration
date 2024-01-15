package HBM_fileProject;
import java.util.Scanner;
public class AllOperationMainApp {
   static Scanner sc1=new Scanner(System.in);
   static AllOperationDAO dao=new AllOperationDAO();

    public static void main(String[] args) {
        boolean status=true;
        while (status){
        System.out.println("1: Add Employee Details");
        System.out.println("2: Delete Employee Details");
        System.out.println("3: Update Employee Details");
        System.out.println("4: Display Details");
        System.out.println("5. Exit");
        System.out.println("Enter the choice");
        int choice= sc1.nextInt();
        switch (choice) {
            case 1:
                addDetails();
                break;
            case 2:
                deleteDetails();
                break;
            case 3:
                updateDetails();
                break;
            case 4:
                displayDetails();
                break;
            case 5:
                System.out.println("Application ended ..");
                status=false;
                break;
            default:
                System.out.println("Enter valid choice..");
            }
        }
    }

    private static void displayDetails() {
        System.out.println("Entre Id To see Yor Details");
        int id= sc1.nextInt();
        dao.displayDetails(id);
    }
    private static void updateDetails() {
        System.out.println("Enter Employee Id");
        int id= sc1.nextInt();
        System.out.println("Enter New Salary");
        double sal= sc1.nextDouble();
        dao.updateDetail(id,sal);
    }
    private static void deleteDetails() {
        System.out.println("Enter Employee Id");
        int id= sc1.nextInt();
        dao.deleteDetail(id);
    }
    private static void addDetails() {
        System.out.println("Enter the id:");
        int id= sc1.nextInt();
        System.out.println("Enter the name:");
        String name= sc1.next();
        System.out.println("Enter the salary:");
        double sal= sc1.nextDouble();
        dao.addDetails(id,name,sal);
    }
}
