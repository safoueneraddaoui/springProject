package tn.iit.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "t_compte")

@NamedQuery(name = "all-compte", query = "select c from Compte c")
@NamedQuery(name = "count-compte", query = "select count(c) from Compte c")
@NamedQuery(name = "sum-money", query = "select sum(solde) from Compte c")
@NamedQuery(name = "top-money", query = "select max(solde) from Compte c")
public class Compte implements Serializable { // spec JEE

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // PK + auto-incrimet
	@Include // tebe3 hashCode ta5ou "rib"
	private Long rib;
	private float solde;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_cin", nullable = false)
	@ToString.Exclude
	private Client client;

	public Compte(float solde, Client client) {
		super();
		this.solde = solde;
		this.client = client;
	}

}