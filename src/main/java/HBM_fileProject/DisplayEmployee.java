package HBM_fileProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class DisplayEmployee {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction tax=session.beginTransaction();
        Scanner sc1=new Scanner(System.in);

        System.out.println("Enter ID");
        int id= sc1.nextInt();

        Employee e1=session.load(Employee.class,id);
        System.out.println("Employee Id      : "+e1.getEmpID());
        System.out.println("Employee Name    : "+e1.getEmpName());
        System.out.println("Employee Salary  : "+e1.getEmpSal());

        tax.commit();
        factory.close();
        session.close();
    }
}
