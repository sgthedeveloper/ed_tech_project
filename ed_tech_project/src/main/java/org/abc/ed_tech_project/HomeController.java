package org.abc.ed_tech_project;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.abc.ed_tech_project.Entity.CourseCatalog;
import org.abc.ed_tech_project.Entity.Courses;
import org.abc.ed_tech_project.Entity.Customer;
import org.abc.ed_tech_project.database.AllDatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController{
	@Autowired
	private AllDatabaseConnection alldatabase;
	@ModelAttribute("courses")
	public Courses getCourses() {
		return new Courses();
	}
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	@RequestMapping("/")
	public String showName() {
		alldatabase.create_tablecourses();
		alldatabase.create_tablecustomersregistration();
		alldatabase.create_coursecatalog();
		//return "AuthenticationPage";
		return "index";
	}
	@RequestMapping("/madeby")
	public String madeby() {
		return "madeby";
	}
	@RequestMapping("/authenticationpage")
	public String authenticationpage(HttpServletRequest request) {
		return "AuthenticationPage";
	}
	@RequestMapping("/Admin")
	public String Admin() {
		return "Admin";
	}
	@RequestMapping("/logoutadmin")
	public String LogoutAdmin(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("adminuname",null);
		session.invalidate();
		Cookie cookie1 = new Cookie("adminuname", null);
		cookie1.setMaxAge(60 * 60);
		response.addCookie(cookie1);
		return "AuthenticationPage";
	}
	@RequestMapping("/logoutcustomer")
	public String LogoutCustomer(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("customeruname",null);
		session.invalidate();
		Cookie cookie2 = new Cookie("customeruname", null);
		cookie2.setMaxAge(60 * 60);
		response.addCookie(cookie2);
		return "AuthenticationPage";
	}
	@RequestMapping("/AdminLoginServlet")
	public String sendotp(@RequestParam("adminuname")String adminuname,HttpServletRequest request,HttpServletResponse response) {
		String adminu = "youremailaddress";
		if(adminuname.equals(adminu)) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"ENTER TO PROCEED", "CORRECT USERNAME!!!" ,JOptionPane.INFORMATION_MESSAGE);
			HttpSession session = request.getSession();
			session.setAttribute("adminuname",adminuname);
			Cookie cookie1 = new Cookie("adminuname", adminuname);
			cookie1.setMaxAge(60 * 60);
			response.addCookie(cookie1);
	        return "otpverify";
		}
		else {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"YOU ARE NOT A AUTHORIZED MEMBER", "UNAUTHORIZED" ,JOptionPane.WARNING_MESSAGE);
			return "AuthenticationPage";
		}
	}
	@RequestMapping("/otpverify")
	public String otpverify(HttpServletResponse response,HttpServletRequest request,@RequestParam("otp")String otp) {
		if(otp.equals("yourpassword")) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "PASSWORD VERIFIED SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
			int timeout =15;
            HttpSession sessionObj = request.getSession(true);
            sessionObj.setMaxInactiveInterval(timeout);
            sessionObj.invalidate();
            response.setHeader("Cache-Control","no-cache"); 
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("Refresh", timeout + "; logoutadmin");
			return "adminmainpage";
		}
		else {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"INCORRECT PASSWORD\n\nCLICK TO TRY AGAIN", "INCORRECT PASSWORD!!!" ,JOptionPane.ERROR_MESSAGE);
			HttpSession session = request.getSession();
			session.setAttribute("adminuname",null);
			session.invalidate();
			Cookie cookie1 = new Cookie("adminuname", null);
			cookie1.setMaxAge(60 * 60);
			response.addCookie(cookie1);
			return "Admin";
		}
	}
	
	@RequestMapping("/addcourse")
	public String addcourse(){
		return "addcourse";
	}
	
	@PostMapping("/addingcourse")
	public String addingcourse(@ModelAttribute("courses")Courses courses,HttpServletResponse response,HttpServletRequest request){
		if(alldatabase.createRecordcourses(courses) == 1) {
			System.out.println("Records updated successfully");
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "COURSE ADDED SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println("Error Occurred!!");
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "AN ERROR OCCURED!!!" ,JOptionPane.ERROR_MESSAGE);
		}
		int timeout =15;
        HttpSession sessionObj = request.getSession(true);
        sessionObj.setMaxInactiveInterval(timeout);
        sessionObj.invalidate();
        response.setHeader("Cache-Control","no-cache"); 
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Refresh", timeout + "; logoutadmin");
		return "adminmainpage";
	}
	@RequestMapping(value="/vecourse", method = RequestMethod.GET)
	public String vecourse(Model model){
		List<Courses> coursesList = alldatabase.loadadminCourses();
		for(Courses tempCourses : coursesList) {
			System.out.println(tempCourses);
		}
		model.addAttribute("courses", coursesList);
		return "vecourse";
	}
	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam("couId")String coursesId, @ModelAttribute("courses") Courses courses, Model model) {
		System.out.println("Getting the book data for id: "+coursesId);
		courses = alldatabase.getCourses(coursesId);
		/* send the student object to view */
		 model.addAttribute(courses); 
		return "courses-update-form";
	}
	@PostMapping("/processUpdate")
	public String processUpdateForm(@ModelAttribute("courses") Courses cou,HttpServletResponse response,HttpServletRequest request) {
		
		if(alldatabase.updateRecord(cou) == 1) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "COURSE UPDATED SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Record update successfully!!");
		}else {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "AN ERROR OCCURED!!!" ,JOptionPane.ERROR_MESSAGE);
			System.out.println("Error!!!");
		}
		int timeout =15;
        HttpSession sessionObj = request.getSession(true);
        sessionObj.setMaxInactiveInterval(timeout);
        sessionObj.invalidate();
        response.setHeader("Cache-Control","no-cache"); 
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Refresh", timeout + "; logoutadmin");
		return "adminmainpage";
	}
	@GetMapping("/deleteCourses")
	public String deleteCourses(@RequestParam("couId")String id) {
		alldatabase.deleteCourses(id);
		return "redirect:/vecourse";
	}
	@RequestMapping(value="/RegistrationServlet", method=RequestMethod.POST)
	public String RegistrationServlet(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult ,Model model,HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			System.out.println("Has Errors!!!");
			return "AuthenticationPage";
		}
		else {
			if(alldatabase.createRecord(customer) == 1) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "CUSTOMER ADDED SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Records updated successfully");
				return "AuthenticationPage";
			}
			else {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "Already Registered!!!" ,JOptionPane.WARNING_MESSAGE);
				System.out.println("Error Occurred!!");
				return "AuthenticationPage";
			}
		}
	}
	@RequestMapping(value="/AuthenticationServlet", method=RequestMethod.POST)
		public String AuthenticationServlet(@RequestParam("uname")String uname,HttpServletRequest request,HttpServletResponse response,@RequestParam("upass")String upass,@ModelAttribute("customer") Customer customer,Model model) {
			try {
				customer = alldatabase.getCustomer(uname);
				String upassd=customer.getCustomer_password();
				if(upass.equals(upassd)) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "LOGGED IN SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Records updated successfully");
					System.out.println("correct");
					HttpSession session = request.getSession();
					session.setAttribute("customeruname",uname);
					Cookie cookie2 = new Cookie("customeruname", uname);
					cookie2.setMaxAge(60 * 60);
					response.addCookie(cookie2);
					int timeout =15;
			        HttpSession sessionObj = request.getSession(true);
			        sessionObj.setMaxInactiveInterval(timeout);
			        sessionObj.invalidate();
			        response.setHeader("Cache-Control","no-cache"); 
			        response.setHeader("Cache-Control","no-store");
			        response.setDateHeader("Expires", 0);
			        response.setHeader("Refresh", timeout + "; logoutcustomer");
					return "customermainmenu";
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"CLICK TO TRY AGAIN", "WRONG PASSWORD!!!" ,JOptionPane.ERROR_MESSAGE);
					return "AuthenticationPage";
				}
			}catch(Exception e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf,"CLICK TO REGISTRATION", "USER NOT REGISTERED!!!" ,JOptionPane.WARNING_MESSAGE);
				return "AuthenticationPage";
			}
			
		}
	@RequestMapping(value="/searchbuy", method = RequestMethod.GET)
	public String searchbuy(Model model){
		List<Courses> coursesList = alldatabase.loadadminCourses();
		for(Courses tempCourses : coursesList) {
			System.out.println(tempCourses);
		}
		model.addAttribute("courses", coursesList);
		return "searchbuy";
	}
	@PostMapping("/searching")
	public String showSearching(@RequestParam("couskill")String couskill, Model model) {
		List<Courses> coursesList = alldatabase.getSearchCourses(couskill);
		for(Courses tempCourses : coursesList) {
			System.out.println(tempCourses);
		}
		model.addAttribute("courses", coursesList);
		return "searchbuy";
	}
	@RequestMapping("/buyCourse")
	public String buyCourse(@RequestParam("couId")String couId, Model model, @ModelAttribute("courses") Courses cou,HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String cusname="";
		for (int i = 0; i < 1; i++) {
		  cusname = cookies[i].getValue();
		}
		if(alldatabase.buyCourse(couId,cusname) == 1) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "COURSE PURCHASED SUCCESSFULLY!!!" ,JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Record update successfully!!");
		}
		else if(alldatabase.buyCourse(couId,cusname) == 2) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "COURSE ALREADY PURCHASED!!!" ,JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Record update successfully!!");
		}
		else {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf,"CLICK TO PROCEED", "UNSUCCESSFULL PURCHASED!!!" ,JOptionPane.ERROR_MESSAGE);
			System.out.println("Error!!!");
		}
		int timeout =15;
        HttpSession sessionObj = request.getSession(true);
        sessionObj.setMaxInactiveInterval(timeout);
        sessionObj.invalidate();
        response.setHeader("Cache-Control","no-cache"); 
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Refresh", timeout + "; logoutcustomer");
		return "customermainmenu";
	}
	@RequestMapping(value="/coursecatalog", method = RequestMethod.GET)
	public String coursecatalog(Model model,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String cusname="";
		for (int i = 0; i < 1; i++) {
		  cusname = cookies[i].getValue();
		}
		List<CourseCatalog> coursesList = alldatabase.loadcoursecatalog(cusname);
		for(CourseCatalog tempCourses : coursesList) {
			System.out.println(tempCourses);
		}
		model.addAttribute("courses", coursesList);
		return "coursecatalog";
	}
	@GetMapping("/viewInformation")
	public String viewInformation(@RequestParam("couId")String coursesId, @ModelAttribute("courses") Courses courses, Model model) {
		List<Courses> coursesList = alldatabase.loadcoursecatalog1(coursesId);
		for(Courses tempCourses : coursesList) {
			System.out.println(tempCourses);
		}
		model.addAttribute("courses", coursesList);
		return "coursecatalogview";
	}
}
