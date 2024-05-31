function ClienteRow({cliente,onEdit,onDelete}) {
    const handleEdit = ()=>{
        onEdit(cliente)
    }

    const handleDelete = ()=>{
        onDelete(cliente.id)
    } 
    //celdas para contener datos de cliente y botones para editar y eliminar 

    return(
        <tr>
            <td>|{cliente.nombrec}|</td>
            <td>|{cliente.email}|</td>
            <td>|{cliente.telefono}|</td>
            <td>
                <button onClick={handleEdit}>Edit ✍️ </button>
                <button onClick={handleDelete}>Delete 🗑️</button>
            </td>
        </tr>

    )
    

}
export default ClienteRow