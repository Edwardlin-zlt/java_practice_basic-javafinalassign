import entity.MasterNumber;
import entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonService {

  private Map<List<String>, Optional<PersonSet>> people;

  public PersonService() {
      // 刚开始写代码的时候怎么直接运行一部分代码？不用在mian中写东西
      // 比如这里我在拿到代码的第一时间就只想看看这个构造函数跑出来是什么样子
      // 没有有就像脚本语言一样的方法, 我直接构造一个a = new PersonService(); 就可以看到 a 是什么样子
    this.people = new HashMap<>();
    people.put(Arrays.asList("1"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1()));
    people.put(Arrays.asList("1", "2"), Optional.of(PersonSetDataProvider.providePersonSetWithNumber1And2()));
  }

  public Stream<Person> getPersonByMasterNumbers(List<MasterNumber> numbers) {
    //TODO: Add the code to return people by numbers
    // Use groupToPeople() method
      // get PersonSet by List<MasterNumber>
      // use personSet.groupToPeople() get Stream<Person>
      List<String> stringList = numbers.stream().map(MasterNumber::getNumber).collect(Collectors.toList());
      Optional<PersonSet> personSet = people.get(stringList);
      try {
          return personSet.orElse(null).groupToPeople();
      } catch (NullPointerException e) {
          return new ArrayList<Person>().stream(); // 真面向测试编程
      }
  }
}
