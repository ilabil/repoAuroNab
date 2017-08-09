package org.formation.jsf.bean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="languageController")
@SessionScoped
public class LanguageController {
	
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}


	public String changeLanguage(String language){
		locale= new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return "";
	}
}
