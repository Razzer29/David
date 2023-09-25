package com.model;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

@Entity
@Table(name = "empleado")
public class Empleado
{
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int idEmpleado;
			private String apellidos;
			private String nombres;
			private int edad;
			@Column(length = 1)
			private String sexo;
			private double salario;



public Empleado() {

}

public Empleado ( int idEmpleado , String apellidos , String nombres , int edad , String sexo , double salario )
{
				 this.idEmpleado = idEmpleado ;
				 this.apellidos = apellidos ;
				 this.nombres = nombres ;
				 this.edad = edad ;
				 this.sexo = sexo ;
				 this.salario = salario ;
}
public Empleado ( String apellidos , String nombres , int edad , String sexo , double salario )
{
				 this.apellidos = apellidos ;
				 this.nombres = nombres ;
				 this.edad = edad ;
				 this.sexo = sexo ;
				 this.salario = salario ;
}

public int getIdEmpleado ( )
{
				 return idEmpleado ;
}

public void setIdEmpleado ( int idEmpleado )
{
				 this.idEmpleado = idEmpleado ;
}

public String getApellidos ( )
{
				 return apellidos ;
}

public void setApellidos ( String apellidos )
{
				 this.apellidos = apellidos ;
}

public String getNombres ( )
{
				 return nombres ;
}

public void setNombres ( String nombres )
{
				 this.nombres = nombres ;
}

public int getEdad ( )
{
				 return edad ;
}

public void setEdad ( int edad )
{
				 this.edad = edad ;
}

public String getSexo ( )
{
				 return sexo ;
}

public void setSexo ( String sexo )
{
				 this.sexo = sexo ;
}

public double getSalario ( )
{
				 return salario ;
}

public void setSalario ( double salario )
{
				 this.salario = salario ;
}



}
