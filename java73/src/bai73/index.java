package bai73;

import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;

public class index implements Serializable {
	private String name;
	private int age;
	private String job;
	public index(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	public String toString() {
		return (this.name + " " + this.getAge() + " " + this.job);
	}
	
	
}
