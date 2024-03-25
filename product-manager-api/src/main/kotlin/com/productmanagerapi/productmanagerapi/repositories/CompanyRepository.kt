package com.productmanagerapi.productmanagerapi.repositories

import com.productmanagerapi.productmanagerapi.models.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : JpaRepository<Company, Long>
