mkdir clientclasses
javac -d .\clientclasses .\src\client\Client.java .\src\rdate\RemoteDate.java -encoding UTF-8
cd clientclasses
java -classpath . client.Client
