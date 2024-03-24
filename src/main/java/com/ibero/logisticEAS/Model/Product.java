package com.ibero.logisticEAS.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	private int id_product;
	private String name_product;
	private String description_pro;
	private String suplier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private Users userp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@ManyToMany(mappedBy = "product")
	private List<Bill> bill;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product2", cascade = CascadeType.ALL)
	private List<Amount_in> amount_in;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producta", cascade = CascadeType.ALL)
	private List<Amount> amount;
	
	@OneToOne(mappedBy = "productt", cascade = CascadeType.ALL)
	private Trace trace;
	

}
