## Java File Writer

_There is nothing too special about this Java project. All it does is write into a file_

__*But..for the hell of it..I will explain just what it does*__


###So. Read the following lines of code

```java
Formatter sendDataToFile = new Formatter(this.file_name);
sendDataToFile.format("%s", this.data_being_sent);
sendDataToFile.close();
```

__Yeah. Ok. What do they do?__
_Good question. Formatter is what opens the file(of which the imported util package Scanner will deal with)__
