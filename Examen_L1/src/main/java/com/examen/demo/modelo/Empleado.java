package com.examen.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String apellidos;
   private String nombres;
   private int edad;
   private char sexo;
   private int salario ;
   public Empleado() {
	// TODO Auto-generated constructor stub
}
public Empleado(int id, String apellidos, String nombres, int edad, char sexo,int salario) {
	super();
	this.id = id;
	this.apellidos = apellidos;
	this.nombres = nombres;
	this.edad = edad;
	this.sexo = sexo;
	this.salario = salario;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public char getSexo() {
	return sexo;
}
public void setSexo(char sexo) {
	this.sexo = sexo;
}
public double getSalario() {
	return salario;
}
public void setSalario(int salario) {
	this.salario = salario;
}
   
}
