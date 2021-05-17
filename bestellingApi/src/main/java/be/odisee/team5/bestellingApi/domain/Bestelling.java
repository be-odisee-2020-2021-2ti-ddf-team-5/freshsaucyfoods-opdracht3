package be.odisee.team5.fsfopdracht2.domain;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bramv
 * @version 1.0
 * @created 09-Mar-2021 3:56:55 PM
 */
@Data
@Entity
@Table(name = "BESTELLINGEN")
public class Bestelling implements Serializable {

	@Column
	private int aantalLiterBesteld;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id=0L;

	@Column
	private LocalDate datumStartproductie;
	@Column
	private String duurProductie;
	@Column
	private String status;
	@Column
	private LocalDate voorafAfgesprokenEindDatum;
	@Column
	private String vooruitgang;
	@Column
	private String titel;

	public Bestelling(){}



	public void finalize() throws Throwable {


	}



	/**
	 *
	 * @param berschrijving
	 * @param titel
	 */
	public void addProefstaaltje(String berschrijving, String titel){

	}

	/**
	 *
	 * @param duur
	 */
	public void setDuurProducte(String duur){
		 duurProductie = duur;
	}

	/**
	 *
	 * @param eindDatum
	 */
	public void setEindDatum(LocalDate eindDatum){
		voorafAfgesprokenEindDatum = eindDatum;
	}

	/**
	 *
	 * @param literBesteld
	 */
	public void setLiterBesteld(int literBesteld){
		aantalLiterBesteld = literBesteld;
	}

	/**
	 *
	 * @param s
	 */

	public void setStatus(String s){
		status = s;
	}

	/**
	 *
	 * @param vooruit
	 */
	public void setVooruitgang(String vooruit){
		vooruitgang = vooruit;
	}

}