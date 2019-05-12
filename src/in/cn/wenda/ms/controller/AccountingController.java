package in.cn.wenda.ms.controller;

import java.util.List;

import in.cn.wenda.ms.domain.Accounting;
import in.cn.wenda.ms.service.AccountingService;

public class AccountingController {
	//依赖于Service层，上接view层。
	private AccountingService service = new 
			AccountingService();

	/*
	 * 控制层类定义方法，实现查询所有的账务数据
	 * 方法由视图层调用，去service层调用selectAll（）
	 */
	public List<Accounting> selectAll() {
		return service.selectAll();
	}

	/*
	 * 定义方法，实现条件查询账务
	 * 方法由视图层调用，传递两个日期的字符串
	 * 去掉用Service层的方法，传递两个日期字符串，获取结果集
	 * 结果集返回给视图层。
	 */
	public List<Accounting> select(String startDate, String endDate) {

		return service.select(startDate, endDate);
	}

	/*
	 * * 定义方法，实现账务添加功能
	 * 由视图层调用，传递参数(传递过来的参数不能是5个数据，传递的是一个ZhangWu类型的对象)
	 * 
	 * 本方法调用service层的方法，传递Accounting对象，获取到添加
	 * 后的结果集（添加成功影响的行数，int）
	 */
	public void addAccounting(Accounting at) {
		// TODO Auto-generated method stub
		service.addAccounting(at);
	}

	/*
	 * 定义方法，实现编辑账务功能
	 * 被视图层view调用，传递参数，也是Accounting对象
	 * 去调用service层的方法
	 */
	public void editAccounting(Accounting at) {
		service.editAccounting(at);		
	}

	/*
	 * 实现删除功能
	 * 被视图层View调用，传递int类型主键，
	 * 去调用service层方法，传递int主键。
	 */
	public void deleteAccounting(int zwid) {
		// TODO Auto-generated method stub
		service.deleteAccounting(zwid);
	}
	
	
}
