package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	

	public List<Course> getAllCourses(String id) {
		return (List<Course>) this.courseRepo.findByTopicId(id);
		
	}

	public Optional<Course> getCourse(String id) {
	//	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepo.findById(id);

	}

	public void addCourse(Course course) {
		courseRepo.save(course);

	}

	public void update(String id, Course topic) {
		courseRepo.save(topic);

	}
	public void delete(String id) {
		courseRepo.deleteById(id);
	}
}
