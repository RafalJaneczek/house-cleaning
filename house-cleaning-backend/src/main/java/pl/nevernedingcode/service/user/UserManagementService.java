package pl.nevernedingcode.service.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.nevernedingcode.entity.User;
import pl.nevernedingcode.mapper.UserMapper;
import pl.nevernedingcode.repository.UserRepository;
import pl.nevernedingcode.response.UserResponse;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findUserById(@NonNull final Long id) {
        final List<User> users = userRepository.findAll();
        return users.stream().filter(user -> id.equals(user.getId())).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("User with id: %s does not exist", id))
        );
    }

    @Override
    @Cacheable("users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        log.info("Get users");
        return ResponseEntity.ok(userMapper.mapToUserResponseList(userRepository.findAll()));
    }
}
