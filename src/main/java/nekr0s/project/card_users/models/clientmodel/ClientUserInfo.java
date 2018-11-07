package nekr0s.project.card_users.models.clientmodel;

import nekr0s.project.card_users.models.UserInfo;

public class ClientUserInfo {
    private int userInfoId;
    private String firstName;
    private String firstNameCyrillic;
    private String lastName;
    private String lastNameCyrillic;
    private String personalNumber;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;

    public ClientUserInfo() {

    }

    public ClientUserInfo(int userInfoId, String firstName, String firstNameCyrillic,
                          String lastName, String lastNameCyrillic, String personalNumber,
                          String dateOfBirth, String address, String phoneNumber, String email) {
        this.userInfoId = userInfoId;
        this.firstName = firstName;
        this.firstNameCyrillic = firstNameCyrillic;
        this.lastName = lastName;
        this.lastNameCyrillic = lastNameCyrillic;
        this.personalNumber = personalNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ClientUserInfo(UserInfo userInfo) {
        this.userInfoId = userInfo.getUserInfoID();
        this.firstName = userInfo.getFirstName();
        this.firstNameCyrillic = userInfo.getFirstNameCyrillic();
        this.lastName = userInfo.getLastName();
        this.lastNameCyrillic = userInfo.getLastNameCyrillic();
        this.personalNumber = userInfo.getPersonalNumber();
        this.dateOfBirth = userInfo.getDateOfBirth();
        this.address = userInfo.getAddress();
        this.phoneNumber = userInfo.getPhoneNumber();
        this.email = userInfo.getEmail();
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
