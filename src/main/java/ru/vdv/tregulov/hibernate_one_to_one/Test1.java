package ru.vdv.tregulov.hibernate_one_to_one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_one_to_one.entity.Employee;
import ru.vdv.tregulov.hibernate_one_to_one.entity.Detail;

public class Test1 {//создание юзера в таблице

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            //Добавление работника со связью One-To-One
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Alexey", "Vedenistov", "IT", 700);
//            Detail detail = new Detail("Moscow", "89265698785", "aoveden1977@mail.ru");
//
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//***********************************************************************
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirniv", "Sales", 300);
//            Detail detail = new Detail("St.Peterburg", "89265893446", "veshiy@mail.ru");
//
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//************************************************************************************
            //Получение работника из таблицы со связью One-to-one
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 10);
//            // System.out.println(employee);
//            System.out.println(employee.getEmpDetail());
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//************************************************************************************
            //Удаление работника из таблицы
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);
            System.out.println(employee.getEmpDetail());
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
