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
package cn.ucloud.sdk.vo.umon.in;

import cn.ucloud.sdk.enums.ActionEnum;
import cn.ucloud.sdk.vo.PageVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class GetMetricInVo extends PageVo {
    private String metricName_0;
    private String metricName_1;
    private String metricName_2;
    private String metricName_3;
    private String metricName_4;
    private String metricName_5;
    private String metricName_6;
    private String metricName_7;
    private String metricName_8;
    private String metricName_9;
    private String metricName_10;
    private String metricName_11;
    private String metricName_12;
    private String metricName_13;
    private String metricName_14;
    private String metricName_15;
    private String metricName_16;
    private String resourceId;
    private String resourceType;
    private Integer timeRange;
    private Integer beginTime;
    private Integer endTime;
    
    public GetMetricInVo() {
        super(ActionEnum.GetMetric.name());
    }
    public String getMetricName_0() {
        return metricName_0;
    }

    public void setMetricName_0(String metricName_0) {
        this.metricName_0 = metricName_0;
    }

    public String getMetricName_1() {
        return metricName_1;
    }
    public void setMetricName_1(String metricName_1) {
        this.metricName_1 = metricName_1;
    }
    public String getMetricName_2() {
        return metricName_2;
    }

    public void setMetricName_2(String metricName_2) {
        this.metricName_2 = metricName_2;
    }

    public String getMetricName_3() {
        return metricName_3;
    }

    public void setMetricName_3(String metricName_3) {
        this.metricName_3 = metricName_3;
    }

    public String getMetricName_4() {
        return metricName_4;
    }

    public void setMetricName_4(String metricName_4) {
        this.metricName_4 = metricName_4;
    }

    public String getMetricName_5() {
        return metricName_5;
    }

    public void setMetricName_5(String metricName_5) {
        this.metricName_5 = metricName_5;
    }

    public String getMetricName_6() {
        return metricName_6;
    }

    public void setMetricName_6(String metricName_6) {
        this.metricName_6 = metricName_6;
    }

    public String getMetricName_7() {
        return metricName_7;
    }

    public void setMetricName_7(String metricName_7) {
        this.metricName_7 = metricName_7;
    }

    public String getMetricName_8() {
        return metricName_8;
    }

    public void setMetricName_8(String metricName_8) {
        this.metricName_8 = metricName_8;
    }

    public String getMetricName_9() {
        return metricName_9;
    }

    public void setMetricName_9(String metricName_9) {
        this.metricName_9 = metricName_9;
    }

    public String getMetricName_10() {
        return metricName_10;
    }

    public void setMetricName_10(String metricName_10) {
        this.metricName_10 = metricName_10;
    }

    public String getMetricName_11() {
        return metricName_11;
    }

    public void setMetricName_11(String metricName_11) {
        this.metricName_11 = metricName_11;
    }

    public String getMetricName_12() {
        return metricName_12;
    }

    public void setMetricName_12(String metricName_12) {
        this.metricName_12 = metricName_12;
    }

    public String getMetricName_13() {
        return metricName_13;
    }

    public void setMetricName_13(String metricName_13) {
        this.metricName_13 = metricName_13;
    }

    public String getMetricName_14() {
        return metricName_14;
    }

    public void setMetricName_14(String metricName_14) {
        this.metricName_14 = metricName_14;
    }

    public String getMetricName_15() {
        return metricName_15;
    }

    public void setMetricName_15(String metricName_15) {
        this.metricName_15 = metricName_15;
    }

    public String getMetricName_16() {
        return metricName_16;
    }

    public void setMetricName_16(String metricName_16) {
        this.metricName_16 = metricName_16;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(Integer timeRange) {
        this.timeRange = timeRange;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
