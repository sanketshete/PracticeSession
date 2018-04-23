package io.javabrain.springbootstarter.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String>{

	public List<Topic> findByName(String name);
	public List<Topic> findById(String name); //syntax for property=string - findBy<Property>
	
	//findByTopicId(String Id) :- Topic is the variable of course class
	//method to get course by topicId 
}
