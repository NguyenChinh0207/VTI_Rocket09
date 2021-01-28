///Login
function loginPage() {
	// if ($("#userName").val() == "admin" && $("#passWord").val() == "admin") {
	// 	alert("Login success");
	// 	window.open("program.html");
	// 	window.close();
	// } else {
	// 	alert("username or password is not correct");
	// }
	$.get(
		"https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees",
		function (data, status) {
			data.forEach(function (item) {
				console.log(item.name);
				console.log(item.password);
				if (
					$("#userName").val() == item.name &&
					$("#passWord").val() == item.password
				) {
					alert("Login success");
					window.open("program.html");
					window.close();
				} else {
					alert("username or password is not correct");
				}
			});
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}
		}
	);
}
