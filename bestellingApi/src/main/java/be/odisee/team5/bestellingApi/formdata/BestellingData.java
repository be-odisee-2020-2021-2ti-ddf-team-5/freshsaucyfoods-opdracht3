package be.odisee.team5.fsfopdracht2.formdata;

import be.odisee.team5.fsfopdracht2.domain.Bestelling;
import lombok.Data;

import javax.validation.constraints.*;


@Data
public class BestellingData extends Bestelling {
	private long id=0;
	private int aantalLiter=0;
	private String gewensteLeverdatum;
	private String titel="";
	private String vooruitgang="";
	private String startProductieDate;

}
