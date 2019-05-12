package in.cn.wenda.ms.DBtools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//创建出BasicDataSource类对象,这个类是DataSource的实现类。
	private static BasicDataSource datasource = 
			new BasicDataSource();
	
	//静态代码块；类加载的时候执行
	//对象BasicDataSource对象中的配置，自定义。
	static {
		//数据库连接信息，必须的。
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/Accounting_SoftWare");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		//对象连接池中的连接数量配置，可选的。
		datasource.setInitialSize(10);//初始化连接数
		datasource.setMaxActive(8);//最大连接数。
		datasource.setMaxIdle(5);//最大空闲数   超过5，缩小。
		datasource.setMinIdle(1);	//最小空闲数。 低于1增大。
	}
	
	//定义静态方法，返回BasicDataSource类的对象（实际是这个对象，多态调用。）
	public static DataSource getDataSource() {
		return datasource;
	}
}
