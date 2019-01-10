import exceptions.GenderException;
import exceptions.IDEmptyOrStudentNotFoundException;
import exceptions.NameFieldEmptyException;
import exceptions.YearOfBirthException;
import repository.StudentRepository;

public class Main {

    public static void main(String[] args) throws NameFieldEmptyException, GenderException, YearOfBirthException, IDEmptyOrStudentNotFoundException {

        StudentRepository repository = new StudentRepository();
        repository.addStudent("John", "Doe", "1999-01-01", "m", 56135445);
        repository.addStudent("Student", "One", "1999-01-02", "f", 51256);

        System.out.println(repository.getStudentsByAge(20));
        System.out.println(repository.getStudentsSorted());
    }
}
