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

import cn.ucloud.sdk.vo.UcloudOutVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class GetUHostInstanceVncInfoOutVo extends UcloudOutVo {
    private String uHostId;
    private String vncIP;
    private String vncPort;
    private String vncPassword;

    public String getuHostId() {
        return uHostId;
    }

    public void setuHostId(String uHostId) {
        this.uHostId = uHostId;
    }

    public String getVncIP() {
        return vncIP;
    }

    public void setVncIP(String vncIP) {
        this.vncIP = vncIP;
    }

    public String getVncPort() {
        return vncPort;
    }

    public void setVncPort(String vncPort) {
        this.vncPort = vncPort;
    }

    public String getVncPassword() {
        return vncPassword;
    }

    public void setVncPassword(String vncPassword) {
        this.vncPassword = vncPassword;
    }
}
