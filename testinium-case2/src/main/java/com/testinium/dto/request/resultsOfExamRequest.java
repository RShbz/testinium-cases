/**
 * 
 */
package com.testinium.dto.request;

import com.testinium.entity.Course;

import lombok.Builder;
import lombok.Data;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Data
@Builder
public class resultsOfExamRequest {
	
	private Course course;
	private String firstExamResult;
	private String secondExamResult;
	private double avarage;
	private boolean stateOfResult;
}
