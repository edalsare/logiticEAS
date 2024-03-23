package com.ibero.logisticEAS.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "People")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_people;
	private String name_people;
	private String lastname;
	private String telephone;
	private String email;
	
	@OneToOne(mappedBy = "people", cascade = CascadeType.ALL)
	private User user;

}
