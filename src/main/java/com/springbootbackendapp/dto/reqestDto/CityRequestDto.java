package com.springbootbackendapp.dto.reqestDto;

import lombok.Data;

@Data
public class CityRequestDto {

	public CityRequestDto() {
		super();
	}

	private String name;

	public CityRequestDto(String name) {
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
		return "CityRequestDto [name=" + name + "]";
	}

}
