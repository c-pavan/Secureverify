<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/favicon.png">
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/bootstrap.css">
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/style.css" />
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/jquery.datetimepicker.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/jquery-1.11.0.min.js"></script> 
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/common.js"></script>