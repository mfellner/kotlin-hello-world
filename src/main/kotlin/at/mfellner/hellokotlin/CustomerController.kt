package at.mfellner.hellokotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val repository: CustomerRepository) {

  @GetMapping("/customers")
  fun findAll(@RequestParam(required = false) lastName: String?) =
      if (lastName != null) repository.findByLastName(lastName) else repository.findAll()

  @GetMapping("/customers/{id}")
  fun findByLastName(@PathVariable id: Long) = repository.findOne(id)
}
