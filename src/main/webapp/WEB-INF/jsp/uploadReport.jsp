<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Excel File</title>
    <style>
        body  {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        h2 {
            margin-top: 20px;
        }
        form {
            margin-top: 20px;
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        select, input[type="file"] {
            margin-bottom: 10px;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        button[type="submit"] {
            margin-right: 10px;
        }
        button[type="button"] {
            background-color: #dc3545;
        }
    </style>
</head>
<script>
function handleUploadFile() {
    var selectedType = document.getElementById('sheetType').value;
    console.log("Selected sheet type: " + selectedType);
    
    var fileInput = document.getElementById('file');
    fileInput.click();
}

function uploadFile() {
    var selectedType = document.getElementById('sheetType').value;
    console.log("Selected sheet type: " + selectedType);
    
    var fileInput = document.getElementById('file');
    var file = fileInput.files[0];
    console.log("Selected file: " + file.name);
    
    // Create FormData object
    var formData = new FormData();
    formData.append('file', file);
    formData.append('sheetType', selectedType);
    
    // Perform AJAX request or other actions with formData
}
</script>
<body>
    <h2>Upload Excel File</h2>
    <form action="processUpload" method="post" enctype="multipart/form-data">
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
        <label for="sheetType">Select report type:</label>
        <select name="sheetType" id="sheetType">
            <option value="leaveReport">Leave Report</option>
            <option value="timesheetReport">Timesheet Report</option>
            <option value="resourceReport">Resource Report</option>
        </select>
        <br><br>
        <input type="file" name="file" id="file" accept=".xlsx, .xls" style="display: none;">
        <button type="button" onclick="handleUploadFile();">Upload</button>
        <button type="button" onclick="window.location.href='cancel.jsp';">Cancel</button>
    </form>
</body>
</html>
