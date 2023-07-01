package omg.sid;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import omg.sid.dao.ContactRepository;

@SpringBootApplication
public class Project1Application  implements CommandLineRunner{
    @Autowired
	private ContactRepository con;
	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = df.parse("14/02/2001");
	//con.save(new Contact("aymen","fekkak",date,"asdfdasd.com",1234,"/asdf"));
	}

}
