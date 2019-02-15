package com.imohsenb.demo.controller

import com.imohsenb.demo.data.Person
import com.imohsenb.demo.repository.PersonRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    lateinit var repository : PersonRepository

    @RequestMapping("/", method = [RequestMethod.GET])
    fun getAllPerson(): List<Person> = repository.findAll()

    @RequestMapping("/", method = [RequestMethod.POST])
    fun createPerson(@Valid @RequestBody person: Person): Person {
        person.id = ObjectId.get()
        repository.save(person)
        return person
    }
}