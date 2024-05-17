package com.ibero.logisticEAS.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
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
        @Column(name = "cant_in")
	private int cantin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_bill")
        @JsonBackReference
	private Bill bill;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_product")
        //@JsonBackReference
	private Product product2;

}
