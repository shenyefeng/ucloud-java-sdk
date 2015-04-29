# UCLOUD-JAVA-SDK
## 一个使用Apache HttpClient的简单、易用、易扩展的Java SDK
---

基于 [UCLOUD HTTP REST API接口](http://docs.ucloud.cn/api/index.html)开发，适用于Java 6及以上版本。

## 目录
* [准备] (#准备)
* [云主机] (#云主机)
  * [DescribeImage] (#describeimage)
  * [CreateUHostInstance] (#createuhostinstance)
  * [DescribeUHostInstance] (#describeuhostinstance)
  * [TerminateUHostInstance] (#terminateuhostinstance)
  * [ResizeUHostInstance] (#resizeuhostinstance)
  * [ReinstallUHostInstance] (#reinstalluhostinstance)
  * [StartUHostInstance] (#startuhostinstance)
  * [StopUHostInstance] (#stopuhostinstance)
  * [RebootUHostInstance] (#rebootuhostinstance)
  * [ResetUHostInstancePassword] (#resetuhostinstancepassword)
  * [ModifyUHostInstanceName] (#modifyuhostinstancename)
  * [ModifyUHostInstanceTag] (#modifyuhostinstancetag)
  * [ModifyUHostInstanceRemark] (#modifyuhostinstanceremark)
  * [GetUHostInstancePrice] (#getuhostinstanceprice)
  * [GetUHostInstanceVncInfo] (#getuhostinstancevncinfo)
  * [CreateCustomImage] (#createcustomimage)
  * [TerminateCustomImage] (#terminatecustomimage)
  * [CreateUHostInstanceSnapshot] (#createuhostinstancesnapshot)
  * [DescribeUHostInstanceSnapshot] (#describeuhostinstancesnapshot)
* [网络] (#网络)
  * [AllocateEIP] (#allocateeip)
  * [DescribeEIP] (#describeeip)
  * [UpdateEIPAttribute] (#updateeipattribute)
  * [ReleaseEIP] (#releaseeip)
  * [BindEIP] (#bindeip)
  * [UnBindEIP] (#unbindeip)
  * [ModifyEIPBandwidth] (#modifyeipbandwidth)
  * [ModifyEIPWeight] (#modifyeipweight)
  * [GetEIPPrice] (#geteipprice)
  * [AllocateVIP] (#allocatevip)
  * [DescribeVIP] (#describevip)
  * [ReleaseVIP] (#releasevip)
  * [DescribeSecurityGroup] (#describesecuritygroup)
  * [DescribeSecurityGroupResource] (#describesecuritygroupresource)
  * [CreateSecurityGroup] (#createsecuritygroup)
  * [UpdateSecurityGroup] (#updatesecuritygroup)
  * [GrantSecurityGroup] (#grantsecuritygroup)
  * [DeleteSecurityGroup] (#deletesecuritygroup)
* [负载均衡] (#负载均衡)
  * [CreateULB] (#createulb)
  * [DeleteULB] (#deleteulb)
  * [DescribeULB] (#describeulb)
  * [UpdateULBAttribute] (#updateulbattribute)
  * [CreateVServer] (#createvserver)
  * [DeleteVServer] (#deletevserver)
  * [UpdateVServerAttribute] (#updatevserverattribute)
  * [AllocateBackend] (#allocatebackend)
  * [ReleaseBackend] (#releasebackend)
  * [UpdateBackendAttribute] (#updatebackendattribute)
  * [CreateSSL] (#createssl)
  * [DeleteSSL] (#deletessl)
  * [BindSSL] (#bindssl)
  * [DescribeSSL] (#describessl)
  * [CreatePolicyGroup] (#createpolicygroup)
  * [DeletePolicyGroup] (#deletepolicygroup)
  * [DescribePolicyGroup] (#describepolicygroup)
  * [UpdatePolicyGroupAttribute] (#updatepolicygroupattribute)
  * [CreatePolicy] (#createpolicy)
  * [DeletePolicy] (#deletepolicy)
* [云监控] (#云监控)
  * [GetMetric] (#getmetric)

---

<a name="准备"></a>
### 准备

##### 注册用户
大家可以登录[UCLOUD主站](http://www.ucloud.cn/)，开启虚拟化之旅。具体教程请参见[“文档中心”](http://docs.ucloud.cn/index.html)。

##### 初始化UcloudClient
有2种方式初始化UcloudClient：

1. 指定公钥和密钥
    UcloudClient client = UcloudClient.newClient("您的UCLOUD公钥", "您的UCLOUD密钥");
    
2. 指定数据中心、公钥和密钥
    UcloudClient client = UcloudClient.newClient("数据中心", "您的UCLOUD公钥", "您的UCLOUD密钥");

若不了解`公钥和密钥`，请参见[“公钥和密钥”](https://consolev3.ucloud.cn/apikey)
若不了解`数据中心`，请参见[“数据中心列表”](http://docs.ucloud.cn/api/regionlist.html)
如果指定了数据中心，XxxInVo中就不需要设置数据中心。

---
<a name="云主机"></a>
### 云主机

<a name="describeimage"></a>
#### DescribeImage

获取指定数据中心镜像列表，用户可通过指定镜像类型，操作系统类型，镜像Id进行过滤。

    DescribeImageInVo in = new DescribeImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    DescribeImageoutVo out = client.exec(in, DescribeImageoutVo.class);

<a name="createuhostinstance"></a>
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

<a name="describeuhostinstance"></a>
#### DescribeUHostInstance

获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。

    DescribeUHostInstanceInVo in = new DescribeUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostIds_0("uhost-f1y3dd");
    DescribeUHostInstanceOutVo out = client.exec(in, DescribeUHostInstanceOutVo.class);

<a name="terminateuhostinstance"></a>
#### TerminateUHostInstance

删除指定数据中心的UHost实例。

    TerminateUHostInstanceInVo in = new TerminateUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    TerminateUHostInstanceOutVo out = client.exec(in, TerminateUHostInstanceOutVo.class);

<a name="resizeuhostinstance"></a>
#### ResizeUHostInstance

修改指定UHost实例的资源配置，如CPU核心数，内存容量大小，磁盘空间大小等。

> **修改配置注意事项：**1.修改配置前，请确认该实例已经被关闭。 2.修改磁盘空间大小后，请在启动后按照说明，进入操作系统进行操作。

    ResizeUHostInstanceInVo in = new ResizeUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setDiskSpace(80);
    ResizeUHostInstanceOutVo out = client.exec(in, ResizeUHostInstanceOutVo.class);

<a name="reinstalluhostinstance"></a>
#### ReinstallUHostInstance

重新安装指定UHost实例的操作系统

> **警告：**1.请确认在重新安装之前，该实例已被关闭； 2.请确认该实例未挂载UDisk；3.将原系统重装为不同类型的系统时(Linux->Windows)，不可选择保留数据盘；4.重装不同版本的系统时(CentOS6->CentOS7)，若选择保留数据盘，请注意数据盘的文件系统格式；5.若主机CPU低于2核，不可重装为Windows系统。

    ReinstallUHostInstanceInVo in = new ReinstallUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setPassword("ucloud2345");
    ReinstallUHostInstanceOutVo out = client.exec(in, ReinstallUHostInstanceOutVo.class);

<a name="startuhostinstance"></a>
#### StartUHostInstance

启动处于关闭状态的UHost实例，需要指定数据中心及UHostID两个参数的值。

    StartUHostInstanceInVo in = new StartUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    StartUHostInstanceOutVo out = client.exec(in, StartUHostInstanceOutVo.class);


<a name="stopuhostinstance"></a>
#### StopUHostInstance

指停止处于运行状态的UHost实例，需指定数据中心及UhostID。

    StopUHostInstanceInVo in = new StopUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    StopUHostInstanceOutVo out = client.exec(in, StopUHostInstanceOutVo.class);

<a name="rebootuhostinstance"></a>
#### RebootUHostInstance

重新启动UHost实例，需要指定数据中心及UHostID两个参数的值。

    RebootUHostInstanceInVo in = new RebootUHostInstanceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    RebootUHostInstanceOutVo out = client.exec(in, RebootUHostInstanceOutVo.class);

<a name="resetuhostinstancepassword"></a>
#### ResetUHostInstancePassword

重置UHost实例的管理员密码。

    ResetUHostInstancePasswordInVo in = new ResetUHostInstancePasswordInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setPassword("ucloud123456");
    ResetUHostInstancePasswordOutVo out = client.exec(in, ResetUHostInstancePasswordOutVo.class);

<a name="modifyuhostinstancename"></a>
#### ModifyUHostInstanceName

修改指定UHost实例名称，需要给出数据中心，UHostId，及新的实例名称。

    ModifyUHostInstanceNameInVo in = new ModifyUHostInstanceNameInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setName("ubuntu1204-001");
    ModifyUHostInstanceNameOutVo out = client.exec(in, ModifyUHostInstanceNameOutVo.class);

<a name="modifyuhostinstancetag"></a>
#### ModifyUHostInstanceTag

修改指定UHost实例业务组标识。

    ModifyUHostInstanceTagInVo in = new ModifyUHostInstanceTagInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setTag("ubuntu1204-001-tag");
    ModifyUHostInstanceTagOutVo out = client.exec(in, ModifyUHostInstanceTagOutVo.class);

<a name="modifyuhostinstanceremark"></a>
#### ModifyUHostInstanceRemark

修改指定UHost实例备注信息。

    ModifyUHostInstanceRemarkInVo in = new ModifyUHostInstanceRemarkInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setRemark("ubuntu1204-001-remark");
    ModifyUHostInstanceRemarkOutVo out = client.exec(in, ModifyUHostInstanceRemarkOutVo.class);

<a name="getuhostinstanceprice"></a>
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

<a name="getuhostinstancevncinfo"></a>
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

<a name="createcustomimage"></a>
#### CreateCustomImage

从指定UHost实例，生成自定义镜像。

    CreateCustomImageInVo in = new CreateCustomImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    in.setImageName("image-ubuntu1204");
    in.setImageDescription("image-ubuntu1204-desc");
    CreateCustomImageOutVo out = client.exec(in, CreateCustomImageOutVo.class);
    System.out.println(out.getImageId());

<a name="terminatecustomimage"></a>
#### TerminateCustomImage

删除用户自定义镜像

    TerminateCustomImageInVo in = new TerminateCustomImageInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setImageId("uimage-4pitdj");
    TerminateCustomImageOutVo out = client.exec(in, TerminateCustomImageOutVo.class);

<a name="createuhostinstancesnapshot"></a>
#### CreateUHostInstanceSnapshot

对指定UHost实例制作数据快照。

    CreateUHostInstanceSnapshotInVo in = new CreateUHostInstanceSnapshotInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    CreateUHostInstanceSnapshotOutVo out = client.exec(in, CreateUHostInstanceSnapshotOutVo.class);

<a name="describeuhostinstancesnapshot"></a>
#### DescribeUHostInstanceSnapshot

获取已经存在的UHost实例的存储快照列表。

    DescribeUHostInstanceSnapshotInVo in = new DescribeUHostInstanceSnapshotInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setuHostId("uhost-f1y3dd");
    DescribeUHostInstanceSnapshotOutVo out = client.exec(in, DescribeUHostInstanceSnapshotOutVo.class);

---

<a name="网络"></a>
### 网络

<a name="allocateeip"></a>
### AllocateEIP

根据提供信息，分配弹性IP

    AllocateEIPInVo in = new AllocateEIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setOperatorName(OperatorNameEnum.Bgp.name());
    in.setBandwidth(1);
    in.setChargeType(ChargeTypeEnum.Month.name());

    AllocateEIPOutVo out = client.exec(in, AllocateEIPOutVo.class);
    for (EIP eip : out.geteIPSet()) {
        System.out.println(eip.geteIPId());
        for(EIPAddr addr : eip.geteIPAddr()) {
    	System.out.println(addr.getiP());
    	System.out.println(addr.getOperatorName());
        }
    }

<a name="describeeip"></a>
### DescribeEIP

获取弹性IP详细信息

    DescribeEIPInVo in = new DescribeEIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPIds_0("eip-mmhr0f");

    DescribeEIPOutVo out = client.exec(in, DescribeEIPOutVo.class);
    for (EIP eip : out.geteIPSet()) {
        System.out.println(eip.geteIPId());
        for(EIPAddr addr : eip.geteIPAddr()) {
            System.out.println(addr.getiP());
            System.out.println(addr.getOperatorName());
        }
    }

<a name="updateeipattribute"></a>
### UpdateEIPAttribute

修改EIP名字业务组备注等属性字段

    UpdateEIPAttributeInVo in = new UpdateEIPAttributeInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-mmhr0f");
    in.setName("eip name");
    in.setRemark("eip remark");
    in.setTag("eip tag");
    UpdateEIPAttributeOutVo out = client.exec(in, UpdateEIPAttributeOutVo.class);

<a name="releaseeip"></a>
### ReleaseEIP

释放EIP资源

    ReleaseEIPInVo in = new ReleaseEIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-n1hvdm");
    ReleaseEIPOutVo out = client.exec(in, ReleaseEIPOutVo.class);

<a name="bindeip"></a>
### BindEIP

将弹性IP绑定到资源上

    BindEIPInVo in = new BindEIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-mmhr0f");
    in.setResourceType(ResourceTypeEnum.ulb.name());
    in.setResourceId("ulb-2t22s4");
    BindEIPOutVo out = client.exec(in, BindEIPOutVo.class);

<a name="unbindeip"></a>
### UnBindEIP

将弹性IP从资源上解绑

    UnBindEIPInVo in = new UnBindEIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-mmhr0f");
    in.setResourceType(ResourceTypeEnum.uhost.name());
    in.setResourceId("uhost-f1y3dd");
    UnBindEIPOutVo out = client.exec(in, UnBindEIPOutVo.class);

<a name="modifyeipbandwidth"></a>
### ModifyEIPBandwidth

修改弹性IP的外网带宽

    ModifyEIPBandwidthInVo in = new ModifyEIPBandwidthInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-mmhr0f");
    in.setBandwidth(1);
    ModifyEIPBandwidthOutVo out = client.exec(in, ModifyEIPBandwidthOutVo.class);

<a name="modifyeipweight"></a>
### ModifyEIPWeight

修改弹性IP的外网出口权重

    ModifyEIPWeightInVo in = new ModifyEIPWeightInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.seteIPId("eip-mmhr0f");
    in.setWeight(2);
    ModifyEIPWeightOutVo out = client.exec(in, ModifyEIPWeightOutVo.class);

<a name="geteipprice"></a>
### GetEIPPrice

获取弹性IP价格

    GetEIPPriceInVo in = new GetEIPPriceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setOperatorName(OperatorNameEnum.Bgp.name());
    in.setBandwidth(1);
    in.setChargeType(ChargeTypeEnum.Month.name());

    GetEIPPriceOutVo out = client.exec(in, GetEIPPriceOutVo.class);
    for(Price price : out.getPriceSet()) {
        System.out.println(price.getChargeType());
        System.out.println(price.getPrice());
        System.out.println(price.getPurchaseValue());
    }

<a name="allocatevip"></a>
### AllocateVIP

根据提供信息，分配内网VIP(Virtual IP，多用于高可用程序作为漂移IP。)

    AllocateVIPInVo in = new AllocateVIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setCount(2);
    AllocateVIPOutVo out = client.exec(in, AllocateVIPOutVo.class);

<a name="describevip"></a>
### DescribeVIP

获取内网VIP详细信息

    DescribeVIPInVo in = new DescribeVIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    DescribeVIPOutVo out = client.exec(in, DescribeVIPOutVo.class);

<a name="releasevip"></a>
### ReleaseVIP

释放VIP资源

    ReleaseVIPInVo in = new ReleaseVIPInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setvIP("10.10.74.26");
    ReleaseVIPOutVo out = client.exec(in, ReleaseVIPOutVo.class);

<a name="describesecuritygroup"></a>
### DescribeSecurityGroup

获取防火墙组信息

    DescribeSecurityGroupInVo in = new DescribeSecurityGroupInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setResourceType(ResourceTypeEnum.uhost.name());
    in.setResourceId("uhost-f1y3dd");
    DescribeSecurityGroupOutVo out = client.exec(in, DescribeSecurityGroupOutVo.class);

<a name="describesecuritygroupresource"></a>
### DescribeSecurityGroupResource

获取防火墙组所绑定资源的外网IP

    DescribeSecurityGroupResourceInVo in = new DescribeSecurityGroupResourceInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setGroupId(14881);
    DescribeSecurityGroupResourceOutVo out = client.exec(in, DescribeSecurityGroupResourceOutVo.class);

<a name="createsecuritygroup"></a>
### CreateSecurityGroup

创建防火墙组

    CreateSecurityGroupInVo in = new CreateSecurityGroupInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    RuleIn rule = new RuleIn();
    rule.setProto(ProtoEnum.TCP.name());
    rule.setDst_port("22-80");
    rule.setSrc_ip("0.0.0.0/0");
    rule.setAction(RuleActionEnum.ACCEPT.name());
    rule.setPriority(PriorityEnum.MIDDLE.getValue());
    in.setRule_0(rule);
    in.setGroupName("sg name");
    in.setDescription("sg desc");
    CreateSecurityGroupOutVo out = client.exec(in, CreateSecurityGroupOutVo.class);

<a name="updatesecuritygroup"></a>
### UpdateSecurityGroup

更新防火墙规则
>**注解**在更新防火墙规则时，新的规则会覆盖掉原有规则。所以若需要更改或加入新的规则，需要将原所有规则与新规则一起提交。

    UpdateSecurityGroupInVo in = new UpdateSecurityGroupInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    RuleIn rule = new RuleIn();
    rule.setProto(ProtoEnum.UDP.name());
    rule.setDst_port("22-88");
    rule.setSrc_ip("0.0.0.0/0");
    rule.setAction(RuleActionEnum.ACCEPT.name());
    rule.setPriority(PriorityEnum.MIDDLE.getValue());
    in.setRule_0(rule);
    in.setGroupId(14881);
    UpdateSecurityGroupOutVo out = client.exec(in, UpdateSecurityGroupOutVo.class);

<a name="grantsecuritygroup"></a>
### GrantSecurityGroup

将防火墙应用到资源上

    GrantSecurityGroupInVo in = new GrantSecurityGroupInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setGroupId(14251);
    in.setResourceType(ResourceTypeEnum.uhost.name());
    in.setResourceId("uhost-f1y3dd");
    GrantSecurityGroupOutVo out = client.exec(in, GrantSecurityGroupOutVo.class);

<a name="deletesecuritygroup"></a>
### DeleteSecurityGroup

删除防火墙

    DeleteSecurityGroupInVo in = new DeleteSecurityGroupInVo();
    in.setRegion(DataCenterEnum.北京BGP_C.getValue());
    in.setGroupId(14884);
    DeleteSecurityGroupOutVo out = client.exec(in, DeleteSecurityGroupOutVo.class);
---

<a name="负载均衡"></a>
### 负载均衡

<a name="createulb"></a>
### CreateULB
创建负载均衡实例

	CreateULBInVo in = new CreateULBInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBName("ulb name");
	CreateULBOutVo out = client.exec(in, CreateULBOutVo.class);

<a name="deleteulb"></a>
### DeleteULB
删除负载均衡实例

	DeleteULBInVo in = new DeleteULBInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	DeleteULBOutVo out = client.exec(in, DeleteULBOutVo.class);

<a name="describeulb"></a>
### DescribeULB
获取ULB详细信息

	DescribeULBInVo in = new DescribeULBInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	DescribeULBOutVo out = client.exec(in, DescribeULBOutVo.class);

<a name="updateulbattribute"></a>
### UpdateULBAttribute
修改ULB名字业务组备注等属性字段

	UpdateULBAttributeInVo in = new UpdateULBAttributeInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setName("ulb name updated");
	in.setTag("ulb tag updated");
	in.setRemark("ulb remark updated");
	UpdateULBAttributeOutVo out = client.exec(in, UpdateULBAttributeOutVo.class);

<a name="createvserver"></a>
### CreateVServer
创建VServer实例

	CreateVServerInVo in = new CreateVServerInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	CreateVServerOutVo out = client.exec(in, CreateVServerOutVo.class);

<a name="deletevserver"></a>
### DeleteVServer
删除VServer实例

	DeleteVServerInVo in = new DeleteVServerInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
	DeleteVServerOutVo out = client.exec(in, DeleteVServerOutVo.class);

<a name="updatevserverattribute"></a>
### UpdateVServerAttribute
修改VServer实例属性

	UpdateVServerAttributeInVo in = new UpdateVServerAttributeInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
	in.setMethod(VServerMethodEnum.Source.name());
	UpdateVServerAttributeOutVo out = client.exec(in, UpdateVServerAttributeOutVo.class);

<a name="allocatebackend"></a>
### AllocateBackend
添加ULB后端资源实例

	AllocateBackendInVo in = new AllocateBackendInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
	in.setResourceType("UHost"/* ResourceTypeEnum.uhost.name() */);
	in.setResourceId("uhost-f1y3dd");
	AllocateBackendOutVo out = client.exec(in, AllocateBackendOutVo.class);

<a name="releasebackend"></a>
### ReleaseBackend
释放ULB后端资源实例

	ReleaseBackendInVo in = new ReleaseBackendInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setBackendId("f174c09c-b8ee-4d2d-99e3-284a7673da82");
	ReleaseBackendOutVo out = client.exec(in, ReleaseBackendOutVo.class);

<a name="updatebackendattribute"></a>
### UpdateBackendAttribute
修改ULB后端资源实例(主机池)属性

	UpdateBackendAttributeInVo in = new UpdateBackendAttributeInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setBackendId("f174c09c-b8ee-4d2d-99e3-284a7673da82");
	UpdateBackendAttributeOutVo out = client.exec(in, UpdateBackendAttributeOutVo.class);

<a name="createssl"></a>
### CreateSSL
添加SSL证书

	CreateSSLInVo in = new CreateSSLInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setsSLName("ssl name");
	in.setsSLContent("");
	CreateSSLOutVo out = client.exec(in, CreateSSLOutVo.class);

<a name="deletessl"></a>
### DeleteSSL
删除SSL证书

<a name="bindssl"></a>
### BindSSL
将SSL证书绑定到VServer

<a name="describessl"></a>
### DescribeSSL
显示SSL证书信息

<a name="createpolicygroup"></a>
### CreatePolicyGroup
创建内容转发策略组

	CreatePolicyGroupInVo in = new CreatePolicyGroupInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setGroupName("PolicyGroup name");
	CreatePolicyGroupOutVo out = client.exec(in, CreatePolicyGroupOutVo.class);

<a name="deletepolicygroup"></a>
### DeletePolicyGroup
删除内容转发策略组

	DeletePolicyGroupInVo in = new DeletePolicyGroupInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setGroupId("ulb-fr-krbaoc");
	DeletePolicyGroupOutVo out = client.exec(in, DeletePolicyGroupOutVo.class);

<a name="describepolicygroup"></a>
### DescribePolicyGroup
显示内容转发策略组详情

	DescribePolicyGroupInVo in = new DescribePolicyGroupInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setGroupId("ulb-fr-krbaoc");
	DescribePolicyGroupOutVo out = client.exec(in, DescribePolicyGroupOutVo.class);

<a name="updatepolicygroupattribute"></a>
### UpdatePolicyGroupAttribute
修改内容转发策略组配置信息

	UpdatePolicyGroupAttributeInVo in = new UpdatePolicyGroupAttributeInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setGroupId("ulb-fr-krbaoc");
	in.setGroupName("PolicyGroup name updated");
	UpdatePolicyGroupAttributeOutVo out = client.exec(in, UpdatePolicyGroupAttributeOutVo.class);

<a name="createpolicy"></a>
### CreatePolicy
创建内容转发策略

	CreatePolicyInVo in = new CreatePolicyInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setuLBId("ulb-2t22s4");
	in.setGroupId("ulb-fr-krbaoc");
	in.setMatch("match word");
	in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
	in.setBackendId_0("f174c09c-b8ee-4d2d-99e3-284a7673da82");
	CreatePolicyOutVo out = client.exec(in, CreatePolicyOutVo.class);

<a name="deletepolicy"></a>
### DeletePolicy
删除内容转发策略

	DeletePolicyInVo in = new DeletePolicyInVo();
	in.setRegion(DataCenterEnum.北京BGP_C.getValue());
	in.setGroupId("ulb-fr-krbaoc");
	in.setPolicyId("84dfd3ae-4217-4197-94b1-87c0141b1b71");
	DeletePolicyOutVo out = client.exec(in, DeletePolicyOutVo.class);

---

<a name="云监控"></a>
### 云监控

<a name="getmetric"></a>
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

---
