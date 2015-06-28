package com.internet.ThreadsDownload;

/**
 * 多线程下载的Main
 * @author Admin
 *
 */
public class MutiThreadDownMain {
	private static DownUtil download;
	
	public static void main(String[] args) {
		String path = "http://localhost:80/dream.gif";           //下载资源的路径
		String targetFile = "F:\\dream.gif";           //下载文件的保存地址
		int threadNum = 5;         //开启下载的线程数量
		download = new DownUtil(path, targetFile, threadNum);
		download.download();
		new Thread(new Runnable() {            //开启一个线程监听下载的百分率	
			@Override
			public void run() {
				int percent = 0;
				System.out.println("下载开始");
				while(percent<100){
					percent = download.getCompleteRate();
					System.out.println("已经下载了"+percent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("下载完成!");
			}
		}).start();
	}

}
