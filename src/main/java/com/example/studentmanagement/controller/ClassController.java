package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.IClassesService;
import com.example.studentmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClassController {
    @Autowired
    private IClassesService classesService;
    @Autowired
    private IStudentService studentService;
    @GetMapping("/classes")
    public ModelAndView listClasses() {
        Iterable<Classes> classes = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }
    @GetMapping("/create-classes")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/classes/create");
        modelAndView.addObject("classes", new Classes());
        return modelAndView;
    }
    @PostMapping("/create-classes")
    public ModelAndView saveClasses(@ModelAttribute("classes") Classes classes) {
        classes.setQuantity(0);
        classesService.save(classes);
        ModelAndView modelAndView = new ModelAndView("/classes/create");
        modelAndView.addObject("classes", new Classes());
        modelAndView.addObject("message", "New classes created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-classes/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Classes> classes = classesService.findById(id);
        if (classes.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/classes/edit");
            modelAndView.addObject("classes", classes.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/classes/error.404");
            return modelAndView;
        }
    }

        @PostMapping("/edit-classes")
    public ModelAndView updateClasses(@ModelAttribute("classes") Classes classes, @PathVariable Integer quantity) {
        classes.setQuantity(quantity);
        classesService.save(classes);
        ModelAndView modelAndView = new ModelAndView("/classes/edit");
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("message", "Classes updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-classes/{id}")
    public String deleteClasses(@PathVariable Long id) {
        classesService.remove(id);
        return "redirect:/classes";
    }
    @GetMapping("/view-classes/{id}")
    public ModelAndView viewClasses(@PathVariable("id") Long id){
        Optional<Classes> classesOptional = classesService.findById(id);
        if(!classesOptional.isPresent()){
            return new ModelAndView("/student/error.404");
        }

        Iterable<Student> students = studentService.viewStudent(classesOptional.get());

        ModelAndView modelAndView = new ModelAndView("/classes/views");
        modelAndView.addObject("classes", classesOptional.get());
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/sort_asc")
    public ModelAndView listClassesByQuantityAsc() {
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", classesService.sortByQuantityAsc());
        return modelAndView;
    }

    @GetMapping("/sort_desc")
    public ModelAndView listClassesByQuantityDesc() {
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", classesService.sortByQuantityDesc());
        return modelAndView;
    }


}
