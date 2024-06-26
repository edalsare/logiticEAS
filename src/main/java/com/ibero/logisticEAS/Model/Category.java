package com.ibero.logisticEAS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_category;
        @Column(name = "name_cat")
	private String namecat;
        @Column(name = "sub_name_cat", unique = true)
	private String subnamecat;       
	
        
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
        @JsonIgnore
	private List<Product> product;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryl", cascade = CascadeType.ALL)
        @JsonIgnore
	private List<Locations> location;

    public Category(String namecat, String subnamecat) {
        this.namecat = namecat;
        this.subnamecat = subnamecat;
    }
        
        
}
