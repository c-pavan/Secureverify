package com.secureVerify.action;

import org.apache.struts2.dispatcher.Dispatcher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.UnknownHandler;
import com.opensymphony.xwork2.XWorkException;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.RuntimeConfiguration;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class InvalidRequests implements UnknownHandler {

	@Override
	public ActionConfig handleUnknownAction(String namespace, String actionName) throws XWorkException {
		ConfigurationManager configurationManager = Dispatcher.getInstance().getConfigurationManager();
	    RuntimeConfiguration runtimeConfiguration = configurationManager.getConfiguration().getRuntimeConfiguration();
	    ActionConfig actionConfig = runtimeConfiguration.getActionConfig(namespace, actionName);
	    if(actionConfig == null) { // invalid url request, and this need to be handled
	        actionConfig = runtimeConfiguration.getActionConfig("", "pageNotFound");
	    }
	    return actionConfig;
	}

	@Override
	public Result handleUnknownResult(ActionContext actionContext, String actionName, ActionConfig actionConfig, String resultCode) throws XWorkException {
		return null;
	}

	@Override
	public Object handleUnknownActionMethod(Object action, String methodName) throws NoSuchMethodException {
		return null;
	}

}
