package com.productmanagerapi.productmanagerapi.services

import com.productmanagerapi.productmanagerapi.dto.company.CompanyDTORequest
import com.productmanagerapi.productmanagerapi.dto.company.CompanyDTOResponse
import com.productmanagerapi.productmanagerapi.models.Company
import com.productmanagerapi.productmanagerapi.repositories.CompanyRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CompanyService(var companyRepository: CompanyRepository) {

    fun create(newCompany: CompanyDTORequest): CompanyDTOResponse {
        val company = Company(
            name = newCompany.name,
            cnpj = newCompany.cnpj,
            logo = newCompany.logo,
        )
        val savedCompany = companyRepository.save(company)
        return CompanyDTOResponse.fromEntity(savedCompany)
    }

    fun listCompanies(pageable: Pageable): Page<CompanyDTOResponse> =
        this.companyRepository.findAll(pageable).map { company: Company -> CompanyDTOResponse.fromEntity(company) }

    fun update(companyDTO: CompanyDTORequest, companyId: Long): CompanyDTOResponse {
        val company = this.companyRepository.findById(companyId)
            .orElseThrow { NoSuchElementException("Empresa não encontrada com o ID: ${companyId}") }

        company.name = companyDTO.name
        company.cnpj = companyDTO.cnpj
        company.logo = companyDTO.logo
        this.companyRepository.save(company)

        return CompanyDTOResponse.fromEntity(company)
    }

    fun delete(companyId: Long) = this.companyRepository.deleteById(companyId)
}
