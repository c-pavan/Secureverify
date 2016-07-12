package com.secureVerify.bo;

import java.util.List;

import com.secureVerify.model.Propertie;

public interface PropertieBo {

	void addPropertie(Propertie propertie);
	
	void updatePropertie(Propertie propertie);
	
	void deletePropertie(Propertie propertie);
	
	void deletePropertieList(List<Propertie> propertieList);
	
	List<Propertie> listPropertie();
	
	Propertie getPropertie();
	
}
