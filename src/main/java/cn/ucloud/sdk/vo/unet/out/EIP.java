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
package cn.ucloud.sdk.vo.unet.out;

import java.util.Set;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class EIP {
    private String eIPId;
    private Integer Weight;
    private Integer BandwidthType;
    private Integer Bandwidth;
    private String Status;
    private String ChargeType;
    private Integer CreateTime;
    private Integer ExpireTime;
    private Resource resource;
    private Set<EIPAddr> eIPAddr;
    private String name;
    private String tag;
    private String remark;

    public String geteIPId() {
        return eIPId;
    }

    public void seteIPId(String eIPId) {
        this.eIPId = eIPId;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Integer getBandwidthType() {
        return BandwidthType;
    }

    public void setBandwidthType(Integer bandwidthType) {
        BandwidthType = bandwidthType;
    }

    public Integer getBandwidth() {
        return Bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        Bandwidth = bandwidth;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getChargeType() {
        return ChargeType;
    }

    public void setChargeType(String chargeType) {
        ChargeType = chargeType;
    }

    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public Integer getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(Integer expireTime) {
        ExpireTime = expireTime;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Set<EIPAddr> geteIPAddr() {
        return eIPAddr;
    }

    public void seteIPAddr(Set<EIPAddr> eIPAddr) {
        this.eIPAddr = eIPAddr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
