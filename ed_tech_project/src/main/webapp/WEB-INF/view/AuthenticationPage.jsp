  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  overflow-x: hidden;
  /*overflow-y: hidden;*/
}

* {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
}
.hero{
	height: 100%;
	width: 100%;
 	background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)),url("https://i.pinimg.com/originals/be/e2/16/bee216fe545375389f0e842d1a8310db.gif");
 	background-position: center;
 	background-size: cover;
 	position: absolute;
 	filter: saturate(2);
}

::placeholder {
  color: lime;
  opacity: 1; /* Firefox */
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
 color: lime;
}

::-ms-input-placeholder { /* Microsoft Edge */
 color: lime;
}

input[type=text] {
  color: yellow;
  caret-color: blue;
}

input[type=password] {
  color: red;
  caret-color: blue;
}

.form-box{
	width: 27%;
	height: 65%;
	position: relative;
	margin: 2% auto;
	background: transparent;
	padding: 5px;
	overflow: hidden;
}
.button-box{
	width: 220px;
	margin: 30px auto;
	position: relative;
	box-shadow: 0 0 20px 9px #ff61241f;
	border-radius: 30px;
}

.toggle-btn{
	padding: 10px 30px;
	cursor: pointer;
	background: transparent;
	border: 0;
	outline: none;
	position: relative;
	color: white;
}

#btn{
	top: 0;
	left: 0;
	position: absolute;
	width: 110px;
	height: 100%;
	background: linear-gradient(to right,#808000,orange,#808000);
	border-radius: 30px;
	transition: .5s;
}

.input-group{
	top: 20%;
	position: absolute;
	width: 74%;
	transition: .5s;
}

.input-field{
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
	color: white;
	font-weight: bold;
}

.submit-btn{
	width: 85%;
	font-size: 18px;
	padding: 10px 30px;
	cursor: pointer;
	display: block;
	margin: auto;
	background: linear-gradient(to right,#808000,orange,#808000);
	border: 0;
	outline: none;
	border-radius: 30px;
	color: white;
}

.submit-btn:hover{
	font-weight: bold;
}

.check-box{
	margin: 20px 5px 26px 0;
	font-weight: bold;
	cursor: pointer;
}
.check-box1{
	margin: 25px 5px 26px 149px;
	font-weight: bold;
	cursor: pointer;
}
.check-box2{
	margin: 25px 5px 26px 61%;
	font-weight: bold;
	cursor: pointer;
}

span{
	color: #F0F8FF;
	font-size: 12.5px;
	bottom: 68px;
	position: absolute;
	cursor: default;
}
span:hover{
	color: yellow;
}

#login{
	left:50px;
}
#register{
	left:450px;
}
.a1{
    font-weight: bold;
    color: yellow;
}
.a1:hover{
    font-weight: bold;
    color: red;
}
.a2{
    color: white;
    margin: 20px 5px 28px 0;
	cursor: pointer;
}
.a2:hover{
    font-weight: bold;
    color: cyan;
}
.a3{
    color: white;
	cursor: pointer;
	font-size:15px;
}
.a3:hover{
    font-weight: bold;
    color: pink;
}
.extra:hover{
    font-weight: bold;
    color: bisque;
    cursor: default;
}
.extra1:hover{
    font-weight: bold;
    color: cyan;
    cursor: default;
}
.headingWelcome{
  font-family: Georgia, serif;
  color:orange; 
  font-size: 50px;
  cursor: default;
}
.headingWelcome1{
  font-family: Georgia, serif;
  color:lime; 
  font-size: 35px;
  cursor: default;
}
.headingWelcome1:hover{
  color:blue;
  font-weight: bold;
  cursor: not-allowed;
}
footer {  
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  font-weight: bold;
  background-color: transparent;
  color: white;
  font-size: 11.5px;
}
.error{
width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
	color: white;
	font-weight: bold;
		color:red;
		margin: 30px 5px 26px 0;
	font-weight: bold;
	cursor: pointer;
	}
.error1{
width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
	color: white;
	font-weight: bold;
		color:red;
		margin: 30px 5px 26px 149px;
	font-weight: bold;
	cursor: pointer;
	}
