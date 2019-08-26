package com.zhongzhou.controller.canteen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhou.entity.canteen.Notice;
import com.zhongzhou.service.canteen.NoticeService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;

/**
 *	通知 controller
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	
	/**
	 *  注入 service对象
	 */
	@Autowired
	NoticeService noticeService;

	
	/**
	 *	添加
	 */
	@RequestMapping(value="/insert",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult insert(Notice notice , HttpSession session,HttpServletRequest request) {
		Long  id = noticeService.insert(notice);
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", notice);
		return result;
	}
	
	/**
	 *	修改
	 */
	@RequestMapping(value="/update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult update(Notice notice , HttpSession session,HttpServletRequest request) {
		Long  id = noticeService.update(notice);
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", notice);
		return result;
	}
	
	/**
	 *	删除指定id
	 */
	@RequestMapping(value="/deleteId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult deleteId(Integer id , HttpSession session,HttpServletRequest request) {
		Long  count = noticeService.deleteId(id);
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", count);
		return result;
	}
	
	/**
	 *	分页查询
	 */
	@RequestMapping(value="/queryPageList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryPageList(Integer pageNumber , Integer pageSize , HttpSession session,HttpServletRequest request) {
		
		Integer startpage = (pageNumber-1) * pageSize;
		Integer endpage = pageSize;
		
		List<Notice> list = noticeService.queryListPage( startpage,  endpage);
		Long  count = noticeService.queryCount();
		
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", list);
		result.setCount(count);
		
		return result;
	}
	
	/**
	 *	查询指定flag  asc排序
	 */
	@RequestMapping(value="/queryFlagAscList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryFlagAscList(Integer flag , HttpSession session,HttpServletRequest request) {
		
		List<Notice> list = noticeService.queryFlagAscList(flag);
		
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", list);
		
		return result;
	}
	
	/**
	 *  查询指定flag  desc排序
	 */
	@RequestMapping(value="/queryFlagDescList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryFlagDescList(Integer flag , HttpSession session,HttpServletRequest request) {
		
		List<Notice> list = noticeService.queryFlagDescList(flag);
		
		HttpResult result = new HttpResult(Consts.Code_Success, "操作成功", list);
		
		return result;
	}
	
	/**
	 *  查询指定id
	 */
	@RequestMapping(value="/queryId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryId(Integer id , HttpSession session,HttpServletRequest request) {
		
		Notice notice = noticeService.queryId(id);
		
		HttpResult result = new HttpResult(Consts.Code_Success, "查询成功", notice);
		
		return result;
	}
	
}
