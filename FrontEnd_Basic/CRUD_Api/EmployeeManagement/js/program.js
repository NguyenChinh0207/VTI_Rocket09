$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListEmployees() {
    $(".main").load("viewlistemployees.html");
    buildTable();
}

var employees = [];

function Employee(id, name, department, phone) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function getListEmployees() {
    // call API from server
    $.get(
        "https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees",
        function(data, status) {
            // reset list employees
            employees = [];

            // error
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }

            // success
            parseData(data);
            fillEmployeeToTable();
        }
    );
}

function parseData(data) {
    // employees = data;

    data.forEach(function(item) {
        employees.push(
            new Employee(item.id, item.name, item.department, item.phone)
        );
    });
}

function fillEmployeeToTable() {
    employees.forEach(function(item) {
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
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
            item.id +
            ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
            item.id +
            ')"><i class="material-icons">&#xE872;</i></a>' +
            "</td>" +
            "<td>" +
            '<a class="viewÁnswer" title="ViewAnswer" data-toggle="tooltip" onClick="openViewAnswer(' +
            item.id +
            ')"><i class="eye">	&hearts;</i></a>' +
            "</td>" +
            "</tr>"
        );
    });
}

function buildTable() {
    $("tbody").empty();
    getListEmployees();
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}

function openModal() {
    $("#myModal").modal("show");
}

function hideModal() {
    $("#myModal").modal("hide");
}

function addEmployee() {
    // get data
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        name: name,
        department: department,
        phone: phone,
    };

    $.post(
        "https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees",
        employee,
        function(data, status) {
            // error
            if (status == "error") {
                alert("Error when loading data");
                return;
            }

            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        }
    );
}

function openUpdateModal(id) {
    // get index from employee's id
    var index = employees.findIndex((x) => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    document.getElementById("department").value = employees[index].department;
    document.getElementById("phone").value = employees[index].phone;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        name: name,
        department: department,
        phone: phone,
    };

    $.ajax({
        url: "https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees/" + id,
        type: "PUT",
        data: employee,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
    });
}

function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex((x) => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate

    $.ajax({
        url: "https://5fa3f69bf10026001618e3a5.mockapi.io/api/v1/employees/" + id,
        type: "DELETE",
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTable();
        },
    });
}

function showSuccessAlert() {
    $("#success-alert")
        .fadeTo(2000, 500)
        .slideUp(500, function() {
            $("#success-alert").slideUp(500);
        });
}

//View list answer??

function clickNavViewListAnswer() {
    $(".main").load("viewlistanswer.html");
    buildTableAnswer();
}
var answers = [];

function Answer(id, title, content, creatorId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.creatorId = creatorId;
}

function getListAnswer() {
    // call API from server
    $.get(
        "https://6005956475860e0017c5cd5a.mockapi.io/answer",
        function(data, status) {
            // reset list employees
            answers = [];

            // error
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }

            // success
            parseDataAnswer(data);
            fillAnswerToTable();
        }
    );
}

function parseDataAnswer(data) {
    // employees = data;

    data.forEach(function(item) {
        answers.push(
            new Answer(item.id, item.title, item.content, item.creatorId)
        );
    });
}

function fillAnswerToTable() {
    answers.forEach(function(item) {
        $("tbody").append(
            "<tr>" +
            "<td>" +
            item.title +
            "</td>" +
            "<td>" +
            item.content +
            "</td>" +
            "<td>" +
            item.creatorId +
            "</td>" +
            "<td>" +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModalAnswer(' +
            item.id +
            ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDeleteAnswer(' +
            item.id +
            ')"><i class="material-icons">&#xE872;</i></a>' +
            "</td>" +
            "</tr>"
        );
    });
}

function buildTableAnswer() {
    $("tbody").empty();
    getListAnswer();
}

function openAddModalAnswer() {
    resetFormAnswer();
    openModalAnswer();
}

function resetFormAnswer() {
    document.getElementById("id").value = "";
    document.getElementById("title").value = "";
    document.getElementById("content").value = "";
    document.getElementById("creatorId").value = "";
}

function openModalAnswer() {
    $("#myModalAnswer").modal("show");
}

function hideModalAnswer() {
    $("#myModalAnswer").modal("hide");
}

function addAnswer() {
    // get data
    var title = document.getElementById("title").value;
    var content = document.getElementById("content").value;
    var creatorId = document.getElementById("creatorId").value;

    // TODO validate
    // then fail validate ==> return;

    var answer = {
        title: title,
        content: content,
        creatorId: creatorId,
    };

    $.post(
        "https://6005956475860e0017c5cd5a.mockapi.io/answer",
        answer,
        function(data, status) {
            // error
            if (status == "error") {
                alert("Error when loading data");
                return;
            }

            // success
            hideModalAnswer();
            showSuccessAlertAnswer();
            buildTableAnswer();
        }
    );
}

function openUpdateModalAnswer(id) {
    // get index from employee's id
    var index = answers.findIndex((x) => x.id == id);

    // fill data
    document.getElementById("id").value = answers[index].id;
    document.getElementById("title").value = answers[index].title;
    document.getElementById("content").value = answers[index].content;
    document.getElementById("creatorId").value = answers[index].creatorId;

    openModalAnswer();
}

function saveAnswer() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addAnswer();
    } else {
        updateAnswer();
    }
}

function updateAnswer() {
    var id = document.getElementById("id").value;
    var title = document.getElementById("title").value;
    var content = document.getElementById("content").value;
    var creatorId = document.getElementById("creatorId").value;

    // TODO validate
    // then fail validate ==> return;

    var answer = {
        title: title,
        content: content,
        creatorId: creatorId,
    };

    $.ajax({
        url: "https://6005956475860e0017c5cd5a.mockapi.io/answer/" + id,
        type: "PUT",
        data: answer,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            hideModalAnswer();
            showSuccessAlertAnswer();
            buildTableAnswer();
        },
    });
}

function openConfirmDeleteAnswer(id) {
    // get index from employee's id
    var index = answers.findIndex((x) => x.id == id);
    var title = answers[index].title;

    var result = confirm("Want to delete " + title + "?");
    if (result) {
        deleteAnswer(id);
    }
}

function deleteAnswer(id) {
    // TODO validate

    $.ajax({
        url: "https://6005956475860e0017c5cd5a.mockapi.io/answer/" + id,
        type: "DELETE",
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlertAnswer();
            buildTableAnswer();
        },
    });
}

function showSuccessAlertAnswer() {
    $("#success-alert")
        .fadeTo(2000, 500)
        .slideUp(500, function() {
            $("#success-alert").slideUp(500);
        });
}

function openViewAnswer(idEmployee) {
    $(".main").load("viewlistanswer.html");

    $.get(
        "https://6005956475860e0017c5cd5a.mockapi.io/answer",
        function(data, status) {
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }
            console.log(idEmployee);
            console.log(data);
            answers = [];
            // success
            data.forEach(function(item) {
                if (item.creatorId == idEmployee) {
                    answers.push(
                        new Answer(item.id, item.title, item.content, item.creatorId)
                    );
                }
            });
            fillAnswerToTable();
        }
    );
}

