package org.seckill.enums;

public enum SeckillStatEnum {
    SUCCESS(1, "seckill succeeded"),
    END(0, "seckill failed"),
    REPEAT_KILL(-1, "repeat seckill"),
    INNER_ERROR(-2, "system error"),
    DATA_REWRITE(-3, "data mismanuipulated");

    private int state;
    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int index){
        for (SeckillStatEnum state: values()){
            if (index == state.getState()){
                return state;
            }
        }
        return null;
    }
}
