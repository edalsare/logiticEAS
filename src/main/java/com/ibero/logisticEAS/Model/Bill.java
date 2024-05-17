 package com.ibero.logisticEAS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
        @Column(name = "id_bill")
	private int idbill;
        @Column(name = "num_bill")
	private String numbill;
        @Column(name = "date_bill")
	private LocalDate datebill;
	private String lagency;
        private boolean actives;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private Users users;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "bill_product", joinColumns = @JoinColumn(name = "id_bill", referencedColumnName = "id_bill"),
			inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product")
			)
	private List<Product> product;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bill", cascade = CascadeType.ALL)
        //@JsonIgnore
        @JsonManagedReference
	private List<Amount_in> amount_in;
        
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "bill2", cascade = CascadeType.ALL)
        @JsonIgnore
	private List<Amount> amount;

}
