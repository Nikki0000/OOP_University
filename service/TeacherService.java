package service;

import java.util.List;

import model.db.DataBase;
import model.impl.Teacher;

public class TeacherService {
    
    public Teacher createTeacher(String name, String lastName) {
        int id;

        int size = DataBase.teachersDB.size();

        if(size == 0) {
            id = 1;
        } else {
            id = size + 1;
        }

        Teacher teacher = new Teacher(id, name, lastName);
        DataBase.teachersDB.add(teacher);
        return teacher;
    }


    public Teacher getById(int id) throws Exception {
        
        Teacher teacher = DataBase.teachersDB//список студентов
                                .stream()//запускаем поток для вычислений
                                    .filter(s -> s.getId() == id) //фильтруем по условию s.id = student.id 
                                        .findFirst()//возвращает первое найденное значение (студента)
                                            .orElse(null);// иначе, верни null

        if (teacher == null) {
            throw new Exception("Teacher not found");
        } else {
            return teacher;
        }

    }


    public List<Teacher> getAllTeachers() {
        return DataBase.teachersDB;
    }

}
