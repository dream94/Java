package com.internet.ThreadsDownload;

/**
 * ���߳����ص�Main
 * @author Admin
 *
 */
public class MutiThreadDownMain {
	private static DownUtil download;
	
	public static void main(String[] args) {
		String path = "http://localhost:80/dream.gif";           //������Դ��·��
		String targetFile = "F:\\dream.gif";           //�����ļ��ı����ַ
		int threadNum = 5;         //�������ص��߳�����
		download = new DownUtil(path, targetFile, threadNum);
		download.download();
		new Thread(new Runnable() {            //����һ���̼߳������صİٷ���	
			@Override
			public void run() {
				int percent = 0;
				System.out.println("���ؿ�ʼ");
				while(percent<100){
					percent = download.getCompleteRate();
					System.out.println("�Ѿ�������"+percent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("�������!");
			}
		}).start();
	}

}
