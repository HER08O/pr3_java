package com.example.pr3_java.controller;

import com.example.pr3_java.model.Student;
import com.example.pr3_java.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("students", studentService.getAllStudents());
        return "students-list";
    }

    @GetMapping("/students/add")
    public String addStudentForm(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("student", new Student());
        return "students-form";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
