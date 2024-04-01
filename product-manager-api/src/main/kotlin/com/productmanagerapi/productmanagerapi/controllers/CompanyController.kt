package com.productmanagerapi.productmanagerapi.controllers

import com.productmanagerapi.productmanagerapi.dto.company.CompanyDTORequest
import com.productmanagerapi.productmanagerapi.dto.company.CompanyDTOResponse
import com.productmanagerapi.productmanagerapi.services.CompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/companies")
class CompanyController(val companyService: CompanyService) {

    @GetMapping("/list")
    fun listCompanies(pageable: Pageable): Page<CompanyDTOResponse> = this.companyService.listCompanies(pageable)

    @PostMapping("/create")
    fun createCompany(@RequestBody newCompany: CompanyDTORequest): CompanyDTOResponse =
        this.companyService.create(newCompany)

    @PutMapping("/update/{id}")
    fun createCompany(
        @RequestBody companyToUpdate: CompanyDTORequest, @PathVariable("id") companyId: Long
    ): CompanyDTOResponse = this.companyService.update(companyToUpdate, companyId)

    @DeleteMapping("/delete/{id}")
    fun deleteCompany(@PathVariable("id") companyId: Long) = this.companyService.delete(companyId)

}
