package med.system.clinicsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "Street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_generator")
    @SequenceGenerator(name="street_generator", sequenceName = "Street_seq", allocationSize=1)
    @Column(name = "street_id", nullable = false)
    private int streetId;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "city_id", nullable = false)
    private int cityId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}

