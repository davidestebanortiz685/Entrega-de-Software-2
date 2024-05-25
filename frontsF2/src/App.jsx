 import { useEffect, useState } from 'react' 
import './App.css'
import axios from 'axios'
import ProductoTable from './Components/Producto_Components/ProductoTable'
import ProductoForm from './Components/Producto_Components/ProductoForm'
import ClienteTable from './Components/Cliente_Components/ClienteTable'
import ClienteForm from './Components/Cliente_Components/ClienteForm'


function App() {
  const [productos, setProductos] = useState([])
  const [edittingProducto, setedittingProducto] = useState(null)
  const [clientes, setClientes] = useState([])
  const [edittingCliente, setedittingCliente] = useState(null)

  //Actualiza los cambios realizados desde los clientes
  useEffect(()=>{
    fetchClientes()
  },[])

  //Recorre todos los clientes y los devuelve
  const fetchClientes = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/clientes')
      setClientes(response.data)
    } catch (error) {
      console.log('Error al cargar los clientes : '.error)
    }
  }
  //Crea o Actualiza un Cliente
  const handleCreateOrUpdateCliente = async (clienteData)=>{
    if (edittingCliente) {
      await axios.put(`http://localhost:8080/api/clientes/${edittingCliente.id}`,clienteData)
    } else {
      await axios.post(`http://localhost:8080/api/clientes`,clienteData)
    }
    fetchClientes()
    setedittingCliente(null)
  }
  //permite editar los clientes
  const handleEditCliente = (clientes) =>{
    setedittingCliente(clientes)
    }
  //Permite eliminar un Cliente apartir de una ID
  const handleDeleteCliente = async(ClienteID)=>{
    await axios.delete(`http://localhost:8080/api/clientes/${ClienteID}`)
    fetchClientes()
  }

/////////////////////////////////////////////////////////////////////////////////////////


   //actualiza la lista de productos por cada producto nuevo
   useEffect(()=>{
    fetchProductos()
  },[])

  //Recorre todos los productos y los devuelve
  const fetchProductos = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/productos')
      setProductos(response.data)
    } catch (error) {
      console.log('Error al cargar los productos : '.error)
    }
    fetchProductos()
    setedittingProducto(null)
  }
  
  //Crea o Actualiza un Producto
  const handCreateOrUpdateProducto = async (productoData)=>{
    if (edittingProducto) {
      await axios.put(`http://localhost:8080/api/productos/${edittingProducto.id}`,productoData)
    } else {
      await axios.post(`http://localhost:8080/api/productos`,productoData)
    }
  }
    
  //permite editar los productos
  const handleEditProducto = (productos) =>{
    setedittingProducto(productos)
  }
  //Permite eliminar un Producto apartir de una ID
  const handleDeleteProducto = async(ProductoID)=>{
    await axios.delete(`http://localhost:8080/api/productos/${ProductoID}`)
    fetchProductos()
  }




return (
      <div className='App'>
      <h1>Proyecto Mandi Snap 🍟</h1>
      <br/>
      <h2>Lista de Productos 📋</h2>
      <ProductoTable productos={productos} onEdit={handleEditProducto} onDelete={handleDeleteProducto} />
      <h2>{edittingProducto ?  'Editar Producto' : 'Crear Producto'}</h2>
      <ProductoForm onSubmit={handCreateOrUpdateProducto} initialProducto= {edittingProducto} />
      <br/>

      <h2>Lista de Clientes 📋</h2>
        <ClienteTable clientes={clientes} onEdit={handleEditCliente} onDelete={handleDeleteCliente} />
        <h2>{edittingCliente ?  'Editar Cliente' : 'Crear Cliente'}</h2>
        <ClienteForm onSubmit={handleCreateOrUpdateCliente} initialCliente= {edittingCliente} />
      <br/>
    </div> 

  )
}
export default App
