package com.kyu.boardsolution;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyu.boardsolution.service.TestService;
import com.kyu.boardsolution.service.WriteBoardService;
import com.kyu.boardsolution.vo.write.CommonVO;
import com.kyu.boardsolution.vo.write.Paging;
import com.kyu.boardsolution.vo.write.WriteBoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestService testService;

	@Autowired
	private WriteBoardService writeBoardService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute CommonVO commVO, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("today", testService.getToday() );
		model.addAttribute("mul", testService.getMul(20, 30) );
		model.addAttribute("sum", testService.getSum(20, 30, 40) );
		model.addAttribute("count", testService.selectWriteBoardCount("write_notice"));
		model.addAttribute("boards", writeBoardService.selectBoardList());
		
		Paging<WriteBoardVO> allPaging = writeBoardService.selectAllWriteBoardList(commVO);
		Paging<WriteBoardVO> paging = writeBoardService.selectWriteBoardGetList("write_freeboard", commVO);
		model.addAttribute("allPaging", allPaging);
		model.addAttribute("paging", paging);
			
		//테스트
		return "home";
	}
	
}
