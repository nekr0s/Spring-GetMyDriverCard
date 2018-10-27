package nekr0s.project.card_users.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserInfoID")
    private int userInfoID;

    @OneToOne
    @JoinColumn(name = "UserInfo_UserID", referencedColumnName = "UserID")
    private User userInfoUser;

    @Column(name = "FirstName")
    @NotNull
    @Size(min = 3, max = 256)
    private String firstName;

    @Column(name = "FirstNameCyrillic")
    @Size(min = 3, max = 256)
    private String firstNameCyrillic;

    @Column(name = "LastName")
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    @Column(name = "LastNameCyrillic")
    @Size(min = 3, max = 30)
    private String lastNameCyrillic;

    @Column(name = "PersonalNumber")
    @NotNull
    @Pattern(regexp = "^\\d{3,20}$")
    private String personalNumber;

    @Column(name = "Address")
    @NotNull
    private String address;

    @Column(name = "PhoneNumber")
    @NotNull
    private String phoneNumber;

    @Column(name = "DateOfBirth")
    @Pattern(regexp = "^\\d+(\\.\\d+)*$")
    @Size(min = 10, max = 10)
    private String dateOfBirth;

    @Column(name = "RequestReason")
    @Max(100)
    private int reason;

    @Column(name = "EuIssuerCountry")
    @Size(min = 3, max = 25)
    private String euIssuerCountry;

    @Column(name = "TcardNumber")
    @Pattern(regexp = "^\\d{3,20}$")
    private String tCardNumber;

    @Column(name = "DriverLicenseIssuerCountry")
    @Size(min = 3, max = 35)
    private String driverLicenseIssuerCountry;

    @Column(name = "DriverLicenseNumber")
    @Size(min = 3, max = 20)
    private String driverLicenseNumber;

    @Column(name = "CountryOfIssuing")
    @Size(min = 3, max = 35)
    private String countryOfIssuing;

    @Column(name = "IssuingAuthority")
    @Size(min = 3, max = 45)
    private String issuingAuthority;

    @Column(name = "DateOfExpiryPrevious")
    @Pattern(regexp = "^\\d+(\\.\\d+)*$")
    @Size(min = 10, max = 10)
    private String dateOfExpiryPrevious;

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
    }

    public UserInfo() {
        // keep empty
    }

    // Getters and setters


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

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
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
