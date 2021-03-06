package com.ruochen.dao.impl;

import com.ruochen.dao.UserDao;
import com.ruochen.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(final User user) {

        // 创建 PrepareStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始 jdbc 完成一个 PrepareStatement 的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        // 创建 KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        // 获得生成的主键
        long userId = keyHolder.getKey().longValue();

        // jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return userId;  // 返回当前保存的用户的id，该id 是数据库自动生成的
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)", userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?", userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
