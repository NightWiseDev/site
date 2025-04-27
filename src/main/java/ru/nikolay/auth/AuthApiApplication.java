		package ru.nikolay.auth;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

		@SpringBootApplication
		public class AuthApiApplication {
			private static final Logger logger = LoggerFactory.getLogger(AuthApiApplication.class);
			public static void main(String[] args) {
				SpringApplication.run(AuthApiApplication.class, args);
				logger.info("Приложение запущено!");
			}
		}
