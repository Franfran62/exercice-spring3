package demoFirst.demoFirst.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private int id;
    private String firstname;
    private String lastname;
    private int age;


    public Student(String firstname, String lastname, int age) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
