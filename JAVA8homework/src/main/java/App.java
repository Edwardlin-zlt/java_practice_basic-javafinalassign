import entity.MasterNumber;
import entity.Person;

import java.util.Arrays;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        //TODO: print Person data that masterNumber is 1 and 2
        // print Person data that masterNumber is 3

        Stream<Person> personStream = personService.getPersonByMasterNumbers(
            Arrays.asList(new MasterNumber("1"), new MasterNumber("2")));
        personStream.forEach(App::printPersonInfo);

        Stream<Person> personStream2 = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")));
        personStream2.forEach(App::printPersonInfo); // 真面向测试编程


    }

    public static void printPersonInfo(Person person) {
        System.out.println("==============================");
        System.out.println("Person " + person.getMasterNumber());
        System.out.println(person.getAddress());
        System.out.println(person.getTelephones());
        System.out.println(person.getEmails());
    }
}
