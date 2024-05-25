import {useState} from "react"
import { getAuth, signInWithEmailAndPassword } from "firebase/auth";
import { firebaseApp } from "../../firebaseConfig";
function Login (){
 
    const [email,setEmail]=useState('')
    const [password,setPassword] = useState('')
    const [errorMessage,setErrorMessage]=useState('')

    const handleLogin = async () =>{
        try {
            const auth = getAuth(firebaseApp)
            await signInWithEmailAndPassword(auth,email,password)
            console.log('User created successfully')
            setErrorMessage('Ingresado exitosamente')
        } catch (error) {
            console.log('Hubo un error al logearse, intente mas tarde', error.message)
            setErrorMessage("Credenciales invalidas")
        }
    }

    return(
        <div className="register">
            <h2>Login</h2>
            <input type = "email" placeholder="Email" value= {email} onChange={(e)=> setEmail(e.target.value)}/>
            <input type = "password" placeholder="Password" value= {password} onChange={(e)=> setPassword(e.target.value)}/>
            <button    onClick={handleLogin}>Login</button>
            {errorMessage && <p>{errorMessage}</p>}
        </div>
    )
}
export default Login