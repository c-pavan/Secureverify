package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Agent;

public interface AgentDAO {

	void addAgent(Agent agent);
	
	void updateAgent(Agent agent);
	
	void updateAgent(Integer agentId, String verificationCode);
	
	void updateAgent(Integer agentId, String verificationCode, String password);
	
	void deleteAgent(Agent agent);
	
	void deleteAgentList(List<Agent> agentList);
	
	List<Agent> listAgent();
	
	List<Agent> listActiveAgent();
	
	List<Agent> searchAgent(Integer agentId, String agentFirstName, String agentLastName, String agentEmailId, String agentPhoneNo, 
			String agentCity, String agentState, String agentCountry, String agentZipcode, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	Agent getAgentByAgentId(Integer agentId);
	
	Agent getAgent(String agentEmailId, String agentPassword);
	
	Agent getAgentByEmailId(String agentEmailId);
	
	List<Agent> getAgentsByZipcode(String agentZipcode);
	
	List<Agent> getAgentsByCity(String agentCity);
	
	List<Agent> getAgentListByPage(final int startRecord, final int endRecord);
	
	Integer getAgentListCount();
	
	Integer getAgentListCount(String agentEmailId, String agentPhoneNo, String agentCountry);
	
}
