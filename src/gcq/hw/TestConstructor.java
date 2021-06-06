package gcq.hw;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.io.Serializable;

public class TestConstructor {
	public static void main(String[] args) {
		System.out.println("========= test new ==========");

		Bean b1 = testNew();

		b1.setId(1);

		b1.setName("b1");

		System.out.println(b1);

		System.out.println("========= test newInstance ==========");

		Bean b2 = testNewInstance();

		b2.setId(2);

		b2.setName("b2");

		System.out.println(b2);

		System.out.println("========= test clone ==========");

		Bean b3 = testClone(b1);

		b3.setName("b3");

		System.out.println(b3);

		System.out.println("========= test serializeBean&unserializeBean ==========");

		serializeBean(b1);

		Bean b4 = unserializeBean();

		b4.setName("b4");

		System.out.println(b4);

	}

	public static Bean testNew() {
		Bean b = new Bean();

		return b;

	}

	public static Bean testNewInstance() {
		try {
			Bean b = Bean.class.newInstance();

			return b;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	public static Bean testClone(Bean bean) {
		try {
			Bean b = (Bean) bean.clone();

			return b;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	public static void serializeBean(Bean bean) {
		try {
			FileOutputStream fos = new FileOutputStream("bean.ser");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(bean);

			oos.close();

			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static Bean unserializeBean() {
		try {
			FileInputStream fis = new FileInputStream("bean.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);

			Bean b = (Bean) ois.readObject();

			return b;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return null;

	}

}

class Bean implements Cloneable, Serializable {
	private static final long serialVersionUID = 8017660448545672348L;

	int id;

	String name;

	Bean() {
		this(-1, "No Name");

		System.out.println("--Bean() called--");

	}

	public Bean(int id, String name) {
		this.id = id;

		this.name = name;

		System.out.println("--Bean(int id, String name) called--");

	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Bean@").append(this.hashCode())

				.append("[id:").append(id).append("; name:'").append(name).append("']");

		return sb.toString();

	}

	public int getId() {
		return id;

	}

	public void setId(int id) {
		this.id = id;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	@Override

	protected Bean clone() throws CloneNotSupportedException {
		System.out.println("-----clone[" + this + "]-----");

		return (Bean) super.clone();

	}

}
