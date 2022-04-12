/**
 * 
 */
package com.testinium.dto.response;

import java.util.Objects;

import com.testinium.entity.Student;

/**
 * @author Remzi ŞAHBAZ
 *
 */
public class InformationStudentResponse {

	private Student student;
	private String gradeName;
	private Double gradAvarage;

	
	/**
	 * 
	 */
	public InformationStudentResponse() {
	}
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the gradeName
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * @param gradeName the gradeName to set
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	/**
	 * @return the gradAvarage
	 */
	public Double getGradAvarage() {
		return gradAvarage;
	}
	/**
	 * @param gradAvarage the gradAvarage to set
	 */
	public void setGradAvarage(Double gradAvarage) {
		this.gradAvarage = gradAvarage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gradeName, student);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformationStudentResponse other = (InformationStudentResponse) obj;
		return Objects.equals(gradeName, other.gradeName) && Objects.equals(student, other.student);
	}
	@Override
	public String toString() {
		return "AllStudentResponse [student=" + student + ", gradeName=" + gradeName + ", gradAvarage=" + gradAvarage
				+ "]";
	}
	
	 
}
