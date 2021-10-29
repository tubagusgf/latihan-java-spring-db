/**
 * 
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.connect.Database;
import com.example.demo.model.Laptop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fauzy
 *
 */
@Controller
@RequestMapping("/laptop")
public class LaptopController {

	Database db = new Database();
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String laptop() {
		return "laptop";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Laptop> findAll() {
		ArrayList<Laptop> list = db.findAll();

		return list;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object create(Laptop laptop) {
		db.insert(laptop);

		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("msg", "Tambah laptop success");
		map.put("data", laptop);
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseBody
	public Object edit(@RequestParam(value = "id") int id, @RequestParam(value = "brand", defaultValue = "-") String brand, @RequestParam(value = "price", defaultValue = "0") Double price) {
		HashMap<String, Object> map1  = db.find(id);

		Double mapPriceDouble = (Double) map1.get("price");

		if (brand.contentEquals("-") && price == 0.0) {
			System.out.println("update if no 1 dijalankan =====");
			db.update(id, map1.get("brand").toString(), mapPriceDouble);
		} else if (!brand.contentEquals("-") && price == 0.0) {
			System.out.println("update if no 2 dijalankan =====");
			db.update(id, brand, mapPriceDouble);
		} else if (brand.contentEquals("-") && price != 0.0) {
			System.out.println("update if no 3 dijalankan =====");
			db.update(id, map1.get("brand").toString(), price);
		} else {
			System.out.println("update else dijalankan =====");
			db.update(id, brand, price);
		}

		HashMap<String, Object> map2  = new HashMap<String, Object>();
		map2.put("msg", "Edit laptop success");
		return map2;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public Object find(@RequestParam(value = "id") int id) {
		HashMap<String, Object> map  = db.find(id);
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Object destroy(@RequestParam(value = "id") int id) {
		db.delete(id);

		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("msg", "Delete laptop success");
		return map;
	}
}
