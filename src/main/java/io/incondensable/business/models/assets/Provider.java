package io.incondensable.business.models.assets;

import io.incondensable.business.models.User;
import io.incondensable.business.models.vt.Address;
import lombok.*;

import javax.persistence.*;

/**
 * @author abbas
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Address address;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private User manager;

}
