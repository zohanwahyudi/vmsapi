package rea.webservice.vms.vms.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rea.webservice.vms.vms.models.entities.Vms;

public interface VmsRepo extends CrudRepository <Vms, Long> {
    @Query(value = "SELECT * FROM vehicle.[vehiclemaster] where " +
    "categoryid LIKE CASE WHEN :categoryid != '' OR :categoryid IS NOT NULL THEN CONCAT('%', :categoryid, '%') END " +
    "AND estateid LIKE CASE WHEN :estateid != '' OR :estateid IS NOT NULL THEN CONCAT('%', :estateid, '%') END " +
    "AND vhcode LIKE CASE WHEN :vhcode != '' OR :vhcode IS NOT NULL THEN CONCAT('%', :vhcode, '%') END " +
    "AND vhbrand LIKE CASE WHEN :vhbrand != '' OR :vhbrand IS NOT NULL THEN CONCAT('%', :vhbrand, '%') END " +
    "AND chasisno LIKE CASE WHEN :chasisno != '' OR :chasisno IS NOT NULL THEN CONCAT('%', :chasisno, '%') END " +
    "AND engineno LIKE CASE WHEN :engineno != '' OR :engineno IS NOT NULL THEN CONCAT('%', :engineno, '%') END " +
    "AND stnk LIKE CASE WHEN :stnk != '' OR :stnk IS NOT NULL THEN CONCAT('%', :stnk, '%') END " +
    "AND manufactureyear LIKE CASE WHEN :manufactureyear != '' OR :manufactureyear IS NOT NULL THEN CONCAT('%', :manufactureyear, '%') END " +
    "AND capacity LIKE CASE WHEN :capacity != '' OR :capacity IS NOT NULL THEN CONCAT('%', :capacity, '%') END " +
    "AND stnkexpired LIKE CASE WHEN :stnkexpired != '' OR :stnkexpired IS NOT NULL THEN CONCAT('%', :stnkexpired, '%') END ", nativeQuery = true )
    List<Vms> Search(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired);

    @Query(value = "SELECT COUNT(*) as jumlah FROM vehicle.[vehiclemaster] where " +
    "categoryid LIKE CASE WHEN :categoryid != '' OR :categoryid IS NOT NULL THEN CONCAT('%', :categoryid, '%') END " +
    "AND estateid LIKE CASE WHEN :estateid != '' OR :estateid IS NOT NULL THEN CONCAT('%', :estateid, '%') END " +
    "AND vhcode LIKE CASE WHEN :vhcode != '' OR :vhcode IS NOT NULL THEN CONCAT('%', :vhcode, '%') END " +
    "AND vhbrand LIKE CASE WHEN :vhbrand != '' OR :vhbrand IS NOT NULL THEN CONCAT('%', :vhbrand, '%') END " +
    "AND chasisno LIKE CASE WHEN :chasisno != '' OR :chasisno IS NOT NULL THEN CONCAT('%', :chasisno, '%') END " +
    "AND engineno LIKE CASE WHEN :engineno != '' OR :engineno IS NOT NULL THEN CONCAT('%', :engineno, '%') END " +
    "AND stnk LIKE CASE WHEN :stnk != '' OR :stnk IS NOT NULL THEN CONCAT('%', :stnk, '%') END " +
    "AND manufactureyear LIKE CASE WHEN :manufactureyear != '' OR :manufactureyear IS NOT NULL THEN CONCAT('%', :manufactureyear, '%') END " +
    "AND capacity LIKE CASE WHEN :capacity != '' OR :capacity IS NOT NULL THEN CONCAT('%', :capacity, '%') END " +
    "AND stnkexpired LIKE CASE WHEN :stnkexpired != '' OR :stnkexpired IS NOT NULL THEN CONCAT('%', :stnkexpired, '%') END ", nativeQuery = true )
    int JumlahSearch(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired);

    @Query(value = "SELECT COUNT(*) as jumlah FROM vehicle.[vehiclemaster]", nativeQuery = true)
    int jumlahFindAll();

    @Query(value = "SELECT * from vehicle.[vehiclemaster] ORDER BY ID DESC OFFSET :offset ROWS FETCH NEXT :fetch ROWS ONLY ", nativeQuery = true)
    Iterable<Vms> getAllDataTOP(Integer fetch, Integer offset);

    @Query(value = "SELECT * from vehicle.[vehiclemaster] WHERE ChasisNo = :chasisno OR EngineNo = :engineno ", nativeQuery = true)
    List<Vms> cekData(String chasisno, String engineno);

    @Query(value = "SELECT COUNT(*) as jumlah from vehicle.[vehiclemaster] WHERE ChasisNo = :chasisno OR EngineNo = :engineno ", nativeQuery = true)
    int cekDataJumlah(String chasisno, String engineno);
    
    @Query(value = "SELECT categoryid from vehicle.[category] WHERE Category = :categorycode ", nativeQuery = true)
    String cekCategory(String categorycode);

    @Query(value = "SELECT EstateID as estateid from general.[estate] WHERE Abbreviation = :businessunitcode ", nativeQuery = true)
    String cekEstate(String businessunitcode);

    @Query(value = "INSERT INTO Vehicle.[VehicleMaster] (CategoryID, EstateID, ContractorID, VHCode, VHBrand, VHModel, VHColor, Active, DateOfCommission, ChasisNo, EngineNo, RegNo, STNK, Remarks, CreatedBy, CreatedOn, ModifiedBy, ModifiedOn, t8, InActiveDate, ManufactureYear, Capacity, Tare, STNKExpired, Tanker) OUTPUT INSERTED.* VALUES (:categoryid, :estateid, NULL, :vhcode, :vhbrand, :vhmodel, :vhcolor, 1, :dateofcommission, :chasisno, :engineno, :regno, :stnk, '', :user, GETDATE(), '', '', :t8, NULL, :manufactureyear, :capacity, :tare, :stnkexpired, :tanker) ", nativeQuery = true)
    List<Vms> insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String vhcolor, String dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, Integer capacity, Integer tare, String stnkexpired, Integer tanker );
    
}
