$(function () {
	//$(".header").load("header.html");

	//ktra login, nếu có thì load home.html, ko thì load login.html
	$(".main").load("login.html");
	$(".footer").load("footer.html");
});

function clickNavLogin() {
	$(".main").load("login.html");
}

function login() {
	$(".main").load("home.html");
}

function clickNavHome() {
	$(".main").load("home.html");
}

function clickNavViewListdepartments() {
	$(".main").load("viewlistdepartments.html");
	buildTable();
}

var departments = [];

function department(id, name, totalMember) {
	this.id = id;
	this.name = name;
	this.totalMember = totalMember;
}

function getListdepartments() {
	// call API from server
	$.get("http://localhost:8080/api/v1/departments", function (data, status) {
		// reset list departments
		departments = [];

		// error
		if (status == "error") {
			// TODO
			alert("Error when loading data");
			return;
		}

		// success
		parseData(data);
		filldepartmentToTable();
	});
}

function parseData(data) {
	departments = data;

	// data.forEach(function(item) {
	//     departments.push(new department(item.id, item.name));
	// });
}

function filldepartmentToTable() {
	departments.forEach(function (item) {
		$("tbody").append(
			"<tr>" +
				"<td>" +
				item.id +
				"</td>" +
				"<td>" +
				item.name +
				"</td>" +
				"<td>" +
				item.totalMember +
				"</td>" +
				"<td>" +
				'<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
				item.id +
				')"><i class="material-icons">&#xE254;</i></a>' +
				'<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
				item.id +
				')"><i class="material-icons">&#xE872;</i></a>' +
				"</td>" +
				"</tr>"
		);
	});
}

function buildTable() {
	$("tbody").empty();
	getListdepartments();
}

function openAddModal() {
	resetForm();
	openModal();
}

function resetForm() {
	document.getElementById("id").value = "";
	document.getElementById("name").value = "";
	document.getElementById("totalMember").value = "";
}

function openModal() {
	$("#myModal").modal("show");
}

function hideModal() {
	$("#myModal").modal("hide");
}

function adddepartment() {
	// get data
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var totalMember = document.getElementById("totalMember").value;
	// TODO validate
	// then fail validate ==> return;

	var department = {
		id: id,
		name: name,
		totalMember: totalMember,
	};

	$.ajax({
		url: "http://localhost:8080/api/v1/departments",
		type: "POST",
		data: JSON.stringify(department), // body
		contentType: "application/json", // type of body (json, xml, text)
		// dataType: 'json', // datatype return
		success: function (data, textStatus, xhr) {
			hideModal();
			showSuccessAlert();
			buildTable();
		},
		error(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
		},
	});
}

function openUpdateModal(id) {
	// get index from department's id
	var index = departments.findIndex((x) => x.id == id);

	// fill data
	document.getElementById("id").value = departments[index].id;
	document.getElementById("name").value = departments[index].name;
	document.getElementById("totalMember").value =
		departments[index].totalMember;
	openModal();
}

function save() {
	var id = document.getElementById("id").value;

	if (id == null || id == "") {
		adddepartment();
	} else {
		updatedepartment();
	}
}

function updatedepartment() {
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var totalMember = document.getElementById("totalMember").value;
	// TODO validate
	// then fail validate ==> return;

	var department = {
		id: id,
		name: name,
		totalMember: totalMember,
	};

	$.ajax({
		url: "http://localhost:8080/api/v1/departments/" + id,
		type: "PUT",
		data: JSON.stringify(department),
		contentType: "application/json",
		success: function (result) {
			// success
			hideModal();
			showSuccessAlert();
			buildTable();
		},
		error(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
		},
	});
}

function openConfirmDelete(id) {
	// get index from department's id
	var index = departments.findIndex((x) => x.id == id);
	var name = departments[index].name;

	var result = confirm("Want to delete " + name + "?");
	if (result) {
		deletedepartment(id);
	}
}

function deletedepartment(id) {
	// TODO validate
	$.ajax({
		url: "http://localhost:8080/api/v1/departments/" + id,
		type: "DELETE",
		success: function (result) {
			// success
			showSuccessAlert();
			buildTable();
		},
		error(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
		},
	});
}

function showSuccessAlert() {
	$("#success-alert")
		.fadeTo(2000, 500)
		.slideUp(500, function () {
			$("#success-alert").slideUp(500);
		});
}

//search
function search() {
	var check = false;
	var searchInput = $("#inputSearch").val();

	$.get(
		"http://localhost:8080/api/v1/departments?search=" + searchInput,
		function (data, status) {
			// reset list departments
			$("tbody").empty();
			departments = [];

			// error
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}

			// success
			parseData(data);
			filldepartmentToTable();
		}
	);
}
function paging(item) {
	$.get(
		"http://localhost:8080/api/v1/departments?pageNumber=" +
			item +
			"&pageSize=5",
		function (data, status) {
			// reset list departments

			$("tbody").empty();
			departments = [];

			// error
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}

			// success
			parseData(data);
			filldepartmentToTable();
		}
	);
}
function login() {
	var username = $("username").val();

	$.get(
		"http://localhost:8080/api/v1/users/" + username,
		function (data, status) {
			alert("Login success");
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
