package com.cisco.iot.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.UUID;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	private static final String VIEW_DEVICE = "device";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("uname", "admin");
		model.addAttribute("passwd", "pass");
		logger.debug("[login]");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	//public String welcomeName(@PathVariable String name, ModelMap model) {

	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public String welcomeName(ModelMap model) {
		Map<String, DeviceStatus> deviceStatusMap = MessageService.deviceStatusMap;
		StringBuffer sb = new StringBuffer("");

		for (String key : deviceStatusMap.keySet()){
			DeviceStatus status = deviceStatusMap.get(key);
			sb.append(status.toHtmlTable());
		}

		model.addAttribute("deviceTable", sb.toString());
		logger.debug("[deviceMap]");
		return VIEW_DEVICE;

	}

}