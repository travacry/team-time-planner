package team.lunch.planner.user.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
