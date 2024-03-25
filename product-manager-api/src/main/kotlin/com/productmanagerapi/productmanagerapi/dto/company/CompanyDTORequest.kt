package com.productmanagerapi.productmanagerapi.dto.company

data class CompanyDTORequest(
    var name: String,
    var cnpj: String,
    var logo: ByteArray?
)

