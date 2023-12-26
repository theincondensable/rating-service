package io.incondensable.business.models;

import io.incondensable.business.models.vt.Address;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author abbas
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;

    @CreationTimestamp
    private Instant createdOn;
    @UpdateTimestamp
    private Instant lastUpdatedOn;

}
