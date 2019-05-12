package in.cn.wenda.ms.service;

import java.util.List;

import in.cn.wenda.ms.dao.AccountingDao;
import in.cn.wenda.ms.domain.Accounting;

public class AccountingService {
	//service������Dao��
	private AccountingDao dao = new AccountingDao();

	/*
	 * ���巽����ʵ�ֲ�ѯ���е��������ݡ�
	 * �˷������ɿ��Ʋ���ã�ȥ����dao��ķ�����
	 * ���ش洢zhangwu�����List���ϡ�
	 */
	public List<Accounting> selectAll() {
		
		return dao.selectAll();
	}

	/*
	 * ���巽����ʵ��������ѯ����
	 * ������Controller����ã�����2�������ַ���
	 * ����dao��ķ���������2�������ַ���
	 * ��ȡ����ѯ�����
	 */
	public List<Accounting> select(String startDate, String endDate) {
		
		return dao.select(startDate, endDate);
	}

	/*
	 * ���巽����ʵ���������
	 * ����controller����õġ�����ȥ����Dao��ķ����������ݣ����ݶ���
	 */
	public void addAccounting(Accounting at) {
		dao.addAccounting(at);
	}

	/*
	 * ���巽����ʵ�ֱ༭����
	 * �����Ʋ�Controller���ã�����Accounting����
	 * ����dao��ķ���������Accounting����
	 */
	public void editAccounting(Accounting at) {
		dao.editAccounting(at);
	}

	/*
	 * ʵ��ɾ��������
	 * ��controller���Ʋ���ã���������id
	 * ȥ����dao�㷽������������id��
	 */
	public void deleteAccounting(int zwid) {
		// TODO Auto-generated method stub
		dao.deleteAccounting(zwid);
	}
	
	
	
}
