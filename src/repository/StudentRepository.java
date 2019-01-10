package repository;

import exceptions.GenderException;
import exceptions.IDEmptyOrStudentNotFoundException;
import exceptions.NameFieldEmptyException;
import exceptions.YearOfBirthException;
import model.Student;

import java.time.LocalDate;
import java.util.*;

public class StudentRepository implements IStudentRepository {

    private List<Student> students;

    public StudentRepository(){
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(String lastName, String firstName, String dateOfBirth, String gender, int ID) throws NameFieldEmptyException, GenderException, YearOfBirthException {
        if(lastName == null || lastName.isEmpty() || firstName == null || firstName.isEmpty()){
            throw new NameFieldEmptyException("First Name or Last Name empty");
        }
        if(gender == null || (
                !gender.equals("male") &&
                !gender.equals("female") &&
                !gender.equalsIgnoreCase("M") &&
                !gender.equalsIgnoreCase("F"))
        ){
            throw new GenderException("Gender not valid");
        }
        LocalDate localDate = LocalDate.parse(dateOfBirth);
        if(localDate.getYear() < 1900 || localDate.getYear() > 2018){
            throw new YearOfBirthException("Nu ai cum sa existi fmm");
        }
        Student student = new Student(firstName, lastName, dateOfBirth, gender, ID);
        this.students.add(student);
    }

    @Override
    public void deleteStudent(int ID) throws IDEmptyOrStudentNotFoundException {
        int val = 0;
        if(ID == 0){
            throw new IDEmptyOrStudentNotFoundException("ID can not be 0");
        }
        for(Iterator<Student> iter = students.listIterator(); iter.hasNext();){
            Student a = iter.next();
            if(a.getID() == ID){
                iter.remove();
                val = val +1;
            }
        }
        if(val == 0){
            throw new IDEmptyOrStudentNotFoundException("Student not found");
        }
    }

    @Override
    public List<Student> getStudentsByAge(int age) {
        List<Student> studentsByage = new ArrayList<>();
        for(Student student : this.students){
            LocalDate localDate = LocalDate.parse(student.getDateofBirth());
            if(Calendar.getInstance().get(Calendar.YEAR) - localDate.getYear() == age){
                studentsByage.add(student);
            }
        }
        return studentsByage;
    }

    @Override
    public List<Student> getStudentsSorted(){
        this.students.sort(new NameComparator());
        return this.students;
    }
}
