package io.incondensable.web.dto.user;

import io.incondensable.web.dto.AddressResponseDto;
import lombok.*;

/**
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponseDto {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private AddressResponseDto userAddress;
}
