###클라이언트 실행방법
Client는 RMI_Assignment 폴더 내에 client실행.bat파일을 실행하면 자동으로 컴파일 후 실행합니다.
```
mkdir clientclasses
javac -d .\clientclasses .\src\client\Client.java .\src\rdate\RemoteDate.java -encoding UTF-8
cd clientclasses
java -classpath . client.Client
```
혹은 위의 명령어를 CMD 상에서 입력하면 됩니다. Bat파일과 동일합니다.

###서버 실행방법
동일하기 RMI_Assignment 폴더 내에 server실행.bat파일을 실행하면 자동으로 컴파일 한 후에
rmi registry를 실행하고 server를 실행합니다.
```
mkdir serverclasses
javac -d .\serverclasses .\src\server\Server.java .\src\rdate\RemoteDate.java -encoding UTF-8
cd serverclasses
start rmiregistry
java -classpath . -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:.\RMI_Assignment\serverclasses\ server.Server
```
혹은 위의 명령어를 CMD 상에서 입력하면 됩니다. Bat파일과 동일합니다.
codebase는 제일 밑 명령어와 같이 지정합니다.
policy 파일은 폴더 내에 server.policy를 지정합니다.