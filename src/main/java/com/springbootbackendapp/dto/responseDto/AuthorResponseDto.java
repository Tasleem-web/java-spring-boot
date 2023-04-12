package com.springbootbackendapp.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorResponseDto {

	public AuthorResponseDto() {
		super();
	}

	private Long id;
	private String name;
	private List<String> bookNames;
	private String zipcodeName;

	public AuthorResponseDto(Long id, String name, List<String> bookNames, String zipcodeName) {
		super();
		this.id = id;
		this.name = name;
		this.bookNames = bookNames;
		this.zipcodeName = zipcodeName;
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

	public String getZipcodeName() {
		return zipcodeName;
	}

	public void setZipcodeName(String zipcodeName) {
		this.zipcodeName = zipcodeName;
	}

	@Override
	public String toString() {
		return "AuthorResponseDto [id=" + id + ", name=" + name + ", bookNames=" + bookNames + ", zipcodeName="
				+ zipcodeName + "]";
	}

}
