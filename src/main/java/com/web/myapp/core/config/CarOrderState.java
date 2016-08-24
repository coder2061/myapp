package com.web.myapp.core.config;

public enum CarOrderState {
	UNCONFIRMED("未确认", 0),CANCELLED("已取消", 1),CONFIRMED("待支付",2),PAID_OFF("已支付",3),DELIVERED("洗车人员已出发",4),RETURNED("已退单",5),REFUNDED("已退款",6),FINISHED("已完成",7);
	
	// 成员变量
    private String name;
    private int index;
	
	private CarOrderState(String name, int index){
		 this.name = name;
         this.index = index;
	}
	public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	// 普通方法
    public static String getName(int index) {
        for (CarOrderState c : CarOrderState.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
}
