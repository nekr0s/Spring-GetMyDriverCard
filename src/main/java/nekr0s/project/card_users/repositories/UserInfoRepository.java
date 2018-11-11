package nekr0s.project.card_users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import nekr0s.project.card_users.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findByUserInfoUserId(int userInfoUserId);

}
