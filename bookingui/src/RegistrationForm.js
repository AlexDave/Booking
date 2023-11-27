import React, { useState } from 'react';
import './RegistrationForm.css'; // Импортируем файл стилей
import Cookies from 'js-cookie';

const RegistrationForm = () => {
  const [formData, setFormData] = useState({
    lastName:'',
    firstName: '',
    email: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    try {
      const response = await fetch('http://localhost:7070/api/user/register', {
        method: 'POST',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });
  
      if (!response.ok) {
        throw new Error('Не удалось зарегистрироваться');
      }
  
      const responseData = await response.json();
      console.log('Успешно зарегистрирован:', responseData);
      Cookies.set('userId', responseData);
  
      // Здесь вы можете выполнить дополнительные действия после успешной регистрации
      // Например, перенаправить пользователя на другую страницу
      window.location.assign('/catalog/');
    } catch (error) {
      console.error('Ошибка при регистрации:', error.message);
      // Здесь вы можете предпринять дополнительные шаги в случае ошибки
    }
  };

  return (
    <form className="registration-form" onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="LastName">Фамилия:</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          value={formData.lastName}
          onChange={handleChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="firstName">Имя:</label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          value={formData.firstName}
          onChange={handleChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="password">Пароль:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Зарегистрироваться</button>
    </form>
  );
};

export default RegistrationForm;
