package entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Person {

    private String masterNumber;
    private Address address;

    private List<Telephone> telephones;

    private List<Email> emails;

    public Person() {
    }

    public Person(String masterNumber, List<Telephone> telephones, Address address,
                  List<Email> emails) {
        this.masterNumber = masterNumber;
        this.address = address;
        this.telephones = telephones;
        this.emails = emails;
    }

    public Optional<SimpleAddress> getSimpleAddress() {
        return Optional.ofNullable(address).map(s -> s.getSimpleAddress()); // SimpleAddress的构造函数不可能生成null, 所以s.getSimpleAddress()也不可能生成null?
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(masterNumber, person.masterNumber) &&
            Objects.equals(address, person.address) &&
            Objects.equals(telephones, person.telephones) &&
            Objects.equals(emails, person.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterNumber, address, telephones, emails);
    }

    public String getMasterNumber() {
        return masterNumber;
    }

    public Address getAddress() {
        return address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    @Override
    public String toString() {
        return "Person{" +
            "masterNumber='" + masterNumber + '\'' +
            ", address=" + address +
            ", telephones=" + telephones +
            ", emails=" + emails +
            '}';
    }
}
