package controller;

import java.util.List;

import model.impl.Teacher;
import service.TeacherService;

public class TeacherController {
    
    private TeacherService teacherService = new TeacherService();

    public Teacher createTeacher(String name, String lastName){
        return teacherService.createTeacher(name, lastName);
    }


    public Teacher getById(int id) {

        Teacher teacher = null;

        try {
            teacher = teacherService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }



}
