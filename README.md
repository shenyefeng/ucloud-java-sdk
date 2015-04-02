# UCLOUD-JAVA-SDK
## 一个使用Apache HttpClient的简单易用易扩展的Java SDK
---

基于 [UCLOUD HTTP REST API接口](http://docs.ucloud.cn/api/index.html)开发，适用于Java 5及以上版本。

## 目录
* [准备] (#prepare)
* [云主机] (#uhost)
  * [DescribeImage] (#describeImage)
  * [CreateUHostInstance] (#createUHostInstance)
  * [DescribeUHostInstance] (#describeUHostInstance)
  * [TerminateUHostInstance] (#terminateUHostInstance)
  * [ResizeUHostInstance] (#resizeUHostInstance)
  * [ReinstallUHostInstance] (#reinstallUHostInstance)
  * [StartUHostInstance] (#startUHostInstance)
  * [StopUHostInstance] (#stopUHostInstance)
  * [RebootUHostInstance] (#rebootUHostInstance)
  * [ResetUHostInstancePassword] (#resetUHostInstancePassword)
  * [ModifyUHostInstanceName] (#modifyUHostInstanceName)
  * [ModifyUHostInstanceTag] (#modifyUHostInstanceTag)
  * [ModifyUHostInstanceRemark] (#modifyUHostInstanceRemark)
  * [GetUHostInstancePrice] (#getUHostInstancePrice)
  * [GetUHostInstanceVncInfo] (#getUHostInstanceVncInfo)
  * [CreateCustomImage] (#createCustomImage)
  * [TerminateCustomImage] (#terminateCustomImage)
  * [CreateUHostInstanceSnapshot] (#createUHostInstanceSnapshot)
  * [DescribeUHostInstanceSnapshot] (#describeUHostInstanceSnapshot)
* [云监控] (#umon)
  * [GetMetric] (#getMetric)

---

<a name="prepare"></a>
### 准备

##### 注册用户
大家可以登录[UCLOUD主站](http://www.ucloud.cn/)，开启虚拟化之旅。具体教程请参见[“文档中心”](http://docs.ucloud.cn/index.html)。

##### 初始化UcloudClient
    UcloudClient client = UcloudClient.newClient("您的UCLOUD公钥", "您的UCLOUD密钥");

若不了解`公钥和密钥`，请参见[“公钥和密钥”](https://consolev3.ucloud.cn/apikey)

---
<a name="uhost"></a>
### 云主机

<a name="describeImage"></a>
#### DescribeImage

获取指定数据中心镜像列表，用户可通过指定镜像类型，操作系统类型，镜像Id进行过滤。

    DescribeImageInVo in = new DescribeImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    DescribeImageoutVo out = client.exec(in, DescribeImageoutVo.class);

<a name="createUHostInstance"></a>
#### CreateUHostInstance

指定数据中心，根据资源使用量创建指定数量的UHost实例。

    CreateUHostInstanceInVo in = new CreateUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setImageId("e36b3acf76663067684332055ade6bae");
    in.setLoginMode(LoginModeEnum.Password.name());
    in.setPassword("ucloud12345");
    in.setcPU(1);
    in.setMemory(1024);
    in.setDiskSpace(0);
    in.setChargeType(ChargeTypeEnum.Month.name());
    CreateUHostInstanceOutVo out = client.exec(in, CreateUHostInstanceOutVo.class);

<a name="describeUHostInstance"></a>
#### DescribeUHostInstance

获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。

    DescribeUHostInstanceInVo in = new DescribeUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostIds_0("uhost-f1y3dd");
    DescribeUHostInstanceOutVo out = client.exec(in, DescribeUHostInstanceOutVo.class);

<a name="terminateUHostInstance"></a>
#### TerminateUHostInstance

删除指定数据中心的UHost实例。

    TerminateUHostInstanceInVo in = new TerminateUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    TerminateUHostInstanceOutVo out = client.exec(in, TerminateUHostInstanceOutVo.class);

<a name="resizeUHostInstance"></a>
#### ResizeUHostInstance

修改指定UHost实例的资源配置，如CPU核心数，内存容量大小，磁盘空间大小等。

> **修改配置注意事项：***1.修改配置前，请确认该实例已经被关闭。 2.修改磁盘空间大小后，请在启动后按照说明，进入操作系统进行操作。

    ResizeUHostInstanceInVo in = new ResizeUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setDiskSpace(80);
    ResizeUHostInstanceOutVo out = client.exec(in, ResizeUHostInstanceOutVo.class);

<a name="reinstallUHostInstance"></a>
#### ReinstallUHostInstance

重新安装指定UHost实例的操作系统

> **警告：***1.请确认在重新安装之前，该实例已被关闭； 2.请确认该实例未挂载UDisk；3.将原系统重装为不同类型的系统时(Linux->Windows)，不可选择保留数据盘；4.重装不同版本的系统时(CentOS6->CentOS7)，若选择保留数据盘，请注意数据盘的文件系统格式；5.若主机CPU低于2核，不可重装为Windows系统。

    ReinstallUHostInstanceInVo in = new ReinstallUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setPassword("ucloud2345");
    ReinstallUHostInstanceOutVo out = client.exec(in, ReinstallUHostInstanceOutVo.class);

<a name="startUHostInstance"></a>
#### StartUHostInstance

启动处于关闭状态的UHost实例，需要指定数据中心及UHostID两个参数的值。

    StartUHostInstanceInVo in = new StartUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    StartUHostInstanceOutVo out = client.exec(in, StartUHostInstanceOutVo.class);


<a name="stopUHostInstance"></a>
#### StopUHostInstance

指停止处于运行状态的UHost实例，需指定数据中心及UhostID。

    StopUHostInstanceInVo in = new StopUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    StopUHostInstanceOutVo out = client.exec(in, StopUHostInstanceOutVo.class);

<a name="rebootUHostInstance"></a>
#### RebootUHostInstance

重新启动UHost实例，需要指定数据中心及UHostID两个参数的值。

    RebootUHostInstanceInVo in = new RebootUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    RebootUHostInstanceOutVo out = client.exec(in, RebootUHostInstanceOutVo.class);

<a name="resetUHostInstancePassword"></a>
#### ResetUHostInstancePassword

重置UHost实例的管理员密码。

    ResetUHostInstancePasswordInVo in = new ResetUHostInstancePasswordInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setPassword("ucloud123456");
    ResetUHostInstancePasswordOutVo out = client.exec(in, ResetUHostInstancePasswordOutVo.class);

<a name="modifyUHostInstanceName"></a>
#### ModifyUHostInstanceName

修改指定UHost实例名称，需要给出数据中心，UHostId，及新的实例名称。

    ModifyUHostInstanceNameInVo in = new ModifyUHostInstanceNameInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setName("ubuntu1204-001");
    ModifyUHostInstanceNameOutVo out = client.exec(in, ModifyUHostInstanceNameOutVo.class);

<a name="modifyUHostInstanceTag"></a>
#### ModifyUHostInstanceTag

修改指定UHost实例业务组标识。

    ModifyUHostInstanceTagInVo in = new ModifyUHostInstanceTagInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setTag("ubuntu1204-001-tag");
    ModifyUHostInstanceTagOutVo out = client.exec(in, ModifyUHostInstanceTagOutVo.class);

<a name="modifyUHostInstanceRemark"></a>
#### ModifyUHostInstanceRemark

修改指定UHost实例备注信息。

    ModifyUHostInstanceRemarkInVo in = new ModifyUHostInstanceRemarkInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setRemark("ubuntu1204-001-remark");
    ModifyUHostInstanceRemarkOutVo out = client.exec(in, ModifyUHostInstanceRemarkOutVo.class);

<a name="getUHostInstancePrice"></a>
#### GetUHostInstancePrice

根据UHost实例配置，获取UHost实例的价格。

    GetUHostInstancePriceInVo in = new GetUHostInstancePriceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setImageId("e36b3acf76663067684332055ade6bae");
    in.setcPU(1);
    in.setMemory(1024);
    in.setCount(1);
    GetUHostInstancePriceOutVo out = client.exec(in, GetUHostInstancePriceOutVo.class);
    for (Price price : out.getPriceSet()) {
        System.out.println(price.getChargeType());
        System.out.println(price.getPrice());
    }

<a name="getUHostInstanceVncInfo"></a>
#### GetUHostInstanceVncInfo

获取指定UHost实例的管理VNC配置详细信息。

    GetUHostInstanceVncInfoInVo in = new GetUHostInstanceVncInfoInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    GetUHostInstanceVncInfoOutVo out = client.exec(in, GetUHostInstanceVncInfoOutVo.class);

    System.out.println(out.getuHostId());
    System.out.println(out.getVncIP());
    System.out.println(out.getVncPort());
    System.out.println(out.getVncPassword());

<a name="createCustomImage"></a>
#### CreateCustomImage

从指定UHost实例，生成自定义镜像。

    CreateCustomImageInVo in = new CreateCustomImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setImageName("image-ubuntu1204");
    in.setImageDescription("image-ubuntu1204-desc");
    CreateCustomImageOutVo out = client.exec(in, CreateCustomImageOutVo.class);
    System.out.println(out.getImageId());

<a name="terminateCustomImage"></a>
#### TerminateCustomImage

删除用户自定义镜像

    TerminateCustomImageInVo in = new TerminateCustomImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setImageId("uimage-4pitdj");
    TerminateCustomImageOutVo out = client.exec(in, TerminateCustomImageOutVo.class);

<a name="createUHostInstanceSnapshot"></a>
#### CreateUHostInstanceSnapshot

对指定UHost实例制作数据快照。

    CreateUHostInstanceSnapshotInVo in = new CreateUHostInstanceSnapshotInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    CreateUHostInstanceSnapshotOutVo out = client.exec(in, CreateUHostInstanceSnapshotOutVo.class);

<a name="describeUHostInstanceSnapshot"></a>
#### DescribeUHostInstanceSnapshot

获取已经存在的UHost实例的存储快照列表。

    DescribeUHostInstanceSnapshotInVo in = new DescribeUHostInstanceSnapshotInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    DescribeUHostInstanceSnapshotOutVo out = client.exec(in, DescribeUHostInstanceSnapshotOutVo.class);

---

<a name="umon"></a>
### 云监控

<a name="getMetric"></a>
#### GetMetric

获取监控数据

    GetMetricInVo in = new GetMetricInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setResourceType(ResourceTypeEnum.uhost.name());
    in.setMetricName_0(MetricNameUhostEnum.CPUUtilization.name());
    in.setMetricName_1(MetricNameUhostEnum.MemUsage.name());
    in.setResourceId("uhost-f1y3dd");
    GetMetricOutVo out = client.exec(in, GetMetricOutVo.class);
    for (MetricDataDetail data : out.getDataSets().getcPUUtilization()) {
        System.out.println(data.getTimestamp());
        System.out.println(data.getValue());
    }
    for (MetricDataDetail data : out.getDataSets().getMemUsage()) {
        System.out.println(data.getTimestamp());
        System.out.println(data.getValue());
    }
