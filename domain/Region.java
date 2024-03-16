package med.system.clinicsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_generator")
    @SequenceGenerator(name="region_generator", sequenceName = "Region_seq", allocationSize=1)
    @Column(name = "region_id", nullable = false)
    private int regionId;

    @Column(name = "region_name", nullable = false)
    private String regionName;

    @Column(name = "location_id", nullable = false)
    private int locationId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}