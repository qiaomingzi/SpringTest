package spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDaoRepository extends JpaRepository<User,Long> {}
