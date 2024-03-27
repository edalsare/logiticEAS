package com.ibero.logisticEAS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_location;
	private String aisle;
	private String rack;
	private String level;
	private String place;
	private String position;
	private Boolean state;
	
	@OneToOne
	@JoinColumn(name = "id_amount")
	private Amount amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category categoryl;

	public Locations(String aisle, String rack, String level, String place, String position, Boolean state, Category categoryl) {
		super();
		this.aisle = aisle;
		this.rack = rack;
		this.level = level;
		this.place = place;
		this.position = position;
		this.state = state;
		this.categoryl = categoryl;
	}
	
	

}
