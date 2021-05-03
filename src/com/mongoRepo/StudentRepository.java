package com.mongoRepo;


import com.pojo.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    @Query("{'id':?0}")
    Optional<Student> findById(Integer id);
}
