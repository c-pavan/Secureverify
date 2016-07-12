<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<footer id="footer">
    <div class="copyright">
      <div class="container">
        <p>&copy; Copyright 2016 SecureVerify | All Rights Reserved</p>
        <ul class="footer-social">
          <s:if test="user==null && employer==null && candidate==null && agent==null && interviewer==null">
          <li class="adminlogin-footer"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLogin"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon-footer.png" alt="Admin login" data-toggle="tooltip" title="Admin Login" /></a></li>
          </s:if>
          <s:if test="urlPage.equals('verifyCandidate')">
          <li class="adminlogin-footer"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLogin"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon-footer.png" alt="Admin login" data-toggle="tooltip" title="Admin Login" /></a></li>
          </s:if>
          <li><a href="#" class="fa fa-facebook"></a></li>
          <li><a href="#" class="fa fa-twitter"></a></li>
          <li><a href="#" class="fa fa-linkedin"></a></li>
          <li><a href="#" class="fa fa-google-plus"></a></li>
        </ul>
      </div>
    </div>
  </footer>
</div>
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/bootstrap.js"></script> 
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/script.js"></script>

<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/jquery.datetimepicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.datetimepicker').datetimepicker();
});
</script>

<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
$('input.datepicker').datepicker({
	todayBtn: "linked",
	autoclose: true,
    todayHighlight: true,
    format: 'mm/dd/yyyy'
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$(".employer-signup").hide(); $(".register-button").hide(); $(".candidate-signup").hide();
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="1"){ $(".candidate-signup").show(); $(".register-button").show(); $(".employer-signup").hide(); }
        if($(this).attr("value")=="2"){ $(".employer-signup").show(); $(".register-button").show(); $(".candidate-signup").hide(); }
    });
});
$(document).ready(function(){
	$(".employer-login").hide();
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="1"){ $(".candidate-login").show(); $(".employer-login").hide(); }
        if($(this).attr("value")=="2"){ $(".employer-login").show(); $(".candidate-login").hide(); }
    });
});
$(document).ready(function(){
	$(".interviewer-login").hide(); $(".agent-login").hide();
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="1"){ $(".admin-login").show(); $(".interviewer-login").hide(); $(".agent-login").hide(); }
		if($(this).attr("value")=="2"){ $(".interviewer-login").show(); $(".admin-login").hide(); $(".agent-login").hide(); }
        if($(this).attr("value")=="3"){ $(".agent-login").show(); $(".admin-login").hide(); $(".interviewer-login").hide(); }
    });
    $('.loading').hide();
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#couponCode").val(''); $("#coupon_id").val('0'); $("#coupon_code_discount_amount").val('0');
	$("#no_of_credits").val(function () { return $(this).find('option:eq()').attr('value'); });
    $('#no_of_credits').on('change', function(){ if ( this.value == ''){ $(".payment-coupon").hide(); }else{ $(".payment-coupon").show(); } });
});
$(document).ready(function(){
	$('input:checkbox').prop('checked', false);
    $('input[type="checkbox"]').click(function(){
        if($(this).attr("value")=="coupon"){$(".coupon").toggle();}
    });
});
</script>
<script type="text/javascript">
$(document).ready(function(){
    $('.advance-search-btn p').click(function(){
       $(".admin-payment-advance-search").toggle();
    });
});
</script>
<script>
$(document).ready(function(){$('[data-toggle="tooltip"]').tooltip();});
</script>

<!-- contact map -->


<s:if test="urlPage!=null && urlPage.equals('contactus')">
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
<script>
function initialize() {
  var myLatlng = new google.maps.LatLng(42.275202,-88.152282);
  var mapOptions = {zoom: 15,scrollwheel: false,center: myLatlng}
  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  var marker = new google.maps.Marker({position: myLatlng,map: map,title: 'Secure Verify'});
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>

</s:if>
</body>
</html>