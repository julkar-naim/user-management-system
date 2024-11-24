package naim.julkar.usermanagementsystem.repository;

import naim.julkar.usermanagementsystem.entity.GeneralUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<GeneralUser, String> {}