</style>
<link rel = "stylesheet" href = "https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
<title>DEVED TECH</title>
<link rel = "icon" href = "https://www.transparentpng.com/thumb/book-png/gYJvka-book-cut-out-png.png" type = "image/x-icon">
</head>
<body style="">
<!-- Top, right, bottom, left ----- margin -->
	<div class = "hero">
	<p align="right"><a href="Admin" class="a1" style="text-decoration: none;">Admin</a></p><br>
	<center><h1 class="headingWelcome">WELCOME TO DEVED TECH</h1></center>
		<div class = "form-box">
			<div class = "button-box">
				<div id="btn"></div>
				<button type = "button" class = "toggle-btn" onclick="login()">Log In</button>
				<button type = "button" class = "toggle-btn"onclick="register()">Register</button>
			</div>
			 <form id ="login"class="input-group" action="AuthenticationServlet" method = "post">
				<input type = "text" class = "input-field" placeholder = "Username" name = "uname" required>
				<input type = "password" class = "input-field" placeholder = "Enter Password" name = "upass" id="upass" required>
				<!-- <span><a href="ForgotPassword.jsp" class="a2" style="text-decoration: none;">Forgot Password?</a></span>-->
				<input type="checkbox" class = "check-box2" onclick="myFunction()"><span>Show Password</span>
				
				<button type="submit" class="submit-btn">Log In Me&#9995;</button>
			</form>
			
			<form:form id="register" class="input-group" action="RegistrationServlet" method = "post" modelAttribute="customer">
			    <form:input type = "text" class = "input-field" placeholder = "Username/Email" path="customer_username" maxlength="50" minlength="5"/>
			    <form:errors path="customer_username" cssClass="error"/>
			    <form:input type = "password" class = "input-field" placeholder = "Enter Password" id = "upass1" path="customer_password" maxlength="50" minlength="5"/>
			    <form:errors path="customer_password" cssClass="error1"/>
			    <form:input type = "text" class = "input-field" placeholder = "Enter Name" path="customer_name" maxlength="50" minlength="5"/>
			    <form:errors path="customer_name" cssClass="error1"/>
			    <form:input type = "text" class = "input-field" placeholder = "Enter Address" path="customer_address" />
			    <form:errors path="customer_address" cssClass="error1"/>
			    <form:input type = "text" class = "input-field" placeholder = "Enter Phone Number" path="customer_pho" />
			    <form:errors path="customer_pho" cssClass="error1"/>
				<input type = "checkbox" class = "check-box" required><span>I agree to the terms<br>& conditions</span>
				<input type="checkbox" class = "check-box1" onclick="myFunction1()"><span>Show Password</span>
				<button type="submit" class="submit-btn">Register Me&#129309;</button>
				
			</form:form>
		</div>
		<footer>
		<input type="hidden" value="youremailaddress" id="myInput12">
	    <a href="mailto:youremailaddress" class="a3" style="text-decoration: none;">Contact Us Through Email?</a>
		<p align="right" style="font-size:15px" class="extra">
		&copy; DEVED TECH | ALL RIGHTS RESERVED.</p><br>
		<p align="center" class="extra1">THE OWNER OF THE WEBSITE DOES NOT TAKE THE CREDIT OF THE BACKGROUND & LOGO IMAGE USED, THE CREDIT MUST BE GIVEN TO IT'S ORIGINAL OWNERS.<br>
		IF THE ORIGINAL OWNERS WANTS TO REMOVE DOWN THE IMAGES, PLEASE CONTACT US AT: <a href="mailto:youremailaddress" class="a3" style="text-decoration: none;">Here </a> AND WE WILL REMOVE IT ASAP.</p>
		<br></footer>
	</div>
	<script>
		var x = document.getElementById("login");
		var y = document.getElementById("register");
		var z = document.getElementById("btn");
		
		function register(){
			x.style.left = "-400px";
			y.style.left = "50px";
			z.style.left = "110px";
		}
		function login(){
			x.style.left = "50px";
			y.style.left = "450px";
			z.style.left = " 0px";
		}
		function myFunction() {
			  var x = document.getElementById("upass");
			  if (x.type === "password") {
			    x.type = "text";
			    x.style.color = 'cyan';
			  } else {
			    x.type = "password";
			    x.style.color = 'red';
			  }
			}
		
		function myFunction1() {
			  var x = document.getElementById("upass1");
			  if (x.type === "password") {
			    x.type = "text";
			    x.style.color = 'cyan';
			  } else {
			    x.type = "password";
			    x.style.color = 'red';
			  }
			}
	</script>
</body>
</html>