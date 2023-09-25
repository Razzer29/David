<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Lista de Empleados</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table border="1" class="table table-dark table-striped-columns">
        <tr>
            <th>ID</th>
            <th>Apellidos</th>
            <th>Nombres</th>
            <th>Edad</th>
            <th>Sexo</th>
            <th>Salario</th>
            <th>Acciones</th>
        </tr>
        <c:forEach items="${empleados}" var="empleado">
            <tr>
                <td>${empleado.idEmpleado}</td>
                <td>${empleado.apellidos}</td>
                <td>${empleado.nombres}</td>
                <td>${empleado.edad}</td>
                <td>${empleado.sexo}</td>
                <td>${empleado.salario}</td>
                <td>
                    <a href="EmpleadoServlet?action=edit&id=${empleado.idEmpleado}" class="btn btn-primary">Editar</a>
                    
                    <a href="EmpleadoServlet?action=delete&id=${empleado.idEmpleado}" class="btn btn-danger m-1">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="EmpleadoServlet?action=add" class="btn btn-primary">Agregar Empleado</a>
</body>
</html>
