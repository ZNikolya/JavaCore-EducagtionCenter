package exampleEducationCenter.model;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String ID;
    private Lesson[] lessons;

    public Student(String name, String surname, String phone, String email, String ID, Lesson[] lessons) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.ID = ID;
        this.lessons = lessons;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setID(String ID){
        this.ID=ID;
    }
    public String getID(){
        return ID;
    }

    public void setLessons(Lesson [] lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(email, student.email) &&
                Objects.equals(ID, student.ID) &&
                Arrays.equals(lessons, student.lessons);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, phone, email,ID);
        result = 31 * result + Arrays.hashCode(lessons);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ID='" + ID + '\'' +
                ", lessons=" + Arrays.toString(lessons) +
                '}';
    }
}
