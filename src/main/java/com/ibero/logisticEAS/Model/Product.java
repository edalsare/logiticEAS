package com.ibero.logisticEAS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
        @Column(name = "id_product")
	private long idproduct;
        @Column(name = "name_product")
	private String nameproduct;
        @Column(name = "description_pro")
	private String descriptionpro;
	private String suplier;                
        
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private Users userp;                
        
	@ManyToOne()
	@JoinColumn(name = "id_category")
	private Category category;
	
	@ManyToMany(mappedBy = "product")
        @JsonIgnore
	private List<Bill> bill;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product2", cascade = CascadeType.ALL)
        @JsonIgnore
        //@JsonManagedReference
	private List<Amount_in> amount_in;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producta", cascade = CascadeType.ALL)
        @JsonIgnore
	private List<Amount> amount;
	
	@OneToOne(mappedBy = "productt", cascade = CascadeType.ALL)
        @JsonIgnore
	private Trace trace;

    public Product(long idproduct, String nameproduct, String suplier) {
        this.idproduct = idproduct;
        this.nameproduct = nameproduct;
        this.suplier = suplier;
    }

    
        
        
	

}
