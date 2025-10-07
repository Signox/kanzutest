package net.sacco.saccobackend.model;
// Importing JPA annotations for ORM mapping
import jakarta.persistence.*;
    

// Importing Lombok annotations to reduce boilerplate code
import lombok.*;


@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table(name = "approvals")

public class Approvals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 2")
    private Integer maxcount;
}
