package top.allviewit.backstage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackstageApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("后台管理 启动完毕");
		};
	}

    //通过RabbitTemplate 的convertAndSend 方法向队列my-queue发送消息
	@Override
	public void run(String... args){
		 // rabbitTemplate.convertAndSend("my-queue","来自RabbitMQ的问候");
	}

}
