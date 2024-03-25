package com.productmanagerapi.productmanagerapi.services

import com.productmanagerapi.productmanagerapi.dto.product.ProductDTORequest
import com.productmanagerapi.productmanagerapi.dto.product.ProductDTOResponse
import com.productmanagerapi.productmanagerapi.models.Company
import com.productmanagerapi.productmanagerapi.models.Product
import com.productmanagerapi.productmanagerapi.repositories.CompanyRepository
import com.productmanagerapi.productmanagerapi.repositories.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository, val companyRepository: CompanyRepository) {

    fun create(newProduct: ProductDTORequest): ProductDTOResponse {
        val company: Company = getCompanyFromProduct(newProduct.companyId)

        val Product = Product(
            name = newProduct.name,
            price = newProduct.price,
            company = company,
        )
        val savedProduct = productRepository.save(Product)
        return ProductDTOResponse.fromEntity(savedProduct)
    }

    private fun getCompanyFromProduct(companyId: Long): Company {
        val company: Company = this.companyRepository.findById(companyId)
            .orElseThrow { NoSuchElementException("Empresa não encontrada com o ID: $companyId") }
        return company
    }

    fun list(pageable: Pageable): Page<ProductDTOResponse> =
        this.productRepository.findAll(pageable).map { product: Product -> ProductDTOResponse.fromEntity(product) }

    fun update(productDTO: ProductDTORequest, productId: Long): ProductDTOResponse {
        val product = this.productRepository.findById(productId)
            .orElseThrow { NoSuchElementException("Produto não encontrado com o ID: $productId") }

        val company: Company = getCompanyFromProduct(productDTO.companyId)

        product.name = productDTO.name
        product.price = productDTO.price
        product.company = company
        this.productRepository.save(product)

        return ProductDTOResponse.fromEntity(product)
    }

    fun delete(productId: Long) = this.productRepository.deleteById(productId)
}
