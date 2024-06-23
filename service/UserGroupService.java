package service;

import java.util.List;

import model.UserGroup;
import model.impl.Student;
import model.impl.Teacher;

public class UserGroupService {

    public UserGroup createGroup(Teacher teacher, List<Student> students) {
        UserGroup userGroup = new UserGroup(teacher, students);
        return userGroup;
    }
}
