package com.springbootbackendapp.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class UpdateCategoryResponseDto {

	public UpdateCategoryResponseDto() {
		super();
	}

	private Long id;
	private String name;
	private List<String> bookNames;

	public UpdateCategoryResponseDto(Long id, String name, List<String> bookNames) {
		super();
		this.id = id;
		this.name = name;
		this.bookNames = bookNames;
	}

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

	public List<String> getBookNames() {
		return bookNames;
	}

	public void setBookNames(List<String> bookNames) {
		this.bookNames = bookNames;
	}

	@Override
	public String toString() {
		return "UpdateCategoryResponseDto [id=" + id + ", name=" + name + ", bookNames=" + bookNames + "]";
	}

}
