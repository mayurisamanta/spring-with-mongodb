package com.spring.mongodb.repository;

import com.spring.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    /*
    * Native query to find student by name and email
    * { $and: [ { 'name': ?0 }, { 'email': ?1 } ] }
     */
    List<Student> findByNameAndEmail(String name, String email);

    /*
    * Native query to find student by name or email
    * { $or: [ { 'name': ?0 }, { 'email': ?1 } ] }
     */
    List<Student> findByNameOrEmail(String name, String email);

    /*
    * Native query to find student by department name
    * { 'department.departmentName': ?0 }
     */
    List<Student> findByDepartmentDepartmentName(String departmentName);

    /*
    * Native query to find student by subject name
    * { 'subjects.subjectName': ?0 }
     */
    List<Student> findBySubjectsSubjectName(String subjectName);

    /*
    * Native query to find student by email Like
    * { 'email': { $regex: ?0 } }
     */
    List<Student> findByEmailIsLike(String email);

    /*
    * Native query to find student by email StartsWith
    * { 'email': { $regex: '^?0' } }
    */
    List<Student> findByEmailStartsWith(String email);

    @Query("{'name': ?0}")
    List<Student> getByName(String name);
}
