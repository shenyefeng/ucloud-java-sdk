package cn.ucloud.sdk.vo.uhost.out;

public class Ip {
    private String type;
    private String iPId;
    private String iP;
    private Integer bandwidth;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getiPId() {
        return iPId;
    }

    public void setiPId(String iPId) {
        this.iPId = iPId;
    }

    public String getiP() {
        return iP;
    }

    public void setiP(String iP) {
        this.iP = iP;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

}
