package com.examen.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.examen.demo.modelo.Empleado;

public interface IEmpleadoService {
	public List<Empleado>listarEmpleados();
	public Optional<Empleado>listarId(int id);
	 public int save (Empleado E);
	 public void delete(int id);

}
