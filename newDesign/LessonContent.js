import React, { useEffect, useState } from 'react';
import axios from 'axios';

const LessonContent = () => {
  const [content, setContent] = useState('');

  useEffect(() => {
    axios.get('/api/lesson-content')
      .then(response => setContent(response.data))
      .catch(error => console.error('Error fetching lesson content:', error));
  }, []);

  return (
    <div>
      <h1>Lesson Content</h1>
      <div dangerouslySetInnerHTML={{ __html: content }} />
    </div>
  );
};

export default LessonContent;