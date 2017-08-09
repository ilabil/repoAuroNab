package org.formation.jsf.bean;

import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CarBean {

	private String marque;
	private String modele;
	private Long kilometrage;
	private boolean controleTechniqueOK;
	private Date dateImmatriculation;

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Long getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Long kilometrage) {
		this.kilometrage = kilometrage;
	}

	public boolean isControleTechniqueOK() {
		return controleTechniqueOK;
	}

	public void setControleTechniqueOK(boolean controleTechniqueOK) {
		this.controleTechniqueOK = controleTechniqueOK;
	}

	public Date getDateImmatriculation() {
		return dateImmatriculation;
	}

	public void setDateImmatriculation(Date dateImmatriculation) {
		this.dateImmatriculation = dateImmatriculation;
	}


	public String getSummary() {

		
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		String language = locale.getLanguage();
		StringBuilder sb = new StringBuilder();
		String text = "";

		if (language == "fr") {
			sb.append("Vous avez saisi une voiture de marque : " + this.marque);
			sb.append(" ,");
			sb.append(" dont le mod�le est : " + this.modele);
			sb.append(" et ayant d�j� roul� " + this.kilometrage + ".");
			sb.append("Elle est destin�e � " + (this.controleTechniqueOK ? " la vente " : " la casse "));
			text = sb.toString();
			
		}

		else if (language == "en") {
			sb.append("You have entered a " + this.marque + "car");
			sb.append(" ,");
			sb.append(" in the " + this.modele + " version");
			sb.append(" having been driven for " + this.kilometrage + " kilometers.");
			sb.append(" It should be " + (this.controleTechniqueOK ? " sold" : " destroyed "));
			text = sb.toString();
		}
		
		return text;
	}

}
