package service;

import java.util.List;


import model.db.DataBase;
import model.impl.Student;

public class StudentService {
    
    public Student createStudent(String name, String lastName, int groupId) {

        int id;

        int size = DataBase.studentsDB.size();

        if(size == 0) {
            id = 1;
        } else {
            id = size + 1;
        }

        Student student = new Student(id, name, lastName, groupId);
        DataBase.studentsDB.add(student);
        return student;
    }


    public Student getById(int id) throws Exception {

        // Student student = DataBase.studentsDB.get(id);

        // return student;
        
        Student student = DataBase.studentsDB//список студентов
                                .stream()//запускаем поток для вычислений
                                    .filter(s -> s.getId() == id) //фильтруем по условию s.id = student.id 
                                        .findFirst()//возвращает первое найденное значение (студента)
                                            .orElse(null);// иначе, верни null

        if (student == null) {
            throw new Exception("Student not found");
        } else {
            return student;
        }

    }


    public List<Student> getAllStudent() {
        return DataBase.studentsDB;
    }

}
