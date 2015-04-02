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

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class VServer {
    private String vServerId;
    private String vServerName;
    private String protocol;
    private Integer frontendPort;
    private String method;
    private String persistenceType;
    private String persistenceInfo;
    private Integer clientTimeout;
    private Integer status;
    private Set<SSL> sSLSet;
    private Set<Backend> backendSet;

    public String getvServerId() {
        return vServerId;
    }

    public void setvServerId(String vServerId) {
        this.vServerId = vServerId;
    }

    public String getvServerName() {
        return vServerName;
    }

    public void setvServerName(String vServerName) {
        this.vServerName = vServerName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getFrontendPort() {
        return frontendPort;
    }

    public void setFrontendPort(Integer frontendPort) {
        this.frontendPort = frontendPort;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPersistenceType() {
        return persistenceType;
    }

    public void setPersistenceType(String persistenceType) {
        this.persistenceType = persistenceType;
    }

    public String getPersistenceInfo() {
        return persistenceInfo;
    }

    public void setPersistenceInfo(String persistenceInfo) {
        this.persistenceInfo = persistenceInfo;
    }

    public Integer getClientTimeout() {
        return clientTimeout;
    }

    public void setClientTimeout(Integer clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<SSL> getsSLSet() {
        return sSLSet;
    }

    public void setsSLSet(Set<SSL> sSLSet) {
        this.sSLSet = sSLSet;
    }

    public Set<Backend> getBackendSet() {
        return backendSet;
    }

    public void setBackendSet(Set<Backend> backendSet) {
        this.backendSet = backendSet;
    }
};
