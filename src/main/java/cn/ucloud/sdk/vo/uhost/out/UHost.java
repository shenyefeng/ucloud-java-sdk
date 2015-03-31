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
package cn.ucloud.sdk.vo.uhost.out;

import java.util.Set;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UHost {
    private String uHostId;
    private String uHostType;
    private String osType;
    private String imageId;
    private String osName;
    private String basicImageId;
    private String basicImageName;
    private String tag;
    private String remark;
    private String name;
    private String state;
    private String networkState;
    private Integer createTime;
    private String chargeType;
    private Integer expireTime;
    private Integer cPU;
    private Integer memory;
    private Set<Disk> diskSet;
    private Set<Ip> iPSet;

    public String getuHostId() {
        return uHostId;
    }

    public void setuHostId(String uHostId) {
        this.uHostId = uHostId;
    }

    public String getuHostType() {
        return uHostType;
    }

    public void setuHostType(String uHostType) {
        this.uHostType = uHostType;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getBasicImageId() {
        return basicImageId;
    }

    public void setBasicImageId(String basicImageId) {
        this.basicImageId = basicImageId;
    }

    public String getBasicImageName() {
        return basicImageName;
    }

    public void setBasicImageName(String basicImageName) {
        this.basicImageName = basicImageName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getcPU() {
        return cPU;
    }

    public void setcPU(Integer cPU) {
        this.cPU = cPU;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Set<Disk> getDiskSet() {
        return diskSet;
    }

    public void setDiskSet(Set<Disk> diskSet) {
        this.diskSet = diskSet;
    }

    public Set<Ip> getiPSet() {
        return iPSet;
    }

    public void setiPSet(Set<Ip> iPSet) {
        this.iPSet = iPSet;
    }

    public String getNetworkState() {
        return networkState;
    }

    public void setNetworkState(String networkState) {
        this.networkState = networkState;
    }
}
