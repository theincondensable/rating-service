package io.incondensable.business.models.vt;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * @author abbas
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String city;
    private String country;
    private String zipcode;

}
