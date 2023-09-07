package rea.webservice.vms.vms.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rea.webservice.vms.vms.models.entities.Contractor;

public interface ContractorRepo extends CrudRepository <Contractor, Long> {
    @Query(value = "SELECT c.id, c.code, c.name, c.ContractorTypeMasterID, t.description, CONCAT(c.Add1, ' ', c.Add2) as address, c.phone1 as phone, c.phone2 as handphone, c.email from General.[Contractor] as c INNER JOIN General.[ContractorTypeMaster] as t ON (c.ContractorTypeMasterID = t.ContractorTypeID) ORDER BY ID DESC", nativeQuery = true)
    Iterable<Contractor> getAllContractor();

    @Query(value = "SELECT COUNT(*) as jumlah FROM General.[Contractor]", nativeQuery = true)
    int jumlahContractor();

    @Query(value = "SELECT c.id, c.code, c.name, c.ContractorTypeMasterID, t.description, CONCAT(c.Add1, ' ', c.Add2) as address, c.phone1 as phone, c.phone2 as handphone, c.email from General.[Contractor] as c INNER JOIN General.[ContractorTypeMaster] as t ON (c.ContractorTypeMasterID = t.ContractorTypeID) where c.Code = CASE WHEN :code != '' THEN :code else c.Code END AND c.Name LIKE CASE WHEN :name !='' THEN CONCAT('%', :name, '%') else c.Name END", nativeQuery = true)
    Iterable<Contractor> SearchContractor(String code, String name);

    @Query(value = "SELECT COUNT(*) as jumlah from General.[Contractor] as c INNER JOIN General.[ContractorTypeMaster] as t ON (c.ContractorTypeMasterID = t.ContractorTypeID) where c.Code = CASE WHEN :code != '' THEN :code else c.Code END AND c.Name LIKE CASE WHEN :name !='' THEN CONCAT('%', :name, '%') else c.Name END", nativeQuery = true)
    int jumlahSearchContractor(String code, String name);
}
