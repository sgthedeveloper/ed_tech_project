<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  overflow-x: hidden;
  overflow-y: hidden;
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
  color: white;
  opacity: 1; /* Firefox */
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
 color: white;
}

::-ms-input-placeholder { /* Microsoft Edge */
 color: white;
}

input[type=text] {
  color: yellow;
  caret-color: red;
}

.form-box{
	width: 27%;
	height: 60%;
	position: relative;
	margin: 2% auto;
	background: transparent;
	padding: 5px;
	overflow: hidden;
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
	top: 30%;
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
	color: red;
}

.submit-btn:hover{
	font-weight: bold;
}
.submit-btn1{
	width: 6%;
	height: 6%;
	font-size: 100%;
	cursor: pointer;
	display: block;
	margin: auto;
	background: linear-gradient(to right,#808000,orange,#808000);
	border: 0;
	float: right;
	font-weight: bold;
	outline: none;
	color: white;
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
	margin: 25px 5px 26px 172px;
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
    color: bisque;
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
    color: blue;
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
    color: #808000;
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
  color:white; 
  font-size: 35px;
  cursor: default;
}
.headingWelcome1:hover{
  color:lime;
  font-weight: bold;
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
th, td {
  border: 3px solid black;
  border-radius: 10px;
  border-style: solid;
}
</style>
<link rel = "stylesheet" href = "https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
<title>DEVED TECH</title>
<link rel = "icon" href = "https://www.transparentpng.com/thumb/book-png/gYJvka-book-cut-out-png.png" type = "image/x-icon">
</head>
<body style="">
<!-- Top, right, bottom, left ----- margin -->
	<div class = "hero"><br>
	<p align="right"><a href="logoutadmin" class="a1" style="text-decoration: none;"><button type="button" class="submit-btn1">Log Out</button></form><br><br></a></p>
	<marquee scrollamount="12"><center><h1 class="headingWelcome">WELCOME TO ADMIN DEVED TECH MAIN MENU</h1></center></marquee><br><br><br><br><br>
	
	<div >
	<%-- ${courses} --%>
	<br>
	<div align="center">
	<%-- ${courses} --%>
	<table border=1>
		<thead>
			<tr>
				<td style="color:white;font-weight:bold">Course Id</td>
				<td style="color:white;font-weight:bold">Course Name</td>
				<td style="color:white;font-weight:bold">Course Detail</td>
				<td style="color:white;font-weight:bold">Course Instructor</td>
				<td style="color:white;font-weight:bold">Course Skill</td>
				<td style="color:white;font-weight:bold">Course Original Price</td>
				<td style="color:white;font-weight:bold">Course Discount(Percentage)</td>
				<td style="color:white;font-weight:bold">Course After Discount</td>
				<td style="color:white;font-weight:bold">Course Quantity</td>
				<td style="color:white;font-weight:bold">Course rating</td>
				<td style="color:white;font-weight:bold">Course Popularity</td>
			</tr>
		</thead>

		
		<c:forEach var="course" items="${courses}">
			<%-- ${course} <br> --%>
			<tr>
				<td style="color:yellow;font-weight:bold">${course.course_id }</td>
				<td style="color:yellow;font-weight:bold">${course.course_name }</td>
				<td style="color:yellow;font-weight:bold">${course.course_detail }</td>
				<td style="color:yellow;font-weight:bold">${course.course_instructor}</td>
				<td style="color:yellow;font-weight:bold">${course.course_skill}</td>
				<td style="color:yellow;font-weight:bold">${course.original_course_price }</td>
				<td style="color:yellow;font-weight:bold">${course.discount }</td>
				<td style="color:yellow;font-weight:bold">${course.course_after_discount }</td>
			    <td style="color:yellow;font-weight:bold">${course.course_quantity }</td>
				<td style="color:yellow;font-weight:bold">${course.course_rating}</td>
				<td style="color:yellow;font-weight:bold">${course.course_popularity}</td>
				<td style="color:yellow;font-weight:bold">
				<a href = "updateForm?couId=${course.course_id}" style="color:cyan;font-weight:bold" >Edit</a></td>
				<td style="color:yellow;font-weight:bold">
				<a href = "deleteCourses?couId=${course.course_id}" onclick = "if (!(confirm('Do you really want to delete this course record?'))) return false" style="color:lime;font-weight:bold">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table> 
	</div>
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
</body>
</html>