package io.incondensable.web.dto.assets;

import io.incondensable.web.dto.AddressResponseDto;
import io.incondensable.web.dto.user.UserResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProviderResponseDto {
    private String name;
    private UserResponseDto manager;
    private AddressResponseDto providerAddress;
}
