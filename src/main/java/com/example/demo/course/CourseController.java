package com.example.demo.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topic{id}/course")
	public List<Course> getCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topic/{topicId}/course/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.update(id, course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.delete(id);
	}
}
