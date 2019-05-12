package in.cn.wenda.ms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import in.cn.wenda.ms.DBtools.JDBCUtils;
import in.cn.wenda.ms.domain.Accounting;
/*
 *  实现对数据表 gjp_zhangwu 数据增删改查操作
 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
 */
public class AccountingDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
/*
 * 定义方法，查询数据库，获取所有的账务数据
 * 方法，由业务层调用
 * 
 * 结果集：将所有的账务数据，存储到Bean对象中，对象再存储到集合中。
 */
	public List<Accounting> selectAll() {
		//查询账务数据的SQL语句
		String sql = "SELECT * FROM AS_zhangwu";
		try {
			//调用qr对象的方法；query方法，结果集BeanListHandler
			List<Accounting> list = qr.query(sql, 
					new BeanListHandler<Accounting>(Accounting.class));
			
			System.out.println(list.get(1).toString());
			
			List<Object> list1 = qr.query(sql, new ColumnListHandler<Object>("createtime"));
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setDATE(list1.get(i).toString());// 将Date类型的转换为toString
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有账务失败");
		}
		
	}
	/*
	 * 定义方法，查询数据库，带有条件去查询账务表
	 * 
	 * 由业务层调用，查询结果集存储到Bean对象中，存储到List集合
	 * 调用者传递2个日期字符串。
	 */
	public List<Accounting> select(String startDate, String endDate) {
		try {
			//拼写条件查询的SQL语句
			String sql = "SELECT * FROM AS_zhangwu WHERE createtime BETWEEN ? AND ?";
			//定义对象数组，存储？占位符
			Object[] params = {startDate, endDate};
			//调用qr对象的方法query查询数据表，获取结果集。
			return qr.query(sql, new BeanListHandler<>(
					Accounting.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("条件查询失败！！！");
		}
	}
	
	/*
	 * 定义方法，实现添加账务功能
	 * 由业务层调用，传递ZhangWu对象
	 * 将ZhangWu对象中的数据，添加到数据库
	 */
	public void addAccounting(Accounting at) {
		try {
			//拼接添加数据的sql
			String sql = "INSERT INTO AS_zhangwu (flname, money, zhanghu, createtime, description) VALUES(?,?,?,?,?)";
			//创建数组对象，填充5个占位符。
			//实际参数来源是传递过来的对象Accounting
			Object[] params = {at.getFlname(), at.getMoney(),at.getZhanghu(),at.getDATE(),at.getDescription()};
			//调用qr对象中的方法update执行添加。
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("账务添加失败");
		}
	}
	
	/*
	 * 定义方法，实现编辑功能，
	 * 由service层调用，传递Accounting对象
	 * 将对象中的数据，更新到数据表。
	 */
	public void editAccounting(Accounting at) {
		try {
			//更新数据的SQL
			String sql = "UPDATE AS_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//定义数组对象，封装所有数据
			Object[] params = {at.getFlname(),at.getMoney(),at.getZhanghu(),at.getDATE(),at.getDescription(),at.getZwid()};
			//调用qr对象方法update执行更新
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("编辑账务失败。");
		}
	}
	
	/*
	 * 定义方法，实现删除业务
	 * 被Service业务层调用，传递主键id
	 */
	public void deleteAccounting(int zwid) {
		try {
			//拼写删除数据SQL
			String sql = "DELETE FROM AS_zhangwu WHERE zwid=?";
			qr.update(sql, zwid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除账务失败！！！");
		}		
	}
	
}
