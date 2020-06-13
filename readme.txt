1.工程采用springcloud重构
springboot版本位2.1.14.RELEASE   springcloud版本为 Greenwich.SR4
2.001common放置系统通用的代码，如大数据平台提供的接口
3.002api抽象工程通用的接口、抽象类
4.003utils封装工程开发中抽出来的公共代码，工具类
5.004provider实现微服务的服务提供接口
6.005consumer实现微服务的服务消费
7.使用feign调用avatar大数据平台的接口，并添加缓存，添加缓存后的代码不在调用大数据平台而直接走缓存，提高页面的展示速度。
8.使用redis实现缓存功能，redis重的key的设计采用 用户名_模块_查询参数的大致形式
9.使用Spring session或token实现权限控制
10.使用dubbo实现服务治理
