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
public class ReinstallUHostInstanceInVo extends PageVo {

    private String uHostId;
    private String password;
    private String imageId;
    private String reserveDisk;

    public ReinstallUHostInstanceInVo() {
        super(ActionEnum.ReinstallUHostInstance.name());
    }

    public String getuHostId() {
        return uHostId;
    }

    public void setuHostId(String uHostId) {
        this.uHostId = uHostId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = EncoderUtils.base64(password);
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getReserveDisk() {
        return reserveDisk;
    }

    public void setReserveDisk(String reserveDisk) {
        this.reserveDisk = reserveDisk;
    }
}
