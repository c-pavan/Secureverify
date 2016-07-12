package com.secureVerify.bo.impl;

import java.util.List;

import com.secureVerify.bo.PropertieBo;
import com.secureVerify.dao.PropertieDAO;
import com.secureVerify.model.Propertie;

public class PropertieBoImpl implements PropertieBo {

	PropertieDAO propertieDAO;
	
	//DI via Spring
	public void setPropertieDAO(PropertieDAO propertieDAO){
		this.propertieDAO = propertieDAO;
	}
	
	
	public void addPropertie(Propertie propertie) {
		propertieDAO.addPropertie(propertie);
	}

	
	public void updatePropertie(Propertie propertie) {
		propertieDAO.updatePropertie(propertie);
	}

	
	public void deletePropertie(Propertie propertie) {
		propertieDAO.deletePropertie(propertie);
	}

	
	public void deletePropertieList(List<Propertie> propertieList) {
		propertieDAO.deletePropertieList(propertieList);
	}

	
	public List<Propertie> listPropertie() {
		return propertieDAO.listPropertie();
	}
	
	public Propertie getPropertie() {
		return propertieDAO.getPropertie();
	}

}
