package jdbc.ex;

import jdbc.dao.*;
import jdbc.dto.*;
import java.util.*;


public class jdbcEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		String menu="�����";//�޴��� �ֹ��Ǿ��ٰ� ����
=======
		String menu="�ֵ���";//�޴��� �ֹ��Ǿ��ٰ� ����
>>>>>>> b53de909580370ac63681362dce5f27b6734dcae
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");//�ֹ��� ������ ��Ḧ ������ String�� ����
		for(int i=0;i<ingredient.length;i++) {//��� ���� 1�� �̰ų� 2�� �̹Ƿ� �迭�� ���̿� ���� �ݺ�
			PCDao.useStock(ingredient[i]);//��� ���� �� ���� �ٿ���
		}
		//���� �� stock table Ȯ���ϸ� �ش� ��� ���� �ϳ��� ������
	}

}
