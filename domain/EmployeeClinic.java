package med.system.clinicsystem.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Employees_Clinic")
public class EmployeeClinic {
    @Id
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
