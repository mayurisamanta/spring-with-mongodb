package com.spring.mongodb.service;

import com.spring.mongodb.entity.Student;
import com.spring.mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).orElse(null);
        /*
        Native query to find student by id
        { '_id': ?0 }
         */
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
        /*
        Native query to find all students
        { }
         */
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> getStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getStudentByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllStudentsByPagination(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentsBySorting(String sortBy, String sortOrder) {

        Sort sort = Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return studentRepository.findAll(sort);
    }

    public List<Student> getStudentByDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    public List<Student> getStudentBySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> getStudentByEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> getStudentByEmailStartsWith(String email) {
        return studentRepository.findByEmailStartsWith(email);
    }


}
