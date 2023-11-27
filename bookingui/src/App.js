import React from 'react';
import {
    Route,
    Routes,
} from 'react-router-dom';
import RegistrationForm from './RegistrationForm';
import Catalog from './Catalog';
import Order from './Order';
import PropertyInfo from './PropertyInfo';

export const App = () => (
    
    <Routes>
        <Route path="/order/:id">
            <Order />
        </Route>
        <Route path="/catalog/:id">
            <PropertyInfo/>
        </Route>
        <Route path="/catalog">
            <Catalog/>
        </Route>
        <Route path="/">
            <RegistrationForm />
        </Route>
    </Routes>
);



export default App;