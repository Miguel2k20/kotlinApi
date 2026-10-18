package com.bancobras.api.users.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User (
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
        
    @Column(nullable = false, length = 255)
    var name: String,
        
    @Column(nullable = false, unique = true, length = 255)
    var email: String,
        
    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: LocalDateTime? = null
)