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

package cn.ucloud.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import cn.ucloud.sdk.enums.MsgEnum;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class SignatureUtils {
    private static final Logger logger = Logger.getLogger(SignatureUtils.class);

    /**
     * Signature
     * @param privateKey
     * @param treeMap
     * @return
     */
    public static String signature(String privateKey, TreeMap<String, Object> treeMap) {
        if(privateKey == null || privateKey.length() == 0 || treeMap == null || treeMap.size() == 0) {
            logger.error(MsgEnum.U_00001.getMessage());
            throw new RuntimeException(MsgEnum.U_00001.getMessage());
        }
        
        String param = "";
        String paramEncoded = "?";
        for(String key : treeMap.keySet()) {
            try {
                param += key + "" + treeMap.get(key) + "";
                paramEncoded += key + "=" + URLEncoder.encode(treeMap.get(key) + "", "utf-8") + "&";
            } catch (UnsupportedEncodingException e) {
                LogUtils.exception(logger, e);
            }
        }
        paramEncoded = paramEncoded.substring(0, paramEncoded.length() - 1);
        logger.debug("Generated parameters are: " + param);
        
        String signture = EncoderUtils.sha1(param + privateKey);
        logger.debug("Generated signatrue is: " + signture);
        
        paramEncoded += "&Signature=" + signture;
        logger.debug("Generated parameters(included signture) are: " + paramEncoded);
        
        return paramEncoded;
    }
}
