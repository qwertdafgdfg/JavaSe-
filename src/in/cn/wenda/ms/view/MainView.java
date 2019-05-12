package in.cn.wenda.ms.view;

import java.util.List;
import java.util.Scanner;

import in.cn.wenda.ms.controller.AccountingController;
import in.cn.wenda.ms.domain.Accounting;

/*
 * ��ͼ�㣬�û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ�ã�����controller���󡣣���Controller���������
 */

public class MainView {

	// View��������Controller��
	private AccountingController controller = new AccountingController();

	public void run() {
		// ����Scanner��������̷������롣
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");

			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				// ѡ���������,�����������ķ���
				addAccounting();
				break;
			case 2:
				// ѡ��ı༭����,���ñ༭���񷽷�
				editAccounting();
				break;
			case 3:
				// ѡ���ɾ������,����ɾ�����񷽷�
				deleteAccounting();
				break;
			case 4:
				// ѡ����ǲ�ѯ����,���ò�ѯ����
				selectAccounting();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("��ѡ������");
				break;
			}
		}
	}

	/*
	 * ���巽����ʵ������ɾ��
	 * ʵ��˼�룺
	 * 		�����û������룬����һ������ ����
	 * 		����Controller�㷽��������һ��������
	 */
	public void deleteAccounting() {
		//���ò�ѯ�����������ݵĹ��ܣ�
		//�����������ݣ�����ѡ��һ�����ɾ��
		selectAll();
		System.out.println("ѡ�����ɾ�����ܣ���������ż���");
		int zwid = new Scanner(System.in).nextInt();
		//����Controller���Ʋ㷽������������id���ɡ�
		controller.deleteAccounting(zwid);
		System.out.println("ɾ������ɹ�");
	}

	// ���巽����ʵ�ֶ�����ı༭����
	// ʵ��˼�룺
	// �����û��������Ϣ����װ��Accounting����
	// ���ÿ��Ʋ�ķ���������Accounting����ʵ�ֱ༭��
	public void editAccounting() {
		// ���ò�ѯ�����������ݵĹ��ܣ���ʾ����
		// �����������ݣ�����ѡ��һ������޸�
		selectAll();
		System.out.println("ѡ����Ǳ༭���ܣ�����������");
		Scanner sc = new Scanner(System.in);
		System.out.print("������ID");
		int zwid = sc.nextInt();
		System.out.println("�����������");
		String flname = sc.next();
		System.out.println("������");
		double money = sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu = sc.next();
		System.out.println("�������ڣ���ʽXXXX-XX-xx");
		String createtime = sc.next();
		System.out.println("�����������");
		String description = sc.next();
		// ���û���������ݣ���װ��ZhangWu������
		// �û������ID�������װ����������
		Accounting at = new Accounting(zwid, flname, money, zhanghu, createtime, description);
		// ����controller���еķ�����ʵ�ֱ༭����
		controller.editAccounting(at);
		System.out.println("����༭�ɹ�");
	}

	/*
	 * ���巽��addAccounting �������ķ������û��ڽ���ѡ��1��ʱ����� ʵ��˼�룺 ���ܼ������룬5�����룬����controller��ķ���
	 */
	public void addAccounting() {
		System.out.println("ѡ�����������ܣ���������������");
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������");
		String flname = sc.next();
		System.out.println("������");
		double money = sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu = sc.next();
		System.out.println("�������ڣ���ʽXXXX-XX-xx");
		String createtime = sc.next();
		System.out.println("�����������");
		String description = sc.next();

		// �����ܵ������ݣ�����Controller��ķ��������ݲ�����ʵ���������
		// ���û���������в�������װ��Accounting����
		Accounting at = new Accounting(0, flname, money, zhanghu, createtime, description);
		controller.addAccounting(at);
		System.out.println("��ϲ���������ɹ�������");
	}

	/*
	 * ���巽����SelectAccounting���� ��ʾ��ѯ�ķ��� 1�����в�ѯ�� 2����������ѯ�� �����û���ѡ��
	 */
	public void selectAccounting() {
		System.out.println("1.��ѯ����		2.��������ѯ");
		Scanner sc = new Scanner(System.in);

		int chooser = sc.nextInt();
		switch (chooser) {
		case 1:
			// ѡ��Ĳ�ѯ����,���ò�ѯ���еķ�����
			selectAll();
			break;
		case 2:
			// ѡ���������ѯ�����ô���������ѯ�ķ�����
			select();
			break;
		default:
			break;
		}
	}

	// ʵ�ֲ�ѯ���еĲ�������
	private void selectAll() {
		// ���ÿ��Ʋ��еķ�������ѯ���е���������
		List<Accounting> list = controller.selectAll();
		if (list.size() != 0) {
			// �����ͷ
			System.out.println("ID\t\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
			// ��������,����������̨
			for (Accounting zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getDATE() + "\t" + zw.getDescription());
			}
		} else
			System.out.println("û�в�ѯ������");
	}

	/*
	 * ���巽����ʵ��������ѯ�������� �ṩ�û����������ڣ���ʼ���ڽ������� ��2�����ڣ����ݵ�controller��
	 * ����controller����������2�����ڲ��� ��ȡ��controller��ѯ�Ľ��������ӡ����
	 */
	private void select() {
		System.out.println("ѡ��������ѯ,�������ڸ�ʽXXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����뿪ʼ����:");
		String startDate = sc.nextLine();
		System.out.print("������������:");
		String endDate = sc.nextLine();
		// ����controller��ķ���,��������,��ȡ��ѯ�����
		List<Accounting> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			// �����ͷ
			System.out.println("ID\t\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
			// ��������,����������̨
			for (Accounting zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getDATE() + "\t" + zw.getDescription());
			}
		} else
			System.out.println("û�в�ѯ������");
	}
}
