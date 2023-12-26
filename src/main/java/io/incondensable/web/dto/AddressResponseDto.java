package io.incondensable.web.dto;

import lombok.*;

/**
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressResponseDto {
    private String city;
    private String country;
}
