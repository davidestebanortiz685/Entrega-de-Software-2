import { useState } from "react"


function ClienteForm({onSubmit}){
    //funciones que contiene la api 

    const[nombrec,setNombrec]= useState('')
    const[email,setEmail]= useState('')
    const[telefono,setTelefono]= useState('')

    const handleNombrecChange = (event) =>{
        setNombrec(event.target.value)
    }
    const handleEmailcChange = (event) =>{
        setEmail(event.target.value)
    }
    const handleTelefonoChange = (event) =>{
        setTelefono(event.target.value)
    }

    //Funcion para enviar el formulario
    const handleSubmit = (event) =>{
        event.preventDefault()
        onSubmit({nombrec,email,telefono})
        setNombrec('')
        setEmail('')
        setTelefono('')
    }
            
    //contiene el boton para agregar cliente y las casillas para ingresar la informacion

    return(
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Nombre del Cliente" value ={nombrec} onChange={handleNombrecChange} />
            <input type="email" placeholder="Email" value ={email} onChange={handleEmailcChange} />
            <input type="text" placeholder="Telefono" value ={telefono} onChange={handleTelefonoChange} />

            <button type="submit"> Guardar </button>
        </form>
    )
}
export default ClienteForm