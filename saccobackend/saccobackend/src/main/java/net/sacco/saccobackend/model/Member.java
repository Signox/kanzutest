package net.sacco.saccobackend.model;
 
// Importing JPA annotations for ORM mapping
import jakarta.persistence.*;

// Importing Lombok annotations to reduce boilerplate code
import lombok.*;

// Importing Timestamp for date tracking
import java.sql.Timestamp; 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table(name = "member")

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String memberNumber;
 
    private String phoneNumber;
    private String email;


}