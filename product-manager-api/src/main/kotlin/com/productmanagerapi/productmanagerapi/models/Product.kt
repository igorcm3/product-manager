package com.productmanagerapi.productmanagerapi.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var price: BigDecimal,
    @CreatedDate
    var createdAt: LocalDateTime,
    @LastModifiedDate
    var updatedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "company_id")
    var company: Company
)
