package com.xywy.zngj.web.enumtype;

/**
 * 常量类
 * @author lipr
 *
 */
public class ApiConstants {
	
	/**
	 * 密码加密key
	 */
	public static final String PWD_KEY = "8329de8119812252fc0580914596e896";
	
public enum ResponseVoStatus {
        
        BadRequestData(301,"非法数据请求"),
        RequestTimeOut(302, "请求超时"),
        LoginTimeOut(303, "登录失效"),
        SignNotPass(304,"验签未通过"),
        RegisterFailure(305,"该手机号已注册");

        private final int code;
        private final String message;

        private ResponseVoStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int value() {
            return this.code;
        }

        public String message() {
            return this.message;
        }

        public static ResponseVoStatus valueOf(int code) {
            for (ResponseVoStatus status : values()) {
                if (status.code == code) {
                    return status;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }

        public static String getMessageByValue(int value) {
            ResponseVoStatus[] res = ResponseVoStatus.values();
            for (ResponseVoStatus sta : res) {
                if (sta.getCode() == value) {
                    return sta.getMessage();
                }
            }
            return "";
        }
        
        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
		/**
		 *地区级别
		 */
		public enum CityLevel {
			COUNTRY(0),
			PROVINCE(1),
			CITY(2),
			AREA(3);
			Integer level;
			
			CityLevel(Integer level){
				this.level = level;
			}
			public Integer getLevel() {  
		        return level;  
			}
		}
}
