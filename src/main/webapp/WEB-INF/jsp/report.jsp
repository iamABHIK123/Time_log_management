<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generate Report</title>
</head>
<body>
    <h2>Generate Report</h2>
    <form action="processGenerate" method="post">
        <label for="month">Select Month:</label>
        <select name="month" id="month">
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
        <br><br>
        <button type="submit">Generate</button>
        <button type="button" onclick="window.location.href='cancel.jsp';">Cancel</button>
    </form>
</body>
</html>
