import ClienteRow from "./ClienteRow"
//codigo html para encabezado de las funciones 

function ClienteTable({clientes,onEdit,onDelete}){

    return(
        <table>
            <thead>
                <tr>
                    <th>|NOMBRE DEL CLIENTE|</th>
                    <th>|EMAIL|</th>
                    <th>|TELEFONO|</th>
                </tr> 
            </thead>
            <tbody>
                {clientes.map((cliente)=>(
                    <ClienteRow key={cliente.id} cliente ={cliente} onEdit={onEdit} onDelete={onDelete} />
                )

                )}
            </tbody>
        </table>
    )

}
export default ClienteTable