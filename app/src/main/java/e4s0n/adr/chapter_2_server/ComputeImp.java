package e4s0n.adr.chapter_2_server;

import android.os.RemoteException;

import e4s0n.adr.chapter_2_server.aidl.ICompute;

public class ComputeImp extends ICompute.Stub {


    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
