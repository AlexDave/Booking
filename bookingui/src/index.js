import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import RegistrationForm from './RegistrationForm';
import Catalog from './Catalog';
import Order from './Order';
import PropertyInfo from './PropertyInfo';

const root = ReactDOM.createRoot(document.getElementById('root'));
const router = createBrowserRouter([
  {
    path: "/",
    element: <RegistrationForm/>,
  },
  {
    path: "/catalog/:id",
    element: <PropertyInfo/>,
  },
  {
    path: "/catalog",
    element: <Catalog/>,
  },
  {
    path: "/order/:id",
    element: <Order/>,
  }
  

]);
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

