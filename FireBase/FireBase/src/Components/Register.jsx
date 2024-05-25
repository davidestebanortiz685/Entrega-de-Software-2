import {useState} from "react"
import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";
import { firebaseApp } from "../../firebaseConfig";
function Register (){

    const [email,setEmail]=useState('')
    const [password,setPassword] = useState('')
    const [errorMessage,setErrorMessage]=useState('')

    const handleRegister = async () =>{
        try {
            const auth = getAuth(firebaseApp)
            await createUserWithEmailAndPassword(auth,email,password)
            console.log('User created successfully')
            setErrorMessage('El usuario fue creado con exito')
        } catch (error) {
            console.log('Hubo un error al registrar el usuario', error.message)
            setErrorMessage('Error para crear un usuario')
        }
    }

    return(
        <div className="register">
            <h2>Register</h2>
            <input type = "email" placeholder="Email" value= {email} onChange={(e)=> setEmail(e.target.value)}/>
            <input type = "password" placeholder="Password" value= {password} onChange={(e)=> setPassword(e.target.value)}/>
            <button    onClick={handleRegister}>Register</button>
            {errorMessage && <p>{errorMessage}</p>}
        </div>
    )
}
export default Register