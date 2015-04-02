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
import cn.ucloud.sdk.vo.ulb.in.CreateULBInVo;
import cn.ucloud.sdk.vo.ulb.in.CreateVServerInVo;
import cn.ucloud.sdk.vo.ulb.in.DescribeULBInVo;
import cn.ucloud.sdk.vo.ulb.in.UpdateULBAttributeInVo;
import cn.ucloud.sdk.vo.ulb.out.CreateULBOutVo;
import cn.ucloud.sdk.vo.ulb.out.CreateVServerOutVo;
import cn.ucloud.sdk.vo.ulb.out.DescribeULBOutVo;
import cn.ucloud.sdk.vo.ulb.out.UpdateULBAttributeOutVo;

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

    UcloudClient client = UcloudClient.newClient("ucloud37393993@qq.com1427084764000315652657", "cda1127f34c284e992c02c79c3f9ed5edbc5b354");

    @Test
    public void testCreateULB() {
        CreateULBInVo in = new CreateULBInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuLBName("ulb name");

        CreateULBOutVo out = client.exec(in, CreateULBOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testUpdateULBAttribute() {
        UpdateULBAttributeInVo in = new UpdateULBAttributeInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
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
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuLBId("ulb-2t22s4");

        DescribeULBOutVo out = client.exec(in, DescribeULBOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testCreateVServer() {
        CreateVServerInVo in = new CreateVServerInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuLBId("ulb-2t22s4");

        CreateVServerOutVo out = client.exec(in, CreateVServerOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
}
