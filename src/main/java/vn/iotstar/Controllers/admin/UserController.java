package vn.iotstar.Controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.Services.IUserService;
import vn.iotstar.Services.impl.UserService;
import vn.iotstar.entity.User;

import static vn.iotstar.utils.Constant.DIR;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/users", "/admin/user/add", "/admin/user/insert",
        "/admin/user/edit", "/admin/user/update", "/admin/user/delete", "/admin/user/search" })
public class UserController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private IUserService userService = new UserService();


	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String url = req.getRequestURI();
	        req.setCharacterEncoding("UTF-8");
	        resp.setCharacterEncoding("UTF-8");

	        if (url.contains("users")) {
	            List<User> userList = userService.findAll();
	            req.setAttribute("userList", userList);
	            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);
	        } else if (url.contains("add")) {
	            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
	        } else if (url.contains("edit")) {
	            int id = Integer.parseInt(req.getParameter("id"));
	            User user = userService.findById(id);
	            req.setAttribute("user", user);
	            req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
	        } else if (url.contains("delete")) {
	            int userId = Integer.parseInt(req.getParameter("id"));
	            try {
	                userService.delete(userId);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            resp.sendRedirect(req.getContextPath() + "/admin/users");
	        }
	    }

	    
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String url = req.getRequestURI();
	        req.setCharacterEncoding("UTF-8");
	        resp.setCharacterEncoding("UTF-8");

	        if (url.contains("insert")) {
	        	 User user = new User();
	             user.setUsername(req.getParameter("username"));
	             user.setEmail(req.getParameter("email"));
	             user.setFullname(req.getParameter("fullname")); // Cập nhật fullname
	             user.setPassword(req.getParameter("password")); // Cập nhật password
	             user.setPhone(req.getParameter("phone")); // Cập nhật số điện thoại
	             user.setRoleId(Integer.parseInt(req.getParameter("roleid"))); // Cập nhật role ID
	            
	            String fname = "";
	            String uploadPath = DIR;
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdir();
	            }
	            try {
	                Part part = req.getPart("image");
	                if (part.getSize() > 0) {
	                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	                    fname = System.currentTimeMillis() + "." + filename.substring(filename.lastIndexOf(".") + 1);
	                    part.write(uploadPath + "/" + fname);
	                    user.setImage(fname);
	                } else {
	                    user.setImage("");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            userService.insert(user);
	            resp.sendRedirect(req.getContextPath() + "/admin/users");
	        } else if (url.contains("update")) {
	        	int userId = Integer.parseInt(req.getParameter("userId"));
	            User user = userService.findById(userId);
	            user.setUsername(req.getParameter("username"));
	            user.setEmail(req.getParameter("email"));
	            user.setFullname(req.getParameter("fullname")); // Cập nhật fullname
	            user.setPassword(req.getParameter("password")); // Cập nhật password
	            user.setPhone(req.getParameter("phone")); // Cập nhật số điện thoại
	            user.setRoleId(Integer.parseInt(req.getParameter("roleid"))); // Cập nhật role ID

	            String fileOld = user.getImage();
	            String fname = "";
	            String uploadPath = DIR;
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdir();
	            }
	            try {
	                Part part = req.getPart("image");
	                if (part.getSize() > 0) {
	                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	                    fname = System.currentTimeMillis() + "." + filename.substring(filename.lastIndexOf(".") + 1);
	                    part.write(uploadPath + "/" + fname);
	                    user.setImage(fname);
	                } else {
	                    user.setImage(fileOld);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            userService.update(user);
	            resp.sendRedirect(req.getContextPath() + "/admin/users");
	        }
	    }

}
