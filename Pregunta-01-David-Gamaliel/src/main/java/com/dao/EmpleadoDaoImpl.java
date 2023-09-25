package com.dao ;



import java.util.List ;


import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence ;

import com.model.Empleado ;


public class EmpleadoDaoImpl implements EmpleadoDao
{

				 private final EntityManagerFactory factory ;

				 public EmpleadoDaoImpl ( )
				 {
									factory = Persistence.createEntityManagerFactory("ConnectionXML") ;
				 }

				 @ Override
				 public void añadir ( Empleado e )
				 {
									EntityManager manager = factory.createEntityManager() ;
									manager.getTransaction().begin() ;
									manager.persist(e) ;
									manager.getTransaction().commit() ;

				 }

				 @ Override
				 public void actualizar ( Empleado e )
				 {
									EntityManager manager = factory.createEntityManager() ;
									manager.getTransaction().begin() ;
									manager.merge(e) ;
									manager.getTransaction().commit() ;
				 }

				 @ Override
				 public Empleado obtener ( int id )
				 {
									EntityManager manager = factory.createEntityManager() ;
									return manager.find(Empleado.class, id) ;
				 }

				 @ Override
				 public void eliminar ( Empleado e )
				 {

									EntityManager manager = factory.createEntityManager() ;
									Empleado em = manager.find(Empleado.class, e.getIdEmpleado()) ;

									if ( em != null )
									{
													 manager.getTransaction().begin() ;
													 manager.remove(e) ;
													 manager.getTransaction().commit() ;
									}
				 }

				 @ Override
				 public List<Empleado> listar ( )
				 {
									EntityManager manager = factory.createEntityManager() ;

									return manager.createQuery("Select e from Empleado e",Empleado.class).getResultList() ;
				 }

}
