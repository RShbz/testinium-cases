/**
 * 
 */
package com.testinium.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.testinium.dto.request.CourseRegistrationRequest;
import com.testinium.entity.Course;
import com.testinium.entity.CourseRegistration;
import com.testinium.entity.ResultsOfExam;
import com.testinium.entity.Student;
import com.testinium.service.business.StandartServiceBusiness;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@RestController
@RequestScope
@RequestMapping("/")
@CrossOrigin
@Api(value = "Student-Course Api documentation")
public class RestFulController {

	@Autowired
	private StandartServiceBusiness standartServiceBusiness;

	/**
	 * @param standartServiceBusiness
	 */
	public RestFulController(StandartServiceBusiness standartServiceBusiness) {
		this.standartServiceBusiness = standartServiceBusiness;
	}

	@ApiOperation(value = "New Student adding method")
	@PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Student> createStudent(@RequestBody Student student) throws Exception {
		System.out.println(student);
		// Objects.nonNull(student);
		return standartServiceBusiness.createStudent(student);
	}

	@ApiOperation(value = "New Course adding method")
	@PostMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Course> createCourse(@RequestBody Course course) throws Exception {
		System.out.println(course);
		// Objects.nonNull(student);
		return standartServiceBusiness.createCourse(course);
	}

	@ApiOperation(value = "New Course Registration adding method")
	@PostMapping(value = "courseregistration", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<CourseRegistration> createCourseRegistration(
			@RequestBody CourseRegistrationRequest courseRegistration) throws Exception {
		System.out.println(courseRegistration);
		// Objects.nonNull(student);
		return standartServiceBusiness.createCourseRegistration(courseRegistration);
	}

	@ApiOperation(value = "New Results Of Exam adding method")
	@PostMapping(value = "resultsofexam", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<ResultsOfExam> createResultsOfExam(@RequestBody ResultsOfExam resultsOfExam) throws Exception {
		System.out.println(resultsOfExam);
		// Objects.nonNull(student);
		return standartServiceBusiness.createResultsOfExam(resultsOfExam);
	}

	@ApiOperation(value = "all the grades and avarage grade of a student according to the \r\n"
			+ "school year code, \r\n" + "course code and \r\n" + "student id \r\n" + "that will be given.")
	
	// localhost:1071/school/api/v1/courseregistration?year={year}&courseCode={courseCode}&schoolNo={schoolNo}
	@GetMapping(value = "courseregistration")
	public Optional<String> getStudentAvarageAndResultsOfExam(@RequestParam String schoolNo,
			@RequestParam String courseCode, @RequestParam String year) throws Exception {
		System.out.println("");
		Objects.nonNull(schoolNo);
		Objects.nonNull(courseCode);
		Objects.nonNull(year);

		return standartServiceBusiness.getStudentBySchoolYearAndCourseCodeAndSchoolNo(schoolNo, courseCode, year);
	}
	@ApiOperation(value = "all the grades and avarage grade of all students according to \r\n"
			+ "the school year code and \r\n"
			+ "course code \r\n"
			+ "that will be given")
	// localhost:1071/school/api/v1/courseRegistration?year={year}&courseCode={courseCode}
	@GetMapping(value = "courseregistration")
	public Optional<String> getAllStudentAvarageAndResultsOfExam(
			@RequestParam String courseCode, @RequestParam String year) throws Exception {
		System.out.println("");
		Objects.nonNull(courseCode);
		Objects.nonNull(year);
		
		return standartServiceBusiness.getAllStudentAvarageAndResultsOfExam(courseCode, year);
	}
	@ApiOperation(value = "assing any course to any student")
	// localhost:1071/school/api/v1/courseRegistration?schoolNo={schoolNo}&courseCode={courseCode}
	@GetMapping(value = "courseregistration")
	public Optional<String> createAnyCourseAnyStudent(
			@RequestParam String courseCode, @RequestParam String schoolNo) throws Exception {
		System.out.println("");
		Objects.nonNull(courseCode);
		Objects.nonNull(schoolNo);
		
		return standartServiceBusiness.createAnyCourseAnyStudent(courseCode, schoolNo);
	}
}
