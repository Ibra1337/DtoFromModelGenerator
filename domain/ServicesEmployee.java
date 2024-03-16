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
@Table(name = "Services_Employees")
public class ServicesEmployee {
    @Id
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Services service;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}