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
import cn.ucloud.sdk.vo.PageVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class DescribeEIPInVo extends PageVo {
    private String eIPIds_0;
    private String eIPIds_1;
    private String eIPIds_2;
    private String eIPIds_3;
    private String eIPIds_4;
    private String eIPIds_5;
    private String eIPIds_6;
    private String eIPIds_7;
    private String eIPIds_8;
    private String eIPIds_9;

    public DescribeEIPInVo() {
        super(ActionEnum.DescribeEIP.name());
    }

    public String geteIPIds_0() {
        return eIPIds_0;
    }

    public void seteIPIds_0(String eIPIds_0) {
        this.eIPIds_0 = eIPIds_0;
    }

    public String geteIPIds_1() {
        return eIPIds_1;
    }

    public void seteIPIds_1(String eIPIds_1) {
        this.eIPIds_1 = eIPIds_1;
    }

    public String geteIPIds_2() {
        return eIPIds_2;
    }

    public void seteIPIds_2(String eIPIds_2) {
        this.eIPIds_2 = eIPIds_2;
    }

    public String geteIPIds_3() {
        return eIPIds_3;
    }

    public void seteIPIds_3(String eIPIds_3) {
        this.eIPIds_3 = eIPIds_3;
    }

    public String geteIPIds_4() {
        return eIPIds_4;
    }

    public void seteIPIds_4(String eIPIds_4) {
        this.eIPIds_4 = eIPIds_4;
    }

    public String geteIPIds_5() {
        return eIPIds_5;
    }

    public void seteIPIds_5(String eIPIds_5) {
        this.eIPIds_5 = eIPIds_5;
    }

    public String geteIPIds_6() {
        return eIPIds_6;
    }

    public void seteIPIds_6(String eIPIds_6) {
        this.eIPIds_6 = eIPIds_6;
    }

    public String geteIPIds_7() {
        return eIPIds_7;
    }

    public void seteIPIds_7(String eIPIds_7) {
        this.eIPIds_7 = eIPIds_7;
    }

    public String geteIPIds_8() {
        return eIPIds_8;
    }

    public void seteIPIds_8(String eIPIds_8) {
        this.eIPIds_8 = eIPIds_8;
    }

    public String geteIPIds_9() {
        return eIPIds_9;
    }

    public void seteIPIds_9(String eIPIds_9) {
        this.eIPIds_9 = eIPIds_9;
    }
}
