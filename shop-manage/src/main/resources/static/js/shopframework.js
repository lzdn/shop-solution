/**
 * shopframework 1.0 Licensed under MIT Released on: June 20, 2018
 */
(function() {

    'use strict';
    /*
	 * =========================== Framework ===========================
	 */
    window.shopframework = function(params) {

        // App
        var shop = this;

        // Version
        shop.version = '1.0';

        // Default Parameters
        shop.params = {
        // Auto init
            init: true,
        };
        // Extend defaults with parameters
        for (var param in params) {
        	shop.params[param] = params[param];
        }  
        
        shop.toJson = function(data){
        	try {
        		return JSON.parse(data)
        	} catch (e) {
        		return data;
        	}
        }
        
        shop.initFrame = function(frame) {
			//初始化iframeId
			$($(frame.layFrame).find("iframe")[0].contentWindow.document.getElementById("iframeId")).val(frame.frameId);
		}
    };
    window.systemshop = new shopframework({});
})();


