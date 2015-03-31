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
package cn.ucloud.sdk.vo.uhost.in;

import cn.ucloud.sdk.enums.ActionEnum;
import cn.ucloud.sdk.utils.EncoderUtils;
import cn.ucloud.sdk.vo.PageVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class CreateUHostInstanceInVo extends PageVo {

    private String imageId;
    private String loginMode;
    private String password;
    private String keyPair;
    private Integer cPU;
    private Integer memory;
    private Integer diskSpace;
    private String name;
    private String networkId;
    private String securityGroupId;
    private String chargeType;
    private Integer quantity;

    public CreateUHostInstanceInVo() {
        super(ActionEnum.CreateUHostInstance.name());
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(String loginMode) {
        this.loginMode = loginMode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = EncoderUtils.base64(password);
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        this.keyPair = keyPair;
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

    public Integer getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(Integer diskSpace) {
        this.diskSpace = diskSpace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
