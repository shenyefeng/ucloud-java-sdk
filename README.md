# UCLOUD-JAVA-SDK
## 一个使用Apache HttpClient的简单易用易扩展的Java SDK
---

基于 [UCLOUD HTTP REST API接口](http://docs.ucloud.cn/api/index.html)开发，适用于Java 5及以上版本。

## 目录
* [准备](#准备)
* [云主机](#UHost)
  * [DescribeImage](#DescribeImage)

<a name="准备"></a>
### 准备

##### 注册用户
大家可以登录[UCLOUD主站](http://www.ucloud.cn/)，开启虚拟化之旅。具体教程请参见[“文档中心”](http://docs.ucloud.cn/index.html)。

##### 初始化UcloudClient
    UcloudClient client = UcloudClient.newClient("您的UCLOUD公钥", "您的UCLOUD密钥");

若不了解`公钥和密钥`，请参见[“公钥和密钥”](https://consolev3.ucloud.cn/apikey)

<a name="UHost"></a>
### 云主机

<a name="DescribeImage"></a>
#### DescribeImage

获取指定数据中心镜像列表，用户可通过指定镜像类型，操作系统类型，镜像Id进行过滤。

    DescribeImageInVo in = new DescribeImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    DescribeImageoutVo out = client.exec(in, DescribeImageoutVo.class);



