package com.springbootbackendapp.dto.reqestDto;

import lombok.Data;

@Data
public class AuthorRequestDto {

	public AuthorRequestDto() {
		super();
	}

	private String name;
	private Long zipcodeId;

	public AuthorRequestDto(String name, Long zipcodeId) {
		super();
		this.name = name;
		this.zipcodeId = zipcodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(Long zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	@Override
	public String toString() {
		return "AuthorRequestDto [name=" + name + ", zipcodeId=" + zipcodeId + "]";
	}

}
