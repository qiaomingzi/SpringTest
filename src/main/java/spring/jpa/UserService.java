package spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService  {

    @PersistenceContext
    private EntityManager em;

    @Autowired
   private UserDaoRepository userDaoRepository;

   public User save(User entity) {
       em.persist(entity);
       return entity;
       //return userDaoRepository.save(entity);
    }
}
