import React from 'react';
import PropertyCard from './ProdertyCard';
import './PropertyCatalog.css';

const PropertyCatalog = ({ properties }) => (
    <div className="property-catalog">
    {properties.map((property, id) => (
      <PropertyCard key={id} property={property} />
    ))}
  </div>
  );
  
  export default PropertyCatalog;