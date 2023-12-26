package io.incondensable.web.mappers;

import io.incondensable.business.models.vt.Address;
import io.incondensable.web.dto.AddressResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author abbas
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {

    AddressResponseDto entityToDto(Address address);

}
