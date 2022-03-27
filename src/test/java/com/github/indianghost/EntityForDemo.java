package com.github.indianghost;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;

public class EntityForDemo {
	private String name;
	private int age;
	private List<Double> marks;

	public EntityForDemo() {
		this.marks = new ArrayList<Double>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Double> getMarks() {
		return marks;
	}

	public void setMarks(List<Double> marks) {
		this.marks = marks;
	}

	public void addMark(Double mark) {
		if (nonNull(mark)) {
			this.marks.add(mark);
		}
	}
}
