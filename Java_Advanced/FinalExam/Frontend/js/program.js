$(function () {
	$("#main").load("home.html");
	if (localStorage.getItem("accLogin")) {
		console.log(JSON.parse(localStorage.getItem("accLogin")));
		var obj = JSON.parse(localStorage.getItem("accLogin"));
		document.getElementById("personName").innerHTML = obj.username;
        
	}
    else{
        console.log(accLogin);
    }
});
function clickNavHome() {
	$("#main").load("home.html");
}
 function clickNavProfile() {
	$("#main").load("profile.html", function(){
		var obj = JSON.parse(localStorage.getItem("accLogin"));
		document.getElementById("example-email").value =obj.email;
		document.getElementById("fullname").value =obj.lastName+" "+obj.firstName;
		document.getElementById("phone").value =obj.phone;
		document.getElementById("email").innerHTML =obj.email;
		document.getElementById("namePro").innerHTML =obj.username;
	});
    //lỗi load script trươc
	
}
function clickNavGroup() {
	$("#main").load("groupTable.html");
	buildTable();
}

var groups = [];

function group(id, name, member, createDate, creatorID) {
	this.id = id;
	this.name = name;
	this.member = member;
	this.createDate = createDate;
	this.creatorID = creatorID;
}

function getListGroups() {
	// call API from server
	$.get("http://localhost:8080/api/v1/groups", function (data, status) {
		// reset list groups
		groups = [];

		// error
		if (status == "error") {
			// TODO
			alert("Error when loading data");
			return;
		}

		// success
		parseData(data);
		fillGroupToTable();
	});
}

function parseData(data) {
	groups = data;

	// data.forEach(function(item) {
	//     groups.push(new group(item.id, item.name));
	// });
}

function fillGroupToTable() {
	groups.forEach(function (item, index) {
		var a = new Date(item.createDate);
		var groupDate =
			a.getDate() + "/" + (a.getMonth() + 1) + "/" + a.getFullYear();
		$("tbody").append(
			"<tr>" +
				"<td>" +
				'<input type="checkbox" name="checkDelete" value=' +
				item.id +
				" >" +
				"</td>" +
				"<td>" +
				index +
				"</td>" +
				"<td>" +
				item.name +
				"</td>" +
				"<td>" +
				item.member +
				"</td>" +
				"<td>" +
				groupDate +
				"</td>" +
				"<td>" +
				item.creator.username +
				"</td>" +
				"<td>" +
				'<a class="edit" title="Edit" data-toggle="tooltip" style="cursor: pointer;" onclick="openUpdateModal(' +
				item.id +
				')"><i class="material-icons">&#xE254;</i></a>' +
				'<a class="delete" title="Delete" data-toggle="tooltip" style="cursor: pointer;" onClick="openConfirmDelete(' +
				item.id +
				')"><i class="material-icons">&#xE872;</i></a>' +
				"</td>" +
				"</tr>"
		);
	});
}

/////////////delete some groups/////////////
function openConfirmDeleteSomeGroup(){
    var listCheck = [];
	var checkbox = document.getElementsByName("checkDelete");
	for (var i = 0; i < checkbox.length; i++) {
		if (checkbox[i].checked === true) {
			listCheck.push(checkbox[i].value);
		}
	}
    var result = confirm("Want to delete list id: " + listCheck + "?");
	if (result) {
		deleteSomeGroups(listCheck);
	}
}
async function deleteSomeGroups(listCheck) {
    
	listCheck.forEach((element) => {
		$.ajax({
			url: "http://localhost:8080/api/v1/groups/" + element,
			type: "DELETE",
			success: function (result) {
				// success
				showSuccessAlert();
			},
			error(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log(errorThrown);
			},
		});
	});
	await sleep(1000);
	buildTable();
	console.log(listCheck);
}
function sleep(ms) {
	return new Promise((resolve) => setTimeout(resolve, ms));
}


////////
function buildTable() {
	$("tbody").empty();
	getListGroups();
}

function resetForm() {
	document.getElementById("id").value = "";
	document.getElementById("name").value = "";
	document.getElementById("member").value = "";
	document.getElementById("createDate").value = "";
	document.getElementById("creatorID").value = "";
}
///////////MODAL////////////
function openModal() {
	$("#myModal").modal("show");
}

