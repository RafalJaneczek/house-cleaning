package pl.nevernedingcode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.nevernedingcode.entity.User;
import pl.nevernedingcode.response.UserResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse mapToUserResponse(final User user);
    List<UserResponse> mapToUserResponseList(final List<User> user);
}
