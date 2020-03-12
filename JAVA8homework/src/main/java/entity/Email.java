package entity;

import java.util.Objects;

public class Email {

  private String masterNumber;

  private String emailAddress;

  public Email(String masterNumber, String emailAddress) {
    this.masterNumber = masterNumber;
    this.emailAddress = emailAddress;
  }

  public void setMasterNumber(String masterNumber) {
    this.masterNumber = masterNumber;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(masterNumber, email.masterNumber) &&
            Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterNumber, emailAddress);
    }

    public String getMasterNumber() {
        return masterNumber;
    }

    @Override
    public String toString() {
        return "Email{" +
            "emailAddress='" + emailAddress + '\'' +
            '}';
    }
}
