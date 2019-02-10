import java.util.*

fun main(args: Array<String>) {

    print("Input array numbers: ")
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray() // 1. baca masukan dan split menjadi array integer

    println("Before Sorted : " + Arrays.toString(array))

    quickSort(array)

    println("After Sorted  : " + Arrays.toString(array))

    secondLarge(array)


    /*val input = Scanner(System.`in`)
    val array: ArrayList<Int> = ArrayList()
    println("Masukan nilai array list dan masuk selain angka untuk selesai...")

    while (input.hasNextInt()) {
        array.add(input.nextInt())
    }

    println("Before sorted $array")


    quickSort(array, 0, array.size-1)

    println("After sorted  $array")
    val sumOfArray = sumAll(array)
    println("Sum of Array $sumOfArray")*/

}

fun secondLarge(arr: IntArray) {

    var largest = arr[0]
    var secLargest = arr[0]

    for (a in 0 until arr.size) {

        if (arr[a] > largest) {
            secLargest = largest
            largest = arr[a]

        } else if (arr[a] > secLargest) {
            secLargest = arr[a]
        }
    }

    println("Second Largest: " + secLargest);

}

fun sumAll(array: ArrayList<Int>): Int {
    var total = 0

    for (i in 0..array.size) {

        total += i
    }
    return total
}


/**
 * O(n * log(n))
 *
 * Quick sort on average runs 2-3 times faster than [merge_sort].
 *
 * If the data is mostly pre-sorted, then the runtime performance will
 * be worse than expected, and will approach O(n^2). Ironically, the
 * pre-sorted data takes longer to sort than the “random” data. The
 * reason is because the pivot point will always be picked
 * sub-optimally, with a “lopsided” partitioning of the data.
 * When we pick this "lopsided" pivot, we are only reducing the problem
 * size by one element. If the pivot were ideal, we would be reducing
 * the problem size by half, since roughly half of the elements would
 * be to the left of the pivot and the other half to the right.
 */


fun quickSort(list: IntArray, startIndex: Int = 0, endIndex: Int = list.size - 1) {
    if (startIndex < endIndex) {
        val pivotIndex = partition(list, startIndex, endIndex)
        quickSort(list, startIndex, pivotIndex - 1) // Before pivot index
        quickSort(list, pivotIndex + 1, endIndex) // After pivot index
    }
}

fun partition(list: IntArray, startIndex: Int = 0, endIndex: Int = list.size - 1): Int {
    // Element to be placed at the correct position in the list
    val pivotValue = list[endIndex]

    // Index of element smaller than pivotValue
    var smallerElementIndex = startIndex

    // Make a single pass through the list (not including endIndex)
    for (index in startIndex until endIndex) {
        // If current element is smaller than equal to pivotValue then swap it w/
        // the element at smallerElementIndex
        val valueAtIndex = list[index]
        if (valueAtIndex < pivotValue) {
            list.swap(smallerElementIndex, index)
            smallerElementIndex++
        }
    }

    // Finally move the pivotValue into the right place on the list
    list.swap(smallerElementIndex, endIndex)

    // Return the index just after where the pivot value ended up
    return smallerElementIndex
}

fun IntArray.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}