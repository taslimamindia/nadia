package ma.fst.tkhzn.sdsi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Ressource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	private Date dateLiv;
	private int dureeGarantie;
	private boolean estAffecter; //1: affecter 0: nonAffecter
	private boolean livrer;

//	@ManyToMany(fetch=FetchType.EAGER)
//	private Collection<Utilisateur> personnels=new ArrayList<>();


	
	//constructeur



	public Ressource(String code, Date dateLiv, int dureeGarantie) {
		super();
		this.code = code;
		this.dateLiv = dateLiv;
		this.dureeGarantie = dureeGarantie;
	}

	public Ressource(String code, Date dateLiv, int dureeGarantie, boolean estAffecter, Fournisseur fournisseur) {
		this.code = code;
		this.dateLiv = dateLiv;
		this.dureeGarantie = dureeGarantie;
		this.estAffecter = estAffecter;
		this.fournisseur = fournisseur;
	}

	public Ressource(String code, Date dateLiv, int dureeGarantie, Fournisseur fournisseur) {
		super();
		this.code = code;
		this.dateLiv = dateLiv;
		this.dureeGarantie = dureeGarantie;
		this.fournisseur = fournisseur;
	}
	

	public Ressource(String code, int Date, int dureeGarantie, boolean estAffecter, Fournisseur fournisseur) {
		super();
		this.code = code;
		this.dateLiv = dateLiv;
		this.dureeGarantie = dureeGarantie;
		this.estAffecter = estAffecter;
		this.fournisseur = fournisseur;
	}



	@ManyToOne
	@JoinColumn(name="fournisseur", insertable=false,updatable=false )
	private Fournisseur fournisseur;
	
//	@ManyToOne
//	@JoinColumn(name="responsable", insertable=false,updatable=false )
//	private Utilisateur responsable;
	

	
}
