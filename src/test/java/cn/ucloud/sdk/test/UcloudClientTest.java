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
import cn.ucloud.sdk.enums.ChargeTypeEnum;
import cn.ucloud.sdk.enums.DataCenterEnum;
import cn.ucloud.sdk.enums.LoginModeEnum;
import cn.ucloud.sdk.utils.SignatureUtils;
import cn.ucloud.sdk.vo.uhost.in.CreateUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.DescribeImageInVo;
import cn.ucloud.sdk.vo.uhost.in.DescribeUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.RebootUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.ReinstallUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.ResetUHostInstancePasswordInVo;
import cn.ucloud.sdk.vo.uhost.in.ResizeUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.StartUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.StopUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.in.TerminateUHostInstanceInVo;
import cn.ucloud.sdk.vo.uhost.out.CreateUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.DescribeImageoutVo;
import cn.ucloud.sdk.vo.uhost.out.DescribeUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.RebootUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.ReinstallUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.ResetUHostInstancePasswordOutVo;
import cn.ucloud.sdk.vo.uhost.out.ResizeUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.StartUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.StopUHostInstanceOutVo;
import cn.ucloud.sdk.vo.uhost.out.TerminateUHostInstanceOutVo;

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
        DescribeImageInVo in = new DescribeImageInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        DescribeImageoutVo out = client.exec(in, DescribeImageoutVo.class);
        System.out.println(out.getTotalCount());
        Assert.assertNotNull(out.getImageSet());
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testCreateUHostInstance() {
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
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeUHostInstance() {
        DescribeUHostInstanceInVo in = new DescribeUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
//        in.setuHostIds_0("uhost-f1y3dd");
        DescribeUHostInstanceOutVo out = client.exec(in, DescribeUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testStopUHostInstance() {
        StopUHostInstanceInVo in = new StopUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        StopUHostInstanceOutVo out = client.exec(in, StopUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testResetUHostInstancePassword() {
        ResetUHostInstancePasswordInVo in = new ResetUHostInstancePasswordInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        in.setPassword("ucloud123456");
        ResetUHostInstancePasswordOutVo out = client.exec(in, ResetUHostInstancePasswordOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testResizeUHostInstance() {
        ResizeUHostInstanceInVo in = new ResizeUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        in.setDiskSpace(80);
        ResizeUHostInstanceOutVo out = client.exec(in, ResizeUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testReinstallUHostInstance() {
        ReinstallUHostInstanceInVo in = new ReinstallUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        in.setPassword("ucloud2345");
        ReinstallUHostInstanceOutVo out = client.exec(in, ReinstallUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testStartUHostInstance() {
        StartUHostInstanceInVo in = new StartUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        StartUHostInstanceOutVo out = client.exec(in, StartUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testRebootUHostInstance() {
        RebootUHostInstanceInVo in = new RebootUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        RebootUHostInstanceOutVo out = client.exec(in, RebootUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testTerminateUHostInstance() {
        TerminateUHostInstanceInVo in = new TerminateUHostInstanceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
//        in.setuHostId("uhost-f1y3dd");
        TerminateUHostInstanceOutVo out = client.exec(in, TerminateUHostInstanceOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
}
