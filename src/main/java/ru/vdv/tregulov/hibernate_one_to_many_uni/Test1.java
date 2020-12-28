package ru.vdv.tregulov.hibernate_one_to_many_uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_one_to_many_uni.entity.Department;
import ru.vdv.tregulov.hibernate_one_to_many_uni.entity.Employee;


public class Test1 {//создание юзера в таблице

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            //Добавление 1 работника и 2 департаментов в таблицу со связью One-To-Many (Uni-directional)
//            session = factory.getCurrentSession();
//            Department dep = new Department("NBA", 500, 3700);
//            Employee emp1 = new Employee("Larry", "Bird", 34);
//            Employee emp2 = new Employee("Scotty", "Pippen", 33);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//************************************************************************************
            //Получение информации из таблицы Department, а заодно и всех его работников
            // со связью One-To-Many (Uni-directional)
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Department department = session.get(Department.class, 2);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//************************************************************************************
            //Получение работника и потом узнать его департамент
//            // со связью One-To-Many (Uni-directional)
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//************************************************************************************
            //Удаление работника из таблицы
            // со связью One-To-Many (Uni-directional)
            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department = session.get(Department.class, 2);

            session.delete(department);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
