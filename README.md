### 实验一位于expriment_01_spring模块，运行前需要起mysql，配置信息看config/AppConfiguration
### 实验二位于expriment_02_spring模块
### 实验三位于expriment_03模块
### 实验四位于expriment_04模块，运行前需要起mysql，配置信息看resources/application，sql文件看javaee4.sql
### 四个实验的视频请关注微信公众号(Atri45)，发送关键词（java实验视频）获取
### 觉得不错的话可以点个starred🥰，还可以看看我的另一个仓库 [CQU_CS-AI_learning_resources](https://github.com/atri45/CQU_CS_learning_resources) ，上面分享了各种学习资源👍。

---

### 实验一要求：
设计开发完成基于命令行的学生成绩管理系统。 要求如下：

1、创建类实现基本对象和他们关系的管理。包括学生、教学班、课程、成绩、教师等。学生至少包含学号、姓名、性别等信息。教学班至少包含教师、课程名字、总人数、教学班号、开课学期等信息。课程至少包含课程编号、课程名字等信息。教师至少包含教师编号、姓名等信息。可以根据自己的分析设计增加其他类。

2、随机生成学生，数量不少于100。课程数量不少于3门。一个教学班有一个教师上一门课程，一个教学班的学生数量不少于20。教师数量不少于6个。一门课至少有两个老师上课。每个学生至少选择3门课程。一个学生在一个教学班上一门课，考试后取得一个成绩。一门课的成绩构成有4部分构成，包括平时成绩、期中考试、实验成绩和期末考试成绩，然后计算出综合成绩。自定义各项成绩的产生策略，均为整数。

3、给出一个主菜单，选择菜单项执行各项功能。例如执行一个菜单命令，可以生成一个教学班的所有学生的平时成绩。分阶段模拟教学过程，第一步，生成初始化数据，包括教师，学生、课程，教学班等；第二步，学生选课，自定义选课策略，为每门课程的教学班安排学生。第三步，获得平时成绩，期中成绩，实验成绩，期末成绩，最后计算综合成绩，要记录成绩取得的时间。

4、能够格式规范地显示一个教学班的学生的成绩，可以根据学号排序，可以根据成绩排序。可以统计学生各科、总成绩的分数段分布。可以通过名字或者学号查询一个学生的所有科目的成绩和总成绩。可以按照学号、各科成绩和总成绩对所有学生进行排名显示。

5、可以实现自己的扩展功能或自定义功能。注意操作使用的方便性，注意类和类之间的关系。充分利用继承，多态等特性，使用上抽象类，接口，泛型，内部类等设计元素，使用好集合类。注意程序的总执行流程和分支执行流程。注意设计思想的表达，注意优化代码结构，优化类的职责分工，注意使用设计模式。代码有注释。

### 实验二要求：
设计开发完成“基于命令行的文件管理器”软件。要求如下：

1、可以设置当前工作文件夹，默认在当前文件夹下进行文件的增删改查操作，文件夹的增删改查操作。也可以操作指定的文件夹。

2、实现当前文件夹下的内容罗列；可以根据文件名、文件大小、文件类型、文件日期等过滤特定类型的文件。罗列的时候可以排序，依据名称、大小、时间等。罗列文件的时候，显示要规范。

3、可以直接查看和显示一个文本文件的内容。

4、实现文件拷贝和文件夹拷贝（文件夹拷贝指深度拷贝，包括所有子目录和文件）；能指定目标名称和位置，能计算拷贝时间，能显示拷贝进度。

5、可以利用线程机制，支持后台长时任务异步执行。不影响前端操作。例如在拷贝大文件或者文件夹的时候，可以选择后台执行，还是前台执行。如果前台执行，显示时间和进度。

6、可以对指定文件进行加密和解密；加密后形成新的文件，可以指定文件名。加密与解密方式自己选择。

7、可以对文件或者文件夹进行压缩，或者解压。压缩与解压方式自己选择。

8、可以实现自定义功能。注意操作使用的方便性，注意类和类之间的关系。充分利用继承，多态等特性，使用上抽象类，接口，泛型，内部类等设计元素，使用好集合类、多线程、IO工具类、NIO工具类等。注意程序的总执行流程和分支执行流程。注意设计思想的表达，注意优化代码结构，优化类的职责分工，注意使用设计模式。代码有注释。

### 实验三要求：
设计开发完成“单点登录系统”软件。要求如下：

1、实现2个简单的、需要用户登录才能使用的应用系统，这2个应用系统称为web1和web2；登录进去后，在主页面显示该系统已经登录的所有用户的信息和登录时间。并提供两个系统相互跳转的链接。一个应用系统可以登录多个用户。

2、设计实现一个单点登录系统ssoserver；提供登录页面等功能。登录后，在主页面显示已经登录的所有用户的信息和登录时间。并提供跳转到web1和web2的链接，能够直接登录到web1或者web2。

3、未登录状态下访问系统web1或者系统web2，跳转到单点登录系统ssoserver进行登录验证，登录成功后，跳转到web1或者Web2；

4、应用系统web1、web2和ssoserver提供登出注销功能。登出任何一个系统后，再次访问任何一个系统都需要重新登录。登出注销后，跳转到一个页面，显示登出注销成功等信息。

5、可以实现自定义功能。注意操作使用的方便性，注意设计思想的表达，注意优化代码结构，优化类的职责分工。代码有注释。

### 实验四要求：
设计开发完成一个基于Web的成绩管理系统。要求如下：

1、后端可以使用SpringBoot等框架，也可以使用其他框架。要求数据存储在数据库中。自由选择使用什么数据库。

2、前端使用浏览器访问软件系统界面。自由选择前端界面技术。自由选择是否前后端分离架构。

3、提供账号注册、登录、注销等功能。教师账号管理学生成绩，学生账号查看学生成绩。教务账号管理班级，课程等。

4、创建类，实现基本对象和他们关系的管理。包括学生、教学班、课程、成绩、教师等。学生至少包含学号、姓名、性别等信息。教学班至少包含教师、课程名字、总人数、教学班号、开课学期等信息。课程至少包含课程编号、课程名字等信息。教师至少包含教师编号、姓名等信息。可以根据自己的分析设计增加其他类。

5、随机生成学生，数量不少于100。课程数量不少于3门。一个教学班有一个教师上一门课程，一个教学班的学生数量不少于20。教师数量不少于6个。一门课至少有两个老师上课。每个学生至少选择3门课程。一个学生在一个教学班上一门课，考试后取得一个成绩。一门课的成绩构成有4部分构成，包括平时成绩、期中考试、实验成绩和期末考试成绩，然后计算出综合成绩。自定义各项成绩的产生策略，均为整数。

6、提供合适的操作界面完成上述功能。可以录入成绩，可以批量产生成绩等；能够格式规范地显示一个教学班的学生的成绩，可以根据学号排序，可以根据成绩排序。可以统计学生各科、总成绩的分数段分布。可以通过名字或者学号查询一个学生的所有科目的成绩和总成绩。可以按照学号、各科成绩和总成绩对所有学生进行排名显示。

7、可以实现自己的扩展功能或自定义功能。注意操作使用的方便性，注意类和类之间的关系。充分利用继承，多态等特性，使用上抽象类，接口，泛型，内部类等设计元素，使用好集合类。注意程序的总执行流程和分支执行流程。注意设计思想的表达，注意优化代码结构，优化类的职责分工，注意使用各种框架。代码有注释。
