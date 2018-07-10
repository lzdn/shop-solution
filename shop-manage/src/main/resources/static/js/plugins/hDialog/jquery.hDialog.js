;
(function($, window, document) {
	var _doc = $(document), $body = $('body');
	methods = {
		init: function(options) {
			return this.each(function() {
				var $this = $(this),opt={};
				opt = $.extend({
						title: '',
						box: '',
						boxBg: '#fff',
						modalBg: 'rgba(0,0,0,0.5)',
						closeBg: '#fff',
						width: 300,
						height: 270,
						positions: 'center',
						triggerEvent: 'click',
						effect: 'hide',
						modalHide: true,
						closeHide: true,
						escHide: true,
						resetForm: function() {},
						beforeShow: function() {},
						afterHide: function() {}},options);
				$(opt.box).hide();
				$this.on(opt.triggerEvent, function() {
					if(opt.escHide) {
						$(document).keyup(function(event) {
							switch(event.keyCode) {
								case 27:
									methods.close(opt);
									break;
							}
						});
					}
					methods.fire.call(this, opt.resetForm);
					methods.fire.call(this, opt.beforeShow);
					methods.add(opt, $this);
					var $close = $('#HCloseBtn');
					if(opt.modalHide) {
						$close = $('#HCloseBtn');
					}
					$close.on('click', function(event) {
						event = event || window.event;
						event.stopPropagation();
						methods.close(opt);
					});
				});
			});
		},
		add: function(o, $this) {
			var w, h, t, l, m;
			$obj = $(o.box);
			title = o.title;
			c = $this.data("animated");
			modalBg = o.modalBg;
			closeBg = o.closeBg;
			w = o.width != undefined ? parseInt(o.width) : '300';
			h = o.height != undefined ? parseInt(o.height) : '270';
			m = "" + (-(h / 2)) + 'px 0 0 ' + (-(w / 2)) + "px";
			switch(o.positions) {
				case 'center':
					t = l = '50%';
					break;
				case 'top':
					t = 0;
					l = '50%';
					m = "0 0 0 " + (-(w / 2)) + "px";
					break;
				case 'left':
					t = l = m = 0;
					break;
				default:
					t = l = '50%';
			}
			methods.remove('#HCloseBtn,#HTitle');
			//$body.stop().append("<div id='HOverlay' style='width:" + _doc.width() + "px;height:" + _doc.height() + "px;background-color:" + modalBg + ";position:fixed;top:0;left:0;z-index:9999;'></div>");
			if(o.title != '') {
				$obj.stop().prepend('<div id="HTitle" style="padding:10px 45px 10px 12px;border-bottom:1px solid #ddd;background-color:#f2f2f2;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">' + o.title + '</div>');
			}
			if(o.closeHide != false) {
				$obj.stop().append('<a id="HCloseBtn" title="关闭" style="line-height:18px;display:inline-block;cursor:pointer;color:#000;font-size:1.4em;text-align:center;position:absolute;top:8px;right:8px;"><span style="display:inline-block;">×</span></a>').css({
					'position': 'fixed',
					'backgroundColor': o.boxBg,
					'top': t,
					'left': l,
					'margin': m,
					'zIndex': '100000'
				});
			}
			
			//$obj.stop().animate({
			//	'width': o.width,
			//	'height': o.height
			//}, 300).removeAttr('class').addClass('animated ' + c + '').show();
			$obj.removeClass('animated').show();
			
		},
		close: function(o, urls) {
			var $obj = $(o.box);
			
			
			switch(o.effect) {
				case "hide":
					$obj.stop().hide(_effect);
					break;
				case "fadeOut":
					$obj.stop().fadeOut(_effect);
					break;
				default:
					$obj.stop().hide(_effect);
			}

			function _effect() {
				//$(this).removeAttr('class').removeAttr('style').addClass('animated').hide();
				$(this).addClass('animated').hide();
				if(urls != undefined) {
					setTimeout(function() {
						window.location.href = urls;
					}, 1000);
				}
				methods.fire.call(this, o.afterHide);
			}
		},
		remove: function(a) {
			$(a).remove();
		},
		fire: function(event, data) {
			if($.isFunction(event)) {
				return event.call(this, data);
			}
		}
	};
	$.fn.hDialog = function(method) {
		if(methods[method]) {
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
		} else if(typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
		} else {
			$.error('Error! Method' + method + 'does not exist on jQuery.hDialog！');
		}
	};
 
})(jQuery, window, document);