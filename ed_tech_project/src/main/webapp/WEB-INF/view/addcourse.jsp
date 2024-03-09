  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DEVED TECH</title>
<link rel = "icon" href = "https://www.transparentpng.com/thumb/book-png/gYJvka-book-cut-out-png.png" type = "image/x-icon">
<style>
    
    body{
    overflow-x: hidden;
    }
    
    body::-webkit-scrollbar {
    width: 4px;               /* width of the entire scrollbar */
    }
    
    
    body::-webkit-scrollbar-track {
    background: transparent;        /* color of the tracking area */
    }
    
    body::-webkit-scrollbar-thumb {
    background-color: cyan;    /* color of the scroll thumb */
    border-radius: 20px;       /* roundness of the scroll thumb */
    border: transparent;  /* creates padding around scroll thumb */
    }
	
	.a1{
    font-weight: bold;
    color: white;
    }
    
    .a1:hover{
    font-weight: bold;
    color: yellow;
    }
    
    .a2{
    color: white;
	cursor: pointer;
	font-size:15px;
	position: absolute;
    left: 2px;
    top: 2px;
	}
	
	.a2:hover{
    font-weight: bold;
    color: pink;
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
    
    .extra {
    position: absolute;
    right: 2px;
    top: 2px;
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
    
    footer {  
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    font-weight: bold;
    background-color: black;
    color: white;
    font-size: 11.5px;
    }
    
    .top-right {
    position: absolute;
    top: -10px;
    right: 10px;
    }
    
    .dear {
    position: relative;
    color: white;
    background: transparent;
    left: 2px;
    cursor: default;
    }
    
    .form-box {
    position: relative;
    top: 10px;
    left: 2px;
    }
    
    label {
    cursor: default;
    color: white;
    }
    
    input[type="text"] {
    font-family: monospace;
    font-size: 20px;
    color: peru;
    border:none;
    font-weight:bold;
    background-color:black;
    }
    
    input[type="number"] {
    font-family: monospace;
    font-size: 20px;
    color: peru;
    border:none;
    font-weight:bold;
    background-color:black;
    }
    
    ::-webkit-calendar-picker-indicator {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="15" viewBox="0 0 24 24"><path fill="%23bbbbbb" d="M20 3h-1V1h-2v2H7V1H5v2H4c-1.1 0-2 .9-2 2v16c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 18H4V8h16v13z"/></svg>');
    }
    
    input[type="date"] {
    font-family: monospace;
    font-size: 20px;
    color: peru;
    border:none;
    font-weight:bold;
    background-color:transparent;
    }
    
    textarea {
    font-family: monospace;
    font-size: 20px;
    color: peru;
    font-weight:bold;
    background-color:black;
    border-color:peru;
    resize: none;
    }
    
    select {
    font-family: monospace;
    font-size: 20px;
    color: peru;
    background-color:black;
    border:none;
    font-weight:bold;
    }
    
    </style>
</head>
<body style = "margin:0;background-color:black;">
<!-- Top, right, bottom, left ----- margin -->
<img src="https://carlislecollegelearningresourcecentre.files.wordpress.com/2016/10/graphics-welcome-676454.gif" alt="Admission Portal" width="100%" height="240">
<div class="top-right"><p align="right"><a href="logoutadmin" class="a1" style="text-decoration: none;">Log Out</a></p></div>
<div class="dear"><br>
	<h1 align="center">ADD COURSE DETAILS</h1>
	<h2 style = "color: red; background-color:transparent;  padding: 8px 12px; cursor: default;"><marquee>Note: All * are mandatory fields.</marquee></h2>
	<div class="form-box" align="left";><h4>
		<form:form action="addingcourse" method="post" modelAttribute="courses">
		        <label for="id">Course ID<span style="color: #ff0000">* </span></b></label>
				<form:input type = "text" class = "input-field" placeholder = "Course Id" path="course_id" style="width: 100%;cursor: pointer;"/><br><br>
				<label for="id">Course Name<span style="color: #ff0000">* </span></b></label>
				<form:input type = "text" class = "input-field" placeholder = "Course Name" path = "course_name" style="width: 100%;cursor: pointer;"/><br><br>
				<label for="id">Course Detail<span style="color: #ff0000">* </span></b></label>
				<form:textarea rows="2" cols="100%" style="width: 99.4%;cursor: pointer;" path = "course_detail"/></textarea>
				<label for="id">Course Instructor<span style="color: #ff0000">* </span></b></label>
				<form:input type = "text" class = "input-field" placeholder = "Course Instructor" path = "course_instructor" style="width: 100%;cursor: pointer;"/><br><br>
				<label for="id">Course Skill<span style="color: #ff0000">* </span></b></label>
				<form:input type = "text" class = "input-field" placeholder = "Course Skill" path = "course_skill" style="width: 100%;cursor: pointer;"/><br><br>
				<label for="id">Course Original Price<span style="color: #ff0000">* </span></b></label>
				<form:input type = "number" class = "input-field" placeholder = "Course Original Price" path = "original_course_price" style="width: 100%;cursor: pointer;" step=".01"/><br><br>
				<label for="id">Course Discount(Percent)<span style="color: #ff0000">* </span></b></label>
				<form:input type = "number" class = "input-field" placeholder = "Course Discount" path = "discount" style="width: 100%;cursor: pointer;"/><br><br>
				<label for="id">Course Quantity<span style="color: #ff0000">* </span></b></label>
				<form:input type = "number" class = "input-field" placeholder = "Course Quantity" path = "course_quantity" style="width: 100%;cursor: pointer;"/><br><br><br>
				<center><button type="submit"  style="width: 50%;height:50px;font-size: 30px;cursor: pointer;"><b>Add Course&#9995;</b></button></center>
			</form:form></h4></div>
		<p></p>
		<br><br><br><br>
		<footer>
		<input type="hidden" value="youremailaddress" id="myInput12">
	    <a href="mailto:youremailaddress" class="a2" style="text-decoration: none;">Contact Us Through Email?</a>
		<div style="font-size:15px" class="extra">
		&copy; DEVED TECH | ALL RIGHTS RESERVED.</div><br>
		<div style="position: relative">
		<p align="center" class="extra1">THE OWNER OF THE WEBSITE DOES NOT TAKE THE CREDIT OF THE LOGO & OTHER IMAGES USED IN MAKING OF THIS WEBSITE, THE CREDIT MUST BE GIVEN TO IT'S ORIGINAL OWNERS.<br>
		IF THE ORIGINAL OWNERS WANTS TO REMOVE DOWN THE IMAGES, PLEASE CONTACT US AT: <a href="mailto:youremailaddress" class="a3" style="text-decoration: none;">HERE </a> AND WE WILL REMOVE IT ASAP.<p>
		</div>
		</footer>
	</div>
</body>
</html>