package com.springbootbackendapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "talukas")
public class Talukas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	@NotNull(message = "Name may not be null")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String name;

	@Column(name = "parent_id")
	@NotNull(message = "Parent ID may not be null")
	@Size(min = 2, max = 32, message = "Parent ID must be between 2 and 32 characters long")
	private String parentID;

	public Talukas() {
		super();
	}

	public Talukas(long id,
			@NotNull(message = "Name may not be null") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String name,
			@NotNull(message = "Parent ID may not be null") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String parentID) {
		super();
		this.id = id;
		this.name = name;
		this.parentID = parentID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	@Override
	public String toString() {
		return "Talukas [id=" + id + ", name=" + name + ", parentID=" + parentID + "]";
	}

	@ManyToOne
	private District district;

}
