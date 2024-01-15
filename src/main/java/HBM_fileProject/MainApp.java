package HBM_fileProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();

        System.out.println("Enter Number How Many Records You Want to Add");
        int num= sc1.nextInt();
        int [] arr=new int[num];

        for (int i=1; i<=arr.length; i++){
            Transaction tax=session.beginTransaction();
            System.out.println("Enter "+ i +" emp Id");
            int empId= sc1.nextInt();
            System.out.println("Enter Emp Name");
            String name= sc1.next();
            System.out.println("Enter Salary");
            double sal= sc1.nextDouble();

            Employee e1=new Employee();
            e1.setEmpID(empId);
            e1.setEmpName(name);
            e1.setEmpSal(sal);

            session.save(e1);
            tax.commit();
        }
        factory.close();
        session.close();
        System.out.println("Mission Successful");
    }
}
