package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import controller.TeacherController;
import controller.UserGroupController;
import model.UserGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

public class View {
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();
    private UserGroupController userGroupController = new UserGroupController();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Создать студента");
            System.out.println("2 - Найти студента по id");
            System.out.println("3 - Расспечатать информацию о всех студентах");
            System.out.println("");
            System.out.println("4 - Создать учителя");
            System.out.println("5 - Найти учителя по id");
            System.out.println("6 - Расспечатать информацию о всех учителях");
            System.out.println("");
            System.out.println("7 - Создать учебную группу");
            System.out.println("0 - Закрыть программу");

            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getByIdStudent();
                case 3 -> getAllStudent();
                case 4 -> createTeacher();
                case 5 -> getByIdTeacher();
                case 6 -> getAllTeachers();
                case 7 -> creatUserGroup();
                case 0 -> System.exit(0);
                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

    private Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите номер группы: ");
        int groupId = scanner.nextInt();
        Student student = studentController.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
    }

    // public void removeStudentDB() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Введите id студента для удаления");
    //     int studentId = scanner.nextInt();
    //     studentController.removeStudentDB(studentId);
    // }

    private Student getByIdStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        int id = scanner.nextInt();
        Student student = studentController.getById(id);
        System.out.println(student);
        return student;
    }

    private List<Student> getAllStudent() {
        List<Student> students = studentController.getAllStudent();
        System.out.println(students);
        return students;
    }


    public Teacher createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        Teacher teacher = teacherController.createTeacher(name, lastName);
        System.out.println(teacher);
        return teacher;
    }

    private Teacher getByIdTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id учителя: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getById(id);
        System.out.println(teacher);
        return teacher;
    }

    private List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherController.getAllTeachers();
        System.out.println(teachers);
        return teachers;
    }

    private UserGroup creatUserGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id учителя для группы: ");
        int teacherId = scanner.nextInt();
        Teacher teacher = teacherController.getById(teacherId);

        System.out.println("Введите id студентов через пробел");
        scanner.nextLine();
        String[] studentIds = scanner.nextLine().split("");
        List<Student> students = new ArrayList<>();

        for(String id : studentIds) {
            try {
                Student student = studentController.getById(Integer.parseInt(id));
                if(student != null) {
                    students.add(student);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        UserGroup userGroup = userGroupController.createGroup(teacher, students);
        System.out.println("Создана учебная группа: " + userGroup);
        return userGroup;

    }

    
}
