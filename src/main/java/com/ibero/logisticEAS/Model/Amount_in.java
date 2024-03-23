package com.ibero.logisticEAS.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "amount_in")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Amount_in {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_amount_in;
	private int cant_in;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bill")
	private Bill bill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product product;

}
