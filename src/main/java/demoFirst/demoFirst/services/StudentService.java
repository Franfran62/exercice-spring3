package demoFirst.demoFirst.services;

import demoFirst.demoFirst.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("student")
public class StudentService {

    private Student student;
    private final ArrayList<Student> database = new ArrayList<>();

    public Student createStudent(Student student){
        if (student == null) {
            return null;
        }
        this.student = student;
        database.add(student);

        return this.student;
    }

    public List<Student> getAllStudents() {
        return database;
    }

    public Student getStudent(int id) {
        return this.database.get(id);
    }

    public Student putStudent(Student student, int id) {

        if (student == null) { return null; }

        this.student = this.getStudent(id);
        this.deleteStudent(id);

        if (student.getFirstname() != null)
        {
            this.student.setFirstname(student.getFirstname());
        }
        if (student.getLastname() != null)
        {
            this.student.setLastname(student.getLastname());
        }
        if (this.student.getAge() != 0)
        {
            this.student.setAge(student.getAge());
        }
        this.database.add(this.student);

        return this.student;
    }

    public void deleteStudent(int id) {
        this.database.remove(this.getStudent(id));
    }
}

