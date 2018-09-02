package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepo;

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Spring FrameWork", "Spring FrameWork Description"),
					new Topic("Java", "Java FrameWork", "Java FrameWork Description")

			));

	public List<Topic> getAllTopics() {
		return (List<Topic>) this.topicRepo.findAll();
		
	}

	public Optional<Topic> getTopic(String id) {
	//	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepo.findById(id);

	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);

	}

	public void update(String id, Topic topic) {
		topicRepo.save(topic);

	}
	public void delete(String id) {
		topicRepo.deleteById(id);
	}
}
