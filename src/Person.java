public class Person {
  public Person(String idNumber, String name, String address, Date birth) {
    this.idNumber = idNumber;
    this.name = name;
    this.address = address;
    this.birth = birth;
  }

  public Person(String idNumber, String name, Date birth) {
    this.idNumber = idNumber;
    this.name = name;
    this.birth = birth;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String idNumber;

  public String name;

  public String address;

    public Date birth;

  public int age() {
  return 0;
  }//fazer o age

  public boolean olderThan(Person p) {

    return !this.birth.afterDate(p.birth);
  }

}