import React, { useEffect, useState } from 'react';
import PropertyCatalog from './PropertyCatalog';
import './Catalog.css';

const Catalog = () => {
  const [propertyData, setPropertyData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
   const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:19872/api/catalog', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
            // Добавьте другие необходимые заголовки, например, авторизацию
          },
        });

        if (!response.ok) {
          throw new Error('Не удалось получить данные');
        }

        const data = await response.json();
        setPropertyData(data.catalog);
        setIsLoading(false);
      } catch (error) {
        console.error('Ошибка при получении данных:', error.message);
        setIsLoading(false);
      }
    };

    fetchData();
  }, []); // Пустой массив зависимостей означает, что эффект будет выполнен только после монтирования компонента

  return (
    <div className="catalog-container">
      {isLoading ? (
         <p className="loading-message">Загрузка данных...</p>
      ) : (
        Array.isArray(propertyData) && propertyData.length > 0 ? (
          <PropertyCatalog properties={propertyData} />
        ) : (
          <p className="no-data-message">Нет данных для отображения</p>
        )
      )}
    </div>
  );
  
};



export default Catalog;
