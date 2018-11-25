/**
 * jQuery 扩展函数
 * 
 * jquery-extend - v1.0.0 - 2017-03-23 Copyright (c) 2017 fengli
 */

(function($){
	
	/**
	 * 正则表达式
	 */
	global_reg_express = {
		number:/^\d+$/,
		phone:/^1(3|4|5|7|8)\d{9}$/,
		tel:/^((0\d{2,3}\d{7,8})|(1[3584]\d{9}))$/,
		email:/^$/,
		url:/^$/,
		date:/^$/,
		identity:/^$/
	}
	
	/**
	 * 扩展ajax方法
	 */
	$.ecej = {
		ajax : function(config){
			if(!config){
				throw "param is not empty";
			}
			config.time=10000;
			if(!config.url){
				return "url is not empty";
			}
			if(!config.headers){
				// config.headers = {"token":"123456"};
			}
			if(config.dataType == undefined){
				config.dataType = "json";
			}
			config.beforeSend = function(XHR){

			};
			config.complete = function(XMLHttpRequest,status){
				if(status=='timeout' || status=='error'){
				　$.layer.msg('链接超时,请再次尝试');
				}
			};
			$.ajax(config);
		},
		ajax_get : function(config){
			if(!config){
				throw "param is not empty";
			}
			if(!config.url){
				return "url is not empty";
			}
			if(!config.headers){
				// config.headers = {"token":"123456"};
			}
			if(config.dataType == undefined){
				config.dataType = "json";
			};
			$.ajax(config);
		},
		post : function(url, param, callback,async){
			var config = {};
			config.url = url;
			config.data = param;
			config.type = "post";
			if(async==undefined){
				async = false;
			}
			config.async = async;
			config.success = function(data){
				if(data.message){
					data.message = $.trim(data.message);
					endStr = data.message.substring(data.message.length-1);
					if(endStr=="," || endStr =="，"){
						data.message = data.message.substring(0,data.message.length-1);
					}
				}
				if (data.resultCode == 200) {
					callback(data.data,data.message);
				}
				if (data.resultCode != 200) {
					layer.msg('错误代码： ' + data.message);
				}
				if (data.resultCode == undefined) {
					layer.msg('数据异常' + data.message, {icon : 2});
				}
			}
			$.ecej.ajax(config);
		},
		get : function(url, param, callback,async){
			var config = {};
			config.url = url;
			config.data = param;
			config.type = "get";
			if(async==undefined){
				async = false;
			}
			config.async = async;
			config.success = function(data){
				if(data.message){
					data.message = $.trim(data.message);
					endStr = data.message.substring(data.message.length-1);
					if(endStr=="," || endStr =="，"){
						data.message = data.message.substring(0,data.message.length-1);
					}
				}
				if (data.resultCode == 200) {
					callback(data.data,data.message);
				}
				if (data.resultCode != 200) {
					layer.msg('错误代码： ' + data.message);
				}
				if (data.resultCode == undefined) {
					layer.msg('数据异常'+ data.message, {icon : 2});
				}
			}
			$.ecej.ajax_get(config);
		}
	}
	
	/**
	 * 拼接url
	 */
	$.joinUrl = function(_url,params){
		// TODO
		_url = _url + "?token="+123456;
		if(typeof params == "string"){
			params = $("#"+params).serializeObj();
		}
		if(params){
			$.each(params,function(key,value){
				_url += "&"+key+"="+value;
			});
		}
		return _url;
	}
	
	/**
	 * 获取URL参数
	 */
	$.getUrlParam = function(param) {
		var reg = new RegExp("(^|&)" + param + "=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r != null) {
			return unescape(r[2]);
		} else {
			return null;
		} // 返回参数值
	}
	 
	/**
	 * 扩展序列化函数
	 */
	$.fn.serializeObj = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							if (this.value && $.trim(this.value)) {
								serializeObj[this.name].push($.trim(this.value));
							}
						} else {
							if (this.value && $.trim(this.value)) {
								serializeObj[this.name] = [
										serializeObj[this.name], $.trim(this.value)];
							}
						}
					} else {
						if (this.value && $.trim(this.value)) {
							serializeObj[this.name] = $.trim(this.value);
						}
					}
				});
		return serializeObj;
	};
	
	
}(jQuery));

