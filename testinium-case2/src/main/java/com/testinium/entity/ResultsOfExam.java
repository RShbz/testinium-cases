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
	@OneToOne( mappedBy="resultsOfExam" ,cascade = CascadeType.ALL)
	@JoinColumn(name="courseRegistration_id")
	@JsonIgnore
	private CourseRegistration courseRegistration;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the courseRegistration
	 */
	public CourseRegistration getCourseRegistration() {
		return courseRegistration;
	}
	/**
	 * @param courseRegistration the courseRegistration to set
	 */
	public void setCourseRegistration(CourseRegistration courseRegistration) {
		this.courseRegistration = courseRegistration;
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
		return Objects.hash(course, courseRegistration, firstExamResult, id);
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
		return Objects.equals(course, other.course) && Objects.equals(courseRegistration, other.courseRegistration)
				&& Objects.equals(firstExamResult, other.firstExamResult) && Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "ResultsOfExam [id=" + id + ", courseRegistration=" + courseRegistration + ", course=" + course
				+ ", firstExamResult=" + firstExamResult + ", secondExamResult=" + secondExamResult + ", avarage="
				+ avarage + ", stateOfResult=" + stateOfResult + "]";
	}
	
	


}
