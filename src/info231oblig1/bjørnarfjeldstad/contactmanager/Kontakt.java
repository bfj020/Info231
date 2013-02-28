package info231oblig1.bj�rnarfjeldstad.contactmanager;


/**
 * Class Kontakt
 * @author Bj�rnar Fjeldstad
 * Brukes til � opprette ein ny kontakt fr� input 
 * som blir gitt i klassen View.
 */

public class Kontakt {

	String fornamn;
	String etternamn;
	String firmaNamn;
	String tlf;
	String kommentar;
	/**
	 * Ein tom konstrukt�r som skal brukes til � kalle eit objekt av klassen i den andre
	 * klassen KontaktListe
	 */
	public Kontakt(){
	}

	/**
	 * Konstrukt�r som intialiserer variablene fornamn,etternamn,firma,tlf og kommentar
	 * @param fNamn
	 * @param eNamn
	 * @param firma
	 * @param telefon
	 * @param komment
	 */
	public Kontakt(String fNamn,String eNamn, String firma, String telefon, String komment){
		this.fornamn = fNamn;
		this.etternamn = eNamn;
		this.firmaNamn = firma;
		this.tlf = telefon;
		this.kommentar = komment;
	}

	/**
	 * 
	 * Metoden getFornamn returnerer strengen gitt til variabelen fornamn
	 * @return fornamn
	 */
	public String getFornamn(){
		return fornamn;
	}/**
	 *Metoden getEtternamn returnerer strengen gitt til variabelen etternamn
	 *@return etternamn
	 */

	public String getEtternamn(){
		return etternamn;
	}
	/**
	 * Metoden getFirma vil returnere strengen gitt til variabelen firma
	 * @return firma
	 */
	public String getFirma(){
		return firmaNamn;
	}
	/**
	 * Metoden getTlf vil returnere strengen gitt til variabelen tlf
	 * @return tlf
	 */

	public String getTlf(){
		return tlf;
	}

	/** Metoden getKommentar vil returnere strengen gitt til variabelen kommentar
	 * @return kommentar
	 */
	public String getKommentar(){
		return kommentar;
	}

}

