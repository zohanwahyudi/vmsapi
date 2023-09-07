package rea.webservice.vms.vms.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rea.webservice.vms.vms.models.entities.ResponseInsert;
import rea.webservice.vms.vms.models.entities.Vms;

public interface InsertRepo extends CrudRepository<ResponseInsert, Long>{
    @Query(value = "INSERT INTO Vehicle.[VehicleMaster] (CategoryID, EstateID, ContractorID, VHCode, VHBrand, VHModel, VHColor, Active, DateOfCommission, ChasisNo, EngineNo, RegNo, STNK, Remarks, CreatedBy, CreatedOn, ModifiedBy, ModifiedOn, t8, InActiveDate, ManufactureYear, Capacity, Tare, STNKExpired, Tanker) OUTPUT inserted.* VALUES (:categoryid, :estateid, NULL, :vhcode, :vhbrand, :vhmodel, :vhcolor, 1, :dateofcommission, :chasisno, :engineno, :regno, :stnk, '', :user, GETDATE(), '', '', :t8, NULL, :manufactureyear, :capacity, :tare, :stnkexpired, :tanker) ", nativeQuery = true)
    List<ResponseInsert> insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String vhcolor, String dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, int capacity, int tare, String stnkexpired, int tanker );
    
    @Query(value = "SELECT id, (SELECT Category FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categorycode, (SELECT Description FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categoryname, (SELECT EstateName FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS Estatename, (SELECT Abbreviation FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS EstateCode, (SELECT Code FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorcode, (SELECT Name FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorname, vhcode, vhbrand, vhmodel, vhcolor, active, dateofcommission, chasisno, engineno, regno, stnk, remarks, createdby, createdon, modifiedby, modifiedon, t8, inactivedate, manufactureyear, capacity, tare, stnkexpired, tanker from vehicle.[vehiclemaster] WHERE ChasisNo = :chasisno OR EngineNo = :engineno OR VHCode = :vhcode OR RegNo = :regno ", nativeQuery = true)
    List<Vms> cekData(String chasisno, String engineno, String vhcode, String regno);

    @Query(value = "SELECT COUNT(*) as jumlah from vehicle.[vehiclemaster] WHERE ChasisNo = :chasisno OR EngineNo = :engineno OR VHCode = :vhcode OR RegNo = :regno ", nativeQuery = true)
    int cekDataJumlah(String chasisno, String engineno, String vhcode, String regno);

    @Query(value = "SELECT Categoryid as categoryid from vehicle.[category] WHERE Category = :categorycode ", nativeQuery = true)
    String cekCategory(String categorycode);

    @Query(value = "SELECT EstateID as estateid from general.[estate] WHERE Abbreviation = :businessunitcode ", nativeQuery = true)
    String cekEstate(String businessunitcode);

}
