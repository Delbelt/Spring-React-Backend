import React from 'react'
import PropTypes from "prop-types";

const Tabla = ({dato}) =>
{
    return(
        <React.Fragment>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th> 
                        <th>Dni</th>                                                                                      
                    </tr>
                </thead>
               
                <tbody>
                    {dato && //Si existe el dato
                        dato.map((objeto)=>
                        {
                            return(
                            <tr key={objeto.idPersona}> 
                                <td>{objeto.idPersona}</td>
                                <td>{objeto.nombre}</td>
                                <td>{objeto.dni}</td>                            
                            </tr>)
                        })                   
                    }
                </tbody>
            </table> 
        </React.Fragment>
    );
}

Tabla.propTypes =
{
    dato: PropTypes.array, //El dato tiene que ser un array
};

export default Tabla;