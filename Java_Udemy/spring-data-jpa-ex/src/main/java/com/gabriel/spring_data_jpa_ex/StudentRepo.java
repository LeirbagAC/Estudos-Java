package com.gabriel.spring_data_jpa_ex;

import com.gabriel.spring_data_jpa_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByMarksGreaterThanEqual(int mark);

}
