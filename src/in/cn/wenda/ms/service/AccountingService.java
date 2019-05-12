package in.cn.wenda.ms.service;

import java.util.List;

import in.cn.wenda.ms.dao.AccountingDao;
import in.cn.wenda.ms.domain.Accounting;

public class AccountingService {
	//service依赖于Dao。
	private AccountingDao dao = new AccountingDao();

	/*
	 * 定义方法，实现查询所有的账务数据。
	 * 此方法，由控制层调用，去调用dao层的方法。
	 * 返回存储zhangwu对象的List集合。
	 */
	public List<Accounting> selectAll() {
		
		return dao.selectAll();
	}

	/*
	 * 定义方法，实现条件查询账务
	 * 方法由Controller层调用，传递2个日期字符串
	 * 调用dao层的方法，传递2个日期字符串
	 * 获取到查询结果集
	 */
	public List<Accounting> select(String startDate, String endDate) {
		
		return dao.select(startDate, endDate);
	}

	/*
	 * 定义方法，实现添加账务
	 * 是由controller层调用的。这里去调用Dao层的方法操作数据，传递对象
	 */
	public void addAccounting(Accounting at) {
		dao.addAccounting(at);
	}

	/*
	 * 定义方法，实现编辑账务
	 * 被控制层Controller调用，传递Accounting对象
	 * 调用dao层的方法，传递Accounting对象。
	 */
	public void editAccounting(Accounting at) {
		dao.editAccounting(at);
	}

	/*
	 * 实现删除账务功能
	 * 被controller控制层调用，传递主键id
	 * 去调用dao层方法，传递主键id。
	 */
	public void deleteAccounting(int zwid) {
		// TODO Auto-generated method stub
		dao.deleteAccounting(zwid);
	}
	
	
	
}
