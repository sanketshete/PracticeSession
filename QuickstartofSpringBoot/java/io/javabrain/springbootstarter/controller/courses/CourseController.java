package io.javabrain.springbootstarter.controller.courses;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {

	@Autowired
	private CourseService topicservice;
	
	@RequestMapping("/topics/{id}")
	public List<Course> getAllTopics(@PathVariable String id){
		
		return topicservice.getAllCourses();
		
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return topicservice.getCourse(courseId);
		
	}

	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicID}/courses/{id}")
	public void addCourse(@RequestBody Course course){
		topicservice.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateCourse(@RequestBody Course topic,@PathVariable String id){
		topicservice.updateCourse(topic,id);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteCourse(@PathVariable String id){
		topicservice.deleteCourse(id);
		
	}

}
