package med.system.clinicsystem.domain;

import lombok.Data;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_generator")
    @SequenceGenerator(name="location_generator", sequenceName = "Location_seq", allocationSize=1)
    @Column(name = "location_id", nullable = false)
    private int locationId;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "local_number", nullable = false)
    private String localNumber;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}