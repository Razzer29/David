package com.view ;



import java.awt.Menu ;
import java.util.Scanner ;


import javax.persistence.criteria.CriteriaBuilder.Case ;

import com.dao.EmpleadoDao ;
import com.dao.EmpleadoDaoImpl ;
import com.model.Empleado ;


public class Console
{
				 
				 public static void main ( String[] args )
				 {
									EmpleadoDao dao = new EmpleadoDaoImpl() ;
									
									Scanner entrada = new Scanner(System.in) ;
									
									System.out.println("1) Listar\n2)Agregar\n3)Editar\n4) Eliminar\n5) Salir") ;
									
									System.out.print("Escoge la accion que quieres realizar: ") ;
									int option = entrada.nextInt() ;
									entrada.nextLine() ;
									switch ( option )
									{
													 case 1 :
																		for ( Empleado e : dao.listar() )
																						 System.out.println("Id : " + e.getIdEmpleado() + "| Empleado : " + e.getNombres() + " " + e.getApellidos() + "| Edad: " + e.getEdad()
																															 + "|Sexo : " + e.getSexo() + "| Salario : " + e.getSalario()) ;
																		break ;
													 case 2 :
																		System.out.print("Ingrese el Nombre: ") ;
																		String nombre = entrada.nextLine() ;
																		System.out.println("Ingresa el Apellido: ") ;
																		String apellidos = entrada.nextLine() ;
																		System.out.println("Ingresar la edad: ") ;
																		int edad = entrada.nextInt() ;
																		entrada.nextLine() ;
																		System.out.println("Ingrese el sexo (M/F):") ;
																		String sexo = entrada.next() ;
																		System.out.println("Ingrese el salario (1500 - 2500): ") ;
																		double salario = entrada.nextDouble() ;
																		entrada.nextLine() ;
																		Empleado empleado = new Empleado(apellidos, nombre, edad, sexo, salario) ;
																		dao.añadir(empleado) ;
																		;
																		System.out.println("Se agrego correctamente") ;
																		break ;
													 case 3 :
																		System.out.print("Ingrese el id del empleado que quiere editar: ") ;
																		int id_editar = entrada.nextInt() ;
																		entrada.nextLine() ;
																		Empleado empleado_editar = dao.obtener(id_editar) ;
																		System.out.print("Ingrese el nuevo Nombre: ") ;
																		String nombre_Edit = entrada.nextLine() ;
																		System.out.println("Ingresa el nuevo Apellido: ") ;
																		String apellidos_edit = entrada.nextLine() ;
																		System.out.println("Ingresar la nueva edad: ") ;
																		int edad_edit = entrada.nextInt() ;
																		entrada.nextLine() ;
																		System.out.println("Ingrese el sexo (M/F):") ;
																		String sexo_edit = entrada.next() ;
																		System.out.println("Ingrese el nuevo salario (1500 - 2500): ") ;
																		double salario_edit = entrada.nextDouble() ;
																		
																		empleado_editar.setSexo(sexo_edit) ;
																		empleado_editar.setApellidos(apellidos_edit) ;
																		empleado_editar.setEdad(edad_edit) ;
																		empleado_editar.setNombres(nombre_Edit) ;
																		empleado_editar.setSalario(salario_edit) ;
																		
																		dao.actualizar(empleado_editar) ;
																		break ;
													 case 4 :
																		
																		entrada.nextLine() ;
																		System.out.println("Ingrese el id del empleado que va a eliminar: ") ;
																		int id_eliminar = entrada.nextInt() ;
																		Empleado empleado_eliminar = dao.obtener(id_eliminar) ;
																		dao.eliminar(empleado_eliminar) ;
																		System.out.println("Se elimino correctamente") ;
																		;
																		break ;
													 
									}
									
				 }
				 
}
