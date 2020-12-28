package ru.vdv.tregulov.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vdv.tregulov.hibernate_many_to_many.entity.Child;
import ru.vdv.tregulov.hibernate_many_to_many.entity.Section;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //Добавление трёх детей в одну секцию
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Judo");
//            Child child1 = new Child("Oleg", 9);
//            Child child2 = new Child("Tanya", 8);
//            Child child3 = new Child("Roma", 5);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);//логика сохранения секции и детей
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
////*********************************************************************
//         //Добавление трёх детей в одну секцию с помощью persist (из-зи CascadeType.PERSIST)
////            session = factory.getCurrentSession();
////
////            Section section1 = new Section("Judo");
////            Child child1 = new Child("Oleg", 9);
////            Child child2 = new Child("Tanya", 8);
////            Child child3 = new Child("Roma", 5);
////
////            section1.addChildToSection(child1);
////            section1.addChildToSection(child2);
////            section1.addChildToSection(child3);
////
////            session.beginTransaction();
////
////            session.persist(section1);//логика сохранения секции и детей
////
////
////            session.getTransaction().commit();
////            System.out.println("Done!!!");
////*********************************************************************
            // Создадим одного ребёнка в три секции
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Section section2 = new Section("Basketball");
//            Section section3 = new Section("Karate");
//
//            Child child1 = new Child("Kolya", 8);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);//логика сохранения ребёнка и секций
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
////*********************************************************************
//            //Получим первую секцию и информацию о детях, которые в ней занимаются
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();//открытие транзакции
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();//закрытие транзакции
//            System.out.println("Done!!!");
////*********************************************************************
//            //Получим информацию по ребёнку
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();//открытие транзакции
//
//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();//закрытие транзакции
//            System.out.println("Done!!!");
//*********************************************************************
//            //Удалим секцию
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();//открытие транзакции
//
//            Section section = session.get(Section.class, 3);
//            session.delete(section);
//
//            session.getTransaction().commit();//закрытие транзакции
//            System.out.println("Done!!!");
            //*********************************************************************
//            //Удалим ребёнка
            session = factory.getCurrentSession();

            session.beginTransaction();//открытие транзакции

            Child child = session.get(Child.class, 4);
            session.delete(child);

            session.getTransaction().commit();//закрытие транзакции
            System.out.println("Done!!!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
