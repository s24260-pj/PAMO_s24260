package com.example.pamo_s24260.kotlin_excercises

class Exercises {
    /**
     * Exercise 1
     * Complete the code to make the program print "Mary is 20 years old" to standard output.
     */
    fun printPersonInfo() {
        val name = "Mary"
        val age = 20
        println("$name is $age years old")
    }
    /**
     * Exercise 2
     * Explicitly declare the correct type for each variable.
     */
    fun declareVariableTypes() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Exercise 3
     * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total
     */
    fun countNumbersInLists() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
    }

    /**
     * Exercise 4
     * You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     */
    fun checkProtocolSupport() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")
    }

    /**
     * Exercise 5
     * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number.
     */
    fun spellNumber() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
    }

    /**
     * Exercise 6
     * Prints the corresponding actions when you input the names of game console buttons
     */
    fun buttonAction() {
        val button = "A"
        println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
        )
    }

    /**
     * Exercise 7
     * You have a program that counts pizza slices until there’s a whole pizza with 8 slices.
     */
    fun countPizzaSlices() {
        var pizzaSlices = 0
        pizzaSlices++

        do {
            println("There's only $pizzaSlices slice/s of pizza :(")
            pizzaSlices++
        } while ( pizzaSlices < 8 )

        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Exercise 8
     * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
     * "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
     */
    fun playFizzBuzz() {
        for (number in 1..100) {
            println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> "$number"
                }
            )
        }
    }

    /**
     * Exercise 9
     * You have a list of words. Use for and if to print only the words that start with the letter l.
     */
    fun printWordsStartingWithL() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l"))
                println(w)
        }
    }

    /**
     * Exercise 10
     * You have a list of actions supported by a web service, a common prefix for all requests, and an ID of a particular resource. To request an action title over the
     * resource with ID: 5, you need to create the following URL: https://example.com/book-info/5/title. Use a lambda expression to create a list of URLs from the list of
     * actions.
     */
    fun generateActionUrls() {
        val actions = listOf("title", "year", "author")
        val prefix = "https://example.com/book-info"
        val id = 5
        val urls = actions.map { action -> "$prefix/$id/$action" }
        println(urls)
    }

    /**
     * Exercise 11
     * Write a function that takes an Int value and an action (a function with type () -> Unit) which then repeats the action the given number of times. Then use this function
     * to print “Hello” 5 times.
     */
    fun repeatActionNTimes(n: Int, action: () -> Unit) {
        for (i in 1..n) {
            action()
        }
    }

    /**
     * Exercise 12
     * You have the employeeById function that gives you access to a database of employees of a company. Unfortunately, this function returns a value of the Employee?
     * type, so the result can be null. Your goal is to write a function that returns the salary of an employee when their id is provided, or 0 if the employee is missing from
     * the database.
     */
    fun getEmployeeSalaryById(id: Int): Int {
        val employee = employeeById(id)
        return employee?.salary ?: 0
    }

    fun employeeById(id: Int): Employee? = when(id) {
        1 -> Employee("Mary", 20)
        2 -> null
        3 -> Employee("John", 21)
        4 -> Employee("Ann", 23)
        else -> null
    }
}