// PropertyCard.js

import React from 'react';
import './PropertyCatalog.css';
import RandomImage from './RandomImage';
import { Link } from 'react-router-dom';

const PropertyCard = ({ property }) => {

  return (
    <div className="property-card">
        <Link to={`/catalog/${property.id}`}>
            <RandomImage />
            <h3>{property.city}</h3>
            <p>{property.address}</p>
            <p className="price">Цена: {property.priceForDay}</p>
        </Link>
    </div>
    
  );
};

export default PropertyCard;
