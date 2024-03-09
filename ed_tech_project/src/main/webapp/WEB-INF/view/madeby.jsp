<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv='refresh' content='7; URL=authenticationpage'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DEVED TECH</title>
<link rel = "stylesheet" href = "https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
<link rel = "icon" href = "https://www.transparentpng.com/thumb/book-png/gYJvka-book-cut-out-png.png" type = "image/x-icon">
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
	background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)),url("https://64.media.tumblr.com/3e90c252f04617de3e1ce332f753ce40/44b3a2ad10a818dc-26/s500x750/957eee0b4d31250c64c05646f99c7c058d417dc8.gif");
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
    color: blue;
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
/*.headingWelcome1:hover{
  color:lime;
  font-weight: bold;
}*/
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
</style>
</head>
<body style="">
<!-- Top, right, bottom, left ----- margin -->
	<div class = "hero"><br><br><br>
	<center><h1 class="headingWelcome">WELCOME TO MY PROJECT WEBSITE</h1></center><br><br><br><br><br>
	
	<center><h1 class="headingWelcome1">DEVELOPED BY: YOUR NAME</h1></center><br><br><br><br><br><br><br>
	</div>
</body>
</html>