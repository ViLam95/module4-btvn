package com.example.studentmanagement.formatter;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClassesFormatter implements Formatter<Classes> {
    private IClassesService classesService;
    @Autowired
    public ClassesFormatter(IClassesService classesService) {
        this.classesService = classesService;
    }
    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        Optional<Classes> classesOptional = classesService.findById(Long.parseLong(text));
        return classesOptional.orElse(null);
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
