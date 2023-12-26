package io.incondensable.business.models.assets;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Random;

/**
 * @author abbas
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <p>Since there is no Enquiry Service present in this task, I decided to mock the price value using the
     * technique below, yeah it might be funny that price does not even persist, and changes everytime, due to
     * high rate of inflation, although it can be negative!</p>
     */
    @Transient
    private int price = new Random().nextInt(10_000, 200_000);

    private String name;
    private String color;
    private String category;

    @ManyToOne
    private Provider provider;

    private boolean isVotable;
    private boolean isOpenToAll;
    private boolean isCommentable;

    @CreationTimestamp
    private Instant createdOn;
    @UpdateTimestamp
    private Instant lastUpdatedOn;

    public Product(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
