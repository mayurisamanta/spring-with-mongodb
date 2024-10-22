package com.spring.mongodb.controller;

import com.spring.mongodb.entity.Student;
import com.spring.mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/get/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/getByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("getByNameAndEmail")
    public List<Student> getStudentByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentByNameAndEmail(name, email);
    }

    @GetMapping("getByNameOrEmail")
    public List<Student> getStudentByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentByNameOrEmail(name, email);
    }

    @GetMapping("getAllByPagination")
    public List<Student> getAllStudentsByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllStudentsByPagination(pageNo, pageSize);
    }

    @GetMapping("getAllBySorting")
    public List<Student> getAllStudentsBySorting(@RequestParam String sortBy, @RequestParam String sortOrder) {
        return studentService.getAllStudentsBySorting(sortBy, sortOrder);
    }

    @GetMapping("getByDepartmentName")
    public List<Student> getStudentByDepartmentName(@RequestParam String departmentName) {
        return studentService.getStudentByDepartmentName(departmentName);
    }
}
