package com.productmanagerapi.productmanagerapi.dto.company

import com.productmanagerapi.productmanagerapi.models.Company
import java.time.LocalDateTime

data class CompanyDTOResponse(
    var id: Long,
    var name: String,
    var cnpj: String,
    var logo: ByteArray?,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) {

    companion object {
        fun fromEntity(company: Company): CompanyDTOResponse {
            return CompanyDTOResponse(
                company.id!!, company.name, company.cnpj, company.logo, company.createdAt, company.updatedAt
            )
        }
    }

}

