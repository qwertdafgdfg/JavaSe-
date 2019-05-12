package in.cn.wenda.ms.view;

import java.util.List;
import java.util.Scanner;

import in.cn.wenda.ms.controller.AccountingController;
import in.cn.wenda.ms.domain.Accounting;

/*
 * 视图层，用户看到和操作的界面
 * 数据传递给controller层实现
 * 成员位置，创建controller对象。（与Controller相关联。）
 */

public class MainView {

	// View层依赖于Controller。
	private AccountingController controller = new AccountingController();

	public void run() {
		// 创建Scanner类独享，键盘反复输入。
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");

			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				// 选择添加账务,调用添加账务的方法
				addAccounting();
				break;
			case 2:
				// 选择的编辑账务,调用编辑账务方法
				editAccounting();
				break;
			case 3:
				// 选择的删除账务,调用删除账务方法
				deleteAccounting();
				break;
			case 4:
				// 选择的是查询账务,调用查询方法
				selectAccounting();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("您选择有误");
				break;
			}
		}
	}

	/*
	 * 定义方法，实现账务删除
	 * 实现思想：
	 * 		接受用户的输入，输入一个主键 数据
	 * 		调用Controller层方法，传递一个主键。
	 */
	public void deleteAccounting() {
		//调用查询所有账务数据的功能，
		//看到所有数据，从中选择一项。进行删除
		selectAll();
		System.out.println("选择的是删除功能，请输入序号即可");
		int zwid = new Scanner(System.in).nextInt();
		//调用Controller控制层方法，传递主键id即可。
		controller.deleteAccounting(zwid);
		System.out.println("删除账务成功");
	}

	// 定义方法，实现对账务的编辑功能
	// 实现思想：
	// 接受用户输入的信息，封装成Accounting对象。
	// 调用控制层的方法，传递Accounting对象，实现编辑。
	public void editAccounting() {
		// 调用查询所有账务数据的功能，显示出来
		// 看到所有数据，从中选择一项，进行修改
		selectAll();
		System.out.println("选择的是编辑功能，请输入数据");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入ID");
		int zwid = sc.nextInt();
		System.out.println("输入分类名称");
		String flname = sc.next();
		System.out.println("输入金额");
		double money = sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu = sc.next();
		System.out.println("输入日期：格式XXXX-XX-xx");
		String createtime = sc.next();
		System.out.println("输入具体描述");
		String description = sc.next();
		// 将用户输入的数据，封装到ZhangWu对象中
		// 用户输入的ID，必须封装到到对象中
		Accounting at = new Accounting(zwid, flname, money, zhanghu, createtime, description);
		// 调用controller层中的方法，实现编辑账务
		controller.editAccounting(at);
		System.out.println("账务编辑成功");
	}

	/*
	 * 定义方法addAccounting 添加账务的方法，用户在界面选择1的时候调用 实现思想： 接受键盘输入，5项输入，调用controller层的方法
	 */
	public void addAccounting() {
		System.out.println("选择的添加账务功能，请输入以下内容");
		Scanner sc = new Scanner(System.in);
		System.out.println("输入分类名称");
		String flname = sc.next();
		System.out.println("输入金额");
		double money = sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu = sc.next();
		System.out.println("输入日期：格式XXXX-XX-xx");
		String createtime = sc.next();
		System.out.println("输入具体描述");
		String description = sc.next();

		// 将接受到的数据，调用Controller层的方法，传递参数，实现数据添加
		// 将用户输入的所有参数，封装成Accounting对象
		Accounting at = new Accounting(0, flname, money, zhanghu, createtime, description);
		controller.addAccounting(at);
		System.out.println("恭喜您添加账务成功！！！");
	}

	/*
	 * 定义方法：SelectAccounting（） 显示查询的方法 1、所有查询， 2、按条件查询。 接收用户的选择。
	 */
	public void selectAccounting() {
		System.out.println("1.查询所有		2.按条件查询");
		Scanner sc = new Scanner(System.in);

		int chooser = sc.nextInt();
		switch (chooser) {
		case 1:
			// 选择的查询所有,调用查询所有的方法。
			selectAll();
			break;
		case 2:
			// 选择的条件查询，调用带有条件查询的方法。
			select();
			break;
		default:
			break;
		}
	}

	// 实现查询所有的财务数据
	private void selectAll() {
		// 调用控制层中的方法，查询所有的账务数据
		List<Accounting> list = controller.selectAll();
		if (list.size() != 0) {
			// 输出表头
			System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			// 遍历集合,结果输出控制台
			for (Accounting zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getDATE() + "\t" + zw.getDescription());
			}
		} else
			System.out.println("没有查询到数据");
	}

	/*
	 * 定义方法，实现条件查询财务数据 提供用户的输入日期，开始日期结束日期 就2个日期，传递到controller层
	 * 调用controller方法，传递2个日期参数 获取到controller查询的结果集，打印出来
	 */
	private void select() {
		System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入开始日期:");
		String startDate = sc.nextLine();
		System.out.print("请输入结果日期:");
		String endDate = sc.nextLine();
		// 调用controller层的方法,传递日期,获取查询结果集
		List<Accounting> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			// 输出表头
			System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			// 遍历集合,结果输出控制台
			for (Accounting zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getDATE() + "\t" + zw.getDescription());
			}
		} else
			System.out.println("没有查询到数据");
	}
}
