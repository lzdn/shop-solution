(function() {

	'use strict';
	/*
	 * =========================== Framework ===========================
	 */
	window.wbuploader = function($) {

		var myuploader = this;
		var limitSize = 1;
		var fileSizeLimit = 200 * 1024 * 1024; // 200 M
		var fileSingleSizeLimit = 50 * 1024 * 1024; // 50 M
		var suportFile = {
			title: 'Images',
			extensions: 'jpg,jpeg,png,bmp,gif',
			mimeTypes: 'image/*'
		}; //支持上传的文件类型
		var uploaderInstance = {};
		var upload_server_path = global_basePath + '/file/uploadLocal';
		var formParms = {};
		var $wrap = $('#uploader'),

			// 图片容器
			$queue = $('<ul class="filelist"></ul>').appendTo($wrap.find('.queueList')),

			// 状态栏，包括进度和控制按钮
			$statusBar = $wrap.find('.statusBar'),

			// 文件总体选择信息。
			$info = $statusBar.find('.info'),

			// 上传按钮
			$upload = $wrap.find('.uploadBtn'),

			// 没选择文件之前的内容。
			$placeHolder = $wrap.find('.placeholder'),

			$progress = $statusBar.find('.progress').hide(),

			// 添加的文件数量
			fileCount = 0,

			// 添加的文件总大小
			fileSize = 0,

			// 优化retina, 在retina下这个值是2
			ratio = window.devicePixelRatio || 1,

			// 缩略图大小
			thumbnailWidth = 110 * ratio,
			thumbnailHeight = 110 * ratio,

			// 可能有pedding, ready, uploading, confirm, done.
			state = 'pedding',

			// 所有文件的进度信息，key为file id
			percentages = {},
			// 判断浏览器是否支持图片的base64
			isSupportBase64 = (function() {
				var data = new Image();
				var support = true;
				data.onload = data.onerror = function() {
					if(this.width != 1 || this.height != 1) {
						support = false;
					}
				}
				data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
				return support;
			})(),

			// 检测是否已经安装flash，检测flash的版本
			flashVersion = (function() {
				var version;

				try {
					version = navigator.plugins['Shockwave Flash'];
					version = version.description;
				} catch(ex) {
					try {
						version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash')
							.GetVariable('$version');
					} catch(ex2) {
						version = '0.0';
					}
				}
				version = version.match(/\d+/g);
				return parseFloat(version[0] + '.' + version[1], 10);
			})(),

			supportTransition = (function() {
				var s = document.createElement('p').style,
					r = 'transition' in s ||
					'WebkitTransition' in s ||
					'MozTransition' in s ||
					'msTransition' in s ||
					'OTransition' in s;
				s = null;
				return r;
			})();

		myuploader.initUpload = function(uploadParams) {

			if(uploadParams.limitSize) {
				limitSize = obj.limitSize;
			}
			if(uploadParams.suport) {
				suportFile = obj.suport;
			}

		}
		myuploader.checkBrowser = function() {
			if(!WebUploader.Uploader.support('flash') && WebUploader.browser.ie) {
				parent.layer.alert("您的浏览器flash版本过低！");
				return false;
			} else if(!WebUploader.Uploader.support()) {
				parent.layer.alert("Web Uploader 不支持您的浏览器！");
				return false;
			}
			return true;
		}
		myuploader.createImageView = function(file) {

			var $li = $('<li id="' + file.id + '">' +
					'<p class="title">' + file.name + '</p>' +
					'<p class="imgWrap"></p>' +
					'<p class="progress"><span></span></p>' +
					'</li>'),

				$btns = $('<div class="file-panel">' +
					'<span class="cancel">删除</span>' +
					'<span class="rotateRight">向右旋转</span>' +
					'<span class="rotateLeft">向左旋转</span></div>').appendTo($li),
				$prgress = $li.find('p.progress span'),
				$wrap = $li.find('p.imgWrap'),
				$info = $('<p class="error"></p>'),

				showError = function(code) {
					switch(code) {
						case 'exceed_size':
							text = '文件大小超出';
							break;

						case 'interrupt':
							text = '上传暂停';
							break;

						default:
							text = '上传失败，请重试';
							break;
					}

					$info.text(text).appendTo($li);
				};

			if(file.getStatus() === 'invalid') {
				showError(file.statusText);
			} else {
				// @todo lazyload
				$wrap.text('预览中');
				uploaderInstance.makeThumb(file, function(error, src) {
					var img;
					if(error) {
						$wrap.text('不能预览');
						return;
					}
					if(isSupportBase64) {
						img = $('<img src="' + src + '">');
						$wrap.empty().append(img);
					} else {
						$.ajax('../../server/preview.php', {
							method: 'POST',
							data: src,
							dataType: 'json'
						}).done(function(response) {
							if(response.result) {
								img = $('<img src="' + response.result + '">');
								$wrap.empty().append(img);
							} else {
								$wrap.text("预览出错");
							}
						});
					}
				}, thumbnailWidth, thumbnailHeight);

				percentages[file.id] = [file.size, 0];
				file.rotation = 0;
			}

			file.on('statuschange', function(cur, prev) {
				if(prev === 'progress') {
					$prgress.hide().width(0);
				} else if(prev === 'queued') {
					$li.off('mouseenter mouseleave');
					$btns.remove();
				}

				// 成功
				if(cur === 'error' || cur === 'invalid') {
					console.log(file.statusText);
					showError(file.statusText);
					percentages[file.id][1] = 1;
				} else if(cur === 'interrupt') {
					showError('interrupt');
				} else if(cur === 'queued') {
					$info.remove();
					$prgress.css('display', 'block');
					percentages[file.id][1] = 0;
				} else if(cur === 'progress') {
					$info.remove();
					$prgress.css('display', 'block');
				} else if(cur === 'complete') {
					$prgress.hide().width(0);
					$li.append('<span class="success"></span>');
				}

				$li.removeClass('state-' + prev).addClass('state-' + cur);
			});

			$li.on('mouseenter', function() {
				$btns.stop().animate({
					height: 30
				});
			});

			$li.on('mouseleave', function() {
				$btns.stop().animate({
					height: 0
				});
			});

			$btns.on('click', 'span', function() {
				var index = $(this).index(),
					deg;

				switch(index) {
					case 0:
						uploaderInstance.removeFile(file);
						return;

					case 1:
						file.rotation += 90;
						break;

					case 2:
						file.rotation -= 90;
						break;
				}

				if(supportTransition) {
					deg = 'rotate(' + file.rotation + 'deg)';
					$wrap.css({
						'-webkit-transform': deg,
						'-mos-transform': deg,
						'-o-transform': deg,
						'transform': deg
					});
				} else {
					$wrap.css('filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation=' + (~~((file.rotation / 90) % 4 + 4) % 4) + ')');
				}

			});
			$li.appendTo($queue);

		}

		myuploader.updateTotalProgress = function() {
			var loaded = 0,
				total = 0,
				spans = $progress.children(),
				percent;

			$.each(percentages, function(k, v) {
				total += v[0];
				loaded += v[0] * v[1];
			});

			percent = total ? loaded / total : 0;

			spans.eq(0).text(Math.round(percent * 100) + '%');
			spans.eq(1).css('width', Math.round(percent * 100) + '%');
			myuploader.updateStatus();
		}

		// 负责view的销毁
		myuploader.removeFile = function(file) {
			var $li = $('#' + file.id);

			delete percentages[file.id];
			myuploader.updateTotalProgress();
			$li.off().find('.file-panel').off().end().remove();
		}

		myuploader.updateStatus = function() {
			var text = '',
				stats;

			if(state === 'ready') {
				text = '选中' + fileCount + '张图片，共' + WebUploader.formatSize(fileSize) + '。';
			} else if(state === 'confirm') {
				stats = uploaderInstance.getStats();
				if(stats.uploadFailNum) {
					text = '已成功上传' + stats.successNum + '张照片至XX相册，' +
						stats.uploadFailNum + '张照片上传失败，<a class="retry" href="#">重新上传</a>失败图片或<a class="ignore" href="#">忽略</a>'
				}

			} else {
				stats = uploaderInstance.getStats();
				text = '共' + fileCount + '张（' +
					WebUploader.formatSize(fileSize) +
					'），已上传' + stats.successNum + '张';

				if(stats.uploadFailNum) {
					text += '，失败' + stats.uploadFailNum + '张';
				}
			}

			$info.html(text);
		}

		myuploader.setState = function(val) {
			var file, stats;

			if(val === state) {
				return;
			}

			$upload.removeClass('state-' + state);
			$upload.addClass('state-' + val);
			state = val;

			switch(state) {
				case 'pedding':
					$placeHolder.removeClass('element-invisible');
					$queue.hide();
					$statusBar.addClass('element-invisible');
					uploaderInstance.refresh();
					break;

				case 'ready':
					$placeHolder.addClass('element-invisible');
					$('#filePicker2').removeClass('element-invisible');
					$queue.show();
					$statusBar.removeClass('element-invisible');
					uploaderInstance.refresh();
					break;

				case 'uploading':
					$('#filePicker2').addClass('element-invisible');
					$progress.show();
					$upload.text('暂停上传');
					break;

				case 'paused':
					$progress.show();
					$upload.text('继续上传');
					break;

				case 'confirm':
					$progress.hide();
					$('#filePicker2').removeClass('element-invisible');
					$upload.text('开始上传');

					stats = uploaderInstance.getStats();
					if(stats.successNum && !stats.uploadFailNum) {
						myuploader.setState('finish');
						return;
					}
					break;
				case 'finish':
					stats = uploaderInstance.getStats();
					if(stats.successNum) {
						alert('上传成功');
					} else {
						// 没有成功的图片，重设
						state = 'done';
						location.reload();
					}
					break;
			}

			myuploader.updateStatus();
		}

		myuploader.createUploader = function() {
			// 实例化
			uploaderInstance = WebUploader.create({
				pick: {
					id: '#filePicker',
					label: '点击选择图片'
				},
				formData: formParms, //向后台传递参数
				dnd: '#dndArea',
				paste: '#uploader',
				swf: './Uploader.swf',
				chunked: false, //是否分片上传大文件
				chunkSize: 512 * 1024, //分片大小
				server: upload_server_path,
				// runtimeOrder: 'flash',
				accept: suportFile,
				// 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。
				disableGlobalDnd: true,
				fileNumLimit: limitSize,
				fileSizeLimit: fileSizeLimit, // 200 M
				fileSingleSizeLimit: fileSingleSizeLimit // 50 M
			});

			// 拖拽时不接受 js, txt 文件。
			uploaderInstance.on('dndAccept', function(items) {
				var denied = false,
					len = items.length,
					i = 0,
					// 修改js类型
					unAllowed = 'text/plain;application/javascript ';

				for(; i < len; i++) {
					// 如果在列表里面
					if(~unAllowed.indexOf(items[i].type)) {
						denied = true;
						break;
					}
				}

				return !denied;
			});

			uploaderInstance.on('dialogOpen', function() {
				console.log('here');
			});

			// 添加“添加文件”的按钮，
			uploaderInstance.addButton({
				id: '#filePicker2',
				label: '继续添加'
			});

			uploaderInstance.on('ready', function() {
				window.uploaderInstance = uploaderInstance;
			});

			uploaderInstance.onUploadProgress = function(file, percentage) {
				var $li = $('#' + file.id),
					$percent = $li.find('.progress span');

				$percent.css('width', percentage * 100 + '%');
				percentages[file.id][1] = percentage;
				myuploader.updateTotalProgress();
			};

			uploaderInstance.onFileQueued = function(file) {
				fileCount++;
				fileSize += file.size;

				if(fileCount === 1) {
					$placeHolder.addClass('element-invisible');
					$statusBar.show();
				}

				myuploader.createImageView(file);
				myuploader.setState('ready');
				myuploader.updateTotalProgress();
			};

			uploaderInstance.onFileDequeued = function(file) {
				fileCount--;
				fileSize -= file.size;

				if(!fileCount) {
					myuploader.setState('pedding');
				}

				myuploader.removeFile(file);
				myuploader.updateTotalProgress();

			};

			uploaderInstance.on('uploadSuccess', function(file, response) {
				success_url_array.push(systemshop.toJson(response).msg);
			});

			uploaderInstance.on('all', function(type) {
				var stats;
				switch(type) {
					case 'uploadFinished':
						myuploader.setState('confirm');
						break;

					case 'startUpload':
						myuploader.setState('uploading');
						break;

					case 'stopUpload':
						myuploader.setState('paused');
						break;

				}
			});

			uploaderInstance.onError = function(code) {
				alert('Eroor: ' + code);
			};

			$upload.on('click', function() {
				if($(this).hasClass('disabled')) {
					return false;
				}

				if(state === 'ready') {
					uploaderInstance.upload();
				} else if(state === 'paused') {
					uploaderInstance.upload();
				} else if(state === 'uploading') {
					uploaderInstance.stop();
				}
			});

			$info.on('click', '.retry', function() {
				uploaderInstance.retry();
			});

			$info.on('click', '.ignore', function() {
				//alert('todo');
			});

			$upload.addClass('state-' + state);
		}

	}

})();