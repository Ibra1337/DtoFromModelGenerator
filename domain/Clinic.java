package med.system.clinicsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clinic_generator")
    @SequenceGenerator(name="clinic_generator", sequenceName = "Clinic_seq", allocationSize=1)
    @Column(name = "clinic_id", nullable = false)
    private Integer clinicId;

    @Column(name = "location_id", nullable = false)
    private Location location;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}