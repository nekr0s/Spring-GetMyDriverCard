package nekr0s.project.card_users.models.clientmodel;

import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.models.UserInfo;

public class ClientUser extends User {

    private ClientUserInfo userInfo;

    public ClientUser() {

    }

    public ClientUser(ClientUserInfo userInfo) {
        super();
        this.userInfo = userInfo;
    }

    public ClientUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(ClientUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
