package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.datos.Persona;

@Repository //Lo declara como Repositorio (Muy importante) - Basado en el Patron Repositorio
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	// TODO Extiende de JpaRepository [Contenedora de los metodos CRUD], no obstante, se pueden agregar Querys personalizables mas adelante
}