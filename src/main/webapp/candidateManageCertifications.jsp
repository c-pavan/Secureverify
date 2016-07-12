<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Manage Certifications | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body class="form-block-page">
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/candidateLeftMenu.jsp"%>
         <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Certifications</h5>
                </div>
               </div>
            </div>
            <div class="clear"></div>
          	<div class="all-certifications-blocks">
          	<s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
          		<input type="hidden" id="size" name="size" value="<s:property value="candidateScheduleTimingList.size"/>"/>
              <s:iterator value="candidateScheduleTimingList" var="candidateScheduleTiming" status="status">
              <input type="hidden" id="skillSet<s:property value="#status.count"/>" name="skillSet<s:property value="#status.count"/>" value="<s:property value="skillSet.primarySkillSet"/>" />
              <input type="hidden" id="performance<s:property value="#status.count"/>" name="performance<s:property value="#status.count"/>" value="<s:property value="candidatePerformance"/>" />
              <input type="hidden" id="verificationId<s:property value="#status.count"/>" name="verificationId<s:property value="#status.count"/>" value="<s:property value="candidateUniqueId"/>" />
              <input type="hidden" id="img<s:property value="#status.count"/>" name="img<s:property value="#status.count"/>" value="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certification-img.jpg"/>
              <canvas id="myCanvas-<s:property value="#status.count"/>" width="318" height="200"></canvas>
              </s:iterator>
            </s:if>
            <s:else>No Certificates to Display</s:else>
          	<script>
          	try{ 
          		var size = parseInt($('#size').val());
              	for(var i =1; i<=size; i++){
              		var candidatePerformance, skillSet, verificationId, image;
	                var ctx = document.getElementById("myCanvas-"+i).getContext('2d');
	       		    image = new Image();
	       		 	candidatePerformance = $('#performance'+i).val(); skillSet = $('#skillSet'+i).val(); verificationId = $('#verificationId'+i).val();
	       		 	if(candidatePerformance=='1'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-best.jpg'; }
				    else if(candidatePerformance=='2'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-good.jpg'; }
				    else if(candidatePerformance=='3'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-average.jpg'; }
				    else if(candidatePerformance=='4'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-not-qualified.jpg'; }
	 			    (function(ctx, image, verificationId, skillSet) {
	       		        image.onload = function() {
	       		            ctx.drawImage(image, 0, 0);
	       		          	ctx.font = '14pt Arial '; ctx.fillStyle = "#fff"; ctx.textAlign = 'left'; ctx.fillText(skillSet,15,157);
	     					ctx.font = '14pt Arial'; ctx.fillStyle = "#fff"; ctx.textAlign = 'left'; ctx.fillText(verificationId,49,190);
	     				};
	       		    })(ctx, image, verificationId, skillSet);
              	}
              }catch(e){ }
			</script>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>