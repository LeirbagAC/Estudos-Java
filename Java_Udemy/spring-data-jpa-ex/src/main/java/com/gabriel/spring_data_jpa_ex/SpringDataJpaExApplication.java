package com.gabriel.spring_data_jpa_ex;

import com.gabriel.spring_data_jpa_ex.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		Student s4 = context.getBean(Student.class);
		Student s5 = context.getBean(Student.class);
		Student s6 = context.getBean(Student.class);
		Student s7 = context.getBean(Student.class);
		Student s8 = context.getBean(Student.class);

		StudentRepo repo = context.getBean(StudentRepo.class);

		s1.setRollNo(101);
		s1.setName("Gabriel");
		s1.setMarks(75);

		s2.setRollNo(102);
		s2.setName("Ricardo");
		s2.setMarks(80);

		s3.setRollNo(103);
		s3.setName("João");
		s3.setMarks(70);

		// Aluno 4
		s4.setRollNo(104);
		s4.setName("Maria");
		s4.setMarks(85);

		s5.setRollNo(105);
		s5.setName("Pedro");
		s5.setMarks(92);

		s6.setRollNo(106);
		s6.setName("Ana Teste Update");
		s6.setMarks(98);

		s7.setRollNo(107);
		s7.setName("Carlos");
		s7.setMarks(88);

		s8.setRollNo(108);
		s8.setName("Beatriz");
		s8.setMarks(95);

		repo.save(s1);
		repo.save(s2);
		repo.save(s3);
		repo.save(s4);
		repo.save(s5);
		repo.save(s6);
		repo.save(s7);
		repo.save(s8);

//		Optional<Stu?dent> s = repo.findById(104);
//		System.out.println(s.orElse(new Student()));

//		System.out.println(repo.findByName("Gabriel"));

//		System.out.println(repo.findById(102));
//		System.out.println(repo.findAll());

//		List<Student> markGreaterThan = repo.findByMarksGreaterThanEqual(80);
//		System.out.println(markGreaterThan);

//		repo.delete(s5);


	}

}
