# rbacdemo2

# rbac实例
data服务用于数据库的相关操作，实现对User表和Role表的CRUD
login-service服务用于登录及权限过滤，二者用erueka连接

### 问题
起初的设计想法是通过查询所有的角色role并通过中间表来获取用户的权限，
但是写到登录时发现，想要给前端返回权限的token，就必须要提前知道到底有多少个权限并且
提前给每个权限一个密钥，用来与前端交互。所以对于role的CRUD就毫无用处，而是应该直接把
Role写成一个枚举类型

另外一个问题是，在data-service中将所有返回类型设为Map，通过get的方式获取到里面的
内容，虽然我在与vue的交互中这样写，但是在login-service服务调用后，就无法直接通过  
User user = map.get("user")  
直接获取，解决方案还没有找到。

最后一个问题是，原本在一个服务中，端口只有一个，可以通过拦截器的方式拦截所有未登录的请求并且可以控制权限，
但是现在不同端口号导致可以跳过login直接访问data，不需要任何权限。我能想到的解决方法是内部调用，虽然我还不懂这个词的意思。
