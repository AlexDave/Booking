// RandomImage.js

import React, { useEffect, useState } from 'react';

const RandomImage = () => {
  const [imageUrl, setImageUrl] = useState('');
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getRandomImage = async () => {
      try {
        // Генерация случайного числа для предотвращения кэширования изображения
        const randomSuffix = Math.floor(Math.random() * 1000);
        setImageUrl(`https://picsum.photos/220/150?random=${randomSuffix}`);
      } catch (error) {
        console.error('Error fetching a random image:', error);
      } finally {
        setLoading(false);
      }
    };

    getRandomImage();
  }, []);

  return (
    <div>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <img src={imageUrl} alt="Random" />
      )}
    </div>
  );
};

export default RandomImage;
