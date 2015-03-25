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

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

/**
 * 
 * @author Jack shen<37393993@qq.com>
 * 
 */
public class JsonUtils {
    private ObjectMapper mapper;

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SuppressWarnings("deprecation")
    public JsonUtils(Inclusion inclusion) {
        mapper = new ObjectMapper();
        mapper.getSerializationConfig().setSerializationInclusion(inclusion);
        mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static JsonUtils buildNormalBinder() {
        return new JsonUtils(Inclusion.ALWAYS);
    }

    public static JsonUtils buildNonNullBinder() {
        return new JsonUtils(Inclusion.NON_NULL);
    }

    public static JsonUtils buildNonDefaultBinder() {
        return new JsonUtils(Inclusion.NON_DEFAULT);
    }

    public static JsonUtils buildNonEmptyBinder() {
        return new JsonUtils(Inclusion.NON_EMPTY);
    }

    public <T> T getJsonToObject(String json, Class<T> clazz) {
        T object = null;
        if (json != null && json.length() > 0) {
            try {
                object = getMapper().readValue(json, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public Object getJsonToList(String json, TypeReference typeReference) {
        Object object = null;
        if (json != null && json.length() > 0) {
            try {
                object = getMapper().readValue(json, TypeFactory.fromTypeReference(typeReference));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public Object getJsonToList(String json, Class clazz) {
        Object object = null;
        if (json != null && json.length() > 0) {
            try {
                object = getMapper().readValue(json, TypeFactory.instance.constructParametricType(List.class, clazz));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public Object getJsonToMap(String json, Class keyclazz, Class valueclazz) {
        Object object = null;
        if (json != null && json.length() > 0) {
            try {
                object = getMapper().readValue(json, TypeFactory.instance.constructParametricType(Map.class, keyclazz, valueclazz));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    public static Map<String, String> getJsonToMap(String str) {
        Map<String, String> map = new HashMap<String, String>();
        if (str != null && str.length() > 0) {
            String[] s = str.split(",");
            if (s.length > 0) {
                for (int i = 0; i < s.length; i++) {
                    String con = s[i];
                    int s1 = con.indexOf(":");
                    if (s1 > 0) {
                        map.put(con.substring(0, s1).trim().replace("\"", ""), con.substring(s1 + 1).replace("\"", ""));
                    } else {
                        map.put(con.trim().replace("\"", ""), "");
                    }
                }
            }
        }
        return map;
    }

    public String getMapToJson(Map<String, String> map) {
        List<String[]> list = new ArrayList<String[]>();
        if (null != map && !map.isEmpty()) {
            for (String key : map.keySet()) {
                String[] strS = new String[2];
                strS[0] = key;
                strS[1] = map.get(key);
                list.add(strS);
            }
        }
        return jsonObject(list);
    }

    public String jsonObject(@SuppressWarnings("rawtypes") List list) {
        StringWriter sw = new StringWriter();
        JsonGenerator gen;
        try {
            gen = new JsonFactory().createJsonGenerator(sw);
            getMapper().writeValue(gen, list);
            gen.close();
        } catch (Exception e) {

        }
        return sw.toString();
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public Object getJsonToObject(String json, Class objclazz, Class... pclazz) {
        Object object = null;
        if (json != null && json.length() > 0) {
            try {
                object = getMapper().readValue(json, TypeFactory.instance.constructParametricType(objclazz, pclazz));
            } catch (Exception e) {
            }
        }
        return object;
    }

    public String toJson(Object object) {
        String json = null;
        try {
            json = getMapper().writeValueAsString(object);
        } catch (Exception e) {
        }
        return json;
    }

    @SuppressWarnings("deprecation")
    public void setDateFormat(String pattern) {
        if (pattern != null && pattern.length() > 0) {
            DateFormat df = new SimpleDateFormat(pattern);
            getMapper().getSerializationConfig().setDateFormat(df);
            getMapper().getDeserializationConfig().setDateFormat(df);
        }
    }
}