package org.csu.tshirt.persistence.impl;

import org.csu.tshirt.domain.Account;
import org.csu.tshirt.domain.Product;
import org.csu.tshirt.persistence.AccountDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
    ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
    DataSource dataSource= (DataSource) context.getBean("dataSource");
    @Override
    public Account getAccountByUserid(String userId) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        Account account= (Account) context.getBean("Account");
        try{
            connection=dataSource.getConnection();
            String sql="select User.User_name FROM User WHERE User.User_ID=#{userId}";
            pstmt=connection.prepareStatement(sql);
            account.setUserId(userId);
            account.setUsername(pstmt.getResultSet().getString(1));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public Account getAccountByUseridAndPassword(String userId, String password) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        Account account= (Account) context.getBean("Account");
        try{
            connection=dataSource.getConnection();
            String sql="select User.User_name FROM User WHERE User.User_ID=#{userId} AND User_password=#{password}";
            pstmt=connection.prepareStatement(sql);
            account.setUsername(pstmt.getResultSet().getString(1));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public void insertAccount(Account account) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        try{
            connection=dataSource.getConnection();
            String sql="insert INTO User (User.User_ID,User.User_name,User.User_password) values (?,?,?)";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,account.getUserId());
            pstmt.setString(2,account.getUsername());
            pstmt.setString(3,account.getPassword());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        try{
            connection=dataSource.getConnection();
            String sql="update User SET User.User_name=?,User.User_password=? values where User.User_ID=?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(3,account.getUserId());
            pstmt.setString(1,account.getUsername());
            pstmt.setString(2,account.getPassword());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
