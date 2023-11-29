// Order.js

import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import './Order.css';

const Order = () => {
  const { id } = useParams();
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    // Загрузите данные о бронированиях при монтировании компонента
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:1212/api/order/getInfoByUser?id=${id}`);
        if (!response.ok) {
          throw new Error('Не удалось получить данные о бронированиях');
        }
        const data = await response.json();
        setReservations(data);
      } catch (error) {
        console.error('Ошибка при получении данных о бронированиях:', error.message);
      }
    };

    fetchData();
  }, [id]);

  const handleReturnToCatalog = () => {
    // Используйте navigate для программной навигации
    window.location.assign('/catalog/');
  };

  return (
    <div className="order-container">
      <h2>Список бронирований</h2>
      <table>
        <thead>
          <tr>
            <th>Ид</th>
            <th>Город</th>
            <th>Адрес</th>
            <th>Дата с</th>
            <th>Дата по</th>
            <th>Цена за ночь</th>
            <th>Статус</th>
          </tr>
        </thead>
        <tbody>
          {reservations.map((reservation) => (
            <tr key={reservation.id}>
              <td>{reservation.id}</td>
              <td>{reservation.city}</td>
              <td>{reservation.address}</td>
              <td>{reservation.checkIn}</td>
              <td>{reservation.checkOut}</td>
              <td>{reservation.priceForDay}</td>
              <td>{reservation.status}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <button onClick={handleReturnToCatalog}>Вернуться в каталог</button>
    </div>
  );
};

export default Order;
