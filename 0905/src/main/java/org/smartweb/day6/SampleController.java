package org.smartweb.day6;


import org.smartweb.day6.domain.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;




//@Controller
@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SampleController.class);

	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basic() {
		log.info("info-------");
		
	}
	/*
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(SampleDTO dto,@ModelAttribute("page")int page,Model model) {
		String title="TEST";
		Date dateDue=new Date();
		log.info("dto:"+dto);		
		log.info("page:"+page);
		model.addAttribute("time",new TodoDTO(title,dateDue));
		
		return "/sample/ex02";
	}

	@GetMapping("/ex02")
	public String ex03(@RequestParam("name")String name,@RequestParam("age")int age){
		log.info("name:"+name);
		log.info("age:"+age);
		return "/sample/ex02";
		
	}

	@GetMapping(value="/getText",produces="text/plain; charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE :"+MediaType.TEXT_PLAIN_VALUE);
		return "hello world";
	}
	
	@GetMapping(value="/getSample",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(111,"홍","길동");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"first",i+"Last")).collect(Collectors.toList());
	}

	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map=new HashMap();
		map.put("First", new SampleVO(111,"홍","길동"));
		return map;
	}
		
	@GetMapping(value="/check",params= {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height,Double weight){
		SampleVO vo=new  SampleVO(0, ""+height,""+weight);
		ResponseEntity<SampleVO> result=null;
		if(height<150) {
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
			
		}else {
			result=ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping(value="/board/{bno}/{num}")
	public String[] getPath(@PathVariable("bno")String bno,@PathVariable("num")Integer num) {
		return new String[] {"bno:"+bno,"num:"+num};
	}
		*/
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket){
		
		return ticket;
	}
//	get : read
//	post : create
//	put :update
//	delete : delete
	
}