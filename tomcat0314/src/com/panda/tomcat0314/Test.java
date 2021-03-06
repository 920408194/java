package com.panda.tomcat0314;

import java.sql.*;

/**
 * @author panda
 * @description
 * @date 2020/3/14
 */
public class Test {
    public static void main(String[] args) {
        //try catch处理异常
        try {
//            //反射加载驱动，jdbc4.0好像不用这步操作
//            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接地址,并处理中文乱码
            String url = "jdbc:mysql://8.129.209.12:3306/panda_test?useUnicode=true&characterEncoding=UTF-8";
            //用户信息
            String usr = "panda";//
            String password = "P@nda2877";//
            //新建connection连接
            Connection connection = DriverManager.getConnection(url,usr,password);
            //获取statement并执行语句
            Statement statement = connection.createStatement();

//            //insert,update,delete等语句需要使用executeUpdate
//            String sql = "insert into foods(title,owner,price,date,sold,image) values('可乐','panda',2.5,'2020-01-01',0,'n')";
//            statement.executeUpdate(sql);

            //查询需要使用executeQuery
            String sql = "select * from foods";
            ResultSet resultSet =  statement.executeQuery(sql);
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String owner = resultSet.getString("owner");
                double price = resultSet.getDouble("price");
                Date date = resultSet.getDate("date");
                int sold = resultSet.getInt("sold");
                String image = resultSet.getString("image");
                System.out.println(title);

            }
        } catch (/*ClassNotFoundException |*/ SQLException e) {
            e.printStackTrace();
        }
    }
}
