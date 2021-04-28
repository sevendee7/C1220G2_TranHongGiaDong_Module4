<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/result">
    <table>
        <tr>
            <td>First Number</td>
            <td><input type="text" name="number1" id="number1"/></td>
        </tr>
        <tr>
            <td>
                <label for="operator">Choose Operator</label>
            </td>
            <td>
                <select name="operator" id="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second Number</td>
            <td><input type="text" name="number2" id="number2"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Calculate"/></td>
        </tr>
    </table>
</form>
</body>
</html>
