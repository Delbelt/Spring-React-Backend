package app.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.datos.Persona;
import app.repository.PersonaRepository;
import app.services.PersonaService;

@Service //Declara la clase como Servicio, Importante para el correcto funcionamiento de la aplicacion
public class PersonaABM implements PersonaService {	
	
	 //TODO Gestiona las operaciones de negocio de Persona
	
	@Autowired() //Inyeccion del repositorio
	private PersonaRepository repository;
	
	//TODO Transactional crea operaciones automaticas (Begin and Close)
	
	@Override
	@Transactional(readOnly = true) //Solo lectura
	public Persona traerPersona(Long id)
	{
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true) //Solo lectura
	public List<Persona> traerListaPersona()
	{
		return repository.findAll();
	}

	@Override
	@Transactional //Commit - Rollback
	public void guardarPersona(Persona persona)
	{
		repository.save(persona);
	}	

	@Override
	@Transactional //Commit - Rollback
	public Persona editarPersona(Persona persona)
	{
		return repository.save(persona);
	}

	@Override
	@Transactional // Commit - Rollback
	public void eliminarPersona(Long id)
	{
		repository.deleteById(id);			
	}
}
