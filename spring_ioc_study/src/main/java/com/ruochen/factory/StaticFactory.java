package com.ruochen.factory;

import com.ruochen.dao.UserDao;
import com.ruochen.dao.impl.UserDaoImpl;

public class StaticFactory {
    /**
     * 工厂静态实例化实例化
     * @return
     */
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
