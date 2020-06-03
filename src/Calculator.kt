fun main() {

    val menu = Menu()

    loop@ while (true) {
        menu.printMenu()
        var inputOrder: String = readLine()!!

        try {
            inputOrder = inputOrder.toInt().toString()
        } catch (e: Exception) {
            println()
            println("WARNING: Input number only")
            continue
        }

        if(menu.selectItem(inputOrder.toInt())) {
            println()
            println("WARNING: Answer that is not Y will be registered as No")
            println("Do you want to order again? [ Y/N ]")
            print("Answer: ")
            var inputConfirmation: String = readLine()!!

            // Answer == NO
            if(inputConfirmation.toUpperCase() != "Y") {
                for(i in menu.orderList) {
                    println(i.item + " x " + i.amount)
                }
                break
            }
            // Answer == YES
            else {
                continue
            }
        }else {
            println()
            println("WARNING: Please select the correct item number")
            continue
        }
    }
}

class Order(item: String, amount: Int) {
    val item: String = item
    val amount: Int = amount
}

class Menu() {
    val orderList = mutableListOf<Order>()

    fun printMenu() {
        println("//==//====================//==//")
        println("//==// MENU //==//")
        println("//==// 1. Pizza")
        println("//==// 2. Noode")
        println("//==//====================//==//")
        print("Please select your order: ")
    }

    fun selectItem(value: Int): Boolean {
        when {
            value == 1 -> {
                val selectedItem = "Pizza"
                loop@ while (true) {
                    print("Please enter the amount: ")
                    var orderAmount: String = readLine()!!

                    try {
                        orderAmount = orderAmount.toInt().toString()
                    } catch (e: Exception) {
                        println()
                        println("WARNING: Select amount in range of 1 and 99")
                        continue
                    }

                    when {
                        orderAmount.toInt() in 1..99 -> {
                            val order = Order(selectedItem, orderAmount.toInt())
                            orderList.add(order)
                            break@loop
                        }
                    }
                }
            }
            value == 2 -> {
                val selectedItem = "Noodle"
                loop@ while (true) {
                    print("Please enter the amount: ")
                    var orderAmount: String = readLine()!!

                    try {
                        orderAmount = orderAmount.toInt().toString()
                    } catch (e: Exception) {
                        println("WARNING: Select amount in range of 1 and 99")
                        continue
                    }

                    when {
                        orderAmount.toInt() in 1..99 -> {
                            val order = Order(selectedItem, orderAmount.toInt())
                            orderList.add(order)
                            break@loop
                        }
                    }
                }
            }
            else -> false
        }

        return if(value in 1..2) true else false
    }
}