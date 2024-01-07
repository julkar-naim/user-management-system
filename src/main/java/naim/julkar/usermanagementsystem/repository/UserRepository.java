package naim.julkar.usermanagementsystem.repository;

import naim.julkar.usermanagementsystem.entity.GeneralUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<GeneralUser, Long> {
}
