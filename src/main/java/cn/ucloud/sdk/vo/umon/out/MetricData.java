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
package cn.ucloud.sdk.vo.umon.out;

import java.util.Set;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class MetricData {
    private Set<MetricDataDetail> cPUUtilization;
    private Set<MetricDataDetail> networkIn;
    private Set<MetricDataDetail> networkOut;
    private Set<MetricDataDetail> iORead;
    private Set<MetricDataDetail> iOWrite;
    private Set<MetricDataDetail> diskReadOps;
    private Set<MetricDataDetail> nICIn;
    private Set<MetricDataDetail> nICOut;
    private Set<MetricDataDetail> memUsage;
    private Set<MetricDataDetail> dataSpaceUsage;
    private Set<MetricDataDetail> rootSpaceUsage;
    private Set<MetricDataDetail> readonlyDiskCount;
    private Set<MetricDataDetail> runnableProcessCount;
    private Set<MetricDataDetail> blockProcessCount;
    private Set<MetricDataDetail> qPS;
    private Set<MetricDataDetail> expensiveQuery;
    private Set<MetricDataDetail> totalNetworkOut;
    private Set<MetricDataDetail> currentConnections;
    private Set<MetricDataDetail> usage;
    private Set<MetricDataDetail> instanceCount;

    public Set<MetricDataDetail> getcPUUtilization() {
        return cPUUtilization;
    }

    public void setcPUUtilization(Set<MetricDataDetail> cPUUtilization) {
        this.cPUUtilization = cPUUtilization;
    }

    public Set<MetricDataDetail> getNetworkIn() {
        return networkIn;
    }

    public void setNetworkIn(Set<MetricDataDetail> networkIn) {
        this.networkIn = networkIn;
    }

    public Set<MetricDataDetail> getNetworkOut() {
        return networkOut;
    }

    public void setNetworkOut(Set<MetricDataDetail> networkOut) {
        this.networkOut = networkOut;
    }

    public Set<MetricDataDetail> getiORead() {
        return iORead;
    }

    public void setiORead(Set<MetricDataDetail> iORead) {
        this.iORead = iORead;
    }

    public Set<MetricDataDetail> getiOWrite() {
        return iOWrite;
    }

    public void setiOWrite(Set<MetricDataDetail> iOWrite) {
        this.iOWrite = iOWrite;
    }

    public Set<MetricDataDetail> getDiskReadOps() {
        return diskReadOps;
    }

    public void setDiskReadOps(Set<MetricDataDetail> diskReadOps) {
        this.diskReadOps = diskReadOps;
    }

    public Set<MetricDataDetail> getnICIn() {
        return nICIn;
    }

    public void setnICIn(Set<MetricDataDetail> nICIn) {
        this.nICIn = nICIn;
    }

    public Set<MetricDataDetail> getnICOut() {
        return nICOut;
    }

    public void setnICOut(Set<MetricDataDetail> nICOut) {
        this.nICOut = nICOut;
    }

    public Set<MetricDataDetail> getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(Set<MetricDataDetail> memUsage) {
        this.memUsage = memUsage;
    }

    public Set<MetricDataDetail> getDataSpaceUsage() {
        return dataSpaceUsage;
    }

    public void setDataSpaceUsage(Set<MetricDataDetail> dataSpaceUsage) {
        this.dataSpaceUsage = dataSpaceUsage;
    }

    public Set<MetricDataDetail> getRootSpaceUsage() {
        return rootSpaceUsage;
    }

    public void setRootSpaceUsage(Set<MetricDataDetail> rootSpaceUsage) {
        this.rootSpaceUsage = rootSpaceUsage;
    }

    public Set<MetricDataDetail> getReadonlyDiskCount() {
        return readonlyDiskCount;
    }

    public void setReadonlyDiskCount(Set<MetricDataDetail> readonlyDiskCount) {
        this.readonlyDiskCount = readonlyDiskCount;
    }

    public Set<MetricDataDetail> getRunnableProcessCount() {
        return runnableProcessCount;
    }

    public void setRunnableProcessCount(Set<MetricDataDetail> runnableProcessCount) {
        this.runnableProcessCount = runnableProcessCount;
    }

    public Set<MetricDataDetail> getBlockProcessCount() {
        return blockProcessCount;
    }

    public void setBlockProcessCount(Set<MetricDataDetail> blockProcessCount) {
        this.blockProcessCount = blockProcessCount;
    }

    public Set<MetricDataDetail> getqPS() {
        return qPS;
    }

    public void setqPS(Set<MetricDataDetail> qPS) {
        this.qPS = qPS;
    }

    public Set<MetricDataDetail> getExpensiveQuery() {
        return expensiveQuery;
    }

    public void setExpensiveQuery(Set<MetricDataDetail> expensiveQuery) {
        this.expensiveQuery = expensiveQuery;
    }

    public Set<MetricDataDetail> getTotalNetworkOut() {
        return totalNetworkOut;
    }

    public void setTotalNetworkOut(Set<MetricDataDetail> totalNetworkOut) {
        this.totalNetworkOut = totalNetworkOut;
    }

    public Set<MetricDataDetail> getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Set<MetricDataDetail> currentConnections) {
        this.currentConnections = currentConnections;
    }

    public Set<MetricDataDetail> getUsage() {
        return usage;
    }

    public void setUsage(Set<MetricDataDetail> usage) {
        this.usage = usage;
    }

    public Set<MetricDataDetail> getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(Set<MetricDataDetail> instanceCount) {
        this.instanceCount = instanceCount;
    }

}
