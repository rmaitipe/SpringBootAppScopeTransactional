package com.mongoRepo;


import com.pojo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,String> {

    @Query(value ="select * from Student s where s.id= :studentId", nativeQuery = true)
    Optional<Student> findById(int studentId);

}
