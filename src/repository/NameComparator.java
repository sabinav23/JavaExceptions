package repository;

import model.Student;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o, Student t1) {
        return o.getFirstName().compareTo(t1.getFirstName());
    }
}
