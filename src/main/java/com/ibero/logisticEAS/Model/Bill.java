package com.ibero.logisticEAS.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bill;
	private String num_bill;
	private LocalDate date_bill;
	private String lagency;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "bill_product", joinColumns = @JoinColumn(name = "id_bill", referencedColumnName = "id_bill"),
			inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product")
			)
	private Product product;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	private List<Amount_in> amount_in;

}
