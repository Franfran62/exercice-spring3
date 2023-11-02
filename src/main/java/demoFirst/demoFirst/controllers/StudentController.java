package demoFirst.demoFirst.controllers;


import demoFirst.demoFirst.entities.Student;
import demoFirst.demoFirst.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "/create")
    public String addPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/add-and-edit";
    }

    @PostMapping(value = "/submit")
    public String addStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            this.studentService.createStudent(student);
        } else {
            this.studentService.putStudent(student, student.getId());
        }
        return "redirect:/liste";
    }

    @GetMapping(value = "/liste")
    public String showStudents(Model model) {
        List<Student> students = this.studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/show";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@ModelAttribute("student") Student student, Model model) {
        System.out.println(student);
        Student studentToModify = this.studentService.getStudent(student.getId());
        System.out.println(studentToModify);
        model.addAttribute(studentToModify);
        return "student/add-and-edit";
    }
}

