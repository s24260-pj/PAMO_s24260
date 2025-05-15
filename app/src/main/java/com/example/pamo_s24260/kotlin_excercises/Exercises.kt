package com.example.pamo_s24260.kotlin_excercises

/**
 * A class containing a collection of small Kotlin exercises
 * demonstrating basic language features such as variables, collections,
 * control flow, lambdas, and null safety.
 */
class Exercises {

    /**
     * Exercise 1
     *
     * Prints a formatted string containing a name and age.
     * Expected output: "Mary is 20 years old"
     */
    fun printPersonInfo(): Unit {
        val name = "Mary"
        val age = 20
        println("$name is $age years old")
        return
    }

    /**
     * Exercise 2
     *
     * Declares several variables with explicit type annotations.
     */
    fun declareVariableTypes(): Unit {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
        return
    }

    /**
     * Exercise 3
     *
     * Counts and prints the total number of elements in two lists.
     */
    fun countNumbersInLists(): Unit {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
        return
    }

    /**
     * Exercise 4
     *
     * Checks whether a requested protocol is supported by the server.
     * Prints true or false accordingly.
     */
    fun checkProtocolSupport(): Unit {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")
        return
    }

    /**
     * Exercise 5
     *
     * Maps numbers 1 to 3 to their word representations and prints the
     * word for a selected number.
     */
    fun spellNumber(): Unit {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
        return
    }

    /**
     * Exercise 6
     *
     * Prints an action based on a button pressed using a when expression.
     */
    fun buttonAction(): Unit {
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
        return
    }

    /**
     * Exercise 7
     *
     * Increments a pizza slice counter until there are 8 slices,
     * printing progress along the way.
     */
    fun countPizzaSlices(): Unit {
        var pizzaSlices = 0
        pizzaSlices++

        do {
            println("There's only $pizzaSlices slice/s of pizza :(")
            pizzaSlices++
        } while (pizzaSlices < 8)

        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
        return
    }

    /**
     * Exercise 8
     *
     * Simulates the FizzBuzz game, printing numbers from 1 to 100
     * with substitutions for multiples of 3, 5, and both.
     */
    fun playFizzBuzz(): Unit {
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
        return
    }

    /**
     * Exercise 9
     *
     * Prints only the words that start with the letter 'l' from a list.
     */
    fun printWordsStartingWithL(): Unit {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l"))
                println(w)
        }
        return
    }

    /**
     * Exercise 10
     *
     * Generates and prints URLs by combining actions with a given
     * prefix and resource ID using a lambda expression.
     */
    fun generateActionUrls(): Unit {
        val actions = listOf("title", "year", "author")
        val prefix = "https://example.com/book-info"
        val id = 5
        val urls = actions.map { action -> "$prefix/$id/$action" }
        println(urls)
        return
    }

    /**
     * Exercise 11
     *
     * Repeats a given action a specified number of times.
     *
     * @param n Number of times to repeat the action.
     * @param action Lambda function to be executed.
     */
    fun repeatActionNTimes(n: Int, action: () -> Unit): Unit {
        for (i in 1..n) {
            action()
        }
        return
    }

    /**
     * Exercise 12
     *
     * Retrieves the salary of an employee by ID. Returns 0 if the employee is not found.
     *
     * @param id The ID of the employee.
     * @return The salary of the employee or 0 if not found.
     */
    fun getEmployeeSalaryById(id: Int): Int {
        val employee = employeeById(id)
        return employee?.salary ?: 0
    }

    /**
     * Returns an [Employee] object based on the provided ID or null if not found.
     *
     * @param id The ID of the employee.
     * @return [Employee]? or null if no match.
     */
    fun employeeById(id: Int): Employee? = when (id) {
        1 -> Employee("Mary", 20)
        2 -> null
        3 -> Employee("John", 21)
        4 -> Employee("Ann", 23)
        else -> null
    }
}

