import { useState } from "react"


function ClienteForm({onsubmit}){
    //funciones que contiene la api 

    const[nombrec,setNombrec]= useState('')
    const[email,setEmail]= useState('')
    const[telefono,setTelefono]= useState('')

    const handlenombrecChange = (event) =>{
        setNombrec(event.target.value)
    }
    const handleemailcChange = (event) =>{
        setEmail(event.target.value)
    }
    const handletelefonoChange = (event) =>{
        setTelefono(event.target.value)
    }

    //Funcion para enviar el formulario
    const handleSubmit = (event) =>{
        event.preventDefault()
        onsubmit({nombrec,email,telefono})
        setNombrec('')
        setEmail('')
        setTelefono('')
    }
            
    //contiene el boton para agregar cliente y las casillas para ingresar la informacion

    return(
        <form onsubmit={handleSubmit}>
            <input type="text" placeholder="Nombre del Cliente" value ={nombrec} onChange={handlenombrecChange} />
            <input type="email" placeholder="Email" value ={email} onChange={handleemailcChange} />
            <input type="text" placeholder="Telefono" value ={telefono} onChange={handletelefonoChange} />

            <button type="submit"> Guardar </button>
        </form>
    )
}
export default ClienteForm