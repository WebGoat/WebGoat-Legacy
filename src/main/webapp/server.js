const express = require('express');
const fs = require('fs');
const { DOMParser } = require('xmldom');
const xpath = require('xpath');

const app = express();
const PORT = 3000;

// API to fetch employee data
app.get('/api/employees', (req, res) => {
    const xmlFilePath = __dirname + '/lessons/Ajax/employees.xml';

    // Check if the XML file exists
    if (!fs.existsSync(xmlFilePath)) {
        return res.status(404).json({ error: 'XML file not found' });
    }

    // Read and parse the XML file
    const xml = fs.readFileSync(xmlFilePath, 'utf-8');
    const doc = new DOMParser().parseFromString(xml);
    const select = xpath.useNamespaces({});

    // Extract employee data using XPath
    const employees = select('/Employees/Employee', doc).map(employee => ({
        userId: select('string(UserID)', employee),
        firstName: select('string(FirstName)', employee),
        lastName: select('string(LastName)', employee),
        ssn: select('string(SSN)', employee),
        salary: select('string(Salary)', employee),
    }));

    res.json(employees);
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});