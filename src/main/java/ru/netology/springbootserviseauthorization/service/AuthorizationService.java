package ru.netology.springbootserviseauthorization.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootserviseauthorization.domain.Person;
import ru.netology.springbootserviseauthorization.exception.InvalidCredentials;
import ru.netology.springbootserviseauthorization.exception.UnauthorizedUser;
import ru.netology.springbootserviseauthorization.model.Authorities;
import ru.netology.springbootserviseauthorization.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<Authorities> getAuthorities(String userName, String userPassword) {
        if (isEmpty(userName) || isEmpty(userPassword)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, userPassword);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userName);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }


}
