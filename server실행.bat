mkdir serverclasses
javac -d .\serverclasses .\src\server\Server.java .\src\rdate\RemoteDate.java -encoding UTF-8
cd serverclasses
start rmiregistry
java -classpath . -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:.\RMI_Assignment\serverclasses\ server.Server