package main.java.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("setting")
public class SettingController {

	@RequestMapping(method = RequestMethod.GET, value = "/properties")
	public ModelAndView getSetting(HttpServletRequest request) throws FileNotFoundException, IOException {
		// TODO: properties 폴더 안에 파일 리스트로 조회, 파일 생성/삭제될때마다 reload
		// properties 파일 경로
		// String rootPath = request.getServletContext().getRealPath("/");
		// String propertiesFilePath = rootPath+"/WEB-INF/properties/test.properties";
		String propertiesFilePath = "properties파일경로";
		
		// properties 로드
		Properties props = new Properties();
		props.load(new FileInputStream(propertiesFilePath));
		
		// properties keys
		Enumeration<Object> keys = props.keys();
		// properties keys sorting - 문자 오름차순
		List<Object> keyList = Collections.list(keys);
        Collections.sort(keyList, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1.toString().compareTo(o2.toString())>0) {
					return 1;
				} else if(o1.toString().compareTo(o2.toString())<0) {
					return -1;
				}
				return 0;
			}
		});
        
        // make response
        List<Map<String,String>> propsList = new ArrayList<>();
        
        for(Object key:keyList) {
        	Map<String,String> map = new HashMap<>();
        	map.put((String) key, props.getProperty((String) key));
        	
        	propsList.add(map);
        }

		ModelAndView mv = new ModelAndView("propertiesSetting");
		mv.addObject("list", propsList);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/properties")
	public String postSetting(HttpServletRequest request, String key, String value, Model model) throws FileNotFoundException, IOException {
		// properties 파일 경로
		// String rootPath = request.getServletContext().getRealPath("/");
		// String propertiesFilePath = rootPath+"/WEB-INF/properties/test.properties";
		String propertiesFilePath = "properties파일경로";
		// properties 로드
		Properties props = new Properties();
		props.load(new FileInputStream(propertiesFilePath));
				
		props.setProperty(key,value);
		props.store(new FileOutputStream(propertiesFilePath),"this is comment!!");
		
		model.addAttribute("result", "success");
		
		return "redirect:/setting/properties";
	}

}
