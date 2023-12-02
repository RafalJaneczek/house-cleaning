package pl.nevernedingcode.service.user;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import pl.nevernedingcode.entity.User;
import pl.nevernedingcode.response.UserResponse;

import java.util.List;

public interface UserService {
    User findUserById(@NonNull final Long id);
    ResponseEntity<List<UserResponse>> getAllUsers();
}
