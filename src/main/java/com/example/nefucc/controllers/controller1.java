package com.example.nefucc.controllers;

import com.example.nefucc.entity.Exam;
import com.example.nefucc.entity.Manager;
import com.example.nefucc.entity.TE;
import com.example.nefucc.entity.Teacher;
import com.example.nefucc.repository.ExamJpa;
import com.example.nefucc.repository.ManagerJpa;
import com.example.nefucc.repository.TEJpa;
import com.example.nefucc.repository.TeacherJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controller1 {
    @Autowired
    private TeacherJpa teacherJpa;
    @Autowired
    private ManagerJpa managerJpa;
    @Autowired
    private ExamJpa examJpa;
    @Autowired
    private TEJpa teJpa;
    @RequestMapping("/tlogin")
    public String tlogin(@RequestParam("username") String username, @RequestParam("password") String password,
                         HttpSession session, Model model) {
        Teacher teacher = teacherJpa.findbyname(username);
        //            要先判断一个对象是否为空，否则getname（）和getpassword取不到值会会抛异常
        if (teacher != null && username.equals(teacher.getName()) && password.equals(teacher.getPassword())) {
            model.addAttribute("hello", teacher.getName());
            model.addAttribute("ps", teacher.getPassword());
//          从数据库查询当前老师所有的监考信息
            List<TE> list=teJpa.findbytname(username);
            List<Exam> list1=new ArrayList<>();
            for (TE te:list){
                list1.add(examJpa.findbyname(te.getEname()));
            }
            model.addAttribute("exams", list1);
//       在session中放入值，因为session对象存在整个生命周期里，所以，拦截器intercepeter里也可以取到
            session.setAttribute("teacher", username);
            return "teacher";
        } else {
            return "index";
        }
    }
        @RequestMapping("/mlogin")
        public  String mlogin(@RequestParam("username") String username, @RequestParam("password") String password,
                HttpSession session,Model model){
            Manager manager=managerJpa.findbyname(username);
//            要先判断一个对象是否为空，否则getname（）和getpassword取不到值会会抛异常
            if(manager!=null&&username.equals(manager.getName())&&password.equals(manager.getPassword())){
//                登录成功以后直接把所有老师的信息封装到model对象里，以便jsp遍历
              List<Teacher> list= teacherJpa.findAll();
              model.addAttribute("hello", manager.getName());
              model.addAttribute("ps", manager.getPassword());
              model.addAttribute("teachers", list);
//              放入所有的监考信息
              List<Exam> examlist=examJpa.findAll();
              model.addAttribute("exams",examlist);

              session.setAttribute("manager", username);
//                如果加上重定向redirect:/，则一定要在视图解析器中注册
                return "manager";
            }
            else
                return "index";
        }

}
