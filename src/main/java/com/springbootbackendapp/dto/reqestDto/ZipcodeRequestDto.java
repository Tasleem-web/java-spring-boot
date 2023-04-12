package com.springbootbackendapp.dto.reqestDto;

import lombok.Data;

@Data
public class ZipcodeRequestDto {

	public ZipcodeRequestDto() {
		super();
	}

	private String name;
	private Long cityId;

	public ZipcodeRequestDto(String name, Long cityId) {
		super();
		this.name = name;
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "ZipcodeRequestDto [name=" + name + ", cityId=" + cityId + "]";
	}

}
