//定义函数
		function tab(tabID, box) {
			$(tabID).click(function() {
				$(tabID).removeClass('active'); //先将所有同级去掉active    
				$(box).hide(); //所有同级box隐藏   
				$(this).addClass('active'); //当前li显示
				$(box).eq($(this).index()).show();
			});
		}
		$(document).ready(function() {
			//选项卡  
				tab("#day li", '.day_box');
				tab("#food1 li", '.food_box1');
				tab("#time11 li", '.time11_1');
				tab("#time12 li", '.time12_1');
				tab("#time13 li", '.time13_1');
				tab("#time14 li", '.time14_1');
				tab("#time15 li", '.time15_1');
				tab("#time16 li", '.time16_1');
				tab("#time17 li", '.time17_1');
				
				tab("#food2 li", '.food_box2');
				tab("#time21 li", '.time21_2');
				tab("#time22 li", '.time22_2');
				tab("#time23 li", '.time23_2');
				tab("#time24 li", '.time24_2');
				tab("#time25 li", '.time25_2');
				tab("#time26 li", '.time26_2');
				tab("#time27 li", '.time27_2');
				
				tab("#food3 li", '.food_box3');
				tab("#time31 li", '.time31_3');
				tab("#time32 li", '.time32_3');
				tab("#time33 li", '.time33_3');
				tab("#time34 li", '.time34_3');
				tab("#time35 li", '.time35_3');
				tab("#time36 li", '.time36_3');
				tab("#time37 li", '.time37_3');
				
				tab("#food4 li", '.food_box4');
				tab("#time41 li", '.time41_4');
				tab("#time42 li", '.time42_4');
				tab("#time43 li", '.time43_4');
				tab("#time44 li", '.time44_4');
				tab("#time45 li", '.time45_4');
				tab("#time46 li", '.time46_4');
				tab("#time47 li", '.time47_4');
				
				tab("#food5 li", '.food_box5');
				tab("#time51 li", '.time51_5');
				tab("#time52 li", '.time52_5');
				tab("#time53 li", '.time53_5');
				tab("#time54 li", '.time54_5');
				tab("#time55 li", '.time55_5');
				tab("#time56 li", '.time56_5');
				tab("#time57 li", '.time57_5');
			
				tab("#food6 li", '.food_box6');
				tab("#time61 li", '.time61_6');
				tab("#time62 li", '.time62_6');
				tab("#time63 li", '.time63_6');
				tab("#time64 li", '.time64_6');
				tab("#time65 li", '.time65_6');
				tab("#time66 li", '.time66_6');
				tab("#time67 li", '.time67_6');
				
				tab("#food7 li", '.food_box7');
				tab("#time71 li", '.time71_7');
				tab("#time72 li", '.time72_7');
				tab("#time73 li", '.time73_7');
				tab("#time74 li", '.time74_7');
				tab("#time75 li", '.time75_7');
				tab("#time76 li", '.time76_7');
				tab("#time77 li", '.time77_7');
		});