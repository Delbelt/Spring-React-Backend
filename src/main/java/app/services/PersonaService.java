package app.services;

import java.util.List;

import app.datos.Persona;

public interface PersonaService { 
	
	//TODO Declara las firmas de los metodos que vamos a usar en la capa de Negocio para refactorizar el codigo
	
	//CRUD Persona
	public Persona traerPersona(Long id);
	public List<Persona> traerListaPersona();
	public void guardarPersona(Persona persona);
	public Persona editarPersona(Persona persona);
	public void eliminarPersona(Long id);
}