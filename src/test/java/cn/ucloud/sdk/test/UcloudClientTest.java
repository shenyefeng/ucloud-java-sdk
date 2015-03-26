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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.ucloud.sdk.UcloudClient;
import cn.ucloud.sdk.enums.DataCenterEnum;
import cn.ucloud.sdk.utils.SignatureUtils;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UcloudClientTest {

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

    @Test
    public void testSignature() {
        
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        map.put("Action", "CreateUHostInstance");
        map.put("Region", "cn-north-01");
        map.put("ImageId", "f43736e1-65a5-4bea-ad2e-8a46e18883c2");
        map.put("CPU", 2);
        map.put("Memory", 2048);
        map.put("Password", "UCloudexample01");
        map.put("DiskSpace", 10);
        map.put("LoginMode", "Password");
        map.put("Name", "Host01");
        map.put("ChargeType", "Month");
        map.put("Quantity", 1);
        map.put("PublicKey", "ucloudsomeone@example.com1296235120854146120");
        String res = SignatureUtils.signature("46f09bb9fab4f12dfc160dae12273d5332b5debe", map);
        
        String paramEncoded = "?";
        for(String key : map.keySet()) {
            try {
                paramEncoded += key + "=" + URLEncoder.encode(map.get(key) + "", "utf-8") + "&";
            } catch (UnsupportedEncodingException e) {
            }
        }
        
        paramEncoded = paramEncoded.substring(0, paramEncoded.length() - 1);
        paramEncoded += "&Signature=7a517649e4e9da3b6c82c932d667daa1599ae3a1";
        
        Assert.assertEquals(paramEncoded, res);
    }

    UcloudClient client = UcloudClient.newClient("ucloud37393993@qq.com1427084764000315652657", "cda1127f34c284e992c02c79c3f9ed5edbc5b354");

    @Test
    public void testDescribeImage() {
        client.describeImage(DataCenterEnum.北京BGP_C.getValue());
    }
}
