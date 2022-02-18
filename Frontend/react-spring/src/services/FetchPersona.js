import axios from "axios";

const query = "http://localhost:8080";

const agregarPersona = async (persona) =>
{
   return await axios.post(`${query}/agregar`, (persona));    
};

const traerPersonas = async () =>
{   
    const {data} = await axios.get(`${query}/personas`);
    return data;
}

const traerPersona = async (id) =>
{
    const {data} = await axios.get(`${query}/persona/${id}`)
    return data;
}

const editarPersona = async (persona, id) =>
{
    return await axios.put(`${query}/editar/${id}`,persona)
}

const eliminarPersona = async (id) =>
{
    return await axios.delete(`${query}/eliminar/${id}`);
}

export default {agregarPersona, traerPersonas, traerPersona, editarPersona, eliminarPersona};