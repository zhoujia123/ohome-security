# 使用的第三方工具

<p> 
> rpc http客户端   
    **[okhttp]()** 
    **[Retrofit]()**
# 签名
> sign **MD5**  **SHA**  **MurmurHash3**  
    [commons-codec]()  
    [guava]()
    [joda-time]() 日期时间处理
# rpc
> rpc [dubbo]() 实现
* 同步
* 异步  **kafaka队列**

# 缓存
> cache 
* **encache**
* **redis**

# 过滤
> 过滤链
* 是否含有公共参数
* timastrap时间戳是否超过系统间隔
* 签名认证
* 权限认证（缓存读取）
* 频率限制,次数限制

