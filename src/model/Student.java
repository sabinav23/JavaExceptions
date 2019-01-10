package model;

public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private int ID;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, int ID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public String getDateofBirth(){
        return this.dateOfBirth;
    }

    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "firstName='" + firstName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
