package org.jiuyu.bingfa;

import org.junit.Test;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class ThreadLocalDemo {
    class MyDataSource implements DataSource{
        private final String name = "alibaba_dataSource";

        public Connection getConnection() throws SQLException {
            return null;
        }

        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }

        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        public void setLoginTimeout(int seconds) throws SQLException {

        }

        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }

        public String getName(){
            return this.name;
        }

    }

    @Test
    public void test(){
        ThreadLocal<DataSource> dataSourceThreadLocal = new ThreadLocal<DataSource>();
        DataSource dataSource = new MyDataSource();
        dataSourceThreadLocal.set(dataSource);
        try {
            MyDataSource dataSource1 = (MyDataSource) dataSourceThreadLocal.get();
            System.out.println(dataSource1.getName());
        }finally {
            dataSourceThreadLocal.remove();
            //此处从threadLocal获取对象为null
            MyDataSource dataSource2 = (MyDataSource) dataSourceThreadLocal.get();
            System.out.println(dataSource2.getName());
        }

    }

}
