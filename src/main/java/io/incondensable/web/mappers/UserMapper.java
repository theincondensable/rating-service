package io.incondensable.web.mappers;

import io.incondensable.business.models.User;
import io.incondensable.web.dto.user.UserResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author abbas
 * <p>Since there is no way to create a User from API, the only mapping method needed is entityToDto.</p>
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = AddressMapper.class)
public interface UserMapper {

    @Mapping(source = "address", target = "userAddress")
    UserResponseDto entityToDto(User user);

}
