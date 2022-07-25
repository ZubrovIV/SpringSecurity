package ru.zubrov.SecurityApp.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zubrov.SecurityApp.models.Person;

import java.util.Optional;

@Repository
public interface PeopleRep extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
