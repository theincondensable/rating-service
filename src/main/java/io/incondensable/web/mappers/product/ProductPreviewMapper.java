package io.incondensable.web.mappers.product;

import io.incondensable.business.models.aggregates.ProductPreview;
import io.incondensable.web.dto.assets.ProductPreviewResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author abbas
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductPreviewMapper {

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "name", source = "product.name")
    ProductPreviewResponseDto entityToPreviewDto(ProductPreview preview);

}
