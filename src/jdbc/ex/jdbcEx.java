package jdbc.ex;

import jdbc.dao.*;
import AdminChat.*;
import jdbc.dto.*;

import java.io.IOException;
import java.util.*;


public class jdbcEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*String menu="���̽�Ƽ";//�޴��� �ֹ��Ǿ��ٰ� ����
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");//�ֹ��� ������ ��Ḧ ������ String�� ����
		for(int i=0;i<ingredient.length;i++) {//��� ���� 1�� �̰ų� 2�� �̹Ƿ� �迭�� ���̿� ���� �ݺ�
			PCDao.useStock(ingredient[i]);//��� ���� �� ���� �ٿ���
		}*/
		//���� �� stock table Ȯ���ϸ� �ش� ��� ���� �ϳ��� ������
		managerGUI window=new managerGUI();
		window.managerWindow();
		AdminChat adminChat = new AdminChat();
		adminChat.serverStart();
	}

}
