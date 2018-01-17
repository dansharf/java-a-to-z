<%@ page language="java" contentType="text/html;charset=UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" charset="utf-8"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" charset="utf-8"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>

    <script>
        $(loadAdverts());

        function loadAdverts() {
            var result = "";
            $.ajax({
                url: './list',
                success: function (data) {
                    result = fillRow(data);
                    document.getElementById("table_body").innerHTML += result;
                    $("#items").dataTable();
                }
            });
        }

        function fillRow(data) {
            var row = "";
            $.each(data, function (i, advert) {
                row += "<tr>" +
                    "<td class='table-td'><img src='./image/" + advert.photo.id + "' alt='Not Photo'" +
                    " style='display: block; width: 100%; margin: 0 auto'></td>" +
                    "<td class='size'>" + advert.title + "<br/>" +
                    "Продавец " + advert.author.name + "<br/>" +
                    "Марка: " + advert.car.carBrand.name + "<br/>Модель: " + advert.car.carModel.name + "<br/>Кузов: "
                    + advert.car.carBody.name + "<br/></td>" +
                    "<td class='table-td'>" + advert.city.name + "</td>" +
                    "<td class='table-td' style='width: 15%;'>" + advert.yearOfIssue + "</td> " +
                    "<td class='table-td'>" + new Date(advert.created).toDateString() + "</td>" +
                    "<td class='table-td'>" + advert.mileage + "</td>" +
                    "<td class='table-td'>" + advert.price + "</td>";
                if (advert.sale) {
                    row += "<td class='table-td'>" +
                        "<input type='checkbox' id='sale' checked='true' onchange='changeBox(" + advert.id + ")'";
                } else {
                    row += "<td class='table-td'>" +
                        "<input type='checkbox' id='sale' onchange='changeBox(" + advert.id + ")'";
                }
                row += "'></td></tr>";
            });
            return row;
        }

        function changeBox(id) {
            var checked = $("#sale").is(":checked");
            $.ajax({
                url: "./update",
                method: "POST",
                data: {"id": id},
                success: function () {
                }
            });
        }
    </script>

</head>
<body>
<div class="container">
    <div style="margin-top: 30px">
        <a href="./add" class="btn btn-info" style="width: 100%">Add new Advert</a>
        <%--<a href="./log-out" class="btn btn-info" style="width: 40%; float: right">Log Out</a>--%>
    </div>
</div>
<div class="container" style="margin-top: 30px">
    <div class="col-md-12">
        <table class="table" id="items">
            <thead>
            <tr>
                <th class="table-td">Фото</th>
                <th class="size">Описание</th>
                <th class="table-td">Город</th>
                <th class="table-td" style="width: 15%;">Год выпуска</th>
                <th class="table-td">Создано</th>
                <th class="table-td">Пробег</th>
                <th class="table-td">Цена</th>
                <th class="table-td">Продано</th>
            </tr>
            </thead>
            <tbody id="table_body"></tbody>
        </table>
    </div>
</div>
</body>
</html>
