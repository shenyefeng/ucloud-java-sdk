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
import cn.ucloud.sdk.enums.DataCenterEnum;
import cn.ucloud.sdk.enums.VServerMethodEnum;
import cn.ucloud.sdk.vo.ulb.in.AllocateBackendInVo;
import cn.ucloud.sdk.vo.ulb.in.CreatePolicyGroupInVo;
import cn.ucloud.sdk.vo.ulb.in.CreatePolicyInVo;
import cn.ucloud.sdk.vo.ulb.in.CreateSSLInVo;
import cn.ucloud.sdk.vo.ulb.in.CreateULBInVo;
import cn.ucloud.sdk.vo.ulb.in.CreateVServerInVo;
import cn.ucloud.sdk.vo.ulb.in.DeletePolicyGroupInVo;
import cn.ucloud.sdk.vo.ulb.in.DeletePolicyInVo;
import cn.ucloud.sdk.vo.ulb.in.DeleteULBInVo;
import cn.ucloud.sdk.vo.ulb.in.DeleteVServerInVo;
import cn.ucloud.sdk.vo.ulb.in.DescribePolicyGroupInVo;
import cn.ucloud.sdk.vo.ulb.in.DescribeULBInVo;
import cn.ucloud.sdk.vo.ulb.in.ReleaseBackendInVo;
import cn.ucloud.sdk.vo.ulb.in.UpdateBackendAttributeInVo;
import cn.ucloud.sdk.vo.ulb.in.UpdatePolicyGroupAttributeInVo;
import cn.ucloud.sdk.vo.ulb.in.UpdateULBAttributeInVo;
import cn.ucloud.sdk.vo.ulb.in.UpdateVServerAttributeInVo;
import cn.ucloud.sdk.vo.ulb.out.AllocateBackendOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreatePolicyGroupOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreatePolicyOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreateSSLOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreateULBOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreateVServerOutVo;
import cn.ucloud.sdk.vo.ulb.out.DeletePolicyGroupOutVo;
import cn.ucloud.sdk.vo.ulb.out.DeletePolicyOutVo;
import cn.ucloud.sdk.vo.ulb.out.DeleteULBOutVo;
import cn.ucloud.sdk.vo.ulb.out.DeleteVServerOutVo;
import cn.ucloud.sdk.vo.ulb.out.DescribePolicyGroupOutVo;
import cn.ucloud.sdk.vo.ulb.out.DescribeULBOutVo;
import cn.ucloud.sdk.vo.ulb.out.ReleaseBackendOutVo;
import cn.ucloud.sdk.vo.ulb.out.UpdateBackendAttributeOutVo;
import cn.ucloud.sdk.vo.ulb.out.UpdatePolicyGroupAttributeOutVo;
import cn.ucloud.sdk.vo.ulb.out.UpdateULBAttributeOutVo;
import cn.ucloud.sdk.vo.ulb.out.UpdateVServerAttributeOutVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UcloudUlbClientTest {

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
    public void testCreateULB() {
        CreateULBInVo in = new CreateULBInVo();
        in.setuLBName("ulb name");

        CreateULBOutVo out = client.exec(in, CreateULBOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUpdateULBAttribute() {
        UpdateULBAttributeInVo in = new UpdateULBAttributeInVo();
        in.setuLBId("ulb-2t22s4");
        in.setName("ulb name updated");
        in.setTag("ulb tag updated");
        in.setRemark("ulb remark updated");

        UpdateULBAttributeOutVo out = client.exec(in, UpdateULBAttributeOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDescribeULB() {
        DescribeULBInVo in = new DescribeULBInVo();
        in.setuLBId("ulb-2t22s4");

        DescribeULBOutVo out = client.exec(in, DescribeULBOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeleteULB() {
        DeleteULBInVo in = new DeleteULBInVo();
        in.setuLBId("ulb-2t22s4");

        DeleteULBOutVo out = client.exec(in, DeleteULBOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testCreateVServer() {
        CreateVServerInVo in = new CreateVServerInVo();
        in.setuLBId("ulb-2t22s4");

        CreateVServerOutVo out = client.exec(in, CreateVServerOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUpdateVServerAttribute() {
        UpdateVServerAttributeInVo in = new UpdateVServerAttributeInVo();
        in.setuLBId("ulb-2t22s4");
        in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
        in.setMethod(VServerMethodEnum.Source.name());

        UpdateVServerAttributeOutVo out = client.exec(in, UpdateVServerAttributeOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeleteVServer() {
        DeleteVServerInVo in = new DeleteVServerInVo();
        in.setuLBId("ulb-2t22s4");
        in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");

        DeleteVServerOutVo out = client.exec(in, DeleteVServerOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testAllocateBackend() {
        AllocateBackendInVo in = new AllocateBackendInVo();
        in.setuLBId("ulb-2t22s4");
        in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
        in.setResourceType("UHost"/* ResourceTypeEnum.uhost.name() */);
        in.setResourceId("uhost-f1y3dd");

        AllocateBackendOutVo out = client.exec(in, AllocateBackendOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUpdateBackendAttribute() {
        UpdateBackendAttributeInVo in = new UpdateBackendAttributeInVo();
        in.setuLBId("ulb-2t22s4");
        in.setBackendId("f174c09c-b8ee-4d2d-99e3-284a7673da82");

        UpdateBackendAttributeOutVo out = client.exec(in, UpdateBackendAttributeOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testReleaseBackend() {
        ReleaseBackendInVo in = new ReleaseBackendInVo();
        in.setuLBId("ulb-2t22s4");
        in.setBackendId("f174c09c-b8ee-4d2d-99e3-284a7673da82");

        ReleaseBackendOutVo out = client.exec(in, ReleaseBackendOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testCreatePolicyGroup() {
        CreatePolicyGroupInVo in = new CreatePolicyGroupInVo();
        in.setGroupName("PolicyGroup name");

        CreatePolicyGroupOutVo out = client.exec(in, CreatePolicyGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDescribePolicyGroup() {
        DescribePolicyGroupInVo in = new DescribePolicyGroupInVo();
        in.setGroupId("ulb-fr-krbaoc");

        DescribePolicyGroupOutVo out = client.exec(in, DescribePolicyGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUpdatePolicyGroupAttribute() {
        UpdatePolicyGroupAttributeInVo in = new UpdatePolicyGroupAttributeInVo();
        in.setGroupId("ulb-fr-krbaoc");
        in.setGroupName("PolicyGroup name updated");

        UpdatePolicyGroupAttributeOutVo out = client.exec(in, UpdatePolicyGroupAttributeOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeletePolicyGroup() {
        DeletePolicyGroupInVo in = new DeletePolicyGroupInVo();
        in.setGroupId("ulb-fr-krbaoc");

        DeletePolicyGroupOutVo out = client.exec(in, DeletePolicyGroupOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testCreatePolicy() {
        CreatePolicyInVo in = new CreatePolicyInVo();
        in.setuLBId("ulb-2t22s4");
        in.setGroupId("ulb-fr-krbaoc");
        in.setMatch("match word");
        in.setvServerId("875a4804-4076-42e0-889d-8c5b1018046f");
        in.setBackendId_0("f174c09c-b8ee-4d2d-99e3-284a7673da82");

        CreatePolicyOutVo out = client.exec(in, CreatePolicyOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeletePolicy() {
        DeletePolicyInVo in = new DeletePolicyInVo();
        in.setGroupId("ulb-fr-krbaoc");
        in.setPolicyId("84dfd3ae-4217-4197-94b1-87c0141b1b71");

        DeletePolicyOutVo out = client.exec(in, DeletePolicyOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    

    @Test
    public void testCreateSSL() {
        CreateSSLInVo in = new CreateSSLInVo();
        in.setsSLName("ssl name");
        in.setsSLContent("");

        CreateSSLOutVo out = client.exec(in, CreateSSLOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

}
