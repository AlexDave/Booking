package ru.booking.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.booking.order.data.Order;
import ru.booking.order.data.OrderRepository;


@Controller
public class UIController {

	private final OrderRepository orderRepository;

	@Autowired
	public UIController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("order", orderRepository.findAll());
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Order order) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(Order order, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		orderRepository.save(order);
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("order", order);

		return "update-order";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, Order order, BindingResult result, Model model) {
		if (result.hasErrors()) {
			order.setId(id);
			return "update-order";
		}

		orderRepository.save(order);

		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		orderRepository.delete(order);

		return "redirect:/index";
	}
}
