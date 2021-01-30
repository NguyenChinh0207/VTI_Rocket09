///Login
function loginPage() {
	var check = false;
	$.get(
		"https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees",
		function (data, status) {
			data.forEach(function (item) {
				if (
					$("#userName").val() == item.name &&
					$("#passWord").val() == item.password
				) {
					check = true;
					alert("Login success");
					window.open("program.html");
					window.close();
				} else {
					check = false;
				}
			});
			if (check == false) {
				alert("Login failed, name or pass is not correct");
			}

			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}
		}
	);
}
