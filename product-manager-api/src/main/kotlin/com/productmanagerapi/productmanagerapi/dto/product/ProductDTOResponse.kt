package com.productmanagerapi.productmanagerapi.dto.product

import com.productmanagerapi.productmanagerapi.dto.company.CompanyDTOResponse
import com.productmanagerapi.productmanagerapi.models.Product
import java.math.BigDecimal

data class ProductDTOResponse(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val company: CompanyDTOResponse
) {
    companion object {
        fun fromEntity(product: Product): ProductDTOResponse {
            return ProductDTOResponse(
                product.id!!, product.name, product.price, CompanyDTOResponse.fromEntity(product.company)
            )
        }
    }
}
