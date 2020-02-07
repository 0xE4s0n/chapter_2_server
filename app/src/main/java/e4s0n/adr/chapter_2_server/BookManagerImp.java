package e4s0n.adr.chapter_2_server;

import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import e4s0n.adr.chapter_2_server.aidl.Book;
import e4s0n.adr.chapter_2_server.aidl.IBookManager;

public class BookManagerImp extends IBookManager.Stub {
    private static final String TAG = "BMS";
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();

    @Override
    public List<Book> getBookList() throws RemoteException {
        mBookList.add(new Book(1,"Android"));
        mBookList.add(new Book(2,"Ios"));
        return mBookList;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        mBookList.add(book);
    }
}