package com.ibero.logisticEAS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pier {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id_pier;
        @Column(name = "nom_pier", unique = true)
	private String nompier;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pier", cascade = CascadeType.ALL)
        @JsonIgnore
	private List<Amount> amount;

	public Pier(String nompier) {
		super();
		this.nompier = nompier;
	}
	
	

}
