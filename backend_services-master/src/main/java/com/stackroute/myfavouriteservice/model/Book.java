//completed---fully same
package com.stackroute.myfavouriteservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;

public class Book {
	
//	  pid: string;
//	  fullName: String;
//	  name: String;
//	  country:String;
	
	@Id
    private String key;
  


    @JsonProperty("name")
    private String name;
    
    @JsonProperty("top_work")
    private String top_work;

    @JsonProperty("work_count")
    private String work_count;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTop_work() {
		return top_work;
	}

	public void setTop_work(String top_work) {
		this.top_work = top_work;
	}

	public String getWork_count() {
		return work_count;
	}

	public void setWork_count(String work_count) {
		this.work_count = work_count;
	}

	public Book(String key, String name, String top_work, String work_count) {
		super();
		this.key = key;
		this.name = name;
		this.top_work = top_work;
		this.work_count = work_count;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
}