<script type="text/javascript">var RecaptchaOptions = { theme : 'red'};</script> 
<% String publicKey  = "6Lc3dw0TAAAAAP_ag6yJvJQBQH2mhNht8hY8-7B-";  %>
<%@page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
 <script type="text/javascript" src="http://www.google.com/recaptcha/api/challenge?k=<%=publicKey %>"></script>
 <noscript>
   <iframe src="http://www.google.com/recaptcha/api/noscript?k=<%=publicKey %>" height="300" width="500"></iframe><br>
   <textarea name="recaptcha_challenge_field" rows="3" cols="40"></textarea>
   <input type="hidden" name="recaptcha_response_field" value="manual_challenge">
 </noscript>