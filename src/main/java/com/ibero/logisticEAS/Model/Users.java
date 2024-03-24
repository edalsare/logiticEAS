package com.ibero.logisticEAS.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_users;
	private String name_user;
	private String password;
	private String post;
	
	
	@OneToOne
	@JoinColumn(name = "id_people")
	private People people;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	private List<Bill> bill;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userp", cascade = CascadeType.ALL)
	private List<Product> product;

}
