package dao;

import entity.NgmcManufacturer;

import java.sql.SQLException;

public interface NgmcManufacturerDao {
    // 新增用户信息
    int saveM(NgmcManufacturer Manufacturer) throws SQLException;
}
