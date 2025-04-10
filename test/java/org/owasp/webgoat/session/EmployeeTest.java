package org.owasp.webgoat.session;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testSetAndGetPhoneNumber() {
        Employee employee = new Employee();
        employee.setPhoneNumber("123-456-7890");

        assertEquals("123-456-7890", employee.getPhoneNumber());
    }

    @Test
    public void testSetAndGetSalary() {
        Employee employee = new Employee();
        employee.setSalary(50000);

        assertEquals(50000, employee.getSalary());
    }
}