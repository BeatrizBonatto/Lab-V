package PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        // Nome: pelo menos 2 partes e só letras
        String[] nameParts = p.getName().trim().split("\\s+");
        if (nameParts.length < 2 || !p.getName().matches("([A-Za-z]+\\s+){1,}[A-Za-z]+")) {
            errors.add("Nome inválido: deve conter ao menos duas partes e apenas letras.");
        }

        // Idade entre 1 e 200
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("Idade inválida: deve estar entre 1 e 200.");
        }

        // Pelo menos um e-mail
        List<Email> emails = p.getEmails();
        if (emails == null || emails.isEmpty()) {
            errors.add("Deve haver ao menos um e-mail associado.");
        } else {
            for (Email e : emails) {
                if (!e.getName().matches(".+@.+\\..+")) {
                    errors.add("E-mail inválido: " + e.getName());
                }
            }
        }

        return errors;
    }
}
