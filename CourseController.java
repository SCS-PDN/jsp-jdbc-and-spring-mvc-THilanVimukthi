package com.example.controller;

import com.example.dao.CourseDAO;
import com.example.dao.RegistrationDAO;
import com.example.model.Course;
import com.example.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private RegistrationDAO registrationDAO;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        List<Course> courses = courseDAO.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, HttpSession session) {
        Student student = (Student) session.getAttribute("student");

        if (student != null) {
            registrationDAO.registerStudentInCourse(student.getStudentId(), courseId, LocalDate.now());
            return "redirect:/success";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
