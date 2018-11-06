package nekr0s.project.card_users.models.clientmodel;

import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.models.UserInfo;

public class ClientUser extends User {

    private UserInfo userInfo;

    public ClientUser() {

    }

    public ClientUser(UserInfo userInfo) {
        super();
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
