package model.db;

import java.util.ArrayList;
import java.util.List;

import model.impl.Student;
import model.impl.Teacher;

//симуляция базы данных
public class DataBase {

    public static final List<Student> studentsDB = new ArrayList<>();
    public static final List<Teacher> teachersDB = new ArrayList<>();


    public static void fillDB() {

        Student student1 = new Student(1, "Vasya", "Ivanov", 1);
        Student student2 = new Student(2, "Ivan", "Sidorod", 1);
        studentsDB.add(student1);
        studentsDB.add(student2);

        Teacher teacher1 = new Teacher(1, "Tamara", "Stepanovna");
        //teacher.addGroupId(1);
        teachersDB.add(teacher1);

        
    }

}
