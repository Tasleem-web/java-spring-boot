package com.springbootbackendapp.dto.reqestDto;

import java.util.List;

import lombok.Data;

@Data
public class BookRequestDto {
	private String name;
	private List<Long> authorIds;
	private Long categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(List<Long> authorIds) {
		this.authorIds = authorIds;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BookRequestDto(String name, List<Long> authorIds, Long categoryId) {
		super();
		this.name = name;
		this.authorIds = authorIds;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "BookRequestDto [name=" + name + ", authorIds=" + authorIds + ", categoryId=" + categoryId + "]";
	}

}
