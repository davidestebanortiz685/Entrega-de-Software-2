import { useState } from "react"

function ClienteForm ({onSubmit}){
    //funciones que contiene la api 
    const[nombrep,setNombrep]= useState('')
    const[precio,setPrecio]= useState('')
    const[peso,setPeso]= useState('')

    const handleNombrepChange = (event) =>{
        setNombrep(event.target.value)
    }
    const handlePrecioChange = (event) =>{
        setPrecio(event.target.value)
    }
    const handlePesoChange = (event) =>{
        setPeso(event.target.value)
    }
    //Funcion para enviar el formulario
    const handleSubmit = (event) =>{
        event.preventDefault()
        onSubmit({nombrep,precio,peso})
        setNombrep('')
        setPrecio('')
        setPeso('')
    }
    //contiene el boton para agregar productos y las casillas para ingresar la informacion
    return(
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Nombre Producto" value ={nombrep} onChange={handleNombrepChange} required/>
            <input type="text" placeholder="Precio" value ={precio} onChange={handlePrecioChange} required/>
            <input type="text" placeholder="Peso" value ={peso} onChange={handlePesoChange} required/>

            <button type="submit"> Guardar </button>
        </form>
    )
}
export default ClienteForm