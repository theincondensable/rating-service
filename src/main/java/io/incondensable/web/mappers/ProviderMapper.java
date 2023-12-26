package io.incondensable.web.mappers;

import io.incondensable.business.models.assets.Provider;
import io.incondensable.web.dto.assets.ProviderResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author abbas
 */
@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {AddressMapper.class, UserMapper.class}
)
public interface ProviderMapper {

    @Mapping(source = "address", target = "providerAddress")
    ProviderResponseDto entityToDto(Provider provider);

}
