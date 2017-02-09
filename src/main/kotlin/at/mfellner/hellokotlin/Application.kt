package at.mfellner.hellokotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

  private val log = LoggerFactory.getLogger(Application::class.java)

  @Bean
  open fun init(repository: CustomerRepository) = CommandLineRunner {
    repository.save(Customer("Albert", "Einstein"))
    repository.save(Customer("Isaac", "Newton"))
    repository.save(Customer("Ada", "Lovelace"))
    repository.save(Customer("Galileo", "Galilei"))
    repository.save(Customer("Marie", "Curie"))
    repository.save(Customer("Charles", "Darwin"))
    repository.save(Customer("Nikola", "Tesla"))
    repository.save(Customer("Rosalind", "Franklin"))

    log.info("Initialized kotlin-hello-world!")
  }
}

fun main(args: Array<String>) {
  SpringApplication.run(Application::class.java, *args)
}
