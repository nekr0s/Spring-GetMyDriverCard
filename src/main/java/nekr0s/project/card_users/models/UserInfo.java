package nekr0s.project.card_users.models;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "UserInfoID")
    private int userInfoID;

    @OneToOne
    @JoinColumn(name = "UserInfo_UserID", referencedColumnName = "UserID")
    private User userInfoUser;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "FirstNameCyrillic")
    private String firstNameCyrillic;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "LastNameCyrillic")
    private String lastNameCyrillic;

    @Column(name = "PersonalNumber")
    private String personalNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "DateOfBirth")
    private String dateOfBirth;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "EuIssuerCountry")
    private String euIssuerCountry;

    @Column(name = "TcardNumber")
    private String tCardNumber;

    @Column(name = "DriverLicenseIssuerCountry")
    private String driverLicenseIssuerCountry;

    @Column(name = "DriverLicenseNumber")
    private String driverLicenseNumber;

    @Column(name = "CountryOfIssuing")
    private String countryOfIssuing;

    @Column(name = "IssuingAuthority")
    private String issuingAuthority;

    @Column(name = "DateOfExpiryPrevious")
    private String dateOfExpiryPrevious;

    @Column(name = "EGN")
    private String egn;

    public UserInfo(User userInfoUser, String egn, String firstName, String firstNameCyrillic, String lastName, String lastNameCyrillic,
                    String personalNumber, String address, String phoneNumber, String dateOfBirth) {
        this.userInfoUser = userInfoUser;
        this.firstName = firstName;
        this.firstNameCyrillic = firstNameCyrillic;
        this.lastName = lastName;
        this.lastNameCyrillic = lastNameCyrillic;
        this.personalNumber = personalNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.egn = egn;
    }

    public UserInfo() {
        // keep empty
    }

    // Getters and setters

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameCyrillic() {
        return firstNameCyrillic;
    }

    public void setFirstNameCyrillic(String firstNameCyrillic) {
        this.firstNameCyrillic = firstNameCyrillic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameCyrillic() {
        return lastNameCyrillic;
    }

    public void setLastNameCyrillic(String lastNameCyrillic) {
        this.lastNameCyrillic = lastNameCyrillic;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEuIssuerCountry() {
        return euIssuerCountry;
    }

    public void setEuIssuerCountry(String euIssuerCountry) {
        this.euIssuerCountry = euIssuerCountry;
    }

    public String gettCardNumber() {
        return tCardNumber;
    }

    public void settCardNumber(String tCardNumber) {
        this.tCardNumber = tCardNumber;
    }

    public String getDriverLicenseIssuerCountry() {
        return driverLicenseIssuerCountry;
    }

    public void setDriverLicenseIssuerCountry(String driverLicenseIssuerCountry) {
        this.driverLicenseIssuerCountry = driverLicenseIssuerCountry;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getCountryOfIssuing() {
        return countryOfIssuing;
    }

    public void setCountryOfIssuing(String countryOfIssuing) {
        this.countryOfIssuing = countryOfIssuing;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getDateOfExpiryPrevious() {
        return dateOfExpiryPrevious;
    }

    public void setDateOfExpiryPrevious(String dateOfExpiryPrevious) {
        this.dateOfExpiryPrevious = dateOfExpiryPrevious;
    }

    public int getUserInfoID() {
        return userInfoID;
    }

    public void setUserInfoID(int userInfoID) {
        this.userInfoID = userInfoID;
    }

    public User getUserInfoUser() {
        return userInfoUser;
    }

    public void setUserInfoUser(User userInfoUser) {
        this.userInfoUser = userInfoUser;
    }
}
