package io.incondensable.web.mappers;

import io.incondensable.business.models.feedback.Feedback;
import io.incondensable.web.dto.FeedbackRequestDto;
import io.incondensable.web.dto.FeedbackResponseDto;
import io.incondensable.web.mappers.product.ProductMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author abbas
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProductMapper.class)
public interface FeedbackMapper {

    @Mapping(source = "product.provider.name", target = "providerName")
    @Mapping(source = "product.name", target = "productName")
    FeedbackResponseDto entityToDto(Feedback feedback);

    @Mapping(source = "productId", target = "product.id")
    Feedback dtoToEntity(FeedbackRequestDto req);

}
