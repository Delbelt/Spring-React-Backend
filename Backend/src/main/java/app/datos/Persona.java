package app.datos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //Agrega el Boilerplate de manera automatica
@Entity //Entidad de persistencia
@Table(name = "persona") //No es necesario, pero se usa en caso de fallar el case sensitive como buena practica
public class Persona implements Serializable {
	
	//TODO Serializable: La serializacion convierte el objeto en una secuencia de bytes para ser almacenado o transmitido a una base de datos o archivo.
	//Guarda el estado de un objeto para poder volver a crearlo cuando sea necesario
	
	private static final long serialVersionUID = 1L;
	
	@Id //Atributo que sera considerado como identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersona;

	private String nombre;	

	private String apellido;	

	private Long dni;
}
