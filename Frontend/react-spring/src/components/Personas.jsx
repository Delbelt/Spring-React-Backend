import React from 'react'
import UsePersona from '../hooks/UsePersona';
import Tabla from './Tabla';

const Personas = () =>
{
    const {mensaje, handleAdd, handleDelete, handleEdit, handleFind, lista} = UsePersona();

    return(
        <React.Fragment>            
            <h2>Crud Personas</h2>
            <hr/>
            <h3>Mensaje: {mensaje}</h3>
                <button onClick={handleAdd}>Agregar Persona</button> {""}            
                <button onClick={handleDelete}>Eliminar Persona</button> {""}
                <button onClick={handleEdit}>Editar Persona</button> {""}
                <button onClick={handleFind}>Traer Persona</button>
            <hr/>
            <Tabla dato={lista}/>            
        </React.Fragment>
    );
}

export default Personas