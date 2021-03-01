package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbUtil {
    /**
     * @连接数据库的一些参数配置
     * JDBC连接数据库的步骤：
     * 1、定义数据库的URL（url里面需要加上时区），账号密码，数据库连接的驱动
     * 2、初始化数据库连接驱动，Class.forName()
     * 3、使用驱动进行数据库连接，DriverManager.getConnection(url,uername.password)
     * 4、使用数据库连接执行数据库语句，
     *   （1）、设置数据库语句，含参数
     *   （2）、使用连接对象预处理sql语句，PreparedStatement pstmt = Connection.preparedstatement(sql)
     *   （3）、设置数据库参数，pstmt.setString()
     *   （4）、执行数据库语句，并返回结果集，pstmt.excuteQuery()
     * 5、关闭数据库连接
     * @byJackson
     */
    //设置数据库链接，注意这里要设定时区，否则会报错
    private String dbUrl = "jdbc:mysql://localhost:3306/WebDemoDB?serverTimezone=UTC";
    //设置数据库操作的账号密码
    private String dbUsername = "root";
    private String dbPassword = "674439544";
    //设置数据库驱动
    private String jdbcName = "com.mysql.cj.jdbc.Driver";
    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getcon() throws Exception{
        //初始化数据库驱动
        Class.forName(jdbcName);
        System.out.println("Connecting...");
        //进行数据库连接
        Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //返回数据库连接，Dao需要调用数据库连接来实现数据库的相关操作
        return con;
    }

    /**
     * 关闭数据库连接
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con)throws Exception{
        if(con != null){
            con.close();
        }
    }

    /**
     * 测试数据库是否连接成功
     * @param args
     */
    public static void main(String[] args){
        DbUtil dbUtil1 = new DbUtil();
        try {
            dbUtil1.getcon();
            System.out.println("数据库连接成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
