package com.ibero.logisticEAS.Model;

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
@Table(name = "Proportion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proportion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_proportion")
	 private int id_proportion;
	 private int hight;
	 private int width;
	 private int lengthy;
	 private int planch;
         @Column(name = "num_planch")
	 private int numplanch;
	 
	 @OneToOne
	 @JoinColumn(name = "id package")
	 private Packages packages;

}
