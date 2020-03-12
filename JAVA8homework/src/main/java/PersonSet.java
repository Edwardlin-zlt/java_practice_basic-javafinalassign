import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
    private List<MasterNumber> masterNumbers;

    private List<Address> addresses;

    private List<Telephone> telephones;

    private List<Email> emails;

    public PersonSet(List<MasterNumber> masterNumbers,
                     List<Telephone> telephones,
                     List<Address> addresses,
                     List<Email> emails) {
        this.masterNumbers = masterNumbers;
        this.addresses = addresses;
        this.telephones = telephones;
        this.emails = emails;
    }

    public Stream<Person> groupToPeople() {
        // TODO: group the data to Stream<Person>
        // 根据masterNumbers中的masterNumber拿到List<Address>,List<Telephone>, List<Email>
        // 中的对应数据
        // 构造List<Person>, .stream() 得到Stream<Person>
        // Can use Collectors.groupingBy method
        Map<String, List<Address>> colAddress = addresses.stream().collect(Collectors.groupingBy(Address::getMasterNumber));
        Map<String, List<Telephone>> colTelephones = telephones.stream().collect(Collectors.groupingBy(Telephone::getMasterNumber));
        Map<String, List<Email>> colEmails = emails.stream().collect(Collectors.groupingBy(Email::getMasterNumber));
        ArrayList<Person> people = new ArrayList<>();
        for (MasterNumber masterNumber : masterNumbers) {
            Address tmpAddress = colAddress.getOrDefault(masterNumber.getNumber(), Collections.singletonList(null)).get(0);
            List<Telephone> tmpTelephone = colTelephones.getOrDefault(masterNumber.getNumber(), new ArrayList<>());
            List<Email> tmpEmail = colEmails.getOrDefault(masterNumber.getNumber(), new ArrayList<>());
            people.add(new Person(masterNumber.getNumber(), tmpTelephone, tmpAddress, tmpEmail));
        }
        return people.stream();

        // Can add helper method
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setMasterNumbers(List<MasterNumber> masterNumbers) {
        this.masterNumbers = masterNumbers;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }
}
