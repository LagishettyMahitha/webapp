<!DOCTYPE html>
<html lang="en">
<head>
  
<title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <spring:url value="/resources/js" var="js"/>
  <spring:url value="/resources/jquery" var="jq"/>
  <spring:url value="/resources/css" var="css"/>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="${jq}/jquery.dataTables.js"></script> 
  <link href="${css}/dataTables.bootstrap.css">
<style>
body{
background-color:#c44dff;
}

<!-- Footer -->
  
  .full {
    width: 100%;    
}
.gap {
	height: 30px;
	width: 100%;
	clear: both;
	display: block;
}
.footer {
	
	background-color:black;
	height: auto;
	padding-bottom: 30px;
	position: relative;
	width: 100%;
	border-bottom: 1px solid white;
	border-top: 1px solid black;
}

.footer p {
	margin: 0;
}
.footer img {
	max-width: 100%;
}
.footer h3 {
	border-bottom: 1px solid black;
	color: white;
	font-size: 18px;
	font-weight: 600;
	line-height: 27px;
	padding: 40px 0 10px;
	text-transform: uppercase;
}
.footer ul {
	font-size: 13px;
	list-style-type: none;
	margin-left: 0;
	padding-left: 0;
	margin-top: 15px;
	color: black;
}
.footer ul li a {
	padding: 0 0 5px 0;
	display: block;
}
.footer a {
	color: white;
}
.supportLi h4 {
	font-size: 20px;
	font-weight: lighter;
	line-height: normal;
	margin-bottom: 0 !important;
	padding-bottom: 0;
}
.newsletter-box input#appendedInputButton {
	background: #FFFFFF;
	display: inline-block;
	float: left;
	height: 30px;
	clear: both;
	width: 100%;
}
.newsletter-box .btn {
	border: medium none;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-o-border-radius: 3px;
	-ms-border-radius: 3px;
	border-radius: 3px;
	display: inline-block;
	height: 40px;
	padding: 0;
	width: 100%;
	color: #fff;
}
.newsletter-box {
	overflow: hidden;
}
.bg-gray {
	background-image: -moz-linear-gradient(center bottom, #BBBBBB 0%, #F0F0F0 100%);
	box-shadow: 0 1px 0 #B4B3B3;
}
.social li {
	background: none repeat scroll 0 0 #B5B5B5;
	border: 2px solid #B5B5B5;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	-o-border-radius: 50%;
	-ms-border-radius: 50%;
	border-radius: 50%;
	float: left;
	height: 36px;
	line-height: 36px;
	margin: 0 8px 0 0;
	padding: 0;
	text-align: center;
	width: 36px;
	transition: all 0.5s ease 0s;
	-moz-transition: all 0.5s ease 0s;
	-webkit-transition: all 0.5s ease 0s;
	-ms-transition: all 0.5s ease 0s;
	-o-transition: all 0.5s ease 0s;
}
.social li:hover {
	transform: scale(1.15) rotate(360deg);
	-webkit-transform: scale(1.1) rotate(360deg);
	-moz-transform: scale(1.1) rotate(360deg);
	-ms-transform: scale(1.1) rotate(360deg);
	-o-transform: scale(1.1) rotate(360deg);
}
.social li a {
	color: #EDEFF1;
}
.social li:hover {
	border: 2px solid #2c3e50;
	background: #2c3e50;
}
.social li a i {
	font-size: 16px;
	margin: 0 0 0 5px;
	color: #EDEFF1 !important;
}
.footer-bottom {
	background: black;
	border-top: 1px solid #DDDDDD;
	padding-top: 10px;
	padding-bottom: 10px;
	color:white;
	text-align:center;
}
.footer-bottom p.pull-left {
	padding-top: 6px;
}
.payments {
	font-size: 1.5em;	
}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">KidsZone</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="adminpage">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Manage Supplier</a></li>

        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="admin/adminprod">Manage Product</a></li>
      
    </ul>
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="admin/admincat">Manage Category</a></li>
    
    <ul class="nav navbar-nav navbar-right">
      
      <li><a href="admin/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
    
  </div>
</nav>
  


</body>
</html>
