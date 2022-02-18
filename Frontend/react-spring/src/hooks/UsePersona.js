import { useEffect, useState } from "react";
import FetchPersona from "../services/FetchPersona";

const UsePersona = () =>
{
    const [lista, setLista] = useState([]); //Lista de las personas
    const [mensaje, setMensaje] = useState(""); //Para ver el estatus
    const [fetch, SetFetch] = useState(true); //Para alterar las peticiones

    const persona = //Array para hacer las pruebas
    {
        "nombre": "Nombre",
        "apellido": "Apellido",
        "dni": 1234
    }

    const handleAdd = () => //Peticion de agregar Persona
    {
        FetchPersona.agregarPersona(persona); 
        setMensaje("Persona agregada Correctamente");
        SetFetch(!fetch);
    }
    
    const handleDelete = async() => //Peticion de eliminar Persona
    {
        const ultimaPosicion = lista.length ? `${Number(lista.length - 1)}` : "1";
        const id = lista[ultimaPosicion].idPersona;

        await FetchPersona.eliminarPersona(id);
        setMensaje("Persona eliminada Correctamente");
        SetFetch(!fetch);
    }

    const handleEdit = async () => //Peticion de editar Persona
    {
        const personaEdit = 
        {
            "nombre": "NombreEditado",
            "apellido": "ApellidoEditado",
            "dni": 9999
        }

        const ultimaPosicion = lista.length ? `${Number(lista.length - 1)}` : "1";
        const id = lista[ultimaPosicion].idPersona;

        await FetchPersona.editarPersona(personaEdit, id);
        setMensaje("Persona Editada correctamente");
        SetFetch(!fetch);
    }

    const handleFind = async () => //Peticion de buscar una persona por Id
    {
        const ultimaPosicion = lista.length ? `${Number(lista.length - 1)}` : "1";
        const id = lista[ultimaPosicion].idPersona;

        console.log(await FetchPersona.traerPersona(id));
    }

    const peticion = async () => //Peticion general que trae las personas
    {
        setLista(await FetchPersona.traerPersonas());
    }

    useEffect (()=> //volvera a pedir los datos cuando se genera una peticion
    {
        peticion();
    },[fetch])

    return {mensaje, handleAdd, handleDelete, handleEdit, handleFind, lista};
};

export default UsePersona;