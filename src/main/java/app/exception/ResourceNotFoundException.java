package app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //La forma estandar de enviar el "Not found" de forma estatica y no dinamica (Personalizar el mensaje)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String mensaje) //Constructor
	{
		super(mensaje); //Le paso el mensaje a RuntimeException
	}
}