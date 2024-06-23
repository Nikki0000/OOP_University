package model;


import java.util.List;

import model.impl.Student;
import model.impl.Teacher;

public class UserGroup {

    protected Teacher teacher;

    protected List<Student> students;

    public UserGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    @Override
    public String toString() {
        
        StringBuilder studentsName = new StringBuilder();
        for (Student student : students) {
            if (studentsName.length() > 0) {
                studentsName.append(", ");
            }
            studentsName.append(String.format("%s %s (id: %s)", student.getName(), student.getLastName(), student.getId()));
        }

        return String.format("\nПреподаватель: %s %s (Id: %d)\nСтуденты: %s", 
                             teacher.getName(), teacher.getLastName(), teacher.getId(), studentsName);

    }

    
}
