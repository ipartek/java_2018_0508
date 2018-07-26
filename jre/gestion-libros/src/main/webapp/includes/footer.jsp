
<script>
	function show() {
		console.log('click en show');
		var pass = document.getElementById('pass');
		var ojo = document.getElementById('eye');

		if (pass.type == "password") {
			pass.type = "text";
			ojo.classList.replace("fa-eye-slash", "fa-eye");
		} else {
			pass.type = "password";
			ojo.classList.replace("fa-eye", "fa-eye-slash");

		}
		console.log(pass);
	}
</script>
</body>
</html>