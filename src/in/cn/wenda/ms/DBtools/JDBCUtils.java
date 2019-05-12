package in.cn.wenda.ms.DBtools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//������BasicDataSource�����,�������DataSource��ʵ���ࡣ
	private static BasicDataSource datasource = 
			new BasicDataSource();
	
	//��̬����飻����ص�ʱ��ִ��
	//����BasicDataSource�����е����ã��Զ��塣
	static {
		//���ݿ�������Ϣ������ġ�
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/Accounting_SoftWare");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		//�������ӳ��е������������ã���ѡ�ġ�
		datasource.setInitialSize(10);//��ʼ��������
		datasource.setMaxActive(8);//�����������
		datasource.setMaxIdle(5);//��������   ����5����С��
		datasource.setMinIdle(1);	//��С�������� ����1����
	}
	
	//���徲̬����������BasicDataSource��Ķ���ʵ����������󣬶�̬���á���
	public static DataSource getDataSource() {
		return datasource;
	}
}
