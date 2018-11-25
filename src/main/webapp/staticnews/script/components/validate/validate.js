/*
*{
    fields: {
        name1: {
            validate: true,
            mold: '', 类型
            moldMsg: '',
            min: 2,
            minMsg: '',
            max: 10,
            maxMsg: '',
            rule: '',
            ruleMsg: '',
            error: function(){
                show();
            }
        },
        name2: {
            min: 1,
            minMsg: '最少输入1个字',
            max: 5
        },
        demoAutoComplete: {
            error: function(){
                alert('加不上啊');
            }
        }
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

    /*  提取行间自定义属性  */
    function initLineAttr(that){
        var validate = that.find('input[validate], textarea[validate]').not(':disabled');
        var min = that.find('input[min], textarea[min]').not(':disabled');
        var max = that.find('input[max], textarea[max]').not(':disabled');
        var mold = that.find('input[mold], textarea[mold]').not(':disabled');
        var rule = that.find('input[rule], textarea[rule]').not(':disabled');
        var error = that.find('input[error], textarea[error]').not(':disabled');

        var eleJson = {
            validate: validate,
            min: min,
            max: max,
            mold: mold,
            rule: rule,
            error: error
        };

        var fields = {};
        for(var name in eleJson){
            eleJson[name].each(function(){

                /*  validate  */
                if(name == 'validate'){
                    if(!fields[this.name]){
                        fields[this.name] = {
                            validate: Object
                        };
                    }
                    fields[this.name].validate = true;
                    fields[this.name].validateMsg = fields[this.name].validateMsg || $(this).attr('validate-msg') || '必填项不能为空';
                }

                /*  min  */
                if(name == 'min'){
                    if(!fields[this.name]){
                        fields[this.name] = {
                            min: Object
                        };
                    }
                    fields[this.name].min = $(this).attr('min');
                    fields[this.name].minMsg = fields[this.name].minMsg || $(this).attr('min-msg') || '长度不小于' + $(this).attr('min');
                }

                /*  max  */
                if(name == 'max'){
                    if(!fields[this.name]){
                        fields[this.name] = {
                            max: Object
                        };
                    }
                    fields[this.name].max = $(this).attr('max');
                    fields[this.name].maxMsg = fields[this.name].maxMsg || $(this).attr('max-msg') || '长度不大于' + $(this).attr('max');
                }

                /*  mold  */
                if(name == 'mold'){
                    if(!fields[this.name]){
                        fields[this.name] = {
                            mold: Object
                        };
                    }
                    fields[this.name].mold = $(this).attr('mold');
                    fields[this.name].moldMsg = fields[this.name].moldMsg || $(this).attr('mold-msg') || '请输入' + $(this).attr('mold') + '类型';
                }

                /*  rule  */
                if(name == 'rule'){
                    if(!fields[this.name]){
                        fields[this.name] = {
                            rule: Object
                        };
                    }
                    fields[this.name].rule = $(this).attr('rule');
                    fields[this.name].ruleMsg = fields[this.name].ruleMsg || $(this).attr('rule-msg') || '规则是' + $(this).attr('rule');
                }
            });
        }
        return fields;
    }

    /*  找到所有的需要验证的input  */
    function dealEle(that, nameArr){
        var handleEle = [];
        $(that).find('input', 'textarea').each(function(){
            for(var i = 0; i < nameArr.length; i++){
                if(this.name === nameArr[i]){
                    handleEle.push(this);
                    break;
                }
            }
        });
        console.log(handleEle);
        return handleEle;
    }

    /*  check  */
    function check(handleEle, handleData){
        for(var i = 0; i < handleEle.length; i++){
            var el = $(handleEle[i]);
            var name = el.attr('name');
            var val = el.val();
            var flag = true;
            var tempJson = handleData[name];

            /*  validate验证  */
            if(tempJson.validate){
                if(val.length){
                    flag = true;
                    el.removeClass('validate_error');
                } else {
                    flag = false;
                    el.addClass('validate_error');
                    el.focus();

                    $.isFunction(tempJson.error) && tempJson.error();
                    return flag;
                }
            }

            /*  mold验证  */
            if(tempJson.mold && val.length){

                /*  number  */
                if(tempJson.mold === 'number'){
                    var reg = tempJson.rule || /^[0-9]+$/;
                    if(reg.test(val)){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        for(var j = 0; j < handleEle.length; j++){
                            $(handleEle[j]).removeClass('validate_error');
                        }
                        el.addClass('validate_error');
                        el.focus();

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                }

                /*  url  */
                if(tempJson.mold === 'url'){
                    var reg = tempJson.rule || /^(https?|ftp|file):\/\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$/;
                    if(reg.test(val)){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        for(var j = 0; j < handleEle.length; j++){
                            $(handleEle[j]).removeClass('validate_error');
                        }
                        el.addClass('validate_error');
                        el.focus();

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                }

                /*  email  */
                if(tempJson.mold === 'email'){
                    var reg = tempJson.rule || /^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/i;
                    if(reg.test(val)){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        el.addClass('validate_error');
                        el.focus();

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                }
            }

            /*  min max 验证  */
            if(tempJson.min || tempJson.max && val.length){
                if(!tempJson.max){
                    if(val.length >= tempJson.min){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        for(var j = 0; j < handleEle.length; j++){
                            $(handleEle[j]).removeClass('validate_error');
                        }
                        el.addClass('validate_error');
                        el.focus();

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                } else if(!tempJson.min){
                    if(val.length <= tempJson.max){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        for(var j = 0; j < handleEle.length; j++){
                            $(handleEle[j]).removeClass('validate_error');
                        }
                        el.addClass('validate_error');
                        el.focus();

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                } else {
                    if(val.length >= tempJson.min && val.length <= tempJson.max){
                        flag = true;
                        el.removeClass('validate_error');
                    } else {
                        flag = false;
                        for(var j = 0; j < handleEle.length; j++){
                            $(handleEle[j]).removeClass('validate_error');
                        }
                        el.addClass('validate_error');

                        $.isFunction(tempJson.error) && tempJson.error();
                        return flag;
                    }
                }
            }

            /*  rule验证  */
            if(tempJson.rule && val.length){
                var reg = new RegExp(tempJson.rule);

                if(reg.test(val)){
                    flag = true;
                    el.removeClass('validate_error');
                } else {
                    flag = false;
                    for(var j = 0; j < handleEle.length; j++){
                        $(handleEle[j]).removeClass('validate_error');
                    }
                    el.addClass('validate_error');
                    el.focus();

                    $.isFunction(tempJson.error) && tempJson.error();
                    return flag;
                }
            }
        }
    }

    $.extend($.fn, {
        validate: function(options){

            var dealSetting = $.extend(true, options.fields, initLineAttr(this));

            var dealName = [];
            for(var name in dealSetting){
                dealName.push(name);
            }

            return check(dealEle(this, dealName), dealSetting);

        }
    });
});
























