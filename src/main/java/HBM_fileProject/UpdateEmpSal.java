package HBM_fileProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateEmpSal {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);

        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction tax=session.beginTransaction();

        System.out.println("Enter Emp ID");
        int id= sc1.nextInt();
        System.out.println("Enter New Salary");
        double sal= sc1.nextDouble();

        Employee e1=session.load(Employee.class,id);
        e1.setEmpSal(sal);

        session.update(e1);
        tax.commit();
        factory.close();
        session.close();
        System.out.println("Data Updated Successfully....");


    }
}
