package no.uio.inf5750.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

 
@Controller
public class BaseController {

        @RequestMapping(value="/", method = RequestMethod.GET)
        public String welcome(ModelMap model) {
                model.addAttribute("message", "This is an index.");

                //Spring uses InternalResourceViewResolver and return back index.jsp
                return "index";

        }
        
        @RequestMapping(value="/hello/{name}", method = RequestMethod.GET)
        public String helloWord(@PathVariable String name, ModelMap model) {
        	model.addAttribute("message", "Hello " + name + " and hello world!");
        	return "hello";
        }
        
        @RequestMapping(value="/hello/", method = RequestMethod.GET)
        public String helloWord(ModelMap model) {
        	return "hello";
        }

        @RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
        public String welcomeName(@PathVariable String name, ModelMap model) {

                model.addAttribute("message", "Welcome " + name + 
                		", I couldn't think of anything else to write here.");
                
                return "index";
        }
        
        @RequestMapping(value="/welcome/", method = RequestMethod.GET)
        public String welcomeName(ModelMap model) {
        	model.addAttribute("message", "Blargh");
                return "index";
        }

}