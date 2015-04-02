package cn.ucloud.sdk.enums;

public enum PriorityEnum {
    HIGH(50), MIDDLE(100), LOW(150);

    private final Integer value;

    private PriorityEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
