package PersonDAO;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;

    public Person() {}

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Email> getEmails() { return emails; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
