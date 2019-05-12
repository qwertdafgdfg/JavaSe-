package in.cn.wenda.ms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import in.cn.wenda.ms.DBtools.JDBCUtils;
import in.cn.wenda.ms.domain.Accounting;
/*
 *  ʵ�ֶ����ݱ� gjp_zhangwu ������ɾ�Ĳ����
 *  dbuils���������,���Ա����QueryRunner����,ָ������Դ
 */
public class AccountingDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
/*
 * ���巽������ѯ���ݿ⣬��ȡ���е���������
 * ��������ҵ������
 * 
 * ������������е��������ݣ��洢��Bean�����У������ٴ洢�������С�
 */
	public List<Accounting> selectAll() {
		//��ѯ�������ݵ�SQL���
		String sql = "SELECT * FROM AS_zhangwu";
		try {
			//����qr����ķ�����query�����������BeanListHandler
			List<Accounting> list = qr.query(sql, 
					new BeanListHandler<Accounting>(Accounting.class));
			
			System.out.println(list.get(1).toString());
			
			List<Object> list1 = qr.query(sql, new ColumnListHandler<Object>("createtime"));
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setDATE(list1.get(i).toString());// ��Date���͵�ת��ΪtoString
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��");
		}
		
	}
	/*
	 * ���巽������ѯ���ݿ⣬��������ȥ��ѯ�����
	 * 
	 * ��ҵ�����ã���ѯ������洢��Bean�����У��洢��List����
	 * �����ߴ���2�������ַ�����
	 */
	public List<Accounting> select(String startDate, String endDate) {
		try {
			//ƴд������ѯ��SQL���
			String sql = "SELECT * FROM AS_zhangwu WHERE createtime BETWEEN ? AND ?";
			//����������飬�洢��ռλ��
			Object[] params = {startDate, endDate};
			//����qr����ķ���query��ѯ���ݱ���ȡ�������
			return qr.query(sql, new BeanListHandler<>(
					Accounting.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("������ѯʧ�ܣ�����");
		}
	}
	
	/*
	 * ���巽����ʵ�����������
	 * ��ҵ�����ã�����ZhangWu����
	 * ��ZhangWu�����е����ݣ���ӵ����ݿ�
	 */
	public void addAccounting(Accounting at) {
		try {
			//ƴ��������ݵ�sql
			String sql = "INSERT INTO AS_zhangwu (flname, money, zhanghu, createtime, description) VALUES(?,?,?,?,?)";
			//��������������5��ռλ����
			//ʵ�ʲ�����Դ�Ǵ��ݹ����Ķ���Accounting
			Object[] params = {at.getFlname(), at.getMoney(),at.getZhanghu(),at.getDATE(),at.getDescription()};
			//����qr�����еķ���updateִ����ӡ�
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�������ʧ��");
		}
	}
	
	/*
	 * ���巽����ʵ�ֱ༭���ܣ�
	 * ��service����ã�����Accounting����
	 * �������е����ݣ����µ����ݱ�
	 */
	public void editAccounting(Accounting at) {
		try {
			//�������ݵ�SQL
			String sql = "UPDATE AS_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//����������󣬷�װ��������
			Object[] params = {at.getFlname(),at.getMoney(),at.getZhanghu(),at.getDATE(),at.getDescription(),at.getZwid()};
			//����qr���󷽷�updateִ�и���
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�༭����ʧ�ܡ�");
		}
	}
	
	/*
	 * ���巽����ʵ��ɾ��ҵ��
	 * ��Serviceҵ�����ã���������id
	 */
	public void deleteAccounting(int zwid) {
		try {
			//ƴдɾ������SQL
			String sql = "DELETE FROM AS_zhangwu WHERE zwid=?";
			qr.update(sql, zwid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ������ʧ�ܣ�����");
		}		
	}
	
}
