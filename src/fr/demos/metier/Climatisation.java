package fr.demos.metier;

import java.io.Serializable;

public class Climatisation implements Serializable {


	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double temperature;
	private double pression=0.0;
	private int tauxHumidite;
	private String nomAppareil;
	private long datation=System.currentTimeMillis();
	private static int AJOUTFAR=40;
	private static final double  FACTEURFAR=1.8;
	private static final double  FACTPRESS=0.0295299831;
	
	
	
	public Climatisation(String n,double t,double pression,int tauxHumidite){
		//prendre des info entre parenthèse a mettre dans mes objets this.blabla
		this.nomAppareil=n;
		this.temperature=t;
	    this.tauxHumidite=tauxHumidite;
		this.pression=pression;
	}

	public Climatisation(String n,double t,int tauxHumidite){
		//datation=;
		this(n,t,0,tauxHumidite);
		
		/*this.nomAppareil=n;
		this.temperature=t;
		this.tauxHumidite=tauxHumidite;*/
		
	}
	
	// avoir la temperature 
	public double getTemperatureFarenheit(){
		double tFarenheit=(((temperature+AJOUTFAR)*FACTEURFAR)-AJOUTFAR);
		return tFarenheit;
		//correction return ((this.temperature+40)*1.8)-40);
		// ajoutFarenheit facteurFarenheit
	}
	
	
	
	
	 public double getPressionPoucesMercure(){
		double pression=(Math.rint(100*(this.pression*FACTPRESS))/100);
		return pression;
	 }
	
	
	 public double getTemperature() {
			return temperature;
		}

		public double getPression() {
			return pression;
		}

		public int getTauxHumidite() {
			return tauxHumidite;
		}

		public String getNomAppareil() {
			return nomAppareil;
		}

		public long getDatation() {
			return datation;
		}

		public static int getAJOUTFAR() {
			return AJOUTFAR;
		}

		public static double getFacteurfar() {
			return FACTEURFAR;
		}

		public static double getFactpress() {
			return FACTPRESS;
		}

		@Override
		public String toString() {
			return "Climatisation [temperature=" + temperature + ", pression=" + pression + ", tauxHumidite="
					+ tauxHumidite + ", nomAppareil=" + nomAppareil + "]";
		}	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
/*	public String toString() {
		return "Climatisation [temperature=" + temperature + ", pression=" + pression + ", tauxHumidite=" + tauxHumidite
				+ ", nomAppareil=" + nomAppareil + ", datation=" +new java.util.Date(this.datation) + "]";
	
	
}*/

	
		
		/*@Override
		public String toString() {
			return "Climatisation [temperature=" + temperature + ", pression=" + pression + ", tauxHumidite=" + tauxHumidite
					+ ", nomAppareil=" + nomAppareil + ", datation=" +new java.util.Date(this.datation) + "]";
		
		
	}*/

	
	
	
	
}
