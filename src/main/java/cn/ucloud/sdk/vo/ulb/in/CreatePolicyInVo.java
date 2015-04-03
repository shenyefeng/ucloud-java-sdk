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
package cn.ucloud.sdk.vo.ulb.in;

import cn.ucloud.sdk.enums.ActionEnum;
import cn.ucloud.sdk.vo.PageVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class CreatePolicyInVo extends PageVo {
    private String groupId;
    private String match;
    private String uLBId;
    private String vServerId;
    private String backendId_0;
    private String backendId_1;
    private String backendId_2;
    private String backendId_3;
    private String backendId_4;
    private String backendId_5;
    private String backendId_6;
    private String backendId_7;
    private String backendId_8;
    private String backendId_9;
    private String type;

    public CreatePolicyInVo() {
        super(ActionEnum.CreatePolicy.name());
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getuLBId() {
        return uLBId;
    }

    public void setuLBId(String uLBId) {
        this.uLBId = uLBId;
    }

    public String getvServerId() {
        return vServerId;
    }

    public void setvServerId(String vServerId) {
        this.vServerId = vServerId;
    }

    public String getBackendId_0() {
        return backendId_0;
    }

    public void setBackendId_0(String backendId_0) {
        this.backendId_0 = backendId_0;
    }

    public String getBackendId_1() {
        return backendId_1;
    }

    public void setBackendId_1(String backendId_1) {
        this.backendId_1 = backendId_1;
    }

    public String getBackendId_2() {
        return backendId_2;
    }

    public void setBackendId_2(String backendId_2) {
        this.backendId_2 = backendId_2;
    }

    public String getBackendId_3() {
        return backendId_3;
    }

    public void setBackendId_3(String backendId_3) {
        this.backendId_3 = backendId_3;
    }

    public String getBackendId_4() {
        return backendId_4;
    }

    public void setBackendId_4(String backendId_4) {
        this.backendId_4 = backendId_4;
    }

    public String getBackendId_5() {
        return backendId_5;
    }

    public void setBackendId_5(String backendId_5) {
        this.backendId_5 = backendId_5;
    }

    public String getBackendId_6() {
        return backendId_6;
    }

    public void setBackendId_6(String backendId_6) {
        this.backendId_6 = backendId_6;
    }

    public String getBackendId_7() {
        return backendId_7;
    }

    public void setBackendId_7(String backendId_7) {
        this.backendId_7 = backendId_7;
    }

    public String getBackendId_8() {
        return backendId_8;
    }

    public void setBackendId_8(String backendId_8) {
        this.backendId_8 = backendId_8;
    }

    public String getBackendId_9() {
        return backendId_9;
    }

    public void setBackendId_9(String backendId_9) {
        this.backendId_9 = backendId_9;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
