package com.vti.program;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

import java.util.List;

public class ExamTest {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		System.out.println("***********GET ALL EXAMS***********");

		List<Exam> Exams = repository.getAllExams();

		for (com.vti.entity.Exam Exam : Exams) {
			System.out.println(Exam);
		}

		System.out.println("\n\n***********CREATE EXAMS***********");

		Exam examCreate = new Exam();
		examCreate.setTitle("Bài thi đầu vào 2");
		examCreate.setDuration((short) 185);

		repository.createExam(examCreate);

	}
}
