package HBM_fileProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AllOperationDAO {
   static Configuration cfg=new Configuration().configure();
    static SessionFactory factory=cfg.buildSessionFactory();
   static Session session=factory.openSession();
    public void addDetails(int id, String name, double sal) {
        Transaction tax=session.beginTransaction();
            Employee e1=new Employee();
            e1.setEmpID(id);
            e1.setEmpName(name);
            e1.setEmpSal(sal);

            session.save(e1);
            tax.commit();
            session.close();
            System.out.println("=========================================");
            System.out.println("Added Successfully");
            System.out.println("=========================================");
    }

    public void deleteDetail(int id) {
        Transaction tax=session.beginTransaction();
        Employee e1=session.load(Employee.class,id);

        session.delete(e1);
        tax.commit();
        session.close();
        System.out.println("=========================================");
        System.out.println("Data Deleted Successfully");
        System.out.println("=========================================");
    }

    public void updateDetail(int id, double sal) {
        Transaction tax=session.beginTransaction();
        Employee e1=session.load(Employee.class,id);
        e1.setEmpSal(sal);

        session.update(e1);
        tax.commit();
        session.close();
        System.out.println("=========================================");
        System.out.println("Data Update... Successfully");
        System.out.println("=========================================");
    }

    public void displayDetails(int id) {
        Employee e1=session.load(Employee.class,id);

        System.out.println("==========================================");
        System.out.println("Employee Id     : "+e1.getEmpID());
        System.out.println("Employee Name   : "+e1.getEmpName());
        System.out.println("Employee Salary : "+e1.getEmpSal());
        System.out.println("==========================================");
        session.close();
    }
}
