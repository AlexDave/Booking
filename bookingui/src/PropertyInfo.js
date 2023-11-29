// PropertyInfo.js

import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './PropertyInfo.css';
import { en } from "date-fns/locale/ru/index.js";
import RandomImage from './RandomImage';
import Cookies from 'js-cookie';

const PropertyInfo = () => {
  const { id } = useParams();
  const [property, setProperty] = useState(null);
  const [loading, setLoading] = useState(true);
  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);



  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:19872/api/catalog/getInfo?id=${id}`);
        if (!response.ok) {
          throw new Error('Ошибка при загрузке данных');
        }
        const data = await response.json();
        setProperty(data);
      } catch (error) {
        console.error('Ошибка:', error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [id]);

  const handleStartDateChange = (date) => {
    setStartDate(date);
  };

  const handleEndDateChange = (date) => {
    setEndDate(date);
  };

 

  const handleBooking = async () => {
    try {

      const response = await fetch('http://localhost:1212/api/order', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          userId: parseInt(Cookies.get('userId')),
          realEstateId: parseInt(id),
          orderDateFrom: startDate.toISOString().slice(0, 10),
          orderDateTo: endDate.toISOString().slice(0, 10),
        }),
      });

      if (!response.ok) {
        throw new Error('Ошибка при отправке заказа');
      }

      // Добавьте обработку успешного ответа по необходимости
      console.log('Заказ успешно отправлен');
      window.location.assign('/order/'+Cookies.get('userId'));

    } catch (error) {
      console.error('Ошибка:', error);
    }
  };

  if (loading) {
    return <p>Loading...</p>;
  }

  if (!property) {
    return <p>Недвижимость не найдена</p>;
  }

  return (
    
    <div className="property-info-container" style={{ backgroundImage: `url('/path/to/your/background.jpg')` }}>
      <div className="overlay">
        <RandomImage/>
        <div className="property-details">
          <h2>{property.city}</h2>
          <p>{property.address}</p>
          <p>Цена: {property.priceForDay}</p>
          <p>Pets Friendly: {property.petsFriendly ? 'Yes' : 'No'}</p>
          <p>Kids Friendly: {property.kidsFriendly ? 'Yes' : 'No'}</p>

          <DatePicker
            dateFormat="dd-MM-yyyy"
            locale={en}
            selected={startDate}
            onChange={handleStartDateChange}
            selectsStart
            startDate={startDate}
            endDate={endDate}
            placeholderText="Дата заезда"
          />
          <DatePicker
            dateFormat="dd-MM-yyyy"
            locale={en}
            selected={endDate}
            onChange={handleEndDateChange}
            selectsEnd
            startDate={startDate}
            endDate={endDate}
            placeholderText="Дата выезда"
          />
          <button onClick={handleBooking}>Забронировать</button>
        </div>
      </div>
    </div>
  );
};

export default PropertyInfo;
