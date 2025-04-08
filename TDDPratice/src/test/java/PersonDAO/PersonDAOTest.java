package PersonDAO;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    private PersonDAO personDAO = new PersonDAO();

    @Test
    public void testValidPerson() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.isEmpty(), "Should have no errors for valid person");
    }

    @Test
    public void testInvalidName_SinglePart() {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for single-part name");
        assertTrue(errors.contains("Nome inválido: deve conter ao menos duas partes e apenas letras."));
    }

    @Test
    public void testInvalidName_WithNumbers() {
        Person person = new Person();
        person.setName("John Doe123");
        person.setAge(30);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for name with numbers");
        assertTrue(errors.contains("Nome inválido: deve conter ao menos duas partes e apenas letras."));
    }

    @Test
    public void testInvalidName_Empty() {
        Person person = new Person();
        person.setName("");
        person.setAge(30);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for empty name");
        assertTrue(errors.contains("Nome inválido: deve conter ao menos duas partes e apenas letras."));
    }

    @Test
    public void testInvalidAge_TooLow() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(0);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for age < 1");
        assertTrue(errors.contains("Idade inválida: deve estar entre 1 e 200."));
    }

    @Test
    public void testInvalidAge_TooHigh() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(201);
        person.setEmails(List.of(new Email(1,"john@example.com")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for age > 200");
        assertTrue(errors.contains("Idade inválida: deve estar entre 1 e 200."));
    }

    @Test
    public void testNoEmails() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmails(List.of());

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for no emails");
        assertTrue(errors.contains("Deve haver ao menos um e-mail associado."));
    }

    @Test
    public void testNullEmails() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmails(null);

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for null emails");
        assertTrue(errors.contains("Deve haver ao menos um e-mail associado."));
    }

    @Test
    public void testInvalidEmailFormat() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmails(List.of(new Email(1,"invalid-email")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertFalse(errors.isEmpty(), "Should have errors for invalid email format");
        assertTrue(errors.contains("E-mail inválido: invalid-email"));
    }

    @Test
    public void testMultipleErrors() {
        Person person = new Person();
        person.setName("John");
        person.setAge(0);
        person.setEmails(List.of(new Email(1,"invalid-email")));

        List<String> errors = personDAO.isValidToInclude(person);
        assertEquals(3, errors.size(), "Should have 3 errors");
        assertTrue(errors.contains("Nome inválido: deve conter ao menos duas partes e apenas letras."));
        assertTrue(errors.contains("Idade inválida: deve estar entre 1 e 200."));
        assertTrue(errors.contains("E-mail inválido: invalid-email"));
    }

}