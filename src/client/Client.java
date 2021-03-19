package client;

import rdate.RemoteDate;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    private Client() { }

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        String language= "";
        int num;

        Date resultDate;
        String resultString;
        String host = (args.length < 1) ? "192.168.123.101" : args[0];



        try {
            Registry registry = LocateRegistry.getRegistry(host);
            RemoteDate stub = (RemoteDate) registry.lookup("RemoteDate");
            while(true)
            {
                System.out.println("서버 시간을 알려주는 프로그램 입니다.");
                System.out.println("종료를 원하면 3을 입력하세요.");
                System.out.println("-------------------------------");
                System.out.println("1을 입력하면 remoteDate() method를 호출, com.client.server machine의 시간을 조회합니다.");
                System.out.println("2을 입력하면 regionalDate() method를 호출, 원하는 언어로 com.client.server machine의 시간을 조회합니다.");
                System.out.println("-------------------------------");
                System.out.println("원하는 기능을 입력하세요: ");
                num = scan.nextInt();
                if(num == 3)
                {
                    break;
                }
                else if (num == 1)
                {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MMMMM dd EEEEE HH:mm:ss.SSSZ");
                    resultDate = stub.remoteDate();
                    System.out.println(format.format(resultDate));
                    System.out.println("-------------------------------");

                }
                else if (num == 2)
                {
                    while(true)
                    {
                        System.out.println("원하는 언어를 입력하세요(en/kr/q(이전화면으로)): ");
                        language = scan.next();
                        if(language.equals("kr"))
                        {
                            Locale locale = new Locale("ko","KR");
                            resultString = stub.regionalDate(locale);
                            System.out.println(resultString);
                            System.out.println("-------------------------------");
                        }
                        else if (language.equals("en"))
                        {
                            Locale locale = new Locale("en","en_CA");
                            resultString = stub.regionalDate(locale);
                            System.out.println(resultString);
                            System.out.println("-------------------------------");
                        }
                        else if (language.equals("q"))
                        {
                            System.out.println("-------------------------------");
                            break;
                        }

                        else
                        {
                            System.out.println("잘못된 언어입니다.");
                            System.out.println("-------------------------------");
                        }
                    }
                }
                else
                {
                    System.out.println("올바른 숫자를 입력하세요.\n");
                    System.out.println("-------------------------------");
                }

            }

        }
        catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
