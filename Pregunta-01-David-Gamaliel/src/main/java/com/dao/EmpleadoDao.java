package com.dao;

import java.util.List ;


import com.model.Empleado ;

public interface EmpleadoDao
{
				public void añadir(Empleado e);
				public void actualizar(Empleado e);
				public Empleado obtener(int id);
				public void eliminar(Empleado e);
				public List<Empleado> listar();
}
