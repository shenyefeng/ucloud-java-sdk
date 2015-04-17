// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package cn.ucloud.sdk.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.ucloud.sdk.UcloudClient;
import cn.ucloud.sdk.enums.ChargeTypeEnum;
import cn.ucloud.sdk.enums.DataCenterEnum;
import cn.ucloud.sdk.enums.OperatorNameEnum;
import cn.ucloud.sdk.enums.PriorityEnum;
import cn.ucloud.sdk.enums.ProtoEnum;
import cn.ucloud.sdk.enums.ResourceTypeEnum;
import cn.ucloud.sdk.enums.RuleActionEnum;
import cn.ucloud.sdk.vo.unet.in.AllocateEIPInVo;
import cn.ucloud.sdk.vo.unet.in.AllocateVIPInVo;
import cn.ucloud.sdk.vo.unet.in.BindEIPInVo;
import cn.ucloud.sdk.vo.unet.in.CreateSecurityGroupInVo;
import cn.ucloud.sdk.vo.unet.in.DeleteSecurityGroupInVo;
import cn.ucloud.sdk.vo.unet.in.DescribeEIPInVo;
import cn.ucloud.sdk.vo.unet.in.DescribeSecurityGroupInVo;
import cn.ucloud.sdk.vo.unet.in.DescribeSecurityGroupResourceInVo;
import cn.ucloud.sdk.vo.unet.in.DescribeVIPInVo;
import cn.ucloud.sdk.vo.unet.in.GetEIPPriceInVo;
import cn.ucloud.sdk.vo.unet.in.GrantSecurityGroupInVo;
import cn.ucloud.sdk.vo.unet.in.ModifyEIPBandwidthInVo;
import cn.ucloud.sdk.vo.unet.in.ModifyEIPWeightInVo;
import cn.ucloud.sdk.vo.unet.in.ReleaseEIPInVo;
import cn.ucloud.sdk.vo.unet.in.ReleaseVIPInVo;
import cn.ucloud.sdk.vo.unet.in.RuleIn;
import cn.ucloud.sdk.vo.unet.in.UnBindEIPInVo;
import cn.ucloud.sdk.vo.unet.in.UpdateEIPAttributeInVo;
import cn.ucloud.sdk.vo.unet.in.UpdateSecurityGroupInVo;
import cn.ucloud.sdk.vo.unet.out.AllocateEIPOutVo;
import cn.ucloud.sdk.vo.unet.out.AllocateVIPOutVo;
import cn.ucloud.sdk.vo.unet.out.BindEIPOutVo;
import cn.ucloud.sdk.vo.unet.out.CreateSecurityGroupOutVo;
import cn.ucloud.sdk.vo.unet.out.DeleteSecurityGroupOutVo;
import cn.ucloud.sdk.vo.unet.out.DescribeEIPOutVo;
import cn.ucloud.sdk.vo.unet.out.DescribeSecurityGroupOutVo;
import cn.ucloud.sdk.vo.unet.out.DescribeSecurityGroupResourceOutVo;
import cn.ucloud.sdk.vo.unet.out.DescribeVIPOutVo;
import cn.ucloud.sdk.vo.unet.out.EIP;
import cn.ucloud.sdk.vo.unet.out.EIPAddr;
import cn.ucloud.sdk.vo.unet.out.GetEIPPriceOutVo;
import cn.ucloud.sdk.vo.unet.out.GrantSecurityGroupOutVo;
import cn.ucloud.sdk.vo.unet.out.ModifyEIPBandwidthOutVo;
import cn.ucloud.sdk.vo.unet.out.ModifyEIPWeightOutVo;
import cn.ucloud.sdk.vo.unet.out.Price;
import cn.ucloud.sdk.vo.unet.out.ReleaseEIPOutVo;
import cn.ucloud.sdk.vo.unet.out.ReleaseVIPOutVo;
import cn.ucloud.sdk.vo.unet.out.UnBindEIPOutVo;
import cn.ucloud.sdk.vo.unet.out.UpdateEIPAttributeOutVo;
import cn.ucloud.sdk.vo.unet.out.UpdateSecurityGroupOutVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UcloudUNetClientTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    UcloudClient client = UcloudClient.newClient(DataCenterEnum.北京BGP_C.getValue(), "ucloud37393993@qq.com1427084764000315652657", "cda1127f34c284e992c02c79c3f9ed5edbc5b354");

    @Test
    public void testAllocateEIP() {
        AllocateEIPInVo in = new AllocateEIPInVo();
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
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDescribeEIP() {
        DescribeEIPInVo in = new DescribeEIPInVo();
        in.seteIPIds_0("eip-mmhr0f");

        DescribeEIPOutVo out = client.exec(in, DescribeEIPOutVo.class);
        for (EIP eip : out.geteIPSet()) {
            System.out.println(eip.geteIPId());
            for(EIPAddr addr : eip.geteIPAddr()) {
                System.out.println(addr.getiP());
                System.out.println(addr.getOperatorName());
            }
        }
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testUpdateEIPAttribute() {
        UpdateEIPAttributeInVo in = new UpdateEIPAttributeInVo();
        in.seteIPId("eip-mmhr0f");
        in.setName("eip name");
        in.setRemark("eip remark");
        in.setTag("eip tag");

        UpdateEIPAttributeOutVo out = client.exec(in, UpdateEIPAttributeOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testBindEIPAttribute() {
        BindEIPInVo in = new BindEIPInVo();
        in.seteIPId("eip-mmhr0f");
        in.setResourceType(ResourceTypeEnum.ulb.name());
        in.setResourceId("ulb-2t22s4");

        BindEIPOutVo out = client.exec(in, BindEIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUnBindEIPAttribute() {
        UnBindEIPInVo in = new UnBindEIPInVo();
        in.seteIPId("eip-mmhr0f");
        in.setResourceType(ResourceTypeEnum.uhost.name());
        in.setResourceId("uhost-f1y3dd");

        UnBindEIPOutVo out = client.exec(in, UnBindEIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testModifyEIPBandwidth() {
        ModifyEIPBandwidthInVo in = new ModifyEIPBandwidthInVo();
        in.seteIPId("eip-mmhr0f");
        in.setBandwidth(1);

        ModifyEIPBandwidthOutVo out = client.exec(in, ModifyEIPBandwidthOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testModifyEIPWeight() {
        ModifyEIPWeightInVo in = new ModifyEIPWeightInVo();
        in.seteIPId("eip-mmhr0f");
        in.setWeight(2);

        ModifyEIPWeightOutVo out = client.exec(in, ModifyEIPWeightOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testGetEIPPrice() {
        GetEIPPriceInVo in = new GetEIPPriceInVo();
        in.setOperatorName(OperatorNameEnum.Bgp.name());
        in.setBandwidth(1);
        in.setChargeType(ChargeTypeEnum.Month.name());
        
        GetEIPPriceOutVo out = client.exec(in, GetEIPPriceOutVo.class);
        for(Price price : out.getPriceSet()) {
            System.out.println(price.getChargeType());
            System.out.println(price.getPrice());
            System.out.println(price.getPurchaseValue());
        }
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testReleaseEIP() {
        ReleaseEIPInVo in = new ReleaseEIPInVo();
        in.seteIPId("eip-n1hvdm");

        ReleaseEIPOutVo out = client.exec(in, ReleaseEIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testAllocateVIP() {
        AllocateVIPInVo in = new AllocateVIPInVo();
        in.setCount(2);

        AllocateVIPOutVo out = client.exec(in, AllocateVIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeVIP() {
        DescribeVIPInVo in = new DescribeVIPInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());

        DescribeVIPOutVo out = client.exec(in, DescribeVIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testReleaseVIP() {
        ReleaseVIPInVo in = new ReleaseVIPInVo();
        in.setvIP("10.10.74.26");

        ReleaseVIPOutVo out = client.exec(in, ReleaseVIPOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testCreateSecurityGroup() {
        CreateSecurityGroupInVo in = new CreateSecurityGroupInVo();
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
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testUpdateSecurityGroup() {
        UpdateSecurityGroupInVo in = new UpdateSecurityGroupInVo();
        RuleIn rule = new RuleIn();
        rule.setProto(ProtoEnum.UDP.name());
        rule.setDst_port("22-88");
        rule.setSrc_ip("0.0.0.0/0");
        rule.setAction(RuleActionEnum.ACCEPT.name());
        rule.setPriority(PriorityEnum.MIDDLE.getValue());
        in.setRule_0(rule);
        in.setGroupId(14881);

        UpdateSecurityGroupOutVo out = client.exec(in, UpdateSecurityGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testGrantSecurityGroup() {
        GrantSecurityGroupInVo in = new GrantSecurityGroupInVo();
        in.setGroupId(14251);
        in.setResourceType(ResourceTypeEnum.uhost.name());
        in.setResourceId("uhost-f1y3dd");

        GrantSecurityGroupOutVo out = client.exec(in, GrantSecurityGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeSecurityGroup() {
        DescribeSecurityGroupInVo in = new DescribeSecurityGroupInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
//        in.setGroupId(14881);
//        in.setResourceType(ResourceTypeEnum.uhost.name());
//        in.setResourceId("uhost-f1y3dd");

        DescribeSecurityGroupOutVo out = client.exec(in, DescribeSecurityGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeSecurityGroupResource() {
        DescribeSecurityGroupResourceInVo in = new DescribeSecurityGroupResourceInVo();
        in.setGroupId(14881);

        DescribeSecurityGroupResourceOutVo out = client.exec(in, DescribeSecurityGroupResourceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDeleteSecurityGroup() {
        DeleteSecurityGroupInVo in = new DeleteSecurityGroupInVo();
        in.setGroupId(14884);

        DeleteSecurityGroupOutVo out = client.exec(in, DeleteSecurityGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
}
