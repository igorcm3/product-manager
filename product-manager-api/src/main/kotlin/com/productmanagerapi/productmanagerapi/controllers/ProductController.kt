package com.productmanagerapi.productmanagerapi.controllers

import com.productmanagerapi.productmanagerapi.dto.product.ProductDTORequest
import com.productmanagerapi.productmanagerapi.dto.product.ProductDTOResponse
import com.productmanagerapi.productmanagerapi.services.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {

    @GetMapping("/list")
    fun listProducts(pageable: Pageable): Page<ProductDTOResponse> = this.productService.list(pageable)

    @PostMapping("/create")
    fun createProduct(@RequestBody newProduct: ProductDTORequest): ProductDTOResponse =
        this.productService.create(newProduct)

    @PutMapping("/update/{id}")
    fun updateProduct(
        @RequestBody productToUpdate: ProductDTORequest, @PathVariable("id") productId: Long
    ): ProductDTOResponse = this.productService.update(productToUpdate, productId)

    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable("id") productId: Long) = this.productService.delete(productId)
}
