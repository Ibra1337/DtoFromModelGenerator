package med.system.clinicsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "services_generator")
    @SequenceGenerator(name="services_generator", sequenceName = "Services_seq", allocationSize=1)
    @Column(name = "service_id", nullable = false)
    private int serviceId;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "version", nullable = false)
    private int version;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}