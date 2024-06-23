package controller;

import java.util.List;

import model.UserGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.UserGroupService;

public class UserGroupController {
    private UserGroupService userGroupService = new UserGroupService();

    public UserGroup createGroup(Teacher teacher, List<Student> students) {
        return userGroupService.createGroup(teacher, students);
    }

}
