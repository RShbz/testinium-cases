/**
 * 
 */
package com.testinium.service;

import java.util.Optional;

import com.testinium.entity.ResultsOfExam;

/**
 * @author Remzi ŞAHBAZ
 *
 */
public interface ResultsOfExamService {

	Optional<ResultsOfExam> createResultsOfExam(ResultsOfExam courseRegistration);

}
