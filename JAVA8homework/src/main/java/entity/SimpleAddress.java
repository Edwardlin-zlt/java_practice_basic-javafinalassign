package entity;

import java.util.Objects;

public class SimpleAddress {

  private String street;

  private String city;

  public SimpleAddress() {
  }

  public SimpleAddress(String street, String city) {
    this.street = street;
    this.city = city;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleAddress that = (SimpleAddress) o;
        return Objects.equals(street, that.street) &&
            Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }
}
