<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZH</title>
<link rel="stylesheet" type="text/css" href="./lib/bootstrap-4.1.1.css">
<!-- <link rel="stylesheet" type="text/css" href="../css/main.css"> -->
<script src="./lib/jquery-3.3.1.js"></script>
<script src="./lib/charts.min.js"></script>
<script src="./lib/bootstap-4.1.1.js"></script>
</head>
<body>
	<main>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <div id="chart" style="width:600px;height:400px;">
						
                    </div>
                </div>
                <div class="col-lg-2"></div>

            </div>
        </div>
  	</main>
  	<script type="text/javascript">
	
		function loadData(option) {
			var d_id=new Array();
			$.ajax({
				type : 'post',	//传输类型
				async : false,	//同步执行
				url : '${PageContext.request.contextpath}playerAction.action',	//web.xml中注册的Servlet的url-pattern
				data : {},
				dataType : 'json', //返回数据形式为json
				success : function(jsonArray) {
					if (jsonArray) {
						//初始化xAxis[0]的data
						/* option.xAxis[0].data = []; */
						/* for (var i=0; i<result.length; i++) {
							option.xAxis[0].data.push(result[i].name);
						} */
						//初始化series[0]的data
						option.series[0].data = [];
						for (var i in jsonArray[0]) {
							d_id[i]=jsonArray[0][i];
							option.series[0].data.push(d_id[i]);
						}
					}
				},
				error : function(errorMsg) {
					
					alert("加载数据失败");
				}
			});//AJAX
		}//loadData()
		
		var myChart = echarts.init(document.getElementById('chart'));
		var option = {
			title: {
	            text: '区域使用情况'
	        },

			tooltip : {
				show : true
			},
			legend : {
				data : [ '使用' ]
			},
			/* xAxis : [ {
				type : 'category'
				
			} ],
			yAxis : [ {
				type : 'value'
			} ], */
			series : [ {
				itemStyle:{
		              normal:{
		                  labelLine:{
		                      show:false,
		                  },
		                  label: {
		                      position: 'inner',
		                  }
		              }
		            },
				name : '使用',
				type : 'pie',
				data:[]
			} ]
		};
		//加载数据到option
		loadData(option);
		//设置option
		myChart.setOption(option);
	</script>
</body>
</html>