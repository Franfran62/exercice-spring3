package demoFirst.demoFirst.controllers;

import demoFirst.demoFirst.entities.Student;
import demoFirst.demoFirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {

        this.studentService = studentService;

    }
    @GetMapping()
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }
    @GetMapping(value = "/{id}")
    public Student getOneStudent(@PathVariable int id)
    {
        return this.studentService.getStudent(id);
    }

    @PutMapping(value = "/{id}")
    public Student putStudent(@RequestBody Student student, @PathVariable int id) { return this.studentService.putStudent(student, id); }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable int id) { this.studentService.deleteStudent(id);}
}
