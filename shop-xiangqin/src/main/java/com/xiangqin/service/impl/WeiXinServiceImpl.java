package com.xiangqin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.conf.WebProperties;
import com.xiangqin.domain.dto.WeiXinDto;
import com.xiangqin.service.WeiXinService;
import com.xiangqin.utils.RedisUtil;
import com.xiangqin.utils.WeixinUtil;

@Service
public class WeiXinServiceImpl implements WeiXinService {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private WebProperties webProperties;

	@Override
	public WeiXinDto getSignature() throws Exception {
		if (webProperties.isProduction()) {
			String accestokenvalue = (String) redisUtil.get(WeixinUtil.ACCESS_TOKEN_CACHE_KEY);
			String jsticket = (String) redisUtil.get(WeixinUtil.TICKET_CACHE_KEY);
			if (StringUtils.isEmpty(accestokenvalue)) {
				accestokenvalue = WeixinUtil.getAccessToken(WeixinUtil.APP_ID, WeixinUtil.APP_SECRET);
				if (StringUtils.isEmpty(accestokenvalue)) {
					throw new Exception("获取accesstoken失败！");
				}
				jsticket = WeixinUtil.getTicket(accestokenvalue);
				redisUtil.set(WeixinUtil.ACCESS_TOKEN_CACHE_KEY, accestokenvalue, 7200L);
				redisUtil.set(WeixinUtil.TICKET_CACHE_KEY, jsticket, 7200L);
			}
			return WeixinUtil.signature(jsticket);
		} else {
			return new WeiXinDto();
		}

	}

}
