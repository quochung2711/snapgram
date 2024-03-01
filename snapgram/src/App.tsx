import './global.css';
import { Route, Routes } from 'react-router-dom';
import SigninForm from './auth/forms/SigninForm';
import { Home } from './root/pages';
import SignUpForm from './auth/forms/SignUpForm';
import AuthLayout from './auth/forms/AuthLayout';

const App = () => {
  return (
    
    <main className='flex h-screen'>
        <Routes>
            {/* public route */}
            <Route element={<AuthLayout />}>
                <Route path='/sign-in' element={<SigninForm />}></Route>
                <Route path='/sign-up' element={<SignUpForm />}></Route>
            </Route>
            
            {/* private route */}
            <Route index element={<Home />}></Route>
        </Routes>
    </main>
   
  )
}

export default App
