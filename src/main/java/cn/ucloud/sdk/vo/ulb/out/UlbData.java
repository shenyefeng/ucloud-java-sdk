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
package cn.ucloud.sdk.vo.ulb.out;

import java.util.Set;

import cn.ucloud.sdk.vo.unet.out.Resource;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UlbData {
    private String uLBId;
    private String uLBName;
    private String name;
    private String tag;
    private String remark;
    private Integer bandwidthType;
    private Integer bandwidth;
    private Integer createTime;
    private Integer expireTime;
    private Set<Resource> resource;
    private Set<Ip> iPSet;
    private Set<VServer> vServerSet;

    public String getuLBId() {
        return uLBId;
    }

    public void setuLBId(String uLBId) {
        this.uLBId = uLBId;
    }

    public String getuLBName() {
        return uLBName;
    }

    public void setuLBName(String uLBName) {
        this.uLBName = uLBName;
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

    public Integer getBandwidthType() {
        return bandwidthType;
    }

    public void setBandwidthType(Integer bandwidthType) {
        this.bandwidthType = bandwidthType;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Set<Resource> getResource() {
        return resource;
    }

    public void setResource(Set<Resource> resource) {
        this.resource = resource;
    }

    public Set<Ip> getiPSet() {
        return iPSet;
    }

    public void setiPSet(Set<Ip> iPSet) {
        this.iPSet = iPSet;
    }

    public Set<VServer> getvServerSet() {
        return vServerSet;
    }

    public void setvServerSet(Set<VServer> vServerSet) {
        this.vServerSet = vServerSet;
    }
}
