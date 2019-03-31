var data = {
    "自然风光类": {
        "青秀山": {
            "纪念品": "75.5",
            "特产": "89.0",
            "门票": "501.2"
        },
        "龙虎山": {
            "门票": "548.9",
            "特产": "64.0",
            "纪念品": "234.6"
        },
        "象鼻山": {
            "纪念品": "316.4",
            "特产": "102.0",
            "门票": "708.7"
        },
        "银子岩": {
            "特产": "35.0",
            "门票": "487.2",
            "纪念品": "59.2"
        },
        "芦笛岩": {
            "特产": "91.9",
            "门票": "751.4",
            "纪念品": "117.3"
        }
    },
    "红色旅游类": {
        "独秀峰王城": {
            "纪念品": "16.8",
            "门票": "602.8",
            "特产": "44.3"
        },
        "桂林千古情": {
            "纪念品": "22.6",
            "门票": "494.5",
            "特产": "48.9"
        },
        "龙脊梯田": {
            "纪念品": "31.2",
            "门票": "311.2",
            "特产": "20.8"
        },
        "桂林尧山景区": {
            "纪念品": "21.4",
            "门票": "313.2",
            "特产": "34.6"
        },
        "象山公园": {
            "特产": "39.1",
            "纪念品": "43.9",
            "门票": "555.2"
        }
    },
    "文化古迹类": {
        "印象刘三姐": {
            "纪念品": "756.8",
            "特产": "133.6",
            "门票": "729.0"
        },
        "独秀峰王城": {
            "门票": "648.6",
            "纪念品": "429.9",
            "特产": "89.0"
        },
        "义江缘": {
            "纪念品": "884.3",
            "特产": "119.5",
            "门票": "702.4"
        },
        "龙脊梯田": {
            "门票": "632.3",
            "纪念品": "666.9",
            "特产": "89.0"
        },
        "七星公园": {
            "纪念品": "648.2",
            "门票": "784.0",
            "特产": "119.3"
        }
    },
    "其它": {
        "红溪": {
            "门票": "318.0",
            "特产": "31.3",
            "纪念品": "22.6"
        },
        "永福天坑景区": {
            "纪念品": "226.2",
            "门票": "635.3",
            "特产": "100.0"
        },
        "仙家温泉": {
            "纪念品": "405.4",
            "门票": "724.6",
            "特产": "89.3"
        },
        "乐8小城": {
            "门票": "470.7",
            "特产": "82.0",
            "纪念品": "104.6"
        },
        "永福温泉": {
            "特产": "70.5",
            "纪念品": "83.7",
            "门票": "374.8"
        }
    },
    "风景名胜类": {
        "贺州园博园": {
            "纪念品": "74.3",
            "门票": "781.7",
            "特产": "33.5"
        },
        "玉石林": {
            "特产": "143.4",
            "纪念品": "831.3",
            "门票": "623.4"
        },
        "黄姚仙女湖花海": {
            "特产": "133.6",
            "门票": "551.0",
            "纪念品": "495.0"
        },
        "程阳桥": {
            "特产": "62.8",
            "门票": "550.0",
            "纪念品": "52.6"
        },
        "玉林容州古城": {
            "门票": "640.3",
            "特产": "53.5",
            "纪念品": "52.5"
        }
    }
};

var points = [],
    region_p,
    region_val,
    region_i,
    country_p,
    country_i,
    cause_p,
    cause_i,
    cause_name = [];
cause_name['门票'] = '门票';
cause_name['纪念品'] = '纪念品';
cause_name['特产'] = '特产';
region_i = 0;
for (var region in data) {
    region_val = 0;
    region_p = {
        id: "id_" + region_i,
        name: region,
        color: Highcharts.getOptions().colors[region_i]
    };
    country_i = 0;
    for (var country in data[region]) {
        country_p = {
            id: region_p.id + "_" + country_i,
            name: country,
            parent: region_p.id
        };
        points.push(country_p);
        cause_i = 0;
        for (var cause in data[region][country]) {
            cause_p = {
                id: country_p.id + "_" + cause_i,
                name: cause_name[cause],
                parent: country_p.id,
                value: Math.round(+data[region][country][cause])
            };
            region_val += cause_p.value;
            points.push(cause_p);
            cause_i++;
        }
        country_i++;
    }
    region_p.value = Math.round(region_val / country_i);
    points.push(region_p);
    region_i++;
}
var chart = new Highcharts.Chart({
    chart: {
        renderTo: 'proportion_3'
    },
    series: [{
        type: "treemap",
        layoutAlgorithm: 'squarified',
        allowDrillToNode: true,
        dataLabels: {
            enabled: false
        },
        levelIsConstant: false,
        levels: [{
            level: 1,
            dataLabels: {
                enabled: true
            },
            borderWidth: 3
        }],
        data: points
    }],
    subtitle: {
        text: '用户在各类商品上浏览的时间大致与销量成正比关系'
    },
    title: {
        text: '用户每月浏览时间统计(单位/小时)'
    }
});