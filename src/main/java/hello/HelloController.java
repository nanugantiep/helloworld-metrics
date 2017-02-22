package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.Counter;
import com.codahale.metrics.annotation.Metric;
import com.codahale.metrics.annotation.Timed;

@RestController
public class HelloController {
	
	@Metric(name = "indexCounter")
	private Counter indexCounter;

	@RequestMapping("/hello")
	@Timed(name="indexTimed")
	public String index() {
		
			indexCounter.inc();

	        return "Greetings from Spring Boot!";
	    }
}
