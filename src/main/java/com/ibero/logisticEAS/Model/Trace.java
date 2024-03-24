package com.ibero.logisticEAS.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_trace;
	private String name_trace;
	
	@OneToOne
	@JoinColumn(name = "id_product")
	private Product productt;
	
	@OneToOne(mappedBy = "trace", cascade = CascadeType.ALL)
	private Packages packages;

}
