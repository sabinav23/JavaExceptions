package repository;

import exceptions.GenderException;
import exceptions.IDEmptyOrStudentNotFoundException;
import exceptions.NameFieldEmptyException;
import exceptions.YearOfBirthException;
import model.Student;

import java.util.List;

public interface IStudentRepository {

    void addStudent(String lastName, String fistName, String dateOfBirth, String gender, int ID) throws NameFieldEmptyException, GenderException, YearOfBirthException;
    void deleteStudent(int ID) throws IDEmptyOrStudentNotFoundException;
    List<Student> getStudentsByAge(int age);
    List<Student> getStudentsSorted();
}

