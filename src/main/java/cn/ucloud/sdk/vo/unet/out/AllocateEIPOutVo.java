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
package cn.ucloud.sdk.vo.unet.out;

import java.util.Set;

import cn.ucloud.sdk.vo.UcloudOutVo;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class AllocateEIPOutVo extends UcloudOutVo {
    private Set<EIP> eIPSet;

    public Set<EIP> geteIPSet() {
        return eIPSet;
    }

    public void seteIPSet(Set<EIP> eIPSet) {
        this.eIPSet = eIPSet;
    }
}
