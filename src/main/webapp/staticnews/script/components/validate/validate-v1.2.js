/*
* {
        fields: {}, // 验证规则区域
        message: {  // 默认参数修改
            validate: '必填项不能为空',
            mold: '正确的类型是',
            min: '最小长度为',
            max: '最大长度为',
            rule: '请输入匹配的内容'
        },
        btn: 'button[type="submit"]', // 提交按钮类型
        errorClass: 'validate_error', // 错误时input的class
        success: function(){},        // 验证成功的回调,如果有就在这里提交数据，如果没有就自动form提交
        error: function(msg){ alert(msg); } // 验证失败的回调
    }

    fields: {
        name: {
            validate: true,   // 必填验证
            mold: number/email, //  验证类型 number / email
            mold-msg: '', //  类型验证失败的message
            min: number, //  验证最小长度 number
            min-msg: '', //
            max: number, //  验证最大长度 number
            max-msg: '', //
            rule: /^$/, //  自定义验证规则 正则
            rule-msg: '', //  内容不匹配时msg
        }
    }
*
* */

(function( factory ) {
    if ( typeof define === "function" && define.amd ) {
        define( ["jquery"], factory );
    } else if (typeof module === "object" && module.exports) {
        module.exports = factory( require( "jquery" ) );
    } else {
        factory( jQuery );
    }
})(function( $ ) {
    var Validate = function(ele, opt){
        // 默认参数
        this.defaults = {
            fields: {},
            message: {
                validate: '必填项不能为空',
                mold: '正确的类型是',
                min: '最小长度为',
                max: '最大长度为',
                rule: '请输入匹配的内容'
            },
            btn: 'button[type="submit"]',
            errorClass: 'validate_error',
            error: function(msg){ alert(msg); }
        };
        // 把自定义参数和默认参数合并
        this.options = $.extend({}, this.defaults, opt);

        this.$ele = $(ele);
        this.$errrorClass = this.options.errorClass;
        $('.' + this.$errrorClass).removeClass(this.$errrorClass);

        this.validateArr = ['validate', 'validate-msg', 'mold', 'mold-msg', 'min', 'min-msg', 'max', 'max-msg', 'rule', 'rule-msg', 'error'];
        this.handle = this.handleElements();

        this.submit();
    };

    Validate.prototype = {
        handleElements: function(){
            var _this = this;
            var handle = [];
            this.$ele.find('input, textarea').each(function(index){
                for(var i = 0; i < _this.validateArr.length; i++){
                    if($(this).attr(_this.validateArr[i])){
                        handle.push(this);
                        break;
                    }
                }
            });
            var hash = {};
            handle = handle.reduce(function(item, next) {
                hash[next.name] ? '' : hash[next.name] = true && item.push(next);
                return item;
            }, []);
            return handle;
        },
        initFields: function(){
            var _this = this;
            var fields = this.options.fields;
            $.each(this.handle, function(index, item){
                var name = $(item).attr('name');
                if(!fields[name]){
                    fields[name] = {};
                }
                for(var i = 0; i < _this.validateArr.length; i++){
                    if($(item).attr(_this.validateArr[i])){
                        fields[name][_this.validateArr[i]] = $(item).attr(_this.validateArr[i]);
                    }
                }
            });
            this.options.fields = $.extend({}, this.options.fields, fields);
            return this.check();
        },
        check: function(){
            var _this = this;
            var validateFlag = false;
            var options = this.options;
            var fields = options.fields;
            $.each(this.handle, function(index, item){
                var value = $(item).val();
                var name = $(item).attr('name');
                // 必填项验证 validate validate-msg
                if(fields[name].validate){
                    if($(item).attr('type') === 'radio' || $(item).attr('type') === 'checkbox'){
                        var name = $(item).attr('name');
                        var flag = false;
                        $('input[name="'+ name +'"]').each(function(){
                            if(this.checked){
                                flag = true;
                                validateFlag = true;
                                return false;
                            }
                        });
                        if(!flag){
                            alert('选项必选');
                            validateFlag = false;
                            return false;
                        }
                    } else {
                        if(value.length === 0){
                            if(fields[name].error){
                                fields[name].error(item);
                            } else {
                                if(fields[name]['validate' + '-msg']){
                                    options.error(fields[name]['validate' + '-msg']);
                                } else {
                                    options.error(options.message.validate);
                                }
                            }
                            $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                            $(item).addClass(_this.$errrorClass).focus();
                            validateFlag = false;
                            return false;
                        } else {
                            $(item).removeClass(_this.$errrorClass);
                            validateFlag = true;
                        }
                    }
                }

                // 类型验证 mold mold-msg
                if(fields[name].mold){
                    var reg;
                    var type;
                    // number
                    if(fields[name].mold === 'number'){
                        reg = /^[0-9]+$/;
                        type = 'number';
                    }
                    // url
                    /*if(_this.options.fields[$(item).attr('name')].mold === 'url'){
                        reg = /^(https?|ftp|file):\/\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$/;
                        type = 'url';
                    }*/
                    //email
                    if(fields[name].mold === 'email'){
                        reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                        type = 'email';
                    }

                    if(!reg.test(value)){
                        if(fields[name].error){
                            fields[name].error(item);
                        } else {
                            if(fields[name]['mold-msg']){
                                options.error(fields[name]['mold-msg']);
                            } else {
                                options.error(options.message.mold + type);
                            }
                        }
                        $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                        $(item).addClass(_this.$errrorClass).focus();
                        validateFlag = false;
                        return false;
                    } else {
                        $(item).removeClass(_this.$errrorClass);
                        validateFlag = true;
                    }
                }

                // 最小值与最大值 min max min-msg max-msg
                if(fields[name].min || fields[name].max){
                    // min
                    if(fields[name].min && !fields[name].max){
                        if(value.length < fields[name].min){
                            if(fields[name].error){
                                fields[name].error(item);
                            } else {
                                if(fields[name]['min-msg']){
                                    options.error(fields[name]['min-msg']);
                                } else {
                                    options.error(options.message.min + fields[name].min);
                                }
                            }
                            $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                            $(item).addClass(_this.$errrorClass).focus();
                            validateFlag = false;
                            return false;
                        } else {
                            $(item).removeClass(_this.$errrorClass);
                            validateFlag = true;
                        }
                    }

                    // max
                    if(fields[name].max && !fields[name].min){
                        if(value.length > fields[name].max){
                            if(fields[name].error){
                                fields[name].error(item);
                            } else {
                                if(fields[name]['max-msg']){
                                    options.error(fields[name]['max-msg']);
                                } else {
                                    options.error(options.message.max + fields[name].max);
                                }
                            }
                            $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                            $(item).addClass(_this.$errrorClass).focus();
                            validateFlag = false;
                            return false;
                        } else {
                            $(item).removeClass(_this.$errrorClass);
                            validateFlag = true;
                        }
                    }

                    // min && max
                    if(fields[name].min && fields[name].max){
                        if(value.length < fields[name].min || value.length > fields[name].max){
                            if(fields[name].error){
                                fields[name].error(item);
                            } else {
                                if(fields[name]['min-msg'] && fields[name]['max-msg']){
                                    options.error(fields[name]['min-msg'] + fields[name]['max-msg']);
                                } else if(fields[name]['min-msg'] && !fields[name]['max-msg']){
                                    options.error(fields[name]['min-msg'] + '最大长度为' + fields[name].max);
                                } else if(!fields[name]['min-msg'] && fields[name]['max-msg']){
                                    options.error('最小长度为' + fields[name].min + fields[name]['max-msg']);
                                } else {
                                    options.error(options.message.min + fields[name].min + ',' + options.message.max + fields[name].max);
                                }
                            }
                            $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                            $(item).addClass(_this.$errrorClass).focus();
                            validateFlag = false;
                            return false;
                        } else {
                            $(item).removeClass(_this.$errrorClass);
                            validateFlag = true;
                        }
                    }
                }

                // 自定义验证 rule rule-msg
                if(fields[name].rule){
                    var reg = fields[name].rule;
                    if(!reg.test(value)){
                        if(fields[name].error){
                            fields[name].error(item);
                        } else {
                            if(fields[name]['rule' + '-msg']){
                                options.error(fields[name]['rule' + '-msg']);
                            } else {
                                options.error(options.message.rule);
                            }
                        }
                        $('.' + _this.$errrorClass).removeClass(_this.$errrorClass);
                        $(item).addClass(_this.$errrorClass).focus();
                        validateFlag = false;
                        return false;
                    } else {
                        $(item).removeClass(_this.$errrorClass);
                        validateFlag = true;
                    }
                }
            });
            return validateFlag;
        },
        submit: function (){
            var _this = this;
            this.$ele.find(this.options.btn).click(function(e){
                if(_this.options.success){
                    e.preventDefault();
                    if(_this.initFields()){
                        _this.options.success();
                    }
                } else {
                    if(_this.initFields()){
                        e.preventDefault();
                    }
                }
            });
        }
    };

    //在插件中使用Beautifier对象
    $.fn.validate = function(options) {
        //创建BrowserSearch的实体
        new Validate(this, options);
        return this;
    }
});