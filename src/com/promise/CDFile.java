/*
********************************************************************************
*                                                                              *
*                         word pdf html ����ͳһ�ӿ�                           *
*                                                                              *
********************************************************************************
*
* ��Ȩ����:  Copyright(c) 2000-2010 PROMISE Networks.All Right Reserved
*
* �ļ��б�:  ALL
*
* ��    ��:  �κ��˶������⴫���޸ģ��޸ĺ��뽫�޸Ĳ��ַ���chenlx10@163.com,�κ�
             ���ⶼ����chenlx10@163.com��ϵ��δ������ַ��www.frdog.org
*
* ��    ��:   ������
*
* ��    ��:   v1.0
*
* ����:     20100920
*
********************************************************************************
*
* ��ʷ��¼:
*
*         v1.0 20100920 edited by MagicPromise
*
*/

package com.promise;

import java.io.File;

/**
 * ɾ���ļ���Ŀ¼
 * 
 * @author chen
 * 
 */
public class CDFile {

	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("ɾ���ļ�ʧ��:" + fileName + "�����ڣ�");
			return false;
		} else {
			if (file.isFile())
				return deleteFile(fileName);
			else
				return deleteDirectory(fileName);
		}
	}

	/**
	 * ɾ�������ļ�
	 * 
	 * @param fileName
	 *            Ҫɾ�����ļ����ļ���
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
				return true;
			} else {
				System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
				return false;
			}
		} else {
			System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
			return false;
		}
	}

	/**
	 * ɾ��Ŀ¼��Ŀ¼�µ��ļ�
	 * 
	 * @param dir
	 *            Ҫɾ����Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteDirectory(String dir) {
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�" + dir + "�����ڣ�");
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����е������ļ�������Ŀ¼
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = CDFile.deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// ɾ����Ŀ¼
			else if (files[i].isDirectory()) {
				flag = CDFile.deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�");
			return false;
		}
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public static void main(String[] args) { // ɾ�������ļ� String file =
	 * "c:/test/test0/test1/test2/testFile.txt"; CDFile.deleteFile(file);
	 * System.out.println(); // ɾ��һ��Ŀ¼ String dir = "c:/test/test0/test1";
	 * CDFile.deleteDirectory(dir); System.out.println(); // ɾ���ļ� dir =
	 * "c:/test/test0"; CDFile.delete(dir);
	 * 
	 * }
	 */
}
