package e4s0n.adr.chapter_2_server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import e4s0n.adr.chapter_2_server.aidl.IBinderPool;

public class BinderPoolService extends Service {
    public static final int BINDER_BOOK = 1;
    public static final int BINDER_COMPUTE = 2;

    public BinderPoolService() {
    }

    private Binder mBinder = new IBinderPool.Stub() {
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            switch (binderCode) {
                case BINDER_BOOK:
                    return new BookManagerImp();
                case BINDER_COMPUTE:
                    return new ComputeImp();
                default:
                    return null;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
