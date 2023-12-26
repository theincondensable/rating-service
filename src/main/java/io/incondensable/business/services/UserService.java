package io.incondensable.business.services;

import io.incondensable.business.exception.user.UserNotFoundWithId;
import io.incondensable.business.models.User;
import io.incondensable.business.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abbas
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundWithId(userId);
                });
    }

}
