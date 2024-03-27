package com.ibero.logisticEAS.Model;

import jakarta.persistence.CascadeType;
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
@Table(name = "amount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cant;
	private int cant;
	private boolean state_pier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product producta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pier")
	private Pier pier;
	
	@OneToOne(mappedBy = "amount", cascade = CascadeType.ALL)
	private Locations location;

}
