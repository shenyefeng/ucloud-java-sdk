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
import cn.ucloud.sdk.utils.SignatureUtils;
import cn.ucloud.sdk.vo.udisk.in.AttachUdiskInVo;
import cn.ucloud.sdk.vo.udisk.in.CloneUDiskInVo;
import cn.ucloud.sdk.vo.udisk.in.CloneUDiskSnapshotInVo;
import cn.ucloud.sdk.vo.udisk.in.CreateUDiskInVo;
import cn.ucloud.sdk.vo.udisk.in.CreateUDiskSnapshotInVo;
import cn.ucloud.sdk.vo.udisk.in.DeleteUDiskInVo;
import cn.ucloud.sdk.vo.udisk.in.DeleteUDiskSnapshotInVo;
import cn.ucloud.sdk.vo.udisk.in.DescribeUDiskInVo;
import cn.ucloud.sdk.vo.udisk.in.DescribeUDiskPriceInVo;
import cn.ucloud.sdk.vo.udisk.in.DescribeUDiskSnapshotInVo;
import cn.ucloud.sdk.vo.udisk.in.DescribeUDiskUpgradePriceInVo;
import cn.ucloud.sdk.vo.udisk.in.RenameUDiskInVo;
import cn.ucloud.sdk.vo.udisk.in.ResizeUDiskInVo;
import cn.ucloud.sdk.vo.udisk.out.AttachUdiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.CloneUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.CloneUDiskSnapshotOutVo;
import cn.ucloud.sdk.vo.udisk.out.CreateUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.CreateUDiskSnapshotOutVo;
import cn.ucloud.sdk.vo.udisk.out.DeleteUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.DeleteUDiskSnapshotOutVo;
import cn.ucloud.sdk.vo.udisk.out.DescribeUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.DescribeUDiskPriceOutVo;
import cn.ucloud.sdk.vo.udisk.out.DescribeUDiskSnapshotOutVo;
import cn.ucloud.sdk.vo.udisk.out.DescribeUDiskUpgradePriceOutVo;
import cn.ucloud.sdk.vo.udisk.out.RenameUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.ResizeUDiskOutVo;
import cn.ucloud.sdk.vo.udisk.out.SnapshotData;
import cn.ucloud.sdk.vo.udisk.out.UdiskData;
import cn.ucloud.sdk.vo.udisk.out.UdiskPriceData;
import cn.ucloud.sdk.vo.uhost.in.DetachUdiskInVo;
import cn.ucloud.sdk.vo.uhost.out.DetachUdiskOutVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UcloudUDiskClientTest {

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
        for (String key : map.keySet()) {
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
    public void testCreateUDisk() {
        CreateUDiskInVo in = new CreateUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setSize(1);
        in.setName("udisk-name1");
        in.setChargeType(ChargeTypeEnum.Month.name());
        CreateUDiskOutVo out = client.exec(in, CreateUDiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testCloneUDisk() {
        CloneUDiskInVo in = new CloneUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setName("udisk-name1");
        in.setSourceId("bs-ds00o2");
        in.setSize(1);
        in.setChargeType(ChargeTypeEnum.Month.name());
        CloneUDiskOutVo out = client.exec(in, CloneUDiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testAttachUdisk() {
        AttachUdiskInVo in = new AttachUdiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        in.setuDiskId("bs-2khsfm");
        AttachUdiskOutVo out = client.exec(in, AttachUdiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDetachUdisk() {
        DetachUdiskInVo in = new DetachUdiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuHostId("uhost-f1y3dd");
        in.setuDiskId("bs-2khsfm");
        DetachUdiskOutVo out = client.exec(in, DetachUdiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeUDisk() {
        DescribeUDiskInVo in = new DescribeUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuDiskId("bs-2khsfm");
        DescribeUDiskOutVo out = client.exec(in, DescribeUDiskOutVo.class);
        System.out.println(out.getTotalCount());
        for(UdiskData data : out.getDataSet()) {
            System.out.println(data.getuDiskId());
            System.out.println(data.getName());
            System.out.println(data.getSize());
            System.out.println(data.getStatus());
            System.out.println(data.getCreateTime());
            System.out.println(data.getExpiredTime());
            System.out.println(data.getuHostId());
            System.out.println(data.getuHostName());
            System.out.println(data.getuHostIP());
            System.out.println(data.getDeviceName());
            System.out.println(data.getChargeType());
        }
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeUDiskUpgradePrice() {
        DescribeUDiskUpgradePriceInVo in = new DescribeUDiskUpgradePriceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setSourceId("bs-2khsfm");
        in.setSize(10);
        DescribeUDiskUpgradePriceOutVo out = client.exec(in, DescribeUDiskUpgradePriceOutVo.class);
        System.out.println(out.getPrice());
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testRenameUDisk() {
        RenameUDiskInVo in = new RenameUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuDiskId("bs-2khsfm");
        in.setuDiskName("udisk-new-name");
        RenameUDiskOutVo out = client.exec(in, RenameUDiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testResizeUDisk() {
        ResizeUDiskInVo in = new ResizeUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuDiskId("bs-2khsfm");
        in.setSize(2);
        ResizeUDiskOutVo out = client.exec(in, ResizeUDiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDescribeUDiskPrice() {
        DescribeUDiskPriceInVo in = new DescribeUDiskPriceInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setSize(10);
        in.setChargeType(ChargeTypeEnum.Month.name());
        DescribeUDiskPriceOutVo out = client.exec(in, DescribeUDiskPriceOutVo.class);
        for(UdiskPriceData data : out.getDataSet()) {
            System.out.println(data.getChargeType());
            System.out.println(data.getPrice());
        }
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeleteUDisk() {
        DeleteUDiskInVo in = new DeleteUDiskInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuDiskId("bs-rb1nl1");
        DeleteUDiskOutVo out = client.exec(in, DeleteUDiskOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testCreateUDiskSnapshot() {
        CreateUDiskSnapshotInVo in = new CreateUDiskSnapshotInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setuDiskId("bs-2khsfm");
        in.setChargeType(ChargeTypeEnum.Month.name());
        in.setName("udisk-snapshot-name");
        in.setComment("udisk-snapshot-comment");
        CreateUDiskSnapshotOutVo out = client.exec(in, CreateUDiskSnapshotOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testCloneUDiskSnapshot() {
        CloneUDiskSnapshotInVo in = new CloneUDiskSnapshotInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setName("udisk-snapshot-name");
        in.setSourceId("snap-5qokce");
        in.setSize(1);
        in.setChargeType(ChargeTypeEnum.Month.name());
        in.setComment("udisk-snapshot-comment");
        CloneUDiskSnapshotOutVo out = client.exec(in, CloneUDiskSnapshotOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }
    
    @Test
    public void testDescribeUDiskSnapshot() {
        DescribeUDiskSnapshotInVo in = new DescribeUDiskSnapshotInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setSnapshotId("snap-keynvt");
        DescribeUDiskSnapshotOutVo out = client.exec(in, DescribeUDiskSnapshotOutVo.class);
        System.out.println(out.getTotalCount());
        for(SnapshotData data : out.getDataSet()) {
            System.out.println(data.getChargeType());
            System.out.println(data.getComment());
            System.out.println(data.getName());
            System.out.println(data.getSnapshotId());
            System.out.println(data.getuDiskId());
            System.out.println(data.getuDiskName());
            System.out.println(data.getCreateTime());
            System.out.println(data.getExpiredTime());
            System.out.println(data.getSize());
        }
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

    @Test
    public void testDeleteUDiskSnapshot() {
        DeleteUDiskSnapshotInVo in = new DeleteUDiskSnapshotInVo();
        in.setRegion(DataCenterEnum.北京BGP_C.getValue());
        in.setSnapshotId("snap-p52tfc");
        DeleteUDiskSnapshotOutVo out = client.exec(in, DeleteUDiskSnapshotOutVo.class);
        Assert.assertEquals(0, out.getRetCode().intValue());
    }

}
