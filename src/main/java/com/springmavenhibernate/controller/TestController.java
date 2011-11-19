package com.springmavenhibernate.controller;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 15/08/2011
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */

import com.springmavenhibernate.domain.entity.Test;
import com.springmavenhibernate.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 15/08/2011
 * Time: 10:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestController{

    @Autowired
    private TestService testService;

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ModelAndView getTest(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("In the Test Controller");
        Map<String, Object> model = new HashMap<String, Object>();

        Long testcase = new Long(1);
        Test fromDB = testService.getById(testcase);
        model.put("name",fromDB.getName());

        testService.setName(testcase, "This is the entry changed ");

        model.put("nameChanged",testService.getById(testcase).getName());

        //add a row
        fromDB = testService.add("Yay another test!");
        testService.add("And another :)");

        //remove a row
        testService.remove(fromDB.getId());

        return new ModelAndView("test",model);
    }
}
