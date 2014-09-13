package no.uio.inf5750.assignment1.controller;

import no.uio.inf5750.assignment1.dao.MessageDao;
import no.uio.inf5750.assignment1.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BaseController {

	@Autowired
	private MessageDao messageDao;
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(ModelMap model) {
            model.addAttribute("message", "Leave a message using the form");
            //Spring uses InternalResourceViewResolver and return back index.jsp
            return "index";
    }

	/**
	 * Stores a message in db.
	 * 
	 * @param content
	 * @param model
	 * @return index
	 */
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(@RequestParam(value = "content") String content,
			ModelMap model) {

		Message msg = new Message();
		msg.setContent(content);
		int id = messageDao.save(msg);
		model.addAttribute("message", "Message id of stored message=" + id);
		return "index";
	}

	/**
	 * Serves page with last message.
	 * 
	 * @param model
	 * @return index
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(ModelMap model) {

		Message message = messageDao.getLast();
		if (message != null) {
			model.addAttribute("message",
					"Last message: " + message.getContent());
		} else {
			model.addAttribute("message", "No message given.");
		}

		return "index";
	}

	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public String readId(@PathVariable int id, ModelMap model) {

		Message message = messageDao.get(id);
		if (message != null) {
			model.addAttribute("message",
					"Msg id " + id + ": " + message.getContent());
		} else {
			model.addAttribute("message", "No message/no id");
		}

		return "index";
	}

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "Hello " + name + " and hello world!");
		return "hello";
	}

	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {
		return "hello";
	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name
				+ ", I couldn't think of anything else to write here.");

		return "index";
	}

	@RequestMapping(value = "/welcome/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Blargh");
		return "index";
	}

}