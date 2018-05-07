window.chartColors = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};
var config = {
	type: 'line',
	data: {
		labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
		datasets: [{
			label: 'Unfilled',
			fill: false,
			backgroundColor: window.chartColors.blue,
			borderColor: window.chartColors.blue,
			data: [
			],
		}, {
			label: 'Dashed',
			fill: false,
			backgroundColor: window.chartColors.green,
			borderColor: window.chartColors.green,
			borderDash: [5, 5],
			data: [
				
			],
		}, {
			label: 'Filled',
			backgroundColor: window.chartColors.red,
			borderColor: window.chartColors.red,
			data: [
			],
			fill: true,
		}]
	},
	options: {
		responsive: true,
		title: {
			display: true,
			text: 'Chart.js Line Chart'
		},
		tooltips: {
			mode: 'index',
			intersect: false,
		},
		hover: {
			mode: 'nearest',
			intersect: true
		},
		scales: {
			xAxes: [{
				display: true,
				scaleLabel: {
					display: true,
					labelString: 'Month'
				}
			}],
			yAxes: [{
				display: true,
				scaleLabel: {
					display: true,
					labelString: 'Value'
				}
			}]
		}
	}
};

	window.onload = function() {
		var ctx = document.getElementById('canvas').getContext('2d');
		window.myLine = new Chart(ctx, config);
	};