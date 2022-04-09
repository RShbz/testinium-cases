package com.testinium.service.business;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.testinium.entity.Student;
import com.testinium.repository.StudentRepository;
import com.testinium.service.StudentsService;

/**
 * 
 * @author Remzi ŞAHBAZ
 *
 */
@Service
public class BusinessStudentService implements StudentsService {

	private StudentRepository studentRepository;

	/**
	 * @param studentRepository
	 */
	public BusinessStudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

//	@Override
//	public AddStudentResponse createStudent(AddStudentRequest request) {
////		var existStudent = studentRepository.existsById(request.getIdentity());
//		if (existStudent) {
//		} else {
//				
//			var newStudent= studentRepository.save(modelMapper.map(request,Student.class));
//			return modelMapper.map(newStudent,AddStudentResponse.class);
//		}
//		return null;
//	}

//	@Override
//	public String createStudent2(AddStudentRequest request) {
//		
//	var newStudent= studentRepository.save(modelMapper.map(request,Student.class));
//		return "ok";
//	}

//	@Override
//	public ExamGradeAndAvarageAllStudentsResponse getAllStudentsByYearAndLessonCode(String year, String lessonCode) {
//		var existEducationYear= educationYearRepository.findByEducationYear(year);
//
//		if(existEducationYear!=null) {
//			
//			var getInformationSudent= studentRepository.findByYear(year);
//				getInformationSudent.getEducationYear()
//									.stream()
//									.map(edu->{
//										
//										var getStudent= ExamGradeAndAvarageAllStudentsResponse.class;
//										
//										return null;
//										
//										
//									})
//									.toList();
//		}
//		else {
//			
//		}

//	return null;
//}

	@Override
	public ResponseEntity<Student> createStudent3(Student request) {
		studentRepository.save(request);

		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@Override
	public Optional<Student> getOneStudent(String identity) {
		
		return studentRepository.findById(identity);
	}

}
