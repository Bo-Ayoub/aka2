<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="aka.StoreResult"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Quiz Result</title>
</head>
<body>
<div class="container-fluid p-2 mt-3" style="width: 70%; margin: auto;">
    <center><u><h1>Quiz Result</h1></u></center><br>
    <h5>Score: <%=session.getAttribute("score") %>/10</h5>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">QNo.</th>
            <th scope="col">Question</th>
            <th scope="col">Option A</th>
            <th scope="col">Option B</th>
            <th scope="col">Option C</th>
            <th scope="col">Option D</th>
            <th scope="col">Your Answer</th>
            <th scope="col">Correct Answer</th>
        </tr>
        </thead>
        <tbody>
        <%
        for (int i = 0; i < 10; i++) {
            String rowClass = "";
            if (!StoreResult.useranswer[i].equals(StoreResult.answer[i])) {
                // Incorrect answer - apply red warning
                rowClass = "table-danger";
            } else {
                // Correct answer - apply green indication
                rowClass = "table-success";
            }
        %>
        <tr class="<%= rowClass %>">
            <td scope="row"><%= i + 1 %></td>
            <td><%= StoreResult.question[i] %></td>
            <td><%= StoreResult.A[i] %></td>
            <td><%= StoreResult.B[i] %></td>
            <td><%= StoreResult.C[i] %></td>
            <td><%= StoreResult.D[i] %></td>
            <td><%= StoreResult.useranswer[i] %></td>
            <td><%= StoreResult.answer[i] %></td>
        </tr>
        <%
        }
        %>
        </tbody>
    </table>
    <div style="text-align: center">
        <h2><a href="Quiz.jsp" class="btn btn-secondary" role="button">Back To Quiz Page</a></h2>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>