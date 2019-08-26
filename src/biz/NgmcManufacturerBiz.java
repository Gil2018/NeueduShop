package biz;

import entity.NgmcManufacturer;

import java.sql.SQLException;

public interface NgmcManufacturerBiz {
    //新增品牌
    int addM(NgmcManufacturer Manufacturer) throws SQLException;
}
