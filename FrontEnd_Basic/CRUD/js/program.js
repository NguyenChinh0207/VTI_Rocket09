$(function () {
	$(".header").load("header.html");
	$(".main").load("home.html");
	$(".footer").load("footer.html");
});

function moveHome() {
	$(".main").load("home.html");
}

function moveViewListEmployee() {
	$(".main").load("main.html");
	createDataEmployee();
	console.log(employees);
}

var employees = [];
var counter = 0;

function Employee(name, department, phone) {
	this.id = ++counter;
	this.name = name;
	this.department = department;
	this.phone = phone;
}

function createDataEmployee() {
	if (employees == null || employees.length == 0) {
		employees.push(new Employee("Nguyễn Thị Chinh", "Tester", "0989456728"));
		employees.push(new Employee("Đinh Huy Khánh", "Backend", "0383007876"));
		employees.push(new Employee("Đình Văn Tuấn", "BA", "0812811358"));
		employees.push(new Employee("Khuất Bá Tiến", "Backend", "0987654321"));
		employees.push(new Employee("Nguyễn Như Trọng", "Gamer", "01694533298"));
	}
}

function showEmployeeTable() {
	$("tbody").empty();
	employees.forEach(function (item) {
		$("tbody").append(
			"<tr>" +
				"<td>" +
				item.name +
				"</td>" +
				"<td>" +
				item.department +
				"</td>" +
				"<td>" +
				item.phone +
				"</td>" +
				"<td>" +
				'<a class="edit" title="Edit" data-toggle="tooltip" onclick="preUpdateEmployee(' +
				item.id +
				')"><i class="material-icons">&#xE254;</i></a>' +
				'<a class="delete" title="Delete" data-toggle="tooltip" onClick="deleteEmployee(' +
				item.id +
				')"><i class="material-icons">&#xE872;</i></a>' +
				"</td>" +
				"</tr>"
		);
	});
}

function deleteEmployee(id) {
	alert("Bạn có muốn xóa id: " + id);
	delete employees[id - 1];
	showEmployeeTable();
}

function showModal() {
	$("#myModal").modal("show");
}

function hideModal() {
	document.getElementById("name").value = "";
	document.getElementById("department").value = "";
	document.getElementById("phone").value = "";
	$("#myModal").modal("hide");
}

function createEmployee() {
	var name = document.getElementById("name").value;
	var department = document.getElementById("department").value;
	var phone = document.getElementById("phone").value;

	employees.push(new Employee(name, department, phone));

	// Ẩn modal đi
	hideModal();
	//Hien thị lại bảng table sau khi thêm mới 1 cháu
	showEmployeeTable();
}

function preUpdateEmployee(id) {
	showModal();
	// get index from employee's id
	var index = employees.findIndex((x) => x.id == id);
	// hàm fill dữ liệu vào modal
	document.getElementById("id").value = employees[index].id;
	document.getElementById("name").value = employees[index].name;
	document.getElementById("department").value = employees[index].department;
	document.getElementById("phone").value = employees[index].phone;
}
function updateEmployee() {
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var department = document.getElementById("department").value;
	var phone = document.getElementById("phone").value;

	// TODO validate
	// then fail validate ==> return;

	// get index from employee's id
	var index = employees.findIndex((x) => x.id == id);

	// update employee
	employees[index].name = name;
	employees[index].department = department;
	employees[index].phone = phone;

	hideModal();
	alert("Update success!!");
	showEmployeeTable();
}

function save() {
	var id = document.getElementById("id").value;

	if (id == null || id == "") {
		createEmployee();
	} else {
		updateEmployee();
	}
}
