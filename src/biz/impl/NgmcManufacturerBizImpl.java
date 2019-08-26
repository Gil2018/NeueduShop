package biz.impl;

import biz.NgmcManufacturerBiz;
import dao.NgmcManufacturerDao;
import dao.impl.NgmcManufacturerDaoimpl;
import entity.NgmcManufacturer;

import java.sql.SQLException;

public class NgmcManufacturerBizImpl implements NgmcManufacturerBiz {
    //新增品牌
    @Override
    public int addM(NgmcManufacturer Manufacturer) throws SQLException {
        try {
            return new NgmcManufacturerDaoimpl().saveM(Manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0 ;
        }
    }
}
