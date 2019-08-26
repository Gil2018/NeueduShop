package dao.impl;

import dao.NgmcManufacturerDao;
import entity.NgmcManufacturer;
import util.DBUtil;

import java.sql.SQLException;

public class NgmcManufacturerDaoimpl extends DBUtil implements NgmcManufacturerDao{
    //添加新品牌
    @Override
    public int saveM(NgmcManufacturer Manufacturer) throws SQLException {
        String sql = "insert into ngmc_manufacturer(name_en,name_cn,gmc_report_type,gmc_report_url,description,sts_cd)"
                + " values (?,?,?,?,?,?)";
        return executeUpdate(sql,Manufacturer.getName_en(),Manufacturer.getName_cn(),Manufacturer.getGmc_report_type(),Manufacturer.getGmc_report_url(),
                Manufacturer.getDescription(),Manufacturer.getSts_cd());
    }
}
