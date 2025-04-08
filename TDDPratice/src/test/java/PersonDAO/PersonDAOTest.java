package PersonDAO;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    private final PersonDAO dao = new PersonDAO();

    @Test
    public void testPessoaValida() {
        List<Email> emails = List.of(new Email(1, "teste@email.com"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    @Test
    public void testNomeInvalido() {
        List<Email> emails = List.of(new Email(1, "teste@email.com"));
        Person p = new Person(1, "Joao123", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Nome inválido")));
    }

    @Test
    public void testIdadeInvalidaBaixa() {
        Person p = new Person(1, "Joao Silva", 0, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }

    @Test
    public void testIdadeInvalidaAlta() {
        Person p = new Person(1, "Joao Silva", 300, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }

    @Test
    public void testSemEmail() {
        Person p = new Person(1, "Joao Silva", 30, new ArrayList<>());
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("e-mail associado")));
    }

    @Test
    public void testEmailInvalido() {
        List<Email> emails = List.of(new Email(1, "emailinvalido"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("E-mail inválido")));
    }

    @Test
    public void testMultiplosErros() {
        List<Email> emails = List.of(new Email(1, "semarroba"));
        Person p = new Person(1, "Joao", -5, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertEquals(3, erros.size());
    }

    @Test
    public void testEmailsNull() {
        Person p = new Person(1, "Joao", 25, null);
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.contains("Lista de emails não pode ser nula"));
    }

    @Test
    public void testNomeComEspacosExtras() {
        Person p = new Person(1, "Joao   Silva", 30, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    @Test
    public void testEmailSemPontoNoDominio() {
        Person p = new Person(1, "Joao Silva", 30, List.of(new Email(1, "teste@email")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("E-mail inválido")));
    }

    @Test
    public void testEmailsNulos() {
        Person p = new Person(1, "Joao Silva", 30, null);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("e-mail associado")));
    }


}