package ru.zubrov.SecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zubrov.SecurityApp.models.Person;
import ru.zubrov.SecurityApp.repositoties.PeopleRep;
import ru.zubrov.SecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRep peopleRep;

    @Autowired
    public PersonDetailsService(PeopleRep peopleRep) {
        this.peopleRep = peopleRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRep.findByUsername(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new PersonDetails(person.get());
    }
}
