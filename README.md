#### 1.程序运行截图及GUI界面

* 运行程序main()类后显示主界面

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151328431.png)

* 点击预约后进入预约口罩界面

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151328482.png)

* 点击查询后进入查询是否中签界面

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151328523.png)

* 在预约界面如不先点开始预约则会跳出如下错误提示

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151328584.png)

* 正确点击开始预约并且填写好信息后若无冲突则成功返回编号供查询

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151329385.png)

* 点击结束预约后跳出如下提示窗口

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151329436.png)

* 若当前预约信息输入检测后发现不符合预约标准，则跳出如下警告并且不会继续录入信息

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_2003151329549.png)

* 查询界面若输入不存在编号或者编号未中签跳出如下提示

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_20031513504111.png)

* 若编号正确且中签则在右边显示详细信息

![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671117/o_20031513295910.png)

#### 2.程序运行环境
- **环境配置**
  - 开发环境：win10
  - 开发工具：IntelliJ IDEA

- **配置信息**
  - Project SDK:11(java version 11.0.5)
  - language level:11

- **配置方法**

  - 打开文件

  - File->Project Structure

    ![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671090/o_2003151255081.png)

  - 选择Project SDK:11(java version 11.0.5)和language level:11

    ![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671090/o_2003151255122.png)

  - 点击运行即可

    ![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671090/o_2003151255153.png)

#### 3.功能实现

* 两个获取指定参数的代码
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407191.png)

* 点击开始预约后调用代码设置口罩批次与数量的函数，通过接收输入框参数来执行
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407232.png)

* 摇号功能，遍历已经录入的信息设置其是否中签参数status的值
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407263.png)

* 判断输入信息是否符合条件
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407304.png)
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407345.png)

* 预约信息录入功能，结合前面的函数进行判断后录入信息
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407396.png)

* 查询功能，连接sql进行操作
![](https://images.cnblogs.com/cnblogs_com/D6Plus/1671156/o_2003151407437.png)
