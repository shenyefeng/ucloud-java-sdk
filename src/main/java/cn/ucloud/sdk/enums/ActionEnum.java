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
package cn.ucloud.sdk.enums;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public enum ActionEnum {
    CreateUHostInstance, DescribeUHostInstance, TerminateUHostInstance, ResizeUHostInstance, ReinstallUHostInstance, StartUHostInstance, StopUHostInstance, RebootUHostInstance, ResetUHostInstancePassword, ModifyUHostInstanceName, ModifyUHostInstanceTag, ModifyUHostInstanceRemark, GetUHostInstancePrice, GetUHostInstanceVncInfo, DescribeImage, CreateCustomImage, TerminateCustomImage, AttachUDisk, DetachUDisk, CreateUHostInstanceSnapshot, DescribeUHostInstanceSnapshot, AllocateEIP, DescribeEIP, UpdateEIPAttribute, ReleaseEIP, BindEIP, UnBindEIP, ModifyEIPBandwidth, ModifyEIPWeight, GetEIPPrice, AllocateVIP, DescribeVIP, ReleaseVIP, DescribeSecurityGroup, DescribeSecurityGroupResource, CreateSecurityGroup, UpdateSecurityGroup, GrantSecurityGroup, DeleteSecurityGroup, CreateULB, DeleteULB, DescribeULB, UpdateULBAttribute, CreateVServer, DeleteVServer, UpdateVServerAttribute, AllocateBackend, ReleaseBackend, UpdateBackendAttribute, CreateSSL, DeleteSSL, BindSSL, DescribeSSL, CreatePolicyGroup, DeletePolicyGroup, DescribePolicyGroup, UpdatePolicyGroupAttribute, CreatePolicy, DeletePolicy, BackupUDBInstance, ClearUDBLog, CreateUDBInstance, CreateUDBParamGroup, CreateUDBReplicationInstance, CreateUDBSlave, DeleteUDBBackup, DeleteUDBInstance, DeleteUDBParamGroup, DescribeUDBBackupBlacklist, DescribeUDBBackup, DescribeUDBInstancePrice, DescribeUDBInstance, DescribeUDBInstanceState, DescribeUDBParamGroup, DescribeUDBType, EditUDBBackupBlacklist, ModifyUDBInstanceName, PromoteUDBSlave, RestartUDBInstance, StartUDBInstance, StopUDBInstance, UpdateUDBParamGroup, UploadUDBParamGroup, CreateUDiskSnapshot, CreateUDisk, CloneUDisk, CloneUDiskSnapshot, DeleteUDiskSnapshot, DeleteUDisk, DescribeUDiskSnapshot, DescribeUDisk, DescribeUDiskPrice, DescribeUDiskUpgradePrice, RenameUDisk, ResizeUDisk, CreateBucket, DescribeBucket, UpdateBucket, DeleteBucket, GetFileList, PutFile, PostFile, UploadHit, GetFile, DeleteFile, InitiateMultipartUpload, UploadPart, FinishMultipartUpload, AbortMultipartUpload, BuyUcdnTraffic, GetUcdnTraffic, CreateUcdnDomain, UpdateUcdnDomain, DescribeUcdnDomain, GetUcdnDomainBandwidth, GetUcdnDomainTraffic, GetUcdnDomainLog, RefreshUcdnDomainCache, DescribeRefreshCacheTask, PrefetchDomainCache, DescribePrefetchCacheTask, UpdateUcdnDomainStatus, GetUcdnDomainPrefetchEnable, GetMetric
}
