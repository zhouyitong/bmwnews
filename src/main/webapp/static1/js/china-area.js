$(function(){

    var geoCoordMap = {
        '北京市':[116.452223,40.894909],
        '安徽省':[117.27,31.86],
        '福建省':[119.306471,26.082198],
        '甘肃省':[103.844551,36.066165],
        '广东省':[113.273004,23.135024],
        '广西壮族自治区':[108.368441,22.823134],
        '贵州省':[106.709877,26.607906],
        '海南省':[110.351513,19.982052],
        '河北省':[114.519349,38.04934],
        '河南省':[113.776057,34.772899],
        '黑龙江省':[126.670803,45.74491],
        '湖北省':[114.358789,30.554834],
        '湖南省':[113.001101,28.111898],
        '吉林省':[125.33258,43.894855],
        '江苏省':[118.796573,32.065553],
        '江西省':[115.918873,28.681945],
        '辽宁省':[123.446521,41.834801],
        '内蒙古自治区':[111.762832,40.849138],
        '宁夏回族自治区':[106.269054,38.485239],
        '青海省':[101.785312,36.62322],
        '山东省':[117.031466,36.669531],
        '山西省':[112.555578,37.879145],
        '陕西省':[108.955794,34.253611],
        '上海市':[121.481689,31.238152],
        '四川省':[104.069443,30.577792],
        '天津市':[104.069443,30.577792],
        '西藏自治区':[91.121467,29.652141],
        '新疆维吾尔自治区':[87.632898,43.831503],
        '云南省':[102.725615,25.050253],
        '浙江省':[120.21415,30.25383],
        '重庆市':[106.557284,29.569247],
        '香港特别行政区':[114.158427,22.328108],
        '澳门特别行政区':[113.558949,22.206712],
        '台湾省':[120.979276,23.808028]

    };
    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];//经纬度
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;

    };
    console.log(convertData(data));
    var mychart = echarts.init(document.getElementById('main'));
    mychart.setOption({
        title:{
            text:'全国地域分布图',
            subtext:'data from PM2.5',
            sublink:'http://www.pm2.5',
            left:'center'
        },
        tooltip:{
            trigger:'item'
        },
        bmap: {
            center: [104.114129, 37.550339],
            zoom: 5,
            roam: true,
            mapStyle: {
                styleJson: [
                    {
                        'featureType': 'water',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#d1d1d1'
                        }
                    }, {
                        'featureType': 'land',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#f3f3f3'
                        }
                    }, {
                        'featureType': 'railway',
                        'elementType': 'all',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'highway',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#fdfdfd'
                        }
                    }, {
                        'featureType': 'highway',
                        'elementType': 'labels',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'arterial',
                        'elementType': 'geometry',
                        'stylers': {
                            'color': '#fefefe'
                        }
                    }, {
                        'featureType': 'arterial',
                        'elementType': 'geometry.fill',
                        'stylers': {
                            'color': '#fefefe'
                        }
                    }, {
                        'featureType': 'poi',
                        'elementType': 'all',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'green',
                        'elementType': 'all',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'subway',
                        'elementType': 'all',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'manmade',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#d1d1d1'
                        }
                    }, {
                        'featureType': 'local',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#d1d1d1'
                        }
                    }, {
                        'featureType': 'arterial',
                        'elementType': 'labels',
                        'stylers': {
                            'visibility': 'off'
                        }
                    }, {
                        'featureType': 'boundary',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#fefefe'
                        }
                    }, {
                        'featureType': 'building',
                        'elementType': 'all',
                        'stylers': {
                            'color': '#d1d1d1'
                        }
                    }, {
                        'featureType': 'label',
                        'elementType': 'labels.text.fill',
                        'stylers': {
                            'color': '#999999'
                        }
                    }]
            }
        },
        series:[{
            name:'区域人数',
            type:'scatter',
            coordinateSystem:'bmap',
            data:convertData(data),
            tooltip:{
                trigger:'item',
                formatter: function(params) {
                    if (typeof(params.value)[2] == "undefined") {
                        return params.name + ' : ' + params.value;
                    } else {
                        return params.name + ' : ' + params.value[2];
                    }
                }
            },
            label:{
                normal:{
                    formatter:'{b}',
                    position:'right',
                    show:false
                },
                emphasis:{
                    show:true
                }
            },
            itemStyle:{
                normal:{
                    color:'purple'
                }
            }
        }]
    })
})