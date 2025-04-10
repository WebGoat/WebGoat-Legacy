import React from 'react';

const LessonContent = ({ userId, firstName, lastName, ssn, salary }) => {
  return (
    <div>
      <h1>Lesson Content</h1>
      <table style={{ width: '90%', border: '1px solid black', textAlign: 'center' }}>
        <thead>
          <tr>
            <th>UserID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>SSN</th>
            <th>Salary</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{userId}</td>
            <td>{firstName}</td>
            <td>{lastName}</td>
            <td>{ssn}</td>
            <td>{salary}</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default LessonContent;