package com.productmanagerapi.productmanagerapi.dto.product

import java.math.BigDecimal

data class ProductDTORequest(
    val name: String,
    val price: BigDecimal,
    val companyId: Long
)
