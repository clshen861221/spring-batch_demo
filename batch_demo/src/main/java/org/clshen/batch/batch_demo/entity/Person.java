package org.clshen.batch.batch_demo.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4863703992420894117L;

	private String id;

	@Size(max = 4, min = 2)
	// 此处使用JSR-303注解来校验数据
	private String name;

	private Integer age;

	private String nation;

	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
