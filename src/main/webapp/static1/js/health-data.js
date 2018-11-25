$(function () {
    $(".selected").siblings().show();
    var mychart = echarts.init(document.getElementById('main'));
    $(".left-inner").eq(1).hide();
    $(".left-inner").eq(2).hide();
    mychart.setOption({
        title: {
            text: '睡眠时长',
            x: 'center',
            y: 'center',
            textStyle: {
                fontSize: 16
            }
        },
        tooltip: {
            show: true,
            trigger: 'item',
            formatter: "{b}: {c}m ({d}%)"
        },
        legend: {
            orient: 'vertical',
            top: 'top',
            right: 'right',
            data: [],
            show: false,
        },
        color: ['#86D560', '#AF89D6', '#59ADF3', '#FF999A'],
        series: [{
            type: 'pie',
            selectesMode: 'single',

            radius: ['25%', '58%'],
            color: ['#86D560', '#AF89D6', '#59ADF3', '#FF999A'],
            label: {
                normal: {
                    position: "inner",
                    formatter: "{d}%",
                    textStyle: {
                        color: '#fff',
                        fontSize: 14
                    },
                    show: false,
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: []
        }, {
            type: 'pie',

            radius: ['58%', '83%'],
            itemStyle: {
                normal: {
                    color: '#f2f2f2'
                },
                emphasis: {
                    color: '#adadad'
                }
            },
            label: {
                normal: {
                    position: 'inner',
                    formatter: '{c}小时',
                    textStyle: {
                        color: '#777',
                        fontSize: 14
                    },
                    show: false,
                }
            },
            data: []
        }]
    });
    mychart.showLoading();

    //var type = [];
    var bai = [];
    var value = [];
    var zong = [];
    var sleepSearchDate = null;
    var url = urljs;
    var stop = false;

    function getData(url) {
        var userid = $("#userid").val();
        var type = $("#type").val();
        $.ajax({
            type: "post",
            url: url + "xywy/userdevice/userDevice/userDeviceAjax",
            data: {userid: userid, type: type, sleepSearchDate: sleepSearchDate},
            dataType: 'json',
            success: function (result) {
                if (result.status == 1) {
                    var data = result.data;
                    var xsleep = result.xsleep;
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].date == undefined) {
                            bai.push("没有数据！");
                        } else {
                            bai.push(data[i].date);
                            value.push(data[i].time);
                            zong.push({
                                name: data[i].date,
                                value: data[i].time
                            });
                        }

                    }
                    if (data[0].date != undefined) {
                        var meanSleepTotalMinute = xsleep.meanSleepTotalMinute;
                        var meanSleepStayupMinute = xsleep.meanSleepStayupMinute;
                        var reachSleep = xsleep.reachSleep;
                        if (type == "0" || type == "3") {
                            var sleep = result.sleep;
                            $("#smsc").html("<span>" + parseInt(data[0].time / 60) + "</spam>小时<span>" + Math.round(data[0].time % 60) + "</span>分");
                            $("#qs").html("<span>" + parseInt(data[1].time / 60) + "</spam>小时<span>" +
                                Math.round(data[1].time % 60) + "</span>分");
                            $("#ss").html("<span>" + parseInt(data[2].time / 60) + "</spam>小时<span>" +
                                Math.round(data[2].time % 60) + "</span>分");
                            $("#oy").html("<span>" + parseInt(data[3].time / 60) + "</spam>小时<span>" +
                                Math.round(data[3].time % 60) + "</span>分");
                            $("#sdsj").html(parseInt(sleep.sleepTarget/60) + "小时" + sleep.sleepTarget%60+"分钟");
                            $("#xlcs").html(parseInt(sleep.sleepWakeCount));
                            if(data[0].time > sleep.sleepTarget) {
                                $("#smsjt").css("width", "30vw");
                            }else{
                                $("#smsjt").css("width", parseInt(data[0].time / sleep.sleepTarget * 30) + "vw");
                            }
                        } else if (type == "1") {
                            $("#zsm").html("<span>" + parseInt(meanSleepTotalMinute / 60) + "</spam>小时<span>" +
                                Math.round(meanSleepTotalMinute % 60) + "</span>分");
                            $("#zoy").html("<span>" + parseInt(meanSleepStayupMinute / 60) + "</spam>小时<span>" +
                                Math.round(meanSleepStayupMinute % 60) + "</span>分");
                            $("#zdb").html("<span>" + reachSleep + "</spam>次");
                        } else if (type == "2") {
                            $("#ysm").html("<span>" + parseInt(meanSleepTotalMinute / 60) + "</spam>小时<span>" +
                                Math.round(meanSleepTotalMinute % 60) + "</span>分");
                            $("#yoy").html("<span>" + parseInt(meanSleepStayupMinute / 60) + "</spam>小时<span>" +
                                Math.round(meanSleepStayupMinute % 60) + "</span>分");
                            $("#ydb").html("<span>" + reachSleep + "</spam>次");
                        }
                        mychart.setOption({
                            legend: {
                                data: bai
                            },
                            series: [
                                {
                                    data: zong
                                },
                                {
                                    data: zong
                                }
                            ]
                        });
                    } else {
                        $("#smsc").html("<span>没有数据！</span>");
                        $("#ss").html("<span>没有数据！</span>");
                        $("#qs").html("<span>没有数据！</span>");
                        $("#oy").html("<span>没有数据！</span>");
                        $("#sdsj").html("");
                        $("#xlcs").html("");
                        $("#smsjt").css("width", "0vw");
                        mychart.setOption({
                            legend: {
                                data: 0
                            },
                            series: [
                                {
                                    data: 0
                                },
                                {
                                    data: 0
                                }
                            ]
                        });
                    }

                    mychart.hideLoading();

                    bai.splice(0, bai.length);
                    zong.splice(0, zong.length);
                }
                stop = true;
            },
            error: function (errorMsg) {
                alert('图表请求失败');
                mychart.hideLoading();
            }
        });
    };
    $("#type").val(0);
    getData(url);
    $("#day").on("click", function () {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $(".left-inner").hide();
        $(".left-inner").eq(0).show();
        $(".section-bottom").show();
        $("#type").val(0);
        getData(url);
    });
    $("#sleepSearch").on("click", function () {
        $("#day").addClass('active');
        $("#day").siblings().removeClass('active');
        $(".left-inner").hide();
        $(".left-inner").eq(0).show();
        $(".section-bottom").show();
        sleepSearchDate = $("#sleepSearchDate").val();
        if (sleepSearchDate != '') {
            $("#type").val(3);
            getData(url);
        }

    });
    $("#week").on("click", function () {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $(".left-inner").hide();
        $(".left-inner").eq(1).show();
        $(".section-bottom").hide();
        $("#type").val(1);
        getData(url);
    });
    $("#month").on("click", function () {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $(".left-inner").hide();
        $(".left-inner").eq(2).show();
        $(".section-bottom").hide();
        $("#type").val(2);
        getData(url);
    });


    var sechart = echarts.init(document.getElementById('second'));
    sechart.setOption({
        tooltip: {
            trigger: 'axis',
            //formatter:function(params)
            //{
            //    var relVal = params[0].name;
            //    for (var i = 0, l = params.length; i < l; i++) {
            //        relVal += '<br/>' + params[i].seriesName + ' : ' + params[i].value+"bpm";
            //    }
            //    return relVal;
            //}
            formatter:"{b}点: {c}bpm"
        },
        toolbox: {
            orient: 'vertical',
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            },
            left: 'right',
            top: 'center'
        },
        legend: {
            data: [
                {
                    name: '心率值'
                }
            ],
            left: 'right'
        },
        xAxis: {
            type: "category",
            boundaryGap: false,
            axisLine: {
                lineStyle: {
//							color:'#ccc'
                }
            },
            data: []
        },
        yAxis: {
            splitLine: {
                lineStyle: {
                    type: 'dashed'
                }
            },
            axisLine: {
                lineStyle: {
//							color:'#ccc'
                }
            }
        },
        series: [
            {
                name: '心率值',
                type: 'line',
                smooth: true,
                silent:true,
                showAllSymbol: 'emptyCircle',
                symbolSize: 15,
                data: [],
                itemStyle: {
                    "normal": {
                        color: 'rgba(151,187,205,1)'
                    }
                },
                markPoint: {
                    silent:true,
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(151,187,205,0.5)'
                        }, {
                            offset: 1,
                            color: 'rgba(151,187,205,0.2)'
                        }], false)
                    }
                }
            }
        ]
    });
    sechart.showLoading();
    var week = [];
    var maxtemp = [];
    var ppgSearchDate = null;
    var stop = false;

    function getData1(url) {
        var userid = $("#userid").val();
        var type = $("#type").val();
        $.ajax({
            type: "post",
            url: url + "xywy/userdevice/userDevice/userPPGAjax",
            async: true,
            data: {userid: userid, type: type, ppgSearchDate: ppgSearchDate},
            dataType: 'json',
            success: function (result) {
                if (result.status == 1) {
                    var data = result.data.heart_rate_raw_data;
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].hour == undefined) {
                            week.push("没有数据！");
                        } else {
                            week.push(data[i].hour);
                        }

                    }
                    for (var i = 0; i < data.length; i++) {
                        maxtemp.push(data[i].num);
                    }
                    var xHeartRate = result.xHeartRate;
                    if (data != null) {
                        $("#sleepAvg").html(xHeartRate.heartRateSleepAvg);
                        $("#alldayAvg").html(xHeartRate.heartRateAlldayAvg);
                        $("#max").html(xHeartRate.heartRateAlldayMax);
                        $("#min").html(xHeartRate.heartRateAlldayMin);
                    }
                    sechart.hideLoading();
                    sechart.setOption({
                        xAxis: {
                            data: week
                        },
                        series: [
                            {
                                data: maxtemp
                            }
                        ]
                    });
                    week.splice(0, week.length);
                    maxtemp.splice(0, maxtemp.length);
                }
                stop = true;
            },
            error: function (errorMsg) {
                alert('图表请求失败');
                mychart.hideLoading();
            }
        });
    };
    $("#type").val("0");
    getData1(url);

    $('#today').click(function () {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $("#type").val("0");
        getData1(url);
    });

    $('#yesterday').click(function () {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $("#type").val("1");
        getData1(url);
    });
    $('#ppgSearch').click(function () {
        ppgSearchDate = $("#ppgSearchDate").val();
        if (ppgSearchDate != '') {
            $("#type").val("2");
            getData1(url);
        }
    });

})
