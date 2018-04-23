package io.javabrain.springbootstarter.controller.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		List<Course> courses= new ArrayList<Course>();
		courseRepository.findAll()
		.forEach(courses::add);
		
		return courses;
	}

	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void updateCourse(Course topic,String id) {
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
	courseRepository.delete(id);	
	}

	public Course getCourse(String id) {
		
		return courseRepository.findOne(id);
	}
	
}