function hideModal() {
	$("#myModal").modal("hide");
}

/////////////CREATE///////////////
function openAddModal() {
	resetForm();
	openModal();
	if (localStorage.getItem("accLogin")) {
		var obj = JSON.parse(localStorage.getItem("accLogin"));
		document.getElementById("creatorID").value = obj.username;
	}
}

function addGroup() {
	// get data
	if (localStorage.getItem("accLogin")) {
		var obj = JSON.parse(localStorage.getItem("accLogin"));

		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var member = document.getElementById("member").value;
		var createDate = document.getElementById("createDate").value;
		var creatorID = obj.id;
	} else {
		alert("you must login first");
	}

	var group = {
		id: id,
		name: name,
		member: member,
		createDate: createDate,
		creatorID: creatorID,
	};
    console.log(group.createDate)
    //log đúng
	$.ajax({
		url: "http://localhost:8080/api/v1/groups",
		type: "POST",
		data: JSON.stringify(group), // body
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

/////////////UPDATE///////////////
function openUpdateModal(id) {
	// get index from group's id

	var index = groups.findIndex((x) => x.id == id);
	// fill data
	document.getElementById("id").value = groups[index].id;
	document.getElementById("name").value = groups[index].name;
	document.getElementById("member").value = groups[index].member;
	document.getElementById("createDate").value = groups[index].createDate;
	document.getElementById("creatorID").value = groups[index].creator.id;
	openModal();
}

function updateGroup() {
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var member = document.getElementById("member").value;
	var createDate = document.getElementById("createDate").value;
	var creatorID = document.getElementById("creatorID").value;

	var group = {
		id: id,
		name: name,
		member: member,
		createDate: createDate,
		creatorID: creatorID,
	};

	$.ajax({
		url: "http://localhost:8080/api/v1/groups/" + id,
		type: "PUT",
		data: JSON.stringify(group),
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

//////////////DELETE////////////
function openConfirmDelete(id) {
	// get index from group's id
	var index = groups.findIndex((x) => x.id == id);
	var name = groups[index].name;

	var result = confirm("Want to delete " + name + "?");
	if (result) {
		deleteGroup(id);
	}
}

function deleteGroup(id) {
	// TODO validate
	$.ajax({
		url: "http://localhost:8080/api/v1/groups/" + id,
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
/////////////SAVE///////////////
function save() {
	var id = document.getElementById("id").value;
	if (id == null || id == "") {
        
		addGroup();
	} else {
		updateGroup();
	}
}
function showSuccessAlert() {
	$("#success-alert")
		.fadeTo(2000, 500)
		.slideUp(500, function () {
			$("#success-alert").slideUp(500);
		});
}

///////////////////SEARCH/////////////////////
function search() {
	var searchInput = $("#inputSearch").val();
	$.get(
		"http://localhost:8080/api/v1/groups?search=" + searchInput,
		function (data, status) {
			// reset list groups
			$("tbody").empty();
			groups = [];

			// error
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}

			// success
			parseData(data);
			fillGroupToTable();
		}
	);
}

///////////////////////LOGIN/////////////////

var accLogin; //luu phiên đăng nhập
function login() {
	var username = $("#userName").val();
	var password = $("#passWord").val();
    
	$.get(
		"http://localhost:8080/api/v1/users/name/" + username,
		function (data, status) {
			if (data.password == password) {
				alert("Login success");
				window.open("dashboard.html");
				
			} else {
				alert("Login failed, name or pass is not correct");
			}
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}
            
			localStorage.setItem("accLogin", JSON.stringify(data));
		}
	);
}


///////////////SORT///////////////////////////
function sortUp(field) {
	console.log(field);
	$.get(
		"http://localhost:8080/api/v1/groups?field=" + field + "&type=asc",
		function (data, status) {
			$("tbody").empty();
			groups = [];

			// error
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}

			// success
			parseData(data);
			fillGroupToTable();
		}
	);
}
function sortDown(field) {
	console.log(field);
	$.get(
		"http://localhost:8080/api/v1/groups?field=" + field + "&type=desc",
		function (data, status) {
			$("tbody").empty();
			groups = [];

			// error
			if (status == "error") {
				// TODO
				alert("Error when loading data");
				return;
			}

			// success
			parseData(data);
			fillGroupToTable();
		}
	);
}
