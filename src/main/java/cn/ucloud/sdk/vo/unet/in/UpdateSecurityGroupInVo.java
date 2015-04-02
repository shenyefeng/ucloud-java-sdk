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
package cn.ucloud.sdk.vo.unet.in;

import cn.ucloud.sdk.enums.ActionEnum;
import cn.ucloud.sdk.vo.UcloudInVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class UpdateSecurityGroupInVo extends UcloudInVo {

    private Integer groupId;
    private String rule_0;
    private String rule_1;
    private String rule_2;
    private String rule_3;
    private String rule_4;
    private String rule_5;
    private String rule_6;
    private String rule_7;
    private String rule_8;
    private String rule_9;

    public UpdateSecurityGroupInVo() {
        super(ActionEnum.UpdateSecurityGroup.name());
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getRule_0() {
        return rule_0;
    }

    public void setRule_0(RuleIn rule_0) {
        this.rule_0 = rule_0.toString();
    }

    public String getRule_1() {
        return rule_1;
    }

    public void setRule_1(RuleIn rule_1) {
        this.rule_1 = rule_1.toString();
    }

    public String getRule_2() {
        return rule_2;
    }

    public void setRule_2(RuleIn rule_2) {
        this.rule_2 = rule_2.toString();
    }

    public String getRule_3() {
        return rule_3;
    }

    public void setRule_3(RuleIn rule_3) {
        this.rule_3 = rule_3.toString();
    }

    public String getRule_4() {
        return rule_4;
    }

    public void setRule_4(RuleIn rule_4) {
        this.rule_4 = rule_4.toString();
    }

    public String getRule_5() {
        return rule_5;
    }

    public void setRule_5(RuleIn rule_5) {
        this.rule_5 = rule_5.toString();
    }

    public String getRule_6() {
        return rule_6;
    }

    public void setRule_6(RuleIn rule_6) {
        this.rule_6 = rule_6.toString();
    }

    public String getRule_7() {
        return rule_7;
    }

    public void setRule_7(RuleIn rule_7) {
        this.rule_7 = rule_7.toString();
    }

    public String getRule_8() {
        return rule_8;
    }

    public void setRule_8(RuleIn rule_8) {
        this.rule_8 = rule_8.toString();
    }

    public String getRule_9() {
        return rule_9;
    }

    public void setRule_9(RuleIn rule_9) {
        this.rule_9 = rule_9.toString();
    }
}
