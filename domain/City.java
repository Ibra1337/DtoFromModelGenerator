package med.system.clinicsystem.domain;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_generator")
    @SequenceGenerator(name="city_generator", sequenceName = "City_seq", allocationSize=1)
    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "region_id", nullable = false)
    private int regionId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}