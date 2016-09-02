<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Exception occurred</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/errorpage/css/main.css" type="text/css" media="screen, projection" /> <!-- main stylesheet -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/errorpage/css/tipsy.css" type="text/css" media="all" /> <!-- Tipsy implementation -->

<!--[if lt IE 9]>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/errorpage/css/ie8.css" type="text/css" />
<![endif]-->

<script type="text/javascript" src="<%= request.getContextPath() %>/resource/errorpage/scripts/jquery-1.7.2.min.js"></script> <!-- uiToTop implementation -->
<script type="text/javascript" src="<%= request.getContextPath() %>/resource/errorpage/scripts/custom-scripts.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resource/errorpage/scripts/jquery.tipsy.js"></script> <!-- Tipsy -->

<script type="text/javascript">

$(document).ready(function(){
			
	universalPreloader();
						   
});

$(window).load(function(){
	//remove Universal Preloader
	universalPreloaderRemove();
	
	rotate();
    dogRun();
	dogTalk();
	
	//Tipsy implementation
	$('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});
						   
});

</script>
</head>
<body>

<!-- Universal preloader -->
<div id="universal-preloader">
    <div class="preloader">
        <img src="<%= request.getContextPath() %>/resource/errorpage/images/universal-preloader.gif" alt="universal-preloader" class="universal-preloader-preloader" />
    </div>
</div>
<!-- Universal preloader -->
<div id="wrapper">
	<!-- 500 graphic -->
	<div class="graphic"></div>
	<!-- 500 graphic -->
	<!-- Not found text -->
	<div class="not-found-text">
    	<h1 class="not-found-text">Exception occurred, sorry!</h1>
    </div>
	<!-- Not found text -->

	<!-- search form -->
	<div class="search">
		<form name="search" method="get" action="#" >
	        <input type="text" name="search" value="Search ..." />
	        <input class="with-tooltip" title="Search!" type="submit" name="submit" value="" />
	    </form>
	</div>
	<!-- search form -->
	
	<!-- top menu -->
	<div class="top-menu">
		<a href="#" class="with-tooltip" title="Return to the home page">Home</a> | <a href="#" class="with-tooltip" title="Navigate through our sitemap">Sitemap</a> | <a href="#" class="with-tooltip" title="Contact us!">Contact</a> | <a href="http://www.cssmoban.com" class="with-tooltip" title="模板之家">模板之家</a>
	</div>
	<!-- top menu -->
	
	<div class="dog-wrapper">
		<!-- dog running -->
		<div class="dog"></div>
		<!-- dog running -->
		
		<!-- dog bubble talking -->
		<div class="dog-bubble"></div>
		<!-- dog bubble talking -->
	    
	    <!-- The dog bubble rotates these -->
	    <div class="bubble-options">
	    	<p class="dog-bubble">
	        	Are you lost, bud? No worries, I'm an excellent guide!
	        </p>
	    	<p class="dog-bubble">
		        <br />
	        	Arf! Arf!
	        </p>
	        <p class="dog-bubble">
	        	<br />
	        	Don't worry! I'm on it!
	        </p>
	        <p class="dog-bubble">
	        	I wish I had a cookie<br />
	        	<img style="margin-top:8px" src="<%= request.getContextPath() %>/resource/errorpage/images/cookie.png" alt="cookie" />
	        </p>
	        <p class="dog-bubble">
	        	<br />
	        	Geez! This is pretty tiresome!
	        </p>
	        <p class="dog-bubble">
	        	<br />
	        	Am I getting close?
	        </p>
	        <p class="dog-bubble">
	        	Or am I just going in circles? Nah...
	        </p>
	        <p class="dog-bubble">
	        	<br />
	            OK, I'm officially lost now...
	        </p>
	        <p class="dog-bubble">
	        	I think I saw a <br />
	        	<img style="margin-top:8px" src="<%= request.getContextPath() %>/resource/errorpage/images/cat.png" alt="cat" />
	        </p>
	        <p class="dog-bubble">
	        	What are we supposed to be looking for, anyway? @_@
	        </p>
	    </div>
	    <!-- The dog bubble rotates these -->
	</div>

	<!-- planet at the bottom -->
	<div class="planet"></div>
	<!-- planet at the bottom -->
</div>

</body>
</html>