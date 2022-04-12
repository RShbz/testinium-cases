/**
 * 
 */
package com.testinium.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.testinium.dto.request.ResultsOfExamRequest;
import com.testinium.dto.response.InformationStudentResponse;
import com.testinium.dto.response.ResultsOfExamResponse;
import com.testinium.entity.CourseRegistration;
import com.testinium.entity.ResultsOfExam;

/**
 * @author sahabt
 *
 */
@Configuration
public class ModelMaperConfig {



	public static final Converter<ResultsOfExamRequest, ResultsOfExam> ResultOfExamRequest_To_ResultOfExam_Converted = (
			context) -> {
		var request = context.getSource();

		var result = new ResultsOfExam();

		System.out.println("result.getResultexam_id-> "+result.getId());
		
		result.setSecondExamResult(request.getSecondExamResult());
		result.setFirstExamResult(request.getFirstExamResult());

		
		result.setAvarage(

				(request.getFirstExamResult() + request.getSecondExamResult()) / 2

		);
		if (result.getAvarage() >= 50) {

			// passed the lesson of school
			result.setStateOfResult(true);
		} else {
			// not passed the lesson of school
			result.setStateOfResult(false);

		}

		return result;
	};

	public static final Converter<ResultsOfExam, ResultsOfExamResponse> ResultOfExam_To_ResultOfExamResponse_Converted = (
			context) -> {
		var result = context.getSource();
		var response = new ResultsOfExamResponse();

		response.setAvarage(result.getAvarage());
		response.setFirstExamResult(result.getFirstExamResult());
		response.setSecondExamResult(result.getSecondExamResult());
		response.setStateOfResult(result.isStateOfResult());
		response.setCourse(result.getCourse());

		return response;
	};
	public static final Converter<CourseRegistration, InformationStudentResponse> CourseRegistration_To_AllStudentResponse_Converted = (
			context) -> {
				var course = context.getSource();
				var response= new InformationStudentResponse();
				
				response.setStudent(course.getStudent());
				
				System.out.println("-->avarage-----"+course.getResultsOfExam());	
				
//				course.getResultsOfExam().stream()
//										.map(
//											result->{
//												
//												var resultof= new ResultsOfExam();
//													
//												response.setGradeName(result.getCourse().getCourseName());
//												response.setGradAvarage(result.getAvarage());
//												
//												return null;
//											}				);
//				
				return response;
			};

	@Bean
	public ModelMapper mapper() {

		var modelm = new ModelMapper();
		// modelm.addConverter(CourseRegistrationRequest_To_Convert_CourseRegistration,CourseRegistrationRequest.class,
		// CourseRegistration.class);
		modelm.addConverter(ResultOfExamRequest_To_ResultOfExam_Converted, ResultsOfExamRequest.class,
				ResultsOfExam.class);
		modelm.addConverter(ResultOfExam_To_ResultOfExamResponse_Converted, ResultsOfExam.class,
				ResultsOfExamResponse.class);
		modelm.addConverter(CourseRegistration_To_AllStudentResponse_Converted, CourseRegistration.class,
				InformationStudentResponse.class);

		return modelm;
	}
}
