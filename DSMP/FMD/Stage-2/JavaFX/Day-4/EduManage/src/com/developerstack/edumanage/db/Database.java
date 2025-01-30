package com.developerstack.edumanage.db;

import com.developerstack.edumanage.model.Student;
import com.developerstack.edumanage.model.User;
import com.developerstack.edumanage.util.security.PasswordManager;

import java.util.ArrayList;

public class Database {
    public static ArrayList<User> userTable = new ArrayList();
    public static ArrayList<Student> studentTable = new ArrayList();
    static {
        userTable.add(
                new User("pavithri","Apeksha","p@gmail.com",new PasswordManager().encrypt("1234"))
        );
    }
}
