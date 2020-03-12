package entity;

import java.util.Objects;

public class Telephone {

  private String masterNumber;
  private String countryCode;

  private String telephoneNumber;

  public Telephone(String masterNumber, String countryCode, String telephoneNumber) {
    this.masterNumber = masterNumber;
    this.countryCode = countryCode;
    this.telephoneNumber = telephoneNumber;
  }

  public void setMasterNumber(String masterNumber) {
    this.masterNumber = masterNumber;
  }

    public String getMasterNumber() {
        return masterNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(masterNumber, telephone.masterNumber) &&
            Objects.equals(countryCode, telephone.countryCode) &&
            Objects.equals(telephoneNumber, telephone.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterNumber, countryCode, telephoneNumber);
    }

    @Override
    public String toString() {
        return "Telephone{" +
            "countryCode='" + countryCode + '\'' +
            ", telephoneNumber='" + telephoneNumber + '\'' +
            '}';
    }
}

