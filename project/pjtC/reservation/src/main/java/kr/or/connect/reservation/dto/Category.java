package kr.or.connect.reservation.dto;

/*
 * Data Transfer Object (DTO)
 * 계층간 데이터 교환을 위한 자바빈즈
 * 순수한 데이터 객체
 */

public class Category {
	
	private int id;
	private String name;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
}
