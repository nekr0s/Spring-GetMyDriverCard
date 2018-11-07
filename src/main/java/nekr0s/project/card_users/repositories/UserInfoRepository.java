package nekr0s.project.card_users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nekr0s.project.card_users.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findByUserInfoUserId(int userInfoUserId);
}
