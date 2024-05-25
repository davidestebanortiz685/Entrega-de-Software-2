import ProductoRow from "./ProductoRow"
//codigo html para encabezado de las funciones 

function ProductoTable({productos,onEdit,onDelete}){

    return(
        <table>
            <thead>
                <tr>
                    <th>|NOMBRE DEL PRODUCTO|</th>
                    <th>|PRECIO|</th>
                    <th>|PESO|</th>
                </tr> 
            </thead>
            <tbody>
                {productos.map((producto)=>(
                    <ProductoRow key={producto.id} producto ={producto}onEdit={onEdit} onDelete={onDelete} />
                )

                )}
            </tbody>
        </table>
    )

}
export default ProductoTable