package com.productmanagerapi.productmanagerapi.dto.company

import com.productmanagerapi.productmanagerapi.models.Company

data class CompanyDTOResponse(
    val id: Long,
    val name: String,
    val cnpj: String,
    val logo: ByteArray?
) {

    companion object {
        fun fromEntity(company: Company): CompanyDTOResponse {
            return CompanyDTOResponse(
                company.id!!, company.name, company.cnpj, company.logo
            )
        }
    }

}

