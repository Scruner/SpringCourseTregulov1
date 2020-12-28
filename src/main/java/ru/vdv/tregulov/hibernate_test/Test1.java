package ru.vdv.tregulov.hibernate_test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_test.entity.Employee;

public class Test1 {//создание юзера в таблице
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Freddy", "Mercury", "Queen", 17);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(employee);

        } finally {
            factory.close();
        }
    }
}
