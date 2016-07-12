package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.AgentBo;
import com.secureVerify.dao.AgentDAO;
import com.secureVerify.model.Agent;

public class AgentBoImpl implements AgentBo {

	AgentDAO agentDAO;
	
	//DI via Spring
	public void setAgentDAO(AgentDAO agentDAO){
		this.agentDAO = agentDAO;
	}
	
	public void addAgent(Agent agent) {
		agentDAO.addAgent(agent);
	}

	public void updateAgent(Agent agent) {
		agentDAO.updateAgent(agent);
	}

	public void updateAgent(Integer agentId, String verificationCode) {
		agentDAO.updateAgent(agentId, verificationCode);
	}

	public void updateAgent(Integer agentId, String verificationCode, String password) {
		agentDAO.updateAgent(agentId, verificationCode, password);
	}

	public void deleteAgent(Agent agent) {
		agentDAO.deleteAgent(agent);
	}

	public void deleteAgentList(List<Agent> agentList) {
		agentDAO.deleteAgentList(agentList);
	}

	public List<Agent> listAgent() {
		return agentDAO.listAgent();
	}

	public List<Agent> listActiveAgent() {
		return agentDAO.listActiveAgent();
	}

	public List<Agent> searchAgent(Integer agentId, String agentFirstName,
			String agentLastName, String agentEmailId, String agentPhoneNo,
			String agentCity,
			String agentState, String agentCountry, String agentZipcode,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return agentDAO.searchAgent(agentId, agentFirstName, agentLastName, agentEmailId, agentPhoneNo, 
				agentCity, agentState, agentCountry, agentZipcode, createdBy, lastModifiedBy, fromDate, 
				toDate, status, startRecord, endRecord);
	}

	public Agent getAgentByAgentId(Integer agentId) {
		return agentDAO.getAgentByAgentId(agentId);
	}

	public Agent getAgent(String agentEmailId, String agentPassword) {
		return agentDAO.getAgent(agentEmailId, agentPassword);
	}

	public Agent getAgentByEmailId(String agentEmailId) {
		return agentDAO.getAgentByEmailId(agentEmailId);
	}

	public List<Agent> getAgentsByZipcode(String agentZipcode) {
		return agentDAO.getAgentsByZipcode(agentZipcode);
	}

	public List<Agent> getAgentsByCity(String agentCity) {
		return agentDAO.getAgentsByCity(agentCity);
	}

	public List<Agent> getAgentListByPage(int startRecord, int endRecord) {
		return agentDAO.getAgentListByPage(startRecord, endRecord);
	}

	public Integer getAgentListCount() {
		return agentDAO.getAgentListCount();
	}
	
	public Integer getAgentListCount(String agentEmailId, String agentPhoneNo, String agentCountry) {
		return agentDAO.getAgentListCount(agentEmailId,agentPhoneNo,agentCountry);
	}

}
