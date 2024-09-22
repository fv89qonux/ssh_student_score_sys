## 本项目实现的最终作用是基于SSH实现的一个学生成绩管理系统
## 分为1个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 个人信息以及密码修改
 - 学生列表管理
 - 学生成绩管理
 - 班级列表管理
 - 管理员登陆
 - 管理员管理
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_student_score_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [sys_admin](#sys_admin) |  |
| [sys_classs](#sys_classs) |  |
| [sys_course](#sys_course) |  |
| [sys_student](#sys_student) |  |

**表名：** <a id="sys_admin">sys_admin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | userName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="sys_classs">sys_classs</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |

**表名：** <a id="sys_course">sys_course</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | sid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | num1 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | num2 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | num3 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | num4 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | num5 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |

**表名：** <a id="sys_student">sys_student</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | cid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分类ID  |
|  3   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  4   | num |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 数量  |
|  5   | sex |   int   | 10 |   0    |    Y     |  N   |   NULL    | 性别  |

