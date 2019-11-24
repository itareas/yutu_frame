## 核心配置区

* 系统框架： **SpringBoot+Mybatis+Druid+Thymeleaf+Docker+Vue**

* 系统版本： **V1.4.0**

* 支持数据库：**SqlServer、Oracle、MySql、Redis、PostgreSql ...**

* 数据库连接池：**Druid**

* 前端模板引擎：Thymeleaf

* 系统接口类型：REST/HttpClient

* 框架安全机制：
>       1.XssAndSqlFilter过滤跨站脚本和sql注入攻击；
>       2.MyFilter过滤非法访问url和用户；
>       3.黑名单机制用来拦截用户恶意访问系统；
>       4.MyInterceptor拦截器实时判断用户登录状态（需要权限系统）；
>       5.全局异常机制来保护系统出错时候敏感信息泄露；
>       6.必要时可以进行系统配置信息AES全程加密；
 
* 系统特色：
>       1.架构层和业务层配置分离，调整框架不影响业务
>       2.支持多库多数据源同时连接，换库更方便
>       3.多层安全保障机制，保护系统安全 

* 配置区：    
>      configuration：系统配置层,用于配置数据源信息；
>      filter：过滤器，过滤系统url地址；
>      interceptor：拦截器，用于系统的单点登录统一退出登录；
>      listener：监听器，用于加载起始业务配置文件加载和监控在线人数和登录退出日志；
>      exception：异常处理层，用于记录全局错误日志；

* 业务区：  
>      controller：控制层,用于前后台数据交互；
>      entity：实体类层；
>      init: 业务配置文件起始加载区；
>      mapper：数据处理层，与数据库交互；
>      service：业务服务层，业务处理层；
>      util：通用工具类；
>      webapi：对外接口层，系统和系统之前交互；

