package com.examen.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examen.demo.interfaceService.IEmpleadoService;
import com.examen.demo.interfaces.IEmpleado;
import com.examen.demo.modelo.Empleado;
@Service
public class EmpleadoService implements IEmpleadoService{
	@Autowired
	private IEmpleado data;

	@Override
	public List<Empleado> listarEmpleados() {
		
		return (List<Empleado>)data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int idEmpleado) {
		
		return data.findById(idEmpleado);
	}

	@Override
	public int save(Empleado E) {
		int res=0;
		Empleado empleado=data.save(E);
		if(!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idEmpleado) {
		data.deleteById(idEmpleado);
		
	}

}
