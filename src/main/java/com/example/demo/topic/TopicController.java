package com.example.demo.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicservice;

	@RequestMapping("/topic")
	public List<Topic> getTopics() {
		return topicservice.getAllTopics();
	}

	@RequestMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicservice.update(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicservice.delete(id);
	}
}
