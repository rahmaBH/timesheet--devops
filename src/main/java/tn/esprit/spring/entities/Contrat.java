package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contrat implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="seq")
	private int reference;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	//@Column(name="TYPE_CTR", nullable=true )
	private String typeContrat;
	
	@Transient 
	private float telephone;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="contrat",cascade = CascadeType.ALL)
	private Employe employe;

	private float salaire;

	public Contrat() {
		super();
	}
	
	public Contrat(Date dateDebut, String typeContrat, float salaire) {
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	
	public Contrat(int id,Date dateDebut, String typeContrat, float salaire) {
		this.reference = id;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
