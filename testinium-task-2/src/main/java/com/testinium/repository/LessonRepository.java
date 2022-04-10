/**
 * 
 */
package com.testinium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testinium.entity.Lesson;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long>{

}
