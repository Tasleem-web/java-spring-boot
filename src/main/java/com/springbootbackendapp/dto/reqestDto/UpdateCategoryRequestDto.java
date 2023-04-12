package com.springbootbackendapp.dto.reqestDto;

import lombok.Data;

@Data
public class UpdateCategoryRequestDto {

	public UpdateCategoryRequestDto() {
		super();
	}

	private String name;

	public UpdateCategoryRequestDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UpdateCategoryRequestDto [name=" + name + "]";
	}

}
