package example.service_c

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<SpringBootStarterWithInvalidName>(*args)
}

@SpringBootApplication
class SpringBootStarterWithInvalidName
