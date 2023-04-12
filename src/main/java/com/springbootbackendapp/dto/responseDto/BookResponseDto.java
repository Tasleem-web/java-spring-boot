package com.springbootbackendapp.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class BookResponseDto {

	public BookResponseDto() {
		super();
	}

	private Long id;
	private String name;
	private List<String> authorNames;
	private String categoryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAuthorNames() {
		return authorNames;
	}

	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BookResponseDto(Long id, String name, List<String> authorNames, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.authorNames = authorNames;
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BookResponseDto [id=" + id + ", name=" + name + ", authorNames=" + authorNames + ", categoryName="
				+ categoryName + "]";
	}

}
