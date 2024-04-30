package com.ibero.logisticEAS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "package")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Packages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_package")
	private int idpackage;
	private int unit;
	private int blister;
	private int box;
	private int pallet;
	private int piece;
	
	@OneToOne
	@JoinColumn(name = "id_trace")
	private Trace trace;
	
	@OneToOne(mappedBy = "packages", cascade = CascadeType.ALL)
        @JsonIgnore
	private Proportion proportion;

}
