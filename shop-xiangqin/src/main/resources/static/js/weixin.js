var appId = "" // 微信平台唯一标识
var timestamp = "" // 生成signature所使用的timestamp
var nonceStr = "" // 生成signature所使用的nonceStr
var signature = "" // 数字签名，生成参照：微信JSSDK接口 - 生成签名

// 后台生成的signature所使用的url应该和它相同
wx.config({
	debug : false,
	appId : appId,
	timestamp : timestamp,
	nonceStr : nonceStr,
	signature : signature,
	jsApiList : [ "chooseImage", "previewImage", "uploadImage", "downloadImage" ]
});

var serverIds = ""
function uploadImg() {
	wx.chooseImage({
		count : 9,
		sizeType : [ 'original', 'compressed' ], // 可以指定是原图还是压缩图，默认二者都有
		sourceType : [ 'album', 'camera' ], // 可以指定来源是相册还是相机，默认二者都有
		success : function(res) {
			var localIds = res.localIds; // 返回选定照片的本地ID列表
			syncUpload(localIds); // localId可作为img标签的src属性显示图片
		}
	});
}
function syncUpload(localIds) {
	var localId = localIds.pop();
	wx.uploadImage({
		localId : localId, // 需要上传的图片的本地ID，由chooseImage接口获得
		isShowProgressTips : 1, // 默认为1，显示进度提示
		success : function(res) {
			var serverId = res.serverId; // 返回图片的服务器端serverId
			serverIds = serverIds + serverId + ",";
			$("#serverIds").val(serverIds);
			if (localIds.length > 0) {
				syncUpload(localIds);
			} else {
				alert("图片上传成功")
			}
		}
	});
};