package site.mizhuo.designpattern.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @ClassName ConnectionPool
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-09 21:48
 * @Version 1.0
 **/
public class ConnectionPool {
    private Vector<Connection> pool;

    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "mizhuo";
    private String password = "123456";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 20;

    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        Connection conn = null;
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(url,username,password);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Connection getConnection(){
        if(pool.size() > 0){
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }else{
            return null;
        }
    }

    public synchronized void release(Connection conn){
        pool.add(conn);
    }
}