* 系统配置文件：
>      resources/config/*：自定义业务配置文件（关于业务的）；
>      resources/frame: 系统架构说明和数据库；
>      resources/application.properties： 系统核心配置文件，用于配置通用配置；
>      resources/application-dev.properties： 开发环境配置文件，用于开发过程中使用；
>      resources/application-prod.properties： 生产环境配置文件，用于正式版部署使用；
>      resources/application-test.properties： 测试环境配置文件，用于系统测试时使用；
>      resources/log4j.properties：日志配置文件；
>      resources/mybatis-config.xml：mybatis核心配置；
>      resources/readme.md：系统开发手册；       

------------------------------------------------------------------

## 后台开发要求

* controller
>   1.RedirectController 为系统统一前台页面统一注册页，由前段人员参与维护
>   2.依赖注入方法统一用 @Resource
>   3.常规前台业务交互层返回数据统一用**MsgPack**类统一进行返回，类注解统一用@RestController，返回参数时无需再转json
>>      示例：         
>>               @RestController
>>               @RequestMapping("login")
>>               public class LoginController {
>>                   @Resource
>>                   private ServiceFactory serviceFactory;
>>    
>>                   @RequestMapping("getLoginVerification")
>>                   public MsgPack getLoginVerification(HttpServletRequest request){
>>                      //正常业务处理
>>                      MsgPack msgPak= serviceFactory.getLoginService().业务处理方法;               
>>                      return msgPak;
>>                   }
>>                }  
> 4.创建类和方法时候及时写注释，注释上必须标明创建人、创建时间、此方法/类简介

* entity
> 1.数据实体类统一放到table文件夹下，公用开发实力类放到主目录下

> 2.创建类和方法时候及时写注释，注释上必须标明创建人、创建时间、此方法/类简介

* mapper
> 1.遵循mybatis规范

* service
> 1.接口首字母用I，后面采用pascal 命名法

> 2.依赖注入方法统一用 @Resource

* webapi
> 1.接口之间通信统一用JSON,类注解统一用@RestController，交互json标准为：MsgPack实体类 

> 2.所有接口返回数据前必须通过**AES进行加密**，AES加密实体类在 /util/AESUtil
>>     加密： String aesMsgPack = AESUtil.encrypt(msgPack);
>>     解密： MsgPack decryptMsgPack=AESUtil.decrypt(aesMsgPack);

* **配置区的文件正常开发请勿乱动，如需要更改，请联系研发负责人** 

------------------------------------------------------------------

## 前段开发要求

* 静态页规范
>  1.首级目录命令为 templates  
>
>  2.主html页面放到 templates/*.html      
>>     例如：login.html/error.html 
>
>  3.模块下业务html根据各个模块分好文件夹 templates/ModularOne/*.html    
>>     例如：ModularOne     

* 其他资源规范
>  1.首级目录命令为 static
>
>  2.二级目录根据资源类型分类  static/js  static/css   static/img    static/script   其他类型造此类推 
>
>  3.三级目录 按模块划分，**具体命名与静态页一致**，主文件放外面，模块文件放到下一级目录
>>     例如：static/js/ModularOne/login.js   static/js/ModularOne/*.js  
>
>  4.第三方js框架统一放到 static/script目录下 
   
* 与后台交互规范 初版
>  1.与后台交互统一用ajax post 方式，传递参数命名采用驼峰命名法
>
>  2.后台与前台交互传递数据统一用json数据格式  
>>     例如：{"status":0,"msg":"用户名或密码错误","data":null} 
>>	    status：0：成功，  1：失败
>>	    msg：提示信息
>>     data：返回json数据



------------------------------------------------------------------

## 未完成的问题

> 1.XSS和SQL注入攻击实用性测试

> 2.监听器进行存文件和读文件时候会有一次，不稳定

> 3.Docker打包发布功能开发

------------------------------------------------------------------

##开发日志区 

* 2019年4月15日  V0.1
>      1.系统架构选型，springboot原型配置生成，定义方向

* 2019年4月16日  V0.2
>      1.系统后台模块确定，由八个区组成，分别为：cache:缓存区、controller：控制层、entity：实体类层，filter：过滤器、init：初始化加载、mapper：数据处理层、service：业务服务层；util：通用工具类、webapi：对外接口层
>      2.springboot和mybatis融合，mybatis下分了三个数据源：sqlserver/oracle/mysql; 由业务层控制连接哪个数据源，只能单向数据源链接，更换数据源只需要更改 application.properties 文件的地址就行
>      3. log4j日志的加入

* 2019年4月17日  V0.3
>      1.完善springboot和mybatis融合，并完成三种数据源的链接测试；
>      2.添加redis和postgreSql通用访问类，测试通过
>      3.新增加 interceptor：拦截器、listener：监听器 模块

* 2019年4月18日  
>      1.过滤器完善
>      2.增加session模板

* 2019年4月19日  V0.4
>      1.增加拦截器功能             
>      2.增加监听器功能  
>      3.过滤器增加.do

* 2019年4月20日  V0.5
>      1.增加mysql数据库三张日志表和一张用户表和相关的实体类
>      2.框架整合

* 2019年4月21日  V0.6
>      1.前后台用户登录和session问题解决（简版）
>      2.过滤器针对登录问题进行测试跑通

* 2019年4月22日  
>      1.全局错误日志处理,新增exception模块

* 2019年4月23日  V0.7 
>      1.全局错误错误页面开发，全局错误日志简化代码
>      2.rest接口完善
 
* 2019年5月6日  V0.8  
>      1.idea发布系统功能实现
>      2.修改thymelef 相关的配置
 
* 2019年5月8-10日   
>      1.学习spring底层原理，着手优化框架
>      2.@Resource属于jeEE提供的注入方式，比spring提供Autowired更灵活
>      3.@Controller、@Service和@Repository在类上进行的控制反转的注入，相当于把类交给spring管理了

* 2019年5月19日  
>      1.增加多数据源配置
>      2.增加configuration模块，用于存储系统级别的配置

* 2019年5月20日  V0.9
>      1.多数据源测试完成，着手进行优化配置           
>      2.业务层增加事务注解

* 2019年5月28日
>      1.对过滤器安全就行测试，增加过滤器对客户端的请求ip，游览器版本等认证，不再唯一是sesionId

* 2019年5月29日 V1.0
>      1.AES加密算法对参数和返回值进行调整，采用实体类传入和实现类传出
>      2.对项目tomcatf部署进行修改

* 2019年6月1日   V1.1
>      1.系统增加黑名单机制，当发现有人恶意访问系统接口时候，系统自动把他拉入黑名单
>      2.因起始加载循序的问题，取消init（起始加载层）springboot提供的CommandLineRunner方法，改用servlet自带的监听器：ServletContextListener
>      3.将黑名单进行序列化到本地，项目启动时候进行读取

* 2019年6月3日
>      1.优化黑名单算法，增加删除多余数据机制
 
* 2019年6月15日  V1.2
>      1.对数据源通用配置区进行升级，由三个数据源三个类改成一个统一封装类
>      2.增加Filter(过滤器)通用配置，用来配置多个过滤器的循序
>      3.增加预防Xss和Sql注入攻击的过滤器，来保证框架的安全性

* 2019年6月20日
>      1.数据源通用配置失败，无法实现一个类三种数据源绑定，恢复至以前版本
>      2.增加时间和编码的通用工具类
>      3.系统配置和业务配置文件进行分离，spring配置文件和框架配置文件进行整合

* 2019年6月22日  V1.3
>      1.恢复init业务配置层，针对业务配置文件，已为开发人员预留出读写配置文件区域，框架人员不在参与
>      2.AESUtils（加密工具类）升级为泛型，可以直接把类转换成加密字符串，也可以加密字符串转成实体类
>      3.MsgPack类升级为泛型，做为中间包装类，可以把任何实体类加入并解析  详见：WebService
 
* 2019年6月26日  
>      1.多数据源其他配置进行调整，由通用数据源改成每一数据源一套
>      2.进行多数据源获取测试

* 2019年7月1日
>      1.修改Serivce层接口的访问修饰符错误，改为缺省，了解java访问修饰符的作用域情况
>      2.干掉ServiceFactory和DaoFactory统一注入类，不便于开发，操作繁琐

* 2019年8月22日
>      1.优化日志，黑名单，序列化反序列化
>      2.系统前端首页调整

* 2019年8月27日  V1.4
>      1.增加自动生成实体类和mapper通用工具
>      2.后台增加 generator层，资源区增加 generator 层

* 2019年10月10日  
>      1.微调登陆过滤器，发现系统超时后，之前过滤器跳转登陆页时候为局部刷新，已修改成页面整体刷新
 