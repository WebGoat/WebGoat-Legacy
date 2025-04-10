import React, { useEffect, useState } from 'react';

const EmployeeTable = () => {
    const [employees, setEmployees] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('/api/employees')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch employee data');
                }
                return response.json();
            })
            .then(data => setEmployees(data))
            .catch(err => setError(err.message));
    }, []);

    if (error) {
        return <div>Error: {error}</div>;
    }

    if (employees.length === 0) {
        return <div>No Results</div>;
    }

    return (
        <table border="1" style={{ width: '90%', margin: 'auto', textAlign: 'center' }}>
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
                {employees.map((employee, index) => (
                    <tr key={index}>
                        <td>{employee.userId}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.ssn}</td>
                        <td>{employee.salary}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default EmployeeTable;