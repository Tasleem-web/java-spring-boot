package com.springbootbackendapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "district")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "district_id")
	@NotNull(message = "District ID may not be null")
	@Size(min = 3, max = 5, message = "District ID must be between 3 and 5 characters long")
	private String districtId;

	@Column(name = "name")
	@NotNull(message = "Name not be null")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String name;

	public District() {
		super();
	}

	public District(long id,
			@NotNull(message = "District ID may not be null") @Size(min = 3, max = 5, message = "District ID must be between 3 and 5 characters long") String districtId,
			@NotNull(message = "Name not be null") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String name,
			List<Talukas> talukas) {
		super();
		this.id = id;
		this.districtId = districtId;
		this.name = name;
		this.talukas = talukas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Talukas> getTalukas() {
		return talukas;
	}

	public void ListTalukas(List<Talukas> talukas) {
		this.talukas = talukas;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtId=" + districtId + ", name=" + name + ", talukas=" + talukas + "]";
	}

	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Talukas> talukas = new ArrayList<>();

}
