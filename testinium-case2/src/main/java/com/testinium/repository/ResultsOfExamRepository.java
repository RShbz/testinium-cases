/**
 * 
 */
package com.testinium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testinium.entity.CourseRegistration;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Repository
public interface ResultsOfExamRepository extends JpaRepository<CourseRegistration, Long> {

}
