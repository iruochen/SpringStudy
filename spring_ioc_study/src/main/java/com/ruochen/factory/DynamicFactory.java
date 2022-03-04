package com.ruochen.factory;

import com.ruochen.dao.UserDao;
import com.ruochen.dao.impl.UserDaoImpl;

public class DynamicFactory {
    /**
     * 工厂实例方法实例化
     * @return
     */
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
