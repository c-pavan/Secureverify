package com.secureVerify.dao;

import java.util.List;

import com.secureVerify.model.Propertie;

public interface PropertieDAO {

	void addPropertie(Propertie propertie);
	
	void updatePropertie(Propertie propertie);
	
	void deletePropertie(Propertie propertie);
	
	void deletePropertieList(List<Propertie> propertieList);
	
	List<Propertie> listPropertie();
	
	Propertie getPropertie();
}
