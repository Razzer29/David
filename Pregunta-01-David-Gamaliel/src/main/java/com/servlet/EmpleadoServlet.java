package com.servlet;

import com.dao.EmpleadoDao;
import com.dao.EmpleadoDaoImpl;
import com.model.Empleado;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpleadoDao empleadoDao;

    public EmpleadoServlet() {
        super();
        // Inicializar el DAO de Empleado
        empleadoDao = new EmpleadoDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // Acción predeterminada: listar empleados
        }

        switch (action) {
            case "list":
                listarEmpleados(request, response);
                break;
            case "add":
                mostrarFormularioAgregar(request, response);
                break;
            case "insert":
                agregarEmpleado(request, response);
                break;
            case "edit":
                mostrarFormularioEditar(request, response);
                break;
            case "update":
                actualizarEmpleado(request, response);
                break;
            case "delete":
                eliminarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleados = empleadoDao.listar();
        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("/lista-empleados.jsp").forward(request, response);

    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("agregar-empleado.jsp").forward(request, response);
    }

    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double salario = Double.parseDouble(request.getParameter("salario"));

        Empleado nuevoEmpleado = new Empleado(apellidos, nombres, edad, sexo, salario);
        empleadoDao.añadir(nuevoEmpleado);

        response.sendRedirect("EmpleadoServlet");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = empleadoDao.obtener(id);

        request.setAttribute("empleado", empleado);
        request.getRequestDispatcher("editar-empleado.jsp").forward(request, response);
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double salario = Double.parseDouble(request.getParameter("salario"));

        Empleado empleadoActualizado = new Empleado(id, apellidos, nombres, edad, sexo, salario);
        empleadoDao.actualizar(empleadoActualizado);

        response.sendRedirect("EmpleadoServlet");
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);

        empleadoDao.eliminar(empleado);

        response.sendRedirect("EmpleadoServlet");
    }
}
