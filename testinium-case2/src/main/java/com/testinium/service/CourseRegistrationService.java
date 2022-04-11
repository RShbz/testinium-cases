/**
 * 
 */
package com.testinium.service;

import java.util.List;
import java.util.Optional;

import com.testinium.dto.request.CourseRegistrationRequest;
import com.testinium.entity.CourseRegistration;
import com.testinium.response.getInformantionAllStudentResponse;

/**
 * @author Remzi ŞAHBAZ
 *
 */
public interface CourseRegistrationService {

	Optional<CourseRegistration> createCourseRegistration(CourseRegistrationRequest courseRegistration);

	Optional<String> getStudentBySchoolYearAndCourseCodeAndSchoolNo(String schoolNo, String courseCode, String year);

	Optional<List<getInformantionAllStudentResponse>> getAllStudentAvarageAndResultsOfExam(String courseCode, String year);

	Optional<String> createAnyCourseAnyStudent(String courseCode, String schoolNo);

}
