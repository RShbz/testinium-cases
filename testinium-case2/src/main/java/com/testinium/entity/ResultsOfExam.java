/**
 * 
 */
package com.testinium.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Entity
@Table(name = "resultsofexam")
 
public class ResultsOfExam  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@ManyToMany(mappedBy="resultsOfExam")
	@ManyToMany(mappedBy = "resultsOfExam")
	@JsonIgnore
	private Set<CourseRegistration> courseRegistration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	private Double firstExamResult;
	private Double secondExamResult;
	private Double avarage;
	private boolean stateOfResult;


	/**
	 * 
	 */
	public ResultsOfExam() {
	}
	
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}




	/**
	 * @return the courseRegistration
	 */
	public Set<CourseRegistration> getCourseRegistration() {
		return courseRegistration;
	}




	/**
	 * @param courseRegistration the courseRegistration to set
	 */
	public void setCourseRegistration(Set<CourseRegistration> courseRegistration) {
		this.courseRegistration = courseRegistration;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}




	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}




	/**
	 * @return the firstExamResult
	 */
	public Double getFirstExamResult() {
		return firstExamResult;
	}




	/**
	 * @param firstExamResult the firstExamResult to set
	 */
	public void setFirstExamResult(Double firstExamResult) {
		this.firstExamResult = firstExamResult;
	}




	/**
	 * @return the secondExamResult
	 */
	public Double getSecondExamResult() {
		return secondExamResult;
	}




	/**
	 * @param secondExamResult the secondExamResult to set
	 */
	public void setSecondExamResult(Double secondExamResult) {
		this.secondExamResult = secondExamResult;
	}




	/**
	 * @return the avarage
	 */
	public Double getAvarage() {
		return avarage;
	}




	/**
	 * @param avarage the avarage to set
	 */
	public void setAvarage(Double avarage) {
		this.avarage = avarage;
	}




	/**
	 * @return the stateOfResult
	 */
	public boolean isStateOfResult() {
		return stateOfResult;
	}




	/**
	 * @param stateOfResult the stateOfResult to set
	 */
	public void setStateOfResult(boolean stateOfResult) {
		this.stateOfResult = stateOfResult;
	}




	@Override
	public int hashCode() {
		return Objects.hash(avarage, firstExamResult, id, stateOfResult);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultsOfExam other = (ResultsOfExam) obj;
		return Objects.equals(avarage, other.avarage) && Objects.equals(firstExamResult, other.firstExamResult)
				&& Objects.equals(id, other.id) && stateOfResult == other.stateOfResult;
	}
	@Override
	public String toString() {
		return "ResultsOfExam [id=" + id + ", firstExamResult=" + firstExamResult + ", secondExamResult="
				+ secondExamResult + ", avarage=" + avarage + ", stateOfResult=" + stateOfResult + "]";
	}

	


}
