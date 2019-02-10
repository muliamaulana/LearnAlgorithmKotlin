fun main(args: Array<String>) {

    print("Input array numbers: ")
    val input = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()

    print("Input element to search: ")
    val elementToSearch = readLine()!!.trim().toInt()

    val position = binarySearch(input, elementToSearch)

    if (position >= 0) {
        println(position)
    } else {
        println("Invalid position")
    }
}

fun binarySearch(input: IntArray, elementToSearch: Int): Int {
    var low = 0
    var high = input.size - 1
    var middle: Int

    while (low <= high) {
        middle = (low + high) / 2
        when {
            elementToSearch > input[middle] -> low = middle + 1
            elementToSearch == input[middle] -> return middle
            elementToSearch < input[middle] -> high = middle-1
        }
    }

    return -1

}
