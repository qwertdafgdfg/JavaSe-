package in.cn.wenda.ms.controller;

import java.util.List;

import in.cn.wenda.ms.domain.Accounting;
import in.cn.wenda.ms.service.AccountingService;

public class AccountingController {
	//������Service�㣬�Ͻ�view�㡣
	private AccountingService service = new 
			AccountingService();

	/*
	 * ���Ʋ��ඨ�巽����ʵ�ֲ�ѯ���е���������
	 * ��������ͼ����ã�ȥservice�����selectAll����
	 */
	public List<Accounting> selectAll() {
		return service.selectAll();
	}

	/*
	 * ���巽����ʵ��������ѯ����
	 * ��������ͼ����ã������������ڵ��ַ���
	 * ȥ����Service��ķ������������������ַ�������ȡ�����
	 * ��������ظ���ͼ�㡣
	 */
	public List<Accounting> select(String startDate, String endDate) {

		return service.select(startDate, endDate);
	}

	/*
	 * * ���巽����ʵ��������ӹ���
	 * ����ͼ����ã����ݲ���(���ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu���͵Ķ���)
	 * 
	 * ����������service��ķ���������Accounting���󣬻�ȡ�����
	 * ��Ľ��������ӳɹ�Ӱ���������int��
	 */
	public void addAccounting(Accounting at) {
		// TODO Auto-generated method stub
		service.addAccounting(at);
	}

	/*
	 * ���巽����ʵ�ֱ༭������
	 * ����ͼ��view���ã����ݲ�����Ҳ��Accounting����
	 * ȥ����service��ķ���
	 */
	public void editAccounting(Accounting at) {
		service.editAccounting(at);		
	}

	/*
	 * ʵ��ɾ������
	 * ����ͼ��View���ã�����int����������
	 * ȥ����service�㷽��������int������
	 */
	public void deleteAccounting(int zwid) {
		// TODO Auto-generated method stub
		service.deleteAccounting(zwid);
	}
	
	
}
