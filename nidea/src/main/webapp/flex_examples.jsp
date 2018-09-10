<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Flex Box Ejemplos</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="css/flexbox-styles.css">
<body>
<div class="main-container border">
	main-container-> display:flex; Contenedor padre
	<header>
		<h1>FlexBox Ejemplos</h1>
		<h2>Ejemplos desde contenedores padre </h2>
	</header>
	<h2>Sin flexbox</h2>
	<div class="container border">
		
		<div class="elemento1">1</div>
		<div class="elemento2">2</div>
		<div class="elemento3">3</div>
		<div class="elemento4">4</div>
	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;flex-flow: row wrap;</h2>
	<div class="container1 border">
	
		<div class="elementoWrap elemento  elemento1c1">1</div>
		<div class="elementoWrap elemento elemento2c1">2</div>
		<div class="elementoWrap elemento elemento3c1">3</div>
		<div class="elementoWrap elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;flex-flow: row nowrap;</h2>
	<div class="container10 border">
	
		<div class="elementoNoWrap elemento elemento1c1">1</div>
		<div class="elementoNoWrap elemento elemento2c1">2</div>
		<div class="elementoNoWrap elemento elemento3c1">3</div>
		<div class="elementoNoWrap elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;flex-flow: column wrap;</h2>
	<div class="container2 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: flex-end;</h2>
	<div class="container3 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: center;</h2>
	<div class="container4 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: space-between;</h2>
	<div class="container5 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: space-around;</h2>
	<div class="container6 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: flex-start;</h2>
	<div class="container7 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: center; align-items:flex-end</h2>
	<div class="container8 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;justify-content: center; align-items:strech</h2>
	<div class="container9 border">
	
		<div class="elemento elemento1c1">1</div>
		<div class="elemento elemento2c1">2</div>
		<div class="elemento elemento3c1">3</div>
		<div class="elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> display: -webkit-flex;display: :flex;flex-flow: row wrap;justify-content: center;align-content: center;</h2>
	<div class="container11 border">
	
		<div class="elementoNoWrap elemento elemento1c1">1</div>
		<div class="elementoNoWrap elemento elemento2c1">2</div>
		<div class="elementoNoWrap elemento elemento3c1">3</div>
		<div class="elementoNoWrap elemento elemento4c1">4</div>

	</div>
	<h2>Flexbox -> justify-content: center;align-content: center;</h2>
	<div class="container12 border">
	
		<div class="elementoNoWrap elemento elemento1c1">1</div>
		<div class="elementoNoWrap elemento elemento2c1">2</div>
		<div class="elementoNoWrap elemento elemento3c1">3</div>
		<div class="elementoNoWrap elemento elemento4c1">4</div>

	</div>
	<section>
		<h2>Ejemplos en los elementos hijos</h2>
	</section>
		<h2>div3-elementoGrow-Flex-grow:4;</h2>
	<div class="container13 border">
	
		<div class="elementoNoWrap elemento ">1</div>
		<div class="elementoNoWrap elemento ">2</div>
		<div class="elementoNoWrap elemento elementoGrow">3</div>
		<div class="elementoNoWrap elemento ">4</div>

	</div>
	<h2>div3-elementoShrink-Flex-shrink:4;</h2>
	<div class="container14 border">
	
		<div class="elementoNoWrap elemento elementoNormalShrink">1</div>
		<div class="elementoNoWrap elemento elementoNormalShrink">2</div>
		<div class="elementoNoWrap elemento elemento14width elementoHighShrink">3</div>
		<div class="elementoNoWrap elemento elementoNormalShrink">4</div>

	</div>
	<h2>div[1,2,3] = order 2, div4 order 1</h2>
	<div class="container14 border">
	
		<div class="elementoNoWrap elemento ">1</div>
		<div class="elementoNoWrap elemento ">2</div>
		<div class="elementoNoWrap elemento  ">3</div>
		<div class="elementoNoWrap elemento elementoOrder">4</div>

	</div>
	<h2>align-self: flex-end</h2>
	<div class="container14 border">
	
		<div class="elementoNoWrap elemento ">1</div>
		<div class="elementoNoWrap elemento elementoAlignSelf">2</div>
		<div class="elementoNoWrap elemento  ">3</div>
		<div class="elementoNoWrap elemento ">4</div>

	</div>
	<p><a href="index.jsp">Inicio</a></p>
</div>

</body>
</html>
	