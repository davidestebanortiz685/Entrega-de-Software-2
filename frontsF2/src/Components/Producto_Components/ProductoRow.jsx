//funciones para editar un producto y eliminar un producto
function ProductoRow({producto,onEdit,onDelete}){
    const handleEdit = ()=>{
        onEdit(producto)
    }

    const handleDelete = ()=>{
        onDelete(producto.id)
    } 
    //celdas para contener datos de productos y botones para editar y eliminar 
    return(
        <tr>
            <td>|{producto.nombrep}|</td>
            <td>|{producto.precio}|</td>
            <td>|{producto.peso}|</td>
            <td>
                <button onClick={handleEdit}>Edit ✍️ </button>
                <button onClick={handleDelete}>Delete 🗑️</button>
            </td>
        </tr>

    )
    

}
export default ProductoRow