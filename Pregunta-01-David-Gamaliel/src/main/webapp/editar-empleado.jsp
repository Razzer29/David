<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    
    <!-- Enlace al archivo CSS de Bootstrap desde un CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Editar Empleado</h1>
        <form action="EmpleadoServlet?action=update" method="POST">
            <input type="hidden" name="id" value="${empleado.idEmpleado}">
            <div class="form-group">
                <label for="apellidos">Apellidos:</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" value="${empleado.apellidos}" required>
            </div>
            <div class="form-group">
                <label for="nombres">Nombres:</label>
                <input type="text" class="form-control" id="nombres" name="nombres" value="${empleado.nombres}" required>
            </div>
            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" class="form-control" id="edad" name="edad" value="${empleado.edad}" required>
            </div>
            <div class="form-group">
                <label for="sexo">Sexo (M/F):</label>
                <input type="text" class="form-control" id="sexo" name="sexo" value="${empleado.sexo}" required>
            </div>
            <div class="form-group">
                <label for="salario">Salario:</label>
                <input type="number" step="0.01" class="form-control" id="salario" name="salario" value="${empleado.salario}" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
        <br>
        <a href="EmpleadoServlet" class="btn btn-secondary">Volver a la Lista</a>
    </div>
    
    <!-- Enlace al archivo JavaScript de Bootstrap desde un CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
