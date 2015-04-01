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
import cn.ucloud.sdk.enums.MetricNameUhostEnum;
import cn.ucloud.sdk.enums.ResourceTypeEnum;
import cn.ucloud.sdk.vo.umon.in.GetMetricInVo;
import cn.ucloud.sdk.vo.umon.out.GetMetricOutVo;
import cn.ucloud.sdk.vo.umon.out.MetricDataDetail;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UcloudUMonClientTest {

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
    public void testGetMetric() {
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

        Assert.assertEquals(0, out.getRetCode().intValue());
    }
}
