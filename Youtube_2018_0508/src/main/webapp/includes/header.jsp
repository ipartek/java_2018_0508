<%@include file="taglibs.jsp"%>

<c:set var="idioma" value="${(not empty sessionScope.idioma)?sessionScope.idioma:'es_ES'}"/>
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="idiomas" /> 

<!DOCTYPE html>
<html lang="${idioma}">

<head>

<!-- Comienza todas las URLs desde el href indicado -->
<base href="<%=request.getContextPath()%>/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="videos youtube">
<meta name="author" content="Adriana">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

<link rel="stylesheet" href="css/styles.css?<%=System.currentTimeMillis()%>">

<title>Youtube</title>
	<!-- Bootstrap core CSS -->
	<link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">

</head>

<body>

