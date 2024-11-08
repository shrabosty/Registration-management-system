
fun main() {
    val courses = mapOf(
        "Wireless Programming" to mutableListOf<Pair<String, String>>(),
        "Compiler Design" to mutableListOf<Pair<String, String>>(),
        "Software Engineering" to mutableListOf<Pair<String, String>>(),
        "Arts of Effective Living" to mutableListOf<Pair<String, String>>()
    )

    while (true) {
        println("\n--- Student Registration Management System ---")
        println("1. Register Student")
        println("2. View Students by Course")
        println("3. Exit")
        print("Enter your choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nAvailable Courses:")
                courses.keys.forEach { println("- $it") }
                print("Enter course name: ")
                val courseName = readLine()

                if (courses.containsKey(courseName)) {
                    print("Enter Student ID (11 CHARACTERS): ")
                    val studentId = readLine()?.takeIf { it?.length == 11 }

                    if (studentId != null) {
                        print("Enter Student Name: ")
                        val studentName = readLine()?.takeIf { it?.isNotBlank() == true }

                        if (studentName != null) {
                            courses[courseName]?.add(studentId to studentName)
                            println("Student registered successfully!")
                        } else {
                            println("Invalid student name.")
                        }
                    } else {
                        println("Invalid student ID. It must be 11 characters long.")
                    }
                } else {
                    println("Invalid course name.")
                }
            }

            2 -> {
                println("\nAvailable Courses:")
                courses.keys.forEach { println("- $it") }
                print("Enter course name: ")
                val courseName = readLine()

                if (courses.containsKey(courseName)) {
                    val studentList = courses[courseName]
                    if (studentList.isNullOrEmpty()) {
                        println("No students registered in $courseName.")
                    } else {
                        println("\nStudents registered in $courseName:")
                        studentList.forEach { (id, name) ->
                            println("ID: $id, Name: $name")
                        }
                    }
                } else {
                    println("Invalid course name.")
                }
            }

            3 -> {
                println("Exiting...")
                break
            }

            else -> println("Invalid choice. Please try again.")
        }
    }
}
