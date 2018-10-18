<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Hogwarts--Login</title>
		<!-- Bulma CSS -->
		<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
		<!-- Custom CSS -->
		<link rel="stylesheet" href="css/styles.css">
	</head>
<body class="login-body section">
	<section class="columns container">
		<div class="column is-one-quarter is-offset-half">
		<p class="title">Login</p>
			<form action="" method="post">
				<div class="field">
				  <p class="control has-icons-left has-icons-right">
				    <input class="input" type="email" placeholder="Email">
				    <span class="icon is-small is-left">
				      <i class="fas fa-envelope"></i>
				    </span>
				    <span class="icon is-small is-right">
				      <i class="fas fa-check"></i>
				    </span>
				  </p>
				</div>
				<div class="field">
				  <p class="control has-icons-left">
				    <input class="input" type="password" placeholder="Password">
				    <span class="icon is-small is-left">
				      <i class="fas fa-lock"></i>
				    </span>
				  </p>
				</div>
				<div class="field">
				  <p class="control">
				    <input class="button is-medium is-fullwidth is-success is-outlined" type="submit" value="Accerder al archivo">
				  </p>
				</div><!-- Cierre del boton -->
			</form>
		</div>
	</section>
	<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</body>
</html>