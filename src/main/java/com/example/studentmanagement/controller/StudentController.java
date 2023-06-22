package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.IClassesService;
import com.example.studentmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassesService classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes() {
        return classesService.findAll();
    }

    @GetMapping("/create-student")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }
    @PostMapping("/create-student")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/student/create");
        } else {
            Classes classes = student.getClasses();
            classes.setQuantity(classes.getQuantity() + 1);
            classesService.save(classes);
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("/student/create");
            modelAndView.addObject("student", new Student());
            modelAndView.addObject("message", "New student created successfully");
            return modelAndView;
        }
    }
    @GetMapping("/students")
    public ModelAndView listStudent() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/edit-student/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/student/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if(studentOptional.isPresent()) {
            studentService.remove(id);
            Classes classes = studentOptional.get().getClasses();
            classes.setQuantity(classes.getQuantity() - 1);
            classesService.save(classes);
        }
        return "redirect:/students";
    }
    @PostMapping("/students/search")
    public ModelAndView searchStudents(@RequestParam("name") String name) {
        List<Student> students = studentService.searchByName(name);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students",students);
        return modelAndView;
    }

    @GetMapping("/sort-point")
    public ModelAndView sortByPoint() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students = studentService.findAllByOrderByPointAsc();
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sortDes-point")
    public ModelAndView sortByPointDes() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students = studentService.findAllByOrderByPointDesc();
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sort-age")
    public ModelAndView sortByAge() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students = studentService.findAllByOrderByAgeAsc();
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sortDes-age")
    public ModelAndView sortByAgeDesc() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students = studentService.findAllByOrderByAgeDesc();
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
