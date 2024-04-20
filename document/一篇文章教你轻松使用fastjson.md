# 一篇文章教你轻松使用fastjson

## 前言

> 只有光头才能变强。  
> **文本已收录至我的GitHub精选文章，欢迎Star**：[https://github.com/ZhongFuCheng3y/3y](https://link.zhihu.com/?target=https%3A//github.com/ZhongFuCheng3y/3y)  

`JSON`相信大家对他也不陌生了，前后端交互中常常就以`JSON`来进行**数据交换**。而有的时候，我们也会将`JSON`直接保存在数据库中。

> 可能就有人不太理解，为什么要将JSON保存在关系型数据库中？  

我在最开始的时候也有类似的疑惑，问了几个同事，得出的结论都差不多：**方便扩展**，如果那些字段**不需要用到索引**，改动比较频繁，你又不想改动表的结构，那就可以在数据库中存入`JSON`

虽说存`JSON`会方便扩展，但如果你的`MySQL`版本还是相对较低的话，想要**用SQL查`JSON`里某个属性**，还是比较麻烦的。

并且从数据库里边取出来也仅仅是一个`String`，而想要操作`JSON`里边的属性，自己写不太方便，所以就有`fastjson`给我们去用。

![](https://pic3.zhimg.com/80/v2-ed7a2ee22c4d7fc30dec7c173c0593f6_720w.webp)

这篇文章简单讲讲`fastjson`的使用，希望对大家有帮助。**如果有帮助，给我点个赞呀！**

## 一、fastjson入门

> 以下内容来源：[https://github.com/alibaba/fastjson/wiki/Quick-Start-CN](https://link.zhihu.com/?target=https%3A//github.com/alibaba/fastjson/wiki/Quick-Start-CN)  

它可以解析`JSON`格式的字符串，支持将`Java Bean`序列化为`JSON`字符串，也可以从`JSON`字符串反序列化到`JavaBean`

![](https://pic1.zhimg.com/80/v2-7e1682c8120e867696fdc96dd02b2568_720w.webp)

`fastjson`优点：**速度快、使用广泛、使用简单、功能完备**、测试完备（之前爆了很多漏洞，现在我司走发布流程都强制我们升级`fastjson`版本了），现在使用`fastjson`至少升级到`1.2.60`版本

速度快的原因：

> 1、自行编写类似StringBuilder的工具类SerializeWriter。  
> 2、使用ThreadLocal来缓存buf。  
> 3、使用asm避免反射  
> 4、集成jdk实现的一些优化算法  

## 二、使用fastjson

首先我们在`pom`文件中引入`fastjson`的依赖就好了：

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>x.x.x</version>
</dependency>
```

`fastjson`的使用主要是三个对象：

- JSON
- JSONObject
- JSONArray

![](https://pic2.zhimg.com/80/v2-0ed45e646e78b05185734dc9077892e9_720w.webp)

JSONArray和JSONObject继承JSON：

![](https://pic3.zhimg.com/80/v2-fe9ad065063afa6660ddd403610cc5a6_720w.webp)

### 2.1 JSON对象

JSON这个类主要用于**转换**：

- 将Java对象序列化为JSON字符串
- 将JSON字符串反序列化为Java对象

所以，有三个方法我们用得特别多：

- `parseObject(String text, Class<T> clazz)`
- `parseArray(String text, Class<T> clazz)`
- `toJSONString(Object object)`

### 2.2 JSONObject

JSON对象(JSONObject)中的数据都是以`key-value`形式出现，所以它实现了`Map`接口：

![](https://pic2.zhimg.com/80/v2-5a980f124ebb9049565d6c97d18327c1_720w.webp)

使用起来也很简单，跟使用`Map`就没多大的区别（因为它底层实际上就是操作`Map`)，常用的方法：

- `getString(String key)`
- `remove(Object key)`

![](https://pic2.zhimg.com/80/v2-f082f9da9979604312d5b55f83534dc5_720w.webp)

### 2.3 JSONArray

JSONArray则是JSON数组，JSON数组对象中存储的是一个个JSON对象，所以类中的方法主要用于**直接操作JSON对象**

![](https://pic3.zhimg.com/80/v2-7341acc752f9a15f277b84685f23835a_720w.webp)

最常用的方法：

- `getJSONObject(int index)`

## 三、实战

从上面的简单介绍我们已经可以知道了：

- JSON用于将字符串反序列化为JavaBean和JavaBean序列化为JSON
- JSONObject代表的是JSON对象，底层通过Map来操作，常用`getString`等方法来获取对应的值
- JSONArray代表的是JSON对象数组，底层实际上是List，它用作于操作JSON对象

一般来说，我们从数据库拿到JSON数据以后，然后要对JSON进行修改。比如JSON串如下：

```json
{
    "formId": "{$formId}",
    "link": "www.java3y.com",
    "text": [{
        "name": "java3y",
        "label": "3y",
        "value": {
            "value": "{$tureName}",
            "color": "",
            "emphasis": ""
        }
    }, {
        "name": "java4y",
        "label": "3y",
        "value": {
            "value": "{$title}",
            "color": "",
            "emphasis": ""
        }
    }, {
        "name": "java5y",
        "label": "5y",
        "value": {
            "value": "关注我的公众号，更多干货",
            "color": "#ff0040",
            "emphasis": ""
        }
    }],
    "yyyImg": "",
    "yyyAge": "",
    "pagepath": ""
}
```

我们是不会**直接操作**JSON的，我们会将JSON转成我们自己的JavaBean，再操作JavaBean，最后序列化为JSONString

从上面的`JSON`结构上来看还是相对复杂的，思路：

- 我们可以根据`JSON`的结构构建对应的JavaBean
- 使用`JSON`类将JSON字符串反序列化为JavaBean
- 修改JavaBean的值
- 最后将`JavaBean`序列化为JSON字符串

从上面的`JSON`结构，首先我们针对`text`这层抽象为一个JavaBean。（实际上最里层的结构是`value`，但我这边不需要处理`value`，所以就不抽象了）

```java
/**
 * "name": "java3y",
 *  "label": "3y",
 *  "value": {
 *      "value": "{$tureName}",
 *      "color": "",
 *      "emphasis": ""
 *    }
 *
 *  对Text进行抽象
 */
public class TextInfo {

    private String name;
    private String label;

    // 因为value我这边不需要操作，所以就不抽象了，如果每层都要处理，那就得抽象
    private Object value;


    // set get ... 省略 欢迎关注我的公众号：Javay

}
```

然后对外层进行抽象：

```java
public class ContentValue {
    private String formId;
    private String link;
    // 这里是一个数组，我们就抽象为List，属性名为text
    private List<TextInfo> text;

    private String yyyImg;
    private String yyyAge;
    private String pagepath;

    // set get ... 省略 欢迎关注我的公众号：Javay

}
```

我们反序列化看一下：

```java
public static void main(String[] args) {

    // JSON 字符串
    String s = "{\"formId\":\"{$formId}\",\"link\":\"www.java3y.com\",\"text\":[{\"name\":\"java3y\",\"label\":\"3y\",\"value\":{\"value\":\"{$tureName}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java4y\",\"label\":\"3y\",\"value\":{\"value\":\"{$title}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java5y\",\"label\":\"5y\",\"value\":{\"value\":\"关注我的公众号，更多干货\",\"color\":\"#ff0040\",\"emphasis\":\"\"}}],\"yyyImg\":\"\",\"yyyAge\":\"\",\"pagepath\":\"\"}";

    // 使用JSON对象 将JSON字符串反序列化为JavaBean
    ContentValue contentValue = JSON.parse(s, ContentValue.class);
    System.out.println(contentValue);


    }
```

反序列化结果：

![](https://pic2.zhimg.com/80/v2-2dc5522390cf0fdd06960cfef91114e5_720w.webp)

我们要改text里边的值，只需要操作`JavaBean`就好了：

```java
public static void main(String[] args) {

    // JSON 字符串
    String s = "{\"formId\":\"{$formId}\",\"link\":\"www.java3y.com\",\"text\":[{\"name\":\"java3y\",\"label\":\"3y\",\"value\":{\"value\":\"{$tureName}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java4y\",\"label\":\"3y\",\"value\":{\"value\":\"{$title}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java5y\",\"label\":\"5y\",\"value\":{\"value\":\"关注我的公众号，更多干货\",\"color\":\"#ff0040\",\"emphasis\":\"\"}}],\"yyyImg\":\"\",\"yyyAge\":\"\",\"pagepath\":\"\"}";

    // 使用JSON对象 将JSON字符串反序列化为JavaBean
    ContentValue contentValue = JSON.parse(s, ContentValue.class);
    List<TextInfo> text = contentValue.getText();
    for (TextInfo textInfo : text) {
        textInfo.setName("Java3y");
        textInfo.setLabel("关注我的公众号呗");
    }


    // 修改后，反序列化回去
    String content = JSON.toJSONString(contentValue);
}
```

序列化结果：

![](https://pic2.zhimg.com/80/v2-e665005cff54c861b90a3b3bb5061e1d_720w.webp)

轻松将JSON字符串里边的字段改掉。

## 最后

总的来说，fastjson还是足够方便好用的，它的速度也很快，只是最近漏洞有点多。

[原文链接](https://zhuanlan.zhihu.com/p/97222262)
