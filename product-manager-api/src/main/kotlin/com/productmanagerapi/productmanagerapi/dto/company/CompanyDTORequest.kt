package com.productmanagerapi.productmanagerapi.dto.company

data class CompanyDTORequest(
    val name: String,
    val cnpj: String,
    val logo: ByteArray?
)

