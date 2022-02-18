package app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.datos.Persona;
import app.negocio.PersonaABM;

@RestController //Controlador
@RequestMapping("/") //Ruta principal
@CrossOrigin(origins = "http://localhost:3000") //Habilita el intercambio de recursos de origen cruzado con React - (CORS)
public class PersonaControlador {
	
	@Autowired(required=true) //Inyeccion de la capa de Negocio - Required = Indica si el atributo es obligatorio
	private PersonaABM sistema;
	
	//TODO PathVariable: Configura variables "/persona/ '{id}' " dentro de los propios segmentos de la URL 'Esto seria el PathVariable'
	
	@GetMapping("/persona/{id}")
	public Persona traerPersona(@PathVariable("id") Long id) //Trae una persona por id
	{
		return sistema.traerPersona(id);
	}
	
	@GetMapping("/personas")
	public List<Persona> traerPersonas() //Trae todas las personas de la BD
	{
		return sistema.traerListaPersona();
	}
	
	//TODO @RequestBody: Necesita un cuerpo para realizar la accion, en este caso una persona: {nombre, apellido, dni}
	
	@PostMapping("/agregar")
	public String agregarPersona(@RequestBody Persona persona)
	{
		sistema.guardarPersona(persona);
		
		return "Persona " + persona.getIdPersona() + " agregada correctamente";
	}
		
	@PutMapping("/editar/{id}")
	public String editarPersona(@PathVariable("id") Long id,@RequestBody Persona persona) throws Exception
	{
		Persona objeto = sistema.traerPersona(id);
		
		objeto.setNombre(persona.getNombre());
		objeto.setApellido(persona.getApellido());
		objeto.setDni(persona.getDni());
		
		sistema.editarPersona(objeto);
		return "Persona " + objeto.getIdPersona() +" modificada correctamente";		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarPersona(@PathVariable("id") Long id) throws Exception
	{
		sistema.eliminarPersona(id);
		
		return "Persona "+ id +" Eliminada correctamente";
	}	
}