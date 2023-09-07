package rea.webservice.vms.vms.models.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rea.webservice.vms.vms.models.entities.Vms;

public interface VmsRepo extends CrudRepository <Vms, Long> {
    @Query(value = "SELECT id, (SELECT Category FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categorycode, (SELECT Description FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categoryname, (SELECT EstateName FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS Estatename, (SELECT Abbreviation FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS EstateCode, (SELECT Code FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorcode, (SELECT Name FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorname, vhcode, vhbrand, vhmodel, vhcolor, active, dateofcommission, chasisno, engineno, regno, stnk, remarks, createdby, createdon, modifiedby, modifiedon, t8, inactivedate, manufactureyear, capacity, tare, stnkexpired, tanker FROM vehicle.[vehiclemaster] where " +
    "CategoryID = CASE WHEN :categoryid != '' THEN :categoryid ELSE CategoryID END " +
    "AND EstateID = CASE WHEN :estateid != '' THEN :estateid ELSE EstateID END " +
    "AND VHCode = CASE WHEN :vhcode != '' THEN :vhcode ELSE VHCode END " +
    "AND VHBrand = CASE WHEN :vhbrand != '' THEN :vhbrand ELSE VHBrand END " +
    "AND ChasisNo = CASE WHEN :chasisno != '' THEN :chasisno ELSE ChasisNo END " +
    "AND EngineNo = CASE WHEN :engineno != '' THEN :engineno ELSE EngineNo END " +
    "AND STNK = CASE WHEN :stnk != '' THEN :stnk ELSE STNK END " +
    "AND ManufactureYear = CASE WHEN :manufactureyear != '' THEN :manufactureyear ELSE ManufactureYear END " +
    "AND Capacity = CASE WHEN :capacity != '' THEN :capacity ELSE Capacity END " +
    "AND STNKExpired = CASE WHEN :stnkexpired != '' THEN :stnkexpired ELSE STNKExpired END ", nativeQuery = true )
    List<Vms> Search(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired);

    @Query(value = "SELECT COUNT(*) as jumlah FROM vehicle.[vehiclemaster] where " +
    "CategoryID = CASE WHEN :categoryid != '' THEN :categoryid ELSE CategoryID END " +
    "AND EstateID = CASE WHEN :estateid != '' THEN :estateid ELSE EstateID END " +
    "AND VHCode = CASE WHEN :vhcode != '' THEN :vhcode ELSE VHCode END " +
    "AND VHBrand = CASE WHEN :vhbrand != '' THEN :vhbrand ELSE VHBrand END " +
    "AND ChasisNo = CASE WHEN :chasisno != '' THEN :chasisno ELSE ChasisNo END " +
    "AND EngineNo = CASE WHEN :engineno != '' THEN :engineno ELSE EngineNo END " +
    "AND STNK = CASE WHEN :stnk != '' THEN :stnk ELSE STNK END " +
    "AND ManufactureYear = CASE WHEN :manufactureyear != '' THEN :manufactureyear ELSE ManufactureYear END " +
    "AND Capacity = CASE WHEN :capacity != '' THEN :capacity ELSE Capacity END " +
    "AND STNKExpired = CASE WHEN :stnkexpired != '' THEN :stnkexpired ELSE STNKExpired END ", nativeQuery = true )
    int JumlahSearch(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired);

    @Query(value = "SELECT COUNT(*) as jumlah FROM vehicle.[vehiclemaster]", nativeQuery = true)
    int jumlahFindAll();
/*
    @Query(value = "SELECT * from vehicle.[vehiclemaster] ORDER BY ID DESC OFFSET :offset ROWS FETCH NEXT :fetch ROWS ONLY ", nativeQuery = true)
    Iterable<Vms> getAllDataTOP(Integer fetch, Integer offset);
 */
    @Query(value = "SELECT id, (SELECT Category FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categorycode, (SELECT Description FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categoryname, (SELECT EstateName FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS Estatename, (SELECT Abbreviation FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS EstateCode, (SELECT Code FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorcode, (SELECT Name FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorname, vhcode, vhbrand, vhmodel, vhcolor, active, dateofcommission, chasisno, engineno, regno, stnk, remarks, createdby, createdon, modifiedby, modifiedon, t8, inactivedate, manufactureyear, capacity, tare, stnkexpired, tanker from vehicle.[vehiclemaster] ORDER BY ID DESC OFFSET :offset ROWS FETCH NEXT :fetch ROWS ONLY ", nativeQuery = true)
    Iterable<Vms> getAllDataTOP(Integer fetch, Integer offset);

    @Query(value = "SELECT COUNT(*) as jumlah from vehicle.[vehiclemaster]  ", nativeQuery = true)
    int jumlahAllData();

    @Query(value = "SELECT id, (SELECT Category FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categorycode, (SELECT Description FROM vehicle.[Category] WHERE CategoryID = vehicle.[vehiclemaster].CategoryID) AS categoryname, (SELECT EstateName FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS Estatename, (SELECT Abbreviation FROM General.[Estate] WHERE EstateID = vehicle.[vehiclemaster].EstateID) AS EstateCode, (SELECT Code FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorcode, (SELECT Name FROM General.[Contractor] WHERE ContractorID = vehicle.[vehiclemaster].ContractorID) AS contractorname, vhcode, vhbrand, vhmodel, vhcolor, active, dateofcommission, chasisno, engineno, regno, stnk, remarks, createdby, createdon, modifiedby, modifiedon, t8, inactivedate, manufactureyear, capacity, tare, stnkexpired, tanker from vehicle.[vehiclemaster] WHERE VHCode = :vhcode ", nativeQuery = true)
    List<Vms> cekData(String vhcode);

    @Query(value = "SELECT COUNT(*) as jumlah from vehicle.[vehiclemaster] WHERE VHCode = :vhcode ", nativeQuery = true)
    int cekDataJumlah(String vhcode);
    
    @Query(value = "SELECT Categoryid as categoryid from vehicle.[category] WHERE Category = :categorycode ", nativeQuery = true)
    String cekCategory(String categorycode);

    @Query(value = "SELECT EstateID as estateid from general.[estate] WHERE Abbreviation = :businessunitcode ", nativeQuery = true)
    String cekEstate(String businessunitcode);

    @Query(value = "SELECT ContractorID as contractorid from General.[Contractor] WHERE Code = :contractorcode ", nativeQuery = true)
    String cekContractor(String contractorcode);

    @Query(value = "INSERT INTO Vehicle.[VehicleMaster] (CategoryID, EstateID, ContractorID, VHCode, VHBrand, VHModel, VHColor, Active, DateOfCommission, ChasisNo, EngineNo, RegNo, STNK, Remarks, CreatedBy, CreatedOn, ModifiedBy, ModifiedOn, t8, InActiveDate, ManufactureYear, Capacity, Tare, STNKExpired, Tanker) OUTPUT inserted.VHCode VALUES (:categoryid, :estateid, NULL, :vhcode, :vhbrand, :vhmodel, :vhcolor, 1, :dateofcommission, :chasisno, :engineno, :regno, :stnk, '', :user, GETDATE(), '', '', :t8, NULL, :manufactureyear, :capacity, :tare, :stnkexpired, :tanker) ", nativeQuery = true)
    String insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String vhcolor, Date dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, Integer capacity, Integer tare, Date stnkexpired, Integer tanker );
    
}
