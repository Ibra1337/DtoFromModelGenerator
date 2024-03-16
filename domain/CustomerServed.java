package med.system.clinicsystem.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "CustomerServed")
public class CustomerServed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_served_generator")
    @SequenceGenerator(name="customer_served_generator", sequenceName = "CustomerServed_seq", allocationSize=1)
    @Column(name = "served_id", nullable = false)
    private int servedId;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "end_time", nullable = false)
    private Timestamp endTime;

    @Column(name = "service_id", nullable = false)
    private int serviceId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
