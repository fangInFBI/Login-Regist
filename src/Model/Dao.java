package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Dao {
    /**
     * 登陆功能的数据库操作
     * @param user
     * @param con
     * @return User
     * @throws Exception
     */
    public User login(Connection con,User user) throws Exception{
        //创建结果对象，存储最终数据
        User resultUser = null;
        //定义执行的数据库语句
        String sql = "select * from WebDemo where username = ? and password = ?";
        //处理sql语句，类似于让sql语句准备好
        PreparedStatement pstmt = con.prepareStatement(sql);
        //设置sql语句中的参数
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        //执行sql语句
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){  //如果返回结果，则进行以下操作，如果没有返回结果，则结果集resultUser保持为null
            resultUser = new User();
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
        }
        //返回结果，servlet根据resultUser是否为null值，进行相应的操作
        return resultUser;
    }

    /**
     * 注册功能的数据库操作
     * @param con
     * @param user
     * @return
     * @throws Exception
     */

    public boolean register(Connection con,User user) throws Exception{
        //首先设置标志变量，最为前端的判断依据
        boolean flag = false;
        //类似于上面登陆功能的相关操作
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO WebDemo(username,password) VALUES(?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        if(pstmt.executeUpdate()>0){    //如果注册成功，则把标志变量设置为真
            flag = true;
        }
        //返回标志变量，servlet根据这个传回来的值进行判断是否注册成功，从而选择相应的操作
        return flag;
    }

}
