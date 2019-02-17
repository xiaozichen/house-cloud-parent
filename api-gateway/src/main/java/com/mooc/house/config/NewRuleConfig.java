package com.mooc.house.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class NewRuleConfig {
	
	@Autowired
	private IClientConfig ribbonClientConfig;

	/**
	 * 每十秒ping一次
	 * @param config
	 * @return
	 */
	@Bean
	public IPing ribbonPing(IClientConfig config){
		return new PingUrl(false,"/health");
	}

	@Bean
	public IRule ribbonRule(IClientConfig config){
//		return new RandomRule();
		//选择上次成功的服务器
		return new AvailabilityFilteringRule();
	}

}
