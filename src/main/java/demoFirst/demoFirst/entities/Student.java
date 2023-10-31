package demoFirst.demoFirst.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class Student {

    private static int count;

    private final int id;
    @Setter private String firstname;
    @Setter private String lastname;
    @Setter private int age;

    {
        ++count;
    }
    public Student(String firstname, String lastname, int age)
    {
        this.id = count;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
}
