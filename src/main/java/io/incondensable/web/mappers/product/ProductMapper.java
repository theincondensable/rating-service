package io.incondensable.web.mappers.product;

import io.incondensable.business.models.assets.Product;
import io.incondensable.web.dto.assets.ProductResponseDto;
import io.incondensable.web.mappers.ProviderMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author abbas
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProviderMapper.class)
public interface ProductMapper {

    @Mapping(source = "provider.name", target = "providerName")
    ProductResponseDto entityToDto(Product product);

}
