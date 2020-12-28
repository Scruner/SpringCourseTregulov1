package ru.vdv.tregulov.hibernate_one_to_one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_one_to_one.entity.Detail;
import ru.vdv.tregulov.hibernate_one_to_one.entity.Employee;

public class Test2 {//создание юзера в таблице

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            //Добавление работника со связью One-To-One (Bi-direction)
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Nick", "Kayv", "IT", 87);
//            Detail detail = new Detail("New-York", "94532344561", "nick@mail.ru");
//
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//
//            session.save(detail);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//************************************************************************************
//            //Получение работника со связью One-To-One (Bi-direction)
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 3);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//************************************************************************************
            //Удаление детали со связью One-To-One (Bi-direction)
            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);//разрушаем связь между строками таблиц
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
