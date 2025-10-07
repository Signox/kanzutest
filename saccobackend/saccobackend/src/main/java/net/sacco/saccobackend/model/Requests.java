package net.sacco.saccobackend.model;

// Importing JPA annotations for ORM mapping
import jakarta.persistence.*;

    
import org.hibernate.annotations.CreationTimestamp;

// Importing Lombok annotations to reduce boilerplate code
import lombok.*;

// Importing Timestamp for date tracking
import java.sql.Timestamp; 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table(name = "requests")

public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    // Payment type selected by this approver 
   @Enumerated(EnumType.STRING)
    @Column(name = "payment", nullable = false)
    private PaymentType paymentType;
    
    @Column(nullable = false)
    private String member;
 
    @Column(nullable = false)
    private float amount;
     
    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'pending'")
    private String status;
 
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer approval;
     
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer requiredApprovals;
    
    @CreationTimestamp
    @Column(name = "createdate", updatable = false)
    private Timestamp createdate;

}
