package ru.vdv.tregulov.hibernate_one_to_many_bi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_one_to_many_bi.entity.Department;
import ru.vdv.tregulov.hibernate_one_to_many_bi.entity.Employee;

public class Test1 {//создание юзера в таблице

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            //Добавление 3 работников и 1 департамента в таблицу со связью One-To-Many (Bi-directional)
//            session = factory.getCurrentSession();
//            Department dep = new Department("IT", 20, 1700);
//            Employee emp1 = new Employee("Alexey", "Vedenistov", 777);
//            Employee emp2 = new Employee("Michael", "Jordan", 23);
//            Employee emp3 = new Employee("Larry", "Bird", 34);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//************************************************************************************
            //Получение информации из таблицы Department, а заодно и всех его работников
            // со связью One-To-Many (Bi-directional)
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 7);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);

            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());

            System.out.println("Done!");
//************************************************************************************
            //Получение работника и потом узнать его департамент
//            // со связью One-To-Many (Bi-directional)
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
            // со связью One-To-Many (Bi-directional)
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 3);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
