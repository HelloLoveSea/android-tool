package com.china.service;

import com.china.jar.IVoiceCallBackInterface;
import com.china.jar.IVoiceClientInterface;
import com.china.jar.VoiceChangedListener;
import com.china.jar.VoiceManager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;

public class SimpleService extends Service{
	private static VoiceClientInterfaceImpl mBinder;
	@Override
	public IBinder onBind(Intent intent) {
		Logger.d();
		return mBinder;//���ͻ��˰�
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.d();
		if (null == mBinder){
			initService();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Logger.d();
		if (null == mBinder){
			initService();
		}
		return START_STICKY;
	}
	//ʵ��AIDL�Ľӿ�
	private class VoiceClientInterfaceImpl extends IVoiceClientInterface.Stub{
		protected RemoteCallbackList<IVoiceCallBackInterface> mRemoteCallbackList = 
				new RemoteCallbackList<IVoiceCallBackInterface>();
		private SimpleControl control;
		
		public VoiceClientInterfaceImpl(){
			control = new SimpleControl(voiceChangedListener);
		}
		
		@Override
		public void face() throws RemoteException {
			Logger.d("face----excute!");//�ͻ��˵���face����ʱ�����ִ�У����ӡface----excute!
		}

		@Override
		public void registerCallBack(IVoiceCallBackInterface arg0)
				throws RemoteException {
			Logger.d();
			mRemoteCallbackList.register(arg0);
			
		}

		@Override
		public void unRegisterCallBack(IVoiceCallBackInterface arg0)
				throws RemoteException {
			Logger.d();
			mRemoteCallbackList.unregister(arg0);
		}
		
		private VoiceChangedListener voiceChangedListener = new VoiceChangedListener() {
		
			@Override
			public void openAppByVoice(String arg0) {
				Logger.d("arg0 = " + arg0);
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i <len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).openAppByVoice(arg0);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}
		};
	}
	//��ʼ��������Ҫ����ϵͳע�����
	private void initService(){
		Logger.d();
		if (null == mBinder){
			synchronized (SimpleService.class) {
				if (null == mBinder){
					try {
						mBinder = new VoiceClientInterfaceImpl();
						ServiceManager.addService(VoiceManager.NAME, mBinder);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
}
