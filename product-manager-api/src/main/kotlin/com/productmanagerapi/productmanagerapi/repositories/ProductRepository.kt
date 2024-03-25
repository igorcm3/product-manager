package com.productmanagerapi.productmanagerapi.repositories

import com.productmanagerapi.productmanagerapi.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>
