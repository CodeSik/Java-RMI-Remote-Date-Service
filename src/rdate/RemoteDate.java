package rdate;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Locale;

public interface RemoteDate extends Remote {
    Date remoteDate() throws RemoteException; // com.client.server machine상의 시간을 조회하여 Date object으로 되돌려준다.
    String regionalDate(Locale language) throws RemoteException;
    //input argument에 지정된 locale에 맞도록 서버 컴퓨터의 시간을 스트링 형태로 변환하여 반환한다.
    // 본 과제에서는 “en”과 “kr” language를 지원해야 한다.
}