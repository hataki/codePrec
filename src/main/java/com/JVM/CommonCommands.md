### natural memory -- nio   

jdk1.3之后增加nio，使用直接内存（不需要拷贝，直接访问内存，访问内核空间），实现zeroCopy零拷贝  

### method area -- runtimeConstantPool 方法区：各种class，常量池  

- -- the java Virtual Machine has a method area that is  shared among all java Virtual Machine threads .
- -- it stores per-class structures . 
- -- a run-time constant pool is a per-class or per-interface run-time representation of the constant_pool table in a class file .

### jvm stack -- frame 存放栈帧    

- -- each java Virtual Machine thread has a private java Virtual Machine stack , created at the same time as the thread .  
- -- A java Virtual Machine stack stores frames .    

### PC -- Program Counter / ThreadPool 每一个线程都具有一个pc：计数器 

- each java Virtual Machine thread has its own pc  
- 记录每个线程执行到了哪一条指令

![1607049739(1)](E:\IDEAworkspace\codePrec\src\main\java\com\JVM\1607049739(1).jpg)

### 栈帧 frame

- a frame is used to store data and partial results , as well as to perform dynamic linking ,return values for methods , and dispatch exceptions .